<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>회원(본인)</title>
	</head>
	<body>
	<h1>문의사항</h1>
	<h2>제목</h2>
	${question.questtitle}
	<h2>내용</h2>
	${question.questtext}
	<input type="button" value="수정하기" onclick="location.href='commentc2.jsp'">
	<input type="button" value="뒤로가기" onclick="location.href='question.jsp'">
	
	</body>
</html>