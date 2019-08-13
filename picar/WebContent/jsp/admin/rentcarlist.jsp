<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8>
<title>차량 렌트목록</title>
</head>
<body>
<h2>차량 렌트목록</h2>
<table border="1">
	<tr>
		<form action="rentedSearch" method="post">
		<td colspan="7"><input type="text" id=carNum /> <input type="submit" /></td>
		</form>
	</tr>
	<tr>
		<th>carNum</th>
		<th>name</th>
		<th>phone</th>
		<th>rentStart</th>
		<th>rentEnd</th>
		<th>late</th>
		<th>반납</th>
	</tr>
	<c:forEach var="rented" items="${rentedList }">
	<tr>
		<td>${rented.carNum }</td>
		<td>${rented.name }</td>
		<td>${rented.phone }</td>
		<td>${rented.rentStart }</td>
		<td>${rented.rentEnd}</td>
		<td>
			<c:if test="${rented.late > 0}">${rented.late * rented.cost * 2}</c:if>
			<c:if test="${rented.late <= 0}">0</c:if>
		</td>
		<td><a href="#"><button>반납</button></a></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>