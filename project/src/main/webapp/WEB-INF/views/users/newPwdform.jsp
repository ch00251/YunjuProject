<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/newPwdform.jsp</title>
</head>
<body>
<div class="container">
	<h1>비밀번호 수정 페이지</h1>
	<form action="pwdUpdate.do" method="post">
		<div>
			<label for="userPwd">기존 비밀번호</label>
			<input type="password" name="userPwd" id="userPwd" />
		</div>
		<div>
			<label for="newPwd">새 비밀번호</label>
			<input type="password" name="newPwd" id="newPwd" />
		</div>
		<div>
			<label for="newPwd2">새 비밀번호 확인</label>
			<input type="password" name="newPwd2" id="newPwd2" />
		</div>
		<button type="submit">수정 확인</button>
	</form>
</div>
<!--  
<script>
	if(${isSuccess}){
		parent.close();
		window.close();
		self.close();
	}else if(${isSuccess}==false){
		alert("비밀번호가 틀렸습니다. 다시 시도해주세요");
	}
</script>
  -->
</body>
</html>