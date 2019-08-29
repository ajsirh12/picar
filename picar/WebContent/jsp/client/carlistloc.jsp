<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>PICAR - CarList</title>
</head>
<body>
	<h1> 차량정보리스트 </h1>
		<h4>지점명을 선택해주세요.</h4>
	<form method="post">
		<table border=1>
		<tr>
			<td> 지점명 </td>
		</tr>
				
			<c:forEach var="carlocy" items="${carlocc}"> 
				<tr>			
					<td><a href="carlisty?carloc=${carlocy.carLoc}">${carlocy.location}</a></td>					
				</tr>
			</c:forEach>
		</table>	
	</form>	
	<input type="button" value="뒤로가기" onclick="history.back(-1);" />
</body>
</html>