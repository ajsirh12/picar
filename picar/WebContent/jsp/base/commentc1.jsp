<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>회원(본인)</title>
	</head>
	<body>
	<h1>문의사항</h1>
	<form action="question_detail2?questnum=${commentJoinList.questnum}" method="post">
	<input type="hidden" name="questnum" value="${commentJoinList.questnum}"/>
	<h2>제목</h2>
	${commentJoinList.questTitle}
	<h2>내용</h2>
	${commentJoinList.questText}<br>
	<input type="submit" value="수정하기">
	<input type="button" value="뒤로가기" onclick="location.href='question_req_list?reqPage=1'">
	</form>
	</body>
</html>