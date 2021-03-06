package com.yunju.project.users.dao;

import com.yunju.project.users.dto.UsersDto;

public interface UsersDao {
	public boolean isExist(String inputuserId);
	public void insert(UsersDto dto);
	public String getPwdHash(String inputuserId);
	//데이터 가져오기(개인정보 볼때 사용)
	public UsersDto getData(String userId);
	public void updatePwd(UsersDto dto);
	public void delete(String userId);
}
