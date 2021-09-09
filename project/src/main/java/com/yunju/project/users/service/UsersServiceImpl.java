package com.yunju.project.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.yunju.project.users.dao.UsersDao;
import com.yunju.project.users.dto.UsersDto;

public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UsersDao dao;

	@Override
	public void addUser(UsersDto dto) {
		//비밀번호 암호화
		String encodedPass= new BCryptPasswordEncoder().encode(dto.getUserPass());
		//암호화된 비밀번호 UsersDto에 다시 넣어주기
		dto.setUserPass(encodedPass);
		//UsersDao 객체를 이용해서 DB에 저장
		dao.insert(dto);
	}
	
	
}
