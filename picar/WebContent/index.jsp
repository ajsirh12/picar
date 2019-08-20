<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8>
<title>picar index</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	
	<a href="question_req_list?reqPage=1">리스트로 이동 밑에 순서 표시</a>

	<ul>
		<li><a href="login_input">로그인</a></li> 		
		<li><a href="rentedList.do?reqPage=1">대여목록</a></li>
		<li><a href="myRentCar.do?membernum=${picarmember.memberNum }">내 차량</a></li>
		<li><a href="allRentCar.do?reqPage=1">관리자 차량목록</a></li>
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

