package com.yunju.project.users.controller;

import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
	//로그인 요청처리
	@RequestMapping(value="/users/login", method=RequestMethod.POST)
	public ModelAndView login(@ModelAttribute UsersDto dto,
			ModelAndView mView, HttpServletRequest request, HttpServletResponse response) {
		//목적지 정보
		String url=request.getParameter("url");
		if(url==null) {
			url=request.getContextPath()+"/home.do";
		}
		//목적지 정보를 미리 인코딩해 놓기
		String encodedUrl=URLEncoder.encode(url);
		//view page에 전달하기
		mView.addObject("url", url);
		mView.addObject("encodedUrl", encodedUrl);
		
		//아이디, 비밀번호 저장 체크박스를 체크했는지 읽어오기
		String isSave=request.getParameter("isSave");
		//아이디,비밀번호 쿠키에 저장
		Cookie idcook=new Cookie("saveId", dto.getUserId());
		Cookie pwdcook=new Cookie("savePwd", dto.getUserPwd());
		if(isSave!=null) {
			//한달동안 저장하기
			idcook.setMaxAge(60*60*24*30);
			pwdcook.setMaxAge(60*60*24*30);
		}else {
			//쿠키 지우기
			idcook.setMaxAge(0);
			pwdcook.setMaxAge(0);
		}
		//응답할때 쿠키도 심어지도록
		response.addCookie(idcook);
		response.addCookie(pwdcook);
		
		service.validUser(dto, request.getSession(), mView);
		
		mView.setViewName("users/login");
		return mView;
	}
	
	//개인정보 보기 요청
	@RequestMapping("/users/profile")
	public ModelAndView userProfile(HttpServletRequest request,
				ModelAndView mView) {
		//로그인된 아이디 읽어오기
		String id=(String)request.getSession().getAttribute("userId");
		//서비스 이용해서 ModelAndView객체에 개인정보 담기
		service.userProfile(id, mView);
		//view page에 정보 담기
		mView.setViewName("users/profile");
		return mView;
	}
	
	//비밀번호 수정폼 요청처리
	@RequestMapping("/users/newPwdform")
	public ModelAndView updatePwd(HttpServletRequest request, 
					ModelAndView mView) {
		mView.setViewName("users/newPwdform");
		return mView;
	}
	
	//비밀번호 수정 반영 요청 처리
	@RequestMapping("/users/pwdUpdate")
	public ModelAndView authPwdUpdate(HttpServletRequest request, 
					ModelAndView mView) {
		//기존 비밀번호
		String pwd=request.getParameter("userPwd");
		//새 비밀번호
		String newPwd=request.getParameter("newPwd");
		//로그인된 아이디
		String id=(String)request.getSession().getAttribute("userId");
		//위의 정보를 UsersDto 객체에 담아 서비스에 전달
		UsersDto dto=new UsersDto();
		dto.setUserPwd(pwd);
		dto.setNewPwd(newPwd);
		dto.setUserId(id);
		service.updatePwd(dto, mView);
		
		mView.setViewName("users/pwdUpdate");
		return mView;
	}
	
	@RequestMapping("users/delete")
	public ModelAndView deleteUser(HttpServletRequest request, 
					ModelAndView mView) {
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("userId");
		//서비스 이용해서 회원정보 삭제
		service.deleteUser(id);
		//로그아웃
		session.invalidate();
		
		mView.addObject("id",id);
		mView.setViewName("users/delete");
		return mView;
	}
}
