<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/pwdUpdate.jsp</title>
</head>
<body>
	<div class="container">
		<c:choose>
			<c:when test="${isSuccess }">
				<script>
					alert("비밀번호를 수정했습니다.");
					location.href="profile.do";
				</script>
			</c:when>
			<c:otherwise>
				<script>
					alert("기존 비밀번호가 일치하지 않습니다.");
					location.href="newPwdform.do";
				</script>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>