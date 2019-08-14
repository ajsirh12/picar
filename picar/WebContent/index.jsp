<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8>
<title>picar index</title>
</head>
<body>
	<ul>
		<li><a href="login_input">로그인</a></li> 					
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

