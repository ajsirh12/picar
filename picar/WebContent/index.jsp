<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8>
<title>picar index</title>
</head>
<body>
	
	<a href="question_req_list?reqPage=1">리스트로 이동 밑에 순서 표시</a>

	<ul>
		<li><a href="login_input">로그인</a></li> 		
		<a href="rentedList?reqPage=1">qwe</a>			
	</ul>		
	${picarmember.id}
	<c:if test="${picarmember !=null}">
		<form action = "logout">
		<input type = "submit" value="로그 아웃" />
		<input type = "button" value="회원 정보 수정" />			
		</form>
	</c:if>	
	
	
	
</body>
</html>

