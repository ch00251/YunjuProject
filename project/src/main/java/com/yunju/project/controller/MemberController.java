package com.yunju.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yunju.project.member.dao.MemberDao;
import com.yunju.project.member.dto.MemberDto;

@Controller
public class MemberController {
	//의존 객체 주입
	@Autowired
	private MemberDao dao;
	
	//회원 목록 보기
	@RequestMapping("/member/list")
	public ModelAndView list(ModelAndView mView) {
		//목록 얻어오기
		List<MemberDto> list=dao.getList();
		mView.addObject("list", list);
		mView.setViewName("member/list");
		return mView;
	}
}
