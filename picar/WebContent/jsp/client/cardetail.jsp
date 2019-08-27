<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>PICAR - Detail</title>
</head>
<body>
	<h4>차량 상세정보</h4>
	<form action="cardetail" method="post">
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
		</table>
		
		<input type="submit" value="예약하기" />
		<input type="button" value="뒤로가기" />
	</form>
</body>
</html>