<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title> PICAR - 차량 등록</title>
</head>
<body>
	<h1> 차량정보 등록 </h1>
	<form method="post">
	<h4>차량번호 </h4>
	<input type="text" placeholder="차량번호" name="carnum" /><br />
	<h4>차종 </h4> 
	    <select name=cartype>
		<option value="car"> 차종 </option>
		<option value="matiz"> 마티즈 </option>
		<option value="K7"> K7 </option>
		</select>
	<h4>대여 </h4>
		<input type="radio" name="rent" value="y"> 가능
		<input type="radio" name="rent" value="n"> 불가능
	<h4>보유지점 </h4>
	<input type="text" placeholder="보유지점" name="location" /><br />
	</form>
	<br /><input type="submit" value="등록">
	<input type="button" value="뒤로가기" />


</body>
</html>