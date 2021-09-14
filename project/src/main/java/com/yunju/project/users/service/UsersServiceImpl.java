package com.yunju.project.users.service;

import com.yunju.project.users.dao.UsersDao;
import com.yunju.project.users.dto.UsersDto;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class UsersServiceImpl implements UsersService{
	@Autowired
	private UsersDao dao;

	//인자로 전달된 아이디가 존재하는지 여부를 map에 담아서 리턴하는 메소드
	@Override
	public Map<String, Object> isExistId(String inputuserId) {
		boolean isExistId=dao.isExist(inputuserId);
		Map<String, Object> map=new HashMap<>();
		map.put("isExist", isExistId);
		return map;
	}

	@Override
	public void addUser(UsersDto dto) {
		//비밀번호 암호화
		String encodePwd=new BCryptPasswordEncoder().encode(dto.getUserPwd());
		//암호화된 비밀번호를 UsersDto에 다시 넣어준다
		dto.setUserPwd(encodePwd);
		dao.insert(dto);
	}

	@Override
	public void validUser(UsersDto dto, HttpSession session, ModelAndView mView) {
		//아이디 비밀번호가 유효한지 여부
		boolean isValid=false;
		//아이디를 이용해서 저장된 비밀번호 읽어오기
		String pwdHash=dao.getPwdHash(dto.getUserId());
		if(pwdHash!=null) {
			isValid=BCrypt.checkpw(dto.getUserPwd(), pwdHash);
		}
		if(isValid) {
			//로그인 처리
			session.setAttribute("userId", dto.getUserId());
		}
	}
	
	
}
