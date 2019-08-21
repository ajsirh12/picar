<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta  charset="utf-8">
<title>picarmemberlist</title>
</head>
<body>
<h2>picarmember List</h2>	
	<table border="1">
		<tr>
			<th>회원번호 </th>
			<th>아이디</th>
			<th>비밀번호</th>	
			<th>이름</th>	
			<th>전화번호</th>	
			<th>면허번호</th>	
			<th>면허유효기간</th>				
		</tr>
	<c:forEach var="picarmember" items="${picarmemberlists}">
		<tr>
			<td>${picarmember.memberNum}</td>
			<td> <a href = "member_detail?memberdetail=${picarmember.memberNum}">${picarmember.id}</a></td>
			<td>${picarmember.password}</td>
			<td>${picarmember.name}</td>
			<td>${picarmember.phone}</td>
			<td>${picarmember.license}</td>
			<td>${picarmember.validate}</td>	
													
		</tr>
		</c:forEach>
	</table>

</body>
</html>