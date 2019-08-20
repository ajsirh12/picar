<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>PICAR - CarList</title>
</head>
<body>
	<h4>차량 리스트</h4>
	<form action="carlist" method="post">		
		<table>
			<tr>
				<td>차량 번호</td>
				<td>차종</td>
				<td>대 여</td>
			</tr>
			<c:forEach var="jiss" items="${jis}">
				<tr>
					<td>${jiss.carnum}</td>
					<td>${jiss.carname}</td>
					<td>${jiss.validrent}</td>
				</tr>
			</c:forEach>	
		</table>
	</form>
</body>
</html>