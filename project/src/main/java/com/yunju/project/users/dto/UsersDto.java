package com.yunju.project.users.dto;

public class UsersDto {
	private String userId;
	private String userPass;
	private String newPass; //비밀번호 변경할때 사용
	private String userName;
	private String userPhone;
	private String email;
	private String userAddr1;
	private String userAddr2;
	private String userAddr3;
	private String regidate;
	private String birthday;
	private int point;
	private int verify;

	private int startRowNum;
	private int endRowNum;
	private int prevNum;
	private int nextNum;
	private int listCount;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getNewPass() {
		return newPass;
	}
	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserAddr1() {
		return userAddr1;
	}
	public void setUserAddr1(String userAddr1) {
		this.userAddr1 = userAddr1;
	}
	public String getUserAddr2() {
		return userAddr2;
	}
	public void setUserAddr2(String userAddr2) {
		this.userAddr2 = userAddr2;
	}
	public String getUserAddr3() {
		return userAddr3;
	}
	public void setUserAddr3(String userAddr3) {
		this.userAddr3 = userAddr3;
	}
	public String getRegidate() {
		return regidate;
	}
	public void setRegidate(String regidate) {
		this.regidate = regidate;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getVerify() {
		return verify;
	}
	public void setVerify(int verify) {
		this.verify = verify;
	}
	public int getStartRowNum() {
		return startRowNum;
	}
	public void setStartRowNum(int startRowNum) {
		this.startRowNum = startRowNum;
	}
	public int getEndRowNum() {
		return endRowNum;
	}
	public void setEndRowNum(int endRowNum) {
		this.endRowNum = endRowNum;
	}
	public int getPrevNum() {
		return prevNum;
	}
	public void setPrevNum(int prevNum) {
		this.prevNum = prevNum;
	}
	public int getNextNum() {
		return nextNum;
	}
	public void setNextNum(int nextNum) {
		this.nextNum = nextNum;
	}
	public int getListCount() {
		return listCount;
	}
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
	
	
}
