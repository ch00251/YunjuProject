<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/home.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
</head>
<body>
<div class="container">
	<h1>인덱스 페이지 입니다</h1>
	<ul>
		<li><a href="member/list.do">회원 목록 보기(member 테이블)</a></li>
		<li><a href="users/signupform.do">회원 가입</a></li>
		<li><a href="users/loginform.do">로그인</a></li>
		<li><a href="users/profile.do">내 정보</a></li>
	</ul>
	<h2>공지사항</h2>
</div>
</body>
</html>
