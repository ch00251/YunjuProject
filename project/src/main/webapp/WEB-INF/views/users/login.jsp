<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/login.jsp</title>
</head>
<body>
<div class="container">
	<c:choose>
		<c:when test="${not empty sessionScope.userId }">
			<p>
				<strong>${userId }</strong>회원님 로그인 되었습니다.
				<a href="url">확인</a>
			</p>
		</c:when>
		<c:otherwise>
			<p>
				아이디 또는 비밀번호가 잘못되었습니다.
				<a href="loginform.do?url=${encodedUrl }">다시 로그인 하러 가기</a>
			</p>
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>