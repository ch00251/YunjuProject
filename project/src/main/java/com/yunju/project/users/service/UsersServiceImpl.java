package com.yunju.project.users.service;

import com.yunju.project.users.dao.UsersDao;
import com.yunju.project.users.dto.UsersDto;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService{
	@Autowired
	private UsersDao dao;

	@Override
	public Map<String, Object> isExistId(String inputUserId) {
		boolean isExistId=dao.isExist(inputUserId);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("isExist", isExistId);
		return map;
	}

	@Override
	public void addUser(UsersDto dto) {
		String encodePass=new BCryptPasswordEncoder().encode(dto.getUserPwd());
		dto.setUserPwd(encodePass);
		dao.insert(dto);
	}
	
	
}
