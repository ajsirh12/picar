<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>PICAR - Detail</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<h4>차량 상세정보</h4>
	<form action="reserveCar.do" method="post" id="frm">
		<table border=1>
			<tr>
				<td>차량번호</td>
				<td>차량종류</td>
				<td>보유지점</td>
				<td>1일기준 대여비용</td>
				<td>탑승인원</td>
				<td>연료종류</td>
			</tr>
			<tr>
				<td>${detail.carnum}</td>
				<td>${detail.carname}</td>
				<td>${detail.location}</td>
				<td>${detail.cost}</td>
				<td>${detail.people}</td>
				<td>${detail.fueltype}</td>
			</tr>
			<tr>
				<td>대여기간</td>
				<td><input type="date" name="firstdate" class="firstdate" required="required" value="" /></td>
				<td><input type="date" name="lastdate" class="lastdate" required="required" /></td>
			</tr>
		</table>
		<input type="hidden" value="${detail.carnum}" name="carnum" />
		<input type="hidden" value="${picarmember.memberNum }" name="membernum" />
		<input type="button" value="예약하기" id="reservebtn" />
	</form>
	<input type="button" value="뒤로가기" onclick="history.back(-1);" />
<script type="text/javascript">
$(function() {
	$("#reservebtn").click(function() {
			var firstdate = $(".firstdate").val();
			var stdate = new Date(firstdate);
			var lastdate = $(".lastdate").val();
			var endate = new Date(lastdate);
			var cost = ${detail.cost};
			
			var rented = endate-stdate;
			var date = 24 * 60 * 60 * 1000;
			
		if(confirm("총 대여일은 "+(rented/date)+"일 대여비용은 " + (rented/date)*cost + "원 입니다. 예약하시겠습니까?")){
	        document.getElementById('frm').submit();
	        return false;
		}
	})
});
</script>		
</body>
</html>