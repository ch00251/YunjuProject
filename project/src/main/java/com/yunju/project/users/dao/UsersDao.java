package com.yunju.project.users.dao;

import com.yunju.project.users.dto.UsersDto;

public interface UsersDao {
	public boolean isExist(String inputUserId);
	public void insert(UsersDto dto);
}
