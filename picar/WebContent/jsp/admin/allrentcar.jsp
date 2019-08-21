<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8>
<title>차량 렌트목록</title>
</head>
<body>
<c:if test="${picarmember.gradeNo == 30 }">
<h2>차량 렌트목록</h2>
<table border="1">
	<tr>
		<!-- <form action="allRentCarSearch.do?reqPage=1" method="post">
		<td colspan="7"><input type="text" name="carNum" /> <input type="submit" /></td>
		</form> -->
	</tr>
	<tr>
		<th>carNum</th>
		<th>carType</th>
		<th>cost</th>
		<th>people</th>
		<th>location</th>
		<th>valid</th>
		<th>detail</th>
	</tr>
	<c:forEach var="carList2" items="${carListList }">
	<tr>
		<td>${carList2.carnum }</td>
		<td>
		<c:forEach var="car" items="${carList }">
			<c:if test="${car.carType == carList2.carType }">${car.carName }</c:if>
		</c:forEach>
		</td>
		<td>${carList2.cost }</td>
		<td>
		<c:forEach var="car" items="${carList }">
			<c:if test="${car.carType == carList2.carType }">${car.people }</c:if>
		</c:forEach>
		</td>
		<td><c:forEach var="loc" items="${locationList }">
			<c:if test="${loc.carLoc == carList2.carLoc }">${loc.location }</c:if>
		</c:forEach></td>
		<td>${carList2.validRent }</td>
		<td><a href="carDetail.do?carNum=${carList2.carnum }"><button>상세보기</button></a></td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="7" align="center">
			<c:if test="${pageGroupResult.beforPage}">
				<a href="allRentCar.do?reqPage=${pageGroupResult.groupStartNumber - 1}">&lt;</a>
			</c:if>
			<c:if test="${!pageGroupResult.beforPage}">
				&lt;
			</c:if>&nbsp&nbsp&nbsp
			<c:forEach var="index" begin="${pageGroupResult.groupStartNumber }" end="${pageGroupResult.groupEndNumber }">
				<c:if test="${index == pageGroupResult.selectPageNumber }">
					<span id="select"><a href="allRentCar.do?reqPage=${index }">${index }</a></span>
				</c:if>
				<c:if test="${index != pageGroupResult.selectPageNumber }">
					<a href="allRentCar.do?reqPage=${index }">${index }</a>
				</c:if>
			</c:forEach>&nbsp&nbsp&nbsp
			<c:if test="${pageGroupResult.afterPage}">
				<a href="allRentCar.do?reqPage=${pageGroupResult.groupEndNumber + 1}">&gt;</a>
			</c:if>
			<c:if test="${!pageGroupResult.afterPage}">
				&gt;
			</c:if>
		</td>
	</tr>
</table>
</c:if>
<c:if test="${picarmember.gradeNo != 30 }">
	<h1>잘못된 접근입니다.</h1>
	<a href="go_index">홈으로 돌아가기</a>
</c:if>	
</body>
</html>