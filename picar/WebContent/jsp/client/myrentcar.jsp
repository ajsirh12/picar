<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>myRentCar</title>
</head>
<body>
<c:if test="${rentinfo.memberNum == picarmember.memberNum }">
	<img src="${car.carImage }" alt="" width="500" />
	<table border="1">
		<tr>
			<td>차종</td>
			<td>${car.carName }</td>
		</tr>
		<tr>
			<td>차량번호</td>
			<td>${rentinfo.carNum }</td>
		</tr>
		<tr>
			<td>1일 대여비용</td>
			<td>${carlist.cost }</td>
		</tr>
		<tr>
			<td>연료종류</td>
			<td>${car.fuelType }</td>
		</tr>
		<tr>
			<td>대여일</td>
			<td>${rentinfo.rentStart }</td>
		</tr>
		<tr>
			<td>반납일</td>
			<td>${rentinfo.rentEnd }</td>
		</tr>
		<form action="renew_car.do" method="post" id="frm">
		<tr>
			<td>연장일수</td>
			<td>
			<input type="number" name="renew" id="renew" required="required" min="1" max="7" value="1"/>
			<input type="hidden" name="rentnum" value="${rentinfo.rentNum }"/>
			<input type="hidden" name="membernum" value="${rentinfo.memberNum }"/>
			</td>
		</tr>
		<tr>
			<td colspan="2"><input type=button value="연장" id="renewbtn" /></td>	
		</tr>
		</form>
	</table>
</c:if>
<c:if test="${rentinfo.memberNum != picarmember.memberNum }">
	<h1>잘못된 접근입니다.</h1>
	<a href="go_index">홈으로 돌아가기</a>
</c:if>
<script type="text/javascript">
$(function() {
	$("#renewbtn").click(function() {
		var renew = $("#renew").val();
		var cost = ${carlist.cost} * $("#renew").val();
		if(confirm(renew+"일 연장 비용은 "+cost+" 원 입니다. 연장하시겠습니까?")){
	        document.getElementById('frm').submit();
	        return false;
		}
	})
});
	
</script>	
</body>
</html>