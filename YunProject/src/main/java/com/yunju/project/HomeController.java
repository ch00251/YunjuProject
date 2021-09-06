package com.yunju.project;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController{
	//home.do 요청이 왔을 때 처리
	@RequestMapping("/home.do")
	public String home(HttpServletRequest request) {
		return "home";
	}
}
