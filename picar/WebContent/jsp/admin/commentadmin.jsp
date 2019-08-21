<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>게시판(관리자)</title>
	</head>
	<body>
	<h1>문의사항</h1>
	<h2>제목</h2>
	${question.questtitle}"
	<h2>내용</h2>
	${question.questtext}"
	<hr>
	<h2>답변</h2>
	<textarea rows="5" cols="40"></textarea><br>
	
	<input type="submit" value="답변등록">
	<input type="button" value="삭제하기">
	<input type="button" value="뒤로가기" onclick="location.href='question.jsp'">
	
	</body>
</html>