<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8>
<title>차량 렌트목록1</title>
</head>
<body>
<c:if test="${picarmember.gradeNo == 30 }">
<h2>차량 렌트목록</h2>
	<table border="1">
	<tr>
		<form action="rentedSearch.do?reqPage=1" method="post">
		<td colspan="6"><input type="text" name="carNum" /> <input type="submit" /></td>
		</form>
		<td><a href="rentedList.do?reqPage=1"><button>목록</button></a></td>
	</tr>
	<tr>
		<th>carNum</th>
		<th>name</th>
		<th>phone</th>
		<th>rentStart</th>
		<th>rentEnd</th>
		<th>late</th>
		<th>반납</th>
	</tr>
	<c:forEach var="rented" items="${rentedList }">
	<tr>
		<td>${rented.carNum }</td>
		<td>${rented.name }</td>
		<td>${rented.phone }</td>
		<td>${rented.rentStart }</td>
		<td>${rented.rentEnd}</td>
		<td>
			<c:if test="${rented.late > 0}">${rented.late * rented.cost * 2}</c:if>
			<c:if test="${rented.late <= 0}">0</c:if>
		</td>
		<td><a href="#"><button>반납</button></a></td>
	</tr>
	</c:forEach>
	<%-- <tr>
		<td colspan="7" align="center">
			<c:if test="${pageGroupResult.beforPage}">
				<a href="rentedSearch.do?reqPage=1=${pageGroupResult.groupStartNumber - 1}">&lt;</a>
			</c:if>
			<c:if test="${!pageGroupResult.beforPage}">
				&lt;
			</c:if>&nbsp&nbsp&nbsp
			<c:forEach var="index" begin="${pageGroupResult.groupStartNumber }" end="${pageGroupResult.groupEndNumber }">
				<c:if test="${index == pageGroupResult.selectPageNumber }">
					<span id="select"><a href="rentedSearch.do?reqPage=${index }">${index }</a></span>
				</c:if>
				<c:if test="${index != pageGroupResult.selectPageNumber }">
					<a href="rentedSearch.do?reqPage=${index }">${index }</a>
				</c:if>
			</c:forEach>&nbsp&nbsp&nbsp
			<c:if test="${pageGroupResult.afterPage}">
				<a href="rentedSearch.do?reqPage=${pageGroupResult.groupEndNumber + 1}">&gt;</a>
			</c:if>
			<c:if test="${!pageGroupResult.afterPage}">
				&gt;
			</c:if>
		</td>
	</tr> --%>
</table>
</c:if>
<c:if test="${picarmember.gradeNo != 30 }">
	<h1>잘못된 접근입니다.</h1>
	<a href="go_index">홈으로 돌아가기</a>
</c:if>
</body>
</html>