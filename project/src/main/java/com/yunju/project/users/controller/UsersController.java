package com.yunju.project.users.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yunju.project.users.dto.UsersDto;
import com.yunju.project.users.service.UsersService;

@Controller
public class UsersController {
	@Autowired
	private UsersService service;
	
	//회원가입폼
	@RequestMapping("/users/signupform")
	public String signupform() {
		return "users/signupform";
	}
	
	//아이디 체크
	@ResponseBody
	@RequestMapping(value = "/users/checkId", method = RequestMethod.POST)
	public Map<String, Object> checkid(@RequestParam String inputId){
		Map<String, Object> map=service.isExistId(inputId);
		return map;
	}
	
	//signup
	@RequestMapping(value="/users/signup", method = RequestMethod.POST)
	public ModelAndView signup(@ModelAttribute("dto") UsersDto dto,
				ModelAndView mView) {
		service.addUser(dto);
		mView.setViewName("users/insert");
		return mView;
	}
	
	//로그인폼 요청처리
	@RequestMapping("/users/loginform")
	public String loginform(HttpServletRequest request) {
		//"url"이라는 파라미터가 넘어오는지 읽어와보기
		String url=request.getParameter("url");
		if(url==null) {
			//만일 없으면 로그인 성공후에 index페이지로 보내질수 있도록 설정
			url=request.getContextPath()+"/home.do";
		}
		//아이디,비밀번호가 쿠키에 저장되었는지 확인 후 저장되었으면 폼에 출력
		Cookie[] cookie=request.getCookies();
		//저장된 아이디와 비밀번호 담을 변수 선언하고 초기값으로 빈 문자열 대입
		String saveId="";
		String savePwd="";
		if(cookie!=null) {
			for(Cookie tmp:cookie) {
				if(tmp.getName().equals("saveId")) {
					saveId=tmp.getValue();
				}else if(tmp.getName().equals("savePwd")) {
					savePwd=tmp.getValue();
				}
			}
		}
		//view page에서 필요한 정보 넘겨주기
		request.setAttribute("url", url);
		request.setAttribute("saveId", saveId);
		request.setAttribute("savePwd", savePwd);
		return "users/loginform";
	}
}
