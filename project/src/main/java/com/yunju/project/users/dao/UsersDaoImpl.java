package com.yunju.project.users.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yunju.project.users.dto.UsersDto;

@Repository
public class UsersDaoImpl implements UsersDao{
	@Autowired
	private SqlSession session;

	@Override
	public boolean isExist(String inputuserId) {
		//인자로 전달되는 아이디를 이용해서 select
		String id=session.selectOne("users.isExist", inputuserId);
		//만일 select된 결과가 null이면 존재하지 않는 아이디이다.
		if(id == null) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public void insert(UsersDto dto) {
		session.insert("users.insert", dto);
	}

	@Override
	public String getPwdHash(String inputuserId) {
		//입력한 아이디를 이용해서 저장된 비밀번호를 select 한다
		String savePwd=session.selectOne("users.getPwdHash", inputuserId);
		return savePwd;
	}

	@Override
	public UsersDto getData(String userId) {
		return session.selectOne("users.getData", userId);
	}

	@Override
	public void updatePwd(UsersDto dto) {
		session.update("users.updatePwd",dto);
	}
	
	
}
