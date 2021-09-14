package com.yunju.project.users.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.yunju.project.users.dto.UsersDto;

public interface UsersService {
	//아이디 중복 확인
	public Map<String, Object> isExistId(String inputuserId);
	public void addUser(UsersDto dto);
	public void validUser(UsersDto dto, HttpSession session, ModelAndView mView);
}
