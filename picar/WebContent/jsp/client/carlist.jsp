<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>PICAR - CarList</title>
</head>
<body>
	<h4>지점별 차량 리스트</h4>
		<table border=1>
			<tr>
				<td>차량 번호</td>
				<td> 차 종 </td>
				<td>대여여부</td>
			</tr>			
			<c:forEach var="carlisty" items="${carlists}">
				<tr>
					<td>${carlisty.carnum}</td>
					<td>${carlisty.carName}</td>
					<td>${carlisty.validRent}</td>
				</tr>
			</c:forEach>	
		</table>
</body>
</html>