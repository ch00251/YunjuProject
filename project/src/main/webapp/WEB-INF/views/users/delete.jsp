<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/delete.jsp</title>
</head>
<body>
<div class="container">
	alert("${userId }님 회원탈퇴되었습니다.");
	<a href="${pageContext.request.contextPath }/home.do" >홈으로</a>
</div>
</body>
</html>