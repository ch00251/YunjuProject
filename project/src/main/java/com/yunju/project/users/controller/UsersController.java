package com.yunju.project.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import com.yunju.project.users.service.UsersService;

public class UsersController {
	@Autowired
	private UsersService service;
	
	//회원가입폼
	@RequestMapping("/user/signupform")
	public String signupform() {
		return "user/signupform";
	}
	
}
