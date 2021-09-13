package com.yunju.project.users.service;

import java.util.Map;

import com.yunju.project.users.dto.UsersDto;

public interface UsersService {
	public Map<String, Object> isExistId(String inputUserId);
	public void addUser(UsersDto dto);
}
