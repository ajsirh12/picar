<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>게시판(관리자)</title>
	</head>
	<body>
	<form action="commlist.update.do" method="post">
	<h1>문의사항</h1>
	<h2>제목</h2>
	${commentJoinList.questTitle}
	<h2>내용</h2>
	${commentJoinList.questText}
	<hr>
	<h2>답변</h2>
	<input type="hidden" name="commNum" value="${commList.commNum}"></input>
	<input type="hidden" name="memberNum" value="${commentJoinList.memberNum}"/>
	<input type="hidden" name="questNum" value="${commentJoinList.questnum}" />
	<textarea rows="5" cols="40" name = "commText">${commList.commText}</textarea><br>
	<input type="submit" value="수정하기">
	<input type="button" value="삭제하기" onclick ="location.href='question_admin_delete.do?questnum=${commentJoinList.questnum}'" >
	<input type="button" value="뒤로가기" onclick="location.href='question_req_admin_list.do?reqPage=1'"> 
	</form>
	</body>
</html>