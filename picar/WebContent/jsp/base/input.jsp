<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>글쓰기</title>
	</head>
	<body>
	<h1>문의사항</h1>
	<form action="question_input" method="post">
	<h2>제목</h2>
	<input type="text" name="subject" placeholder="제목을 입력해주세요" />
	<h2>내용</h2>
	<textarea rows="20" cols="80" name="write" placeholder="내용을 입력해주세요"></textarea><br>
	<input type="submit" value="등록하기">
	<input type="button" value="뒤로가기" onclick="location.href='question_req_list?reqPage=1'">
	</form>
	</body>
</html>