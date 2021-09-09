package com.yunju.project.users.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.yunju.project.users.dto.UsersDto;

public class UsersDaoImpl implements UsersDao {

	//핵심 의존 객체를 spring으로부터 주입받기(Dependency Injection)
	@Autowired
	private SqlSession session;
	
	@Override
	public void insert(UsersDto dto) {
		session.insert("users.insert", dto);
	}

}
