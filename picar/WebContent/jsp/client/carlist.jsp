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
		<form action="carsearch" method="post">
		<input type="text" placeholder="차량 종류" name="carname">
		<input type="submit" value="검 색">
		</form>
		<br />
		<c:if test="${empty carlists}">
			검색된 결과가 존재하지 않습니다.
		</c:if>
		
		<c:if test="${!empty carlists}">
		<table border=1>
				<tr>
					<td>차량 번호</td>
					<td> 차 종 </td>
					<td>대여여부</td>
					<td>보유지점</td>
					<td>상세보기</td>
				</tr>				
				<c:forEach var="carlisty" items="${carlists}">
					<tr>					
						<td>${carlisty.carnum}</td>
						<td>${carlisty.carName}</td>
						<td>${carlisty.validRent}</td>
						<td>${carlisty.location}</td>
						<td><a href="cardetail?carnum=${carlisty.carnum}">클릭!</a></td>
					</tr>
				</c:forEach>	
			</table>
		</c:if>
</body>
</html>