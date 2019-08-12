<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8>
<title>차량 렌트목록</title>
</head>
<body>
<h2>차량 렌트목록</h2>
<table>
	<tr>
		<th>차량번호</th>
		<th>차종</th>
		<th>대여비용</th>
		<th>승차인원수</th>
		<th>대여회원</th>
		<th>반납</th>
	</tr>
	<%-- <c:forEach var="rent" items="${rentList }"> --%>
	<tr>
		<td>12오3434</td>
		<td>마티즈</a></td>
		<td>123</td>
		<td>234</td>
		<td>345</td>
		<td><a href="#"><button>반납</button></a></td>
	</tr>
	<%-- </c:forEach> --%>
</table>
</body>
</html>