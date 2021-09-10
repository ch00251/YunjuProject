package com.yunju.project.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yunju.project.member.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao{
	@Autowired
	private SqlSession session;

	@Override
	public List<MemberDto> getList() {
		List<MemberDto> list=session.selectList("member.getList");
		return list;
	}
	
	
}
