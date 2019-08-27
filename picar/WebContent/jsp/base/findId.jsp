<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Id</title>
</head>
<body>

 <c:if test="${picarrmember !=null}">	
	 고객님의 정보와 일치하는 아이디 목록입니다. <br />
	<li>id = ${picarrmember.id}</li><br />
 </c:if>
 
 <c:if test="${picarrmember ==null}">	
	 고객님의 정보와 일치하는 정보가 없습니다 <br />
	
 </c:if>
	
	  
	
 <a href="login_input">로그인</a>	
</body>
</html>