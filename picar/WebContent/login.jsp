<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>login</title>
</head>
<body>
	<h1>로그인</h1>	
	<form action="login" method="post">
	대소문자를 구분해 주세요 . <br />
	
		<input type="text" name="id" id="id" placeholder="아이디를 입력하세요." /> <br />
		<input type="password" name="password" id="password" placeholder="비밀번호를 입력하세요."/> <br />
		<input type="submit" value="로그인">
		
		<input type="button" value="회원 가입" onclick="location.href='membership.jsp'">
	</form>	
	${message}		
</body>
</html>