<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Detail</title>
</head>
<body>
	<c:forEach var="car" items="${carList }">
		<c:if test="${car.carType == carListList.carType }">
		<img src="${car.carImage }" width="500" alt="" />
		</c:if>
	</c:forEach><br />
	<table>
	<form action="carInfoUpdate.do" method="post">
	차량번호<input type="text" disabled="disabled" value="${carListList.carnum }" /><br />
	<input type="hidden" value="${carListList.carnum }" name="carnum" />
	차량종류
	<c:forEach var="car" items="${carList }">
		<c:if test="${car.carType == carListList.carType }">
		<input type="text" disabled="disabled" value="${car.carName }"/>
		</c:if>
	</c:forEach><br />
	차량색상
	<c:forEach var="car" items="${carList }">	
		<c:if test="${car.carType == carListList.carType }">
		<input type="text" disabled="disabled" value="${car.colorType }"/>
		</c:if>
	</c:forEach><br />
	차량연료
	<c:forEach var="car" items="${carList }">
		<c:if test="${car.carType == carListList.carType }">
		<input type="text" disabled="disabled" value="${car.fuelType }"/>
		</c:if>
	</c:forEach><br />
	대여비용<input type="number" name="cost" min="0" value="${carListList.cost }" /><br />
	지점위치 	
	<select name="carloc">
	<c:forEach var="loc" items="${locationList }">
		<c:if test="${carListList.carLoc == loc.carLoc }">
			<option value="${loc.carLoc }" selected="selected">${loc.location }</option>
		</c:if>
		<c:if test="${loc.carLoc != carListList.carLoc }">
			<option value="${loc.carLoc }">${loc.location }</option>
		</c:if>
	</c:forEach>
	</select>
	<br />
	승차인원
	<c:forEach var="car" items="${carList }">
		<c:if test="${car.carType == carListList.carType }">
		<input type="number" disabled="disabled" value="${car.people }"/>
		</c:if>
	</c:forEach><br />
	대여가능여부<br />
	<c:if test="${carListList.validRent == 'Y' || carListLIst.validRent == 'y' }">
	보유중<input type="radio" name="validrent" value="Y" checked="checked"/>
	대여중<input type="radio" name="validrent" value="N"/>
	</c:if>
	<c:if test="${carListList.validRent == 'N' || carListLIst.validRent == 'n' }">
	보유중<input type="radio" name="validrent" value="Y"/>
	대여중<input type="radio" name="validrent" value="N" checked="checked"/>
	</c:if><br />
	대여횟수
	<input type="number" min="${carListList.usedTime }" max="${carListList.usedTime+1 }" value="${carListList.usedTime }" disabled="disabled"/>
	<tr><td><input type="submit" value="수정" /></form>
	<a href="carInfoDelete.do?carnum=${carListList.carnum }"><button>삭제</button></a>
	<a href="allRentCar.do?reqPage=1"><button>뒤로</button></a></td></tr>
	</table>
</body>
</html>