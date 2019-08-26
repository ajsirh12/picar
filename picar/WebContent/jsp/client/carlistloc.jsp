<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
		<option value="1"> 마티즈 </option>
		<option value="2"> K7 </option>
		<option value="3"> 아반떼 </option>
		</select>
	<h4>대여비용</h4>
		<input type="text" placeholder="대여비용" name="cost" /><br />		
	<h4>보유지점 </h4>
		<select name="carloc">
		<option value="" selected disabled hidden> === 지 점 선 택 === </option>
		<option value="1"> 강남점 </option>
		<option value="2"> 영등포점 </option>
		<option value="3"> 마포점 </option>
		</select><br />
	<br /><input type="submit" value="등록">
	<input type="button" value="뒤로가기" />
	</form>	
</body>
</html>