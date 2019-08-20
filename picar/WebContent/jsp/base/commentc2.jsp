<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>회원(수정 누른후)</title>
	</head>
	<body>
	<h1>문의사항</h1>
	<form action="question_update.do" method="post">
	<input type="hidden" name="questnum" value="${commentJoinList.questnum}"/>
	<h2>제목</h2>
	<input type="text" name="questTitle" value="${commentJoinList.questTitle}"/>
	<h2>내용</h2>
	<textarea rows="20" cols="80" name="questText" value="${commentJoinList.questText}">${commentJoinList.questText}</textarea><br>
	<hr>
	
	<input type="submit" value="수정하기">
	<input type="button" value="삭제하기" onclick="location.href='question_delete.do?questnum=${commentJoinList.questnum}'">
	<input type="button" value="뒤로가기" onclick="location.href='question_req_list.do?reqPage=1'">
	</form>
	</body>
</html>