<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/user/profile.jsp</title>
</head>
<body>
<form action="info.do">
	<h1>나의 정보</h1>
	<br />
	<table id="signup">
		<tbody id="signbody">
			<tr>
				<th class="row">아이디</th>
				<td>${dto.userId }</td>
			</tr>
			<tr>
				<th class="row">비밀번호</th>
				<td><a onclick="newPwdform()">수정하기</a></td>
			</tr>
			<script>
				function newPwdform(){
					window.open("newPwdform.do","newPwd",
							"width=500, height=400, top=250, left=550, resizable=no")
				}
			</script>
			<tr>
				<th class="row">이름</th>
				<td>${dto.userName }</td>
			</tr>
			<tr>
				<th class="row">연락처</th>
				<td>${dto.userPhone }</td>
			</tr>
			<tr>
				<th class="row">E-mail</th>
				<td>${dto.email }</td>
			</tr>
			<tr>
				<th class="row">주소</th>
				<td>${dto.userAddr1} <br />
					${dto.userAddr2},${dto.userAddr3}</td>
			</tr>
			<tr>
				<th class="row">생년월일</th>
				<td>${dto.birthday }</td>
			</tr>
			<tr>
				<th class="row">가입일</th>
				<td>${dto.regidate  }</td>
			</tr>
		</tbody>
	</table>
</form>
<div class="sbtn">
	<div class="updatebtn" style="float:right">
		<div class="eff"></div>
		<a href="updateform.do">수정하기</a>
	</div>
	<br />
	<div class="homebtn" style="float:right">
		<div class="eff"></div>
		<a href="../home.do">홈으로</a>
	</div>
</div>
</body>
</html>