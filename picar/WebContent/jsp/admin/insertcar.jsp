<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title> PICAR - 차량 등록</title>
</head>
<body>
	<h1> 차량정보 등록 </h1>
	<form action="registercar" method="post">
	<h4>차량번호 </h4>
		<input type="text" placeholder="차량번호" name="carnum" /><br />
	<h4>차종 </h4> 
	    <select name=cartype>
		<option value="" selected disabled hidden> === 차 종  선 택 === </option>
		<c:forEach var="car" items="${carlist }">
			<option value="${car.carType }">${car.carName }</option>
		</c:forEach>
		</select>
	<h4>대여비용</h4>
		<input type="text" placeholder="대여비용" name="cost" /><br />		
	<h4>보유지점 </h4>
		<select name="carloc">
		<option value="" selected disabled hidden> === 지 점  선 택 === </option>
		<c:forEach var="loc" items="${locationlist }">
			<option value="${loc.carLoc }">${loc.location }</option>
		</c:forEach>
		</select><br />
		<br />
	<input type="submit" value="등 록" />
	<input type="button" value="뒤로가기" />
	</form>	
</body>
</html>