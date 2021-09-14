<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/loginform.jsp</title>
</head>
<body>
<div class="container">
	<form action="login.do" method="post">
		<h2 class="title">로그인</h2>
		<br /><br />
		<label for="userId">아이디</label>
		<input type="text" id="userId" name="userId" class="form-control" placeholder="아이디" required="required"/>
		<label for="userPwd">비밀번호</label>
		<input type="password" id="userPwd" name="userPwd" class="form-control" placeholder="비밀번호"/>
		<div class="checkbox">
			<label>
				<input type="checkbox" name="isSave" value="yes" />아이디, 비밀번호 저장
			</label>
		</div>
	<button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
	</form>
</div>
</body>
</html>