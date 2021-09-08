package com.yunju.project.users.dao;

import com.yunju.project.users.dto.UsersDto;

public interface UsersDao {
	//회원 가입, 로그인
	public void insert(UsersDto dto);
	
}
