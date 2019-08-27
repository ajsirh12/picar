<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta  charset="utf-8">
<title>picarmemberlist</title>
</head>
<body>
<header id="header" class="alt">
	<div class="logo"><a href="index.jsp">PICAR <span>Pick up your CAR</span></a></div>
</header>



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
			<td> <a href ="member_detail?memberdetail=${picarmember.memberNum}">${picarmember.id}</a></td>
			<td>${picarmember.password}</td>
			<td>${picarmember.name}</td>
			<td>${picarmember.phone}</td>
			<td>${picarmember.license}</td>
			<td>${picarmember.validate}</td>														
		</tr>
		</c:forEach>
	</table>

	<c:if test="${pageGroupResult.beforPage}">
		<a href="member_list.do?reqPage=${pageGroupResult.groupStartNumber-1}">《</a>
	</c:if>
	 
	<c:forEach var="index" begin="${pageGroupResult.groupStartNumber}" end="${pageGroupResult.groupEndNumber}">
		<c:choose>
			<c:when test="${pageGroupResult.selectPageNumber==index}">
				<a href="member_list.do?reqPage=${index}">${index}</a>
			</c:when>
			<c:otherwise>
				<a href="member_list.do?reqPage=${index}">${index}</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	
	<c:if test="${pageGroupResult.afterPage}">
		<a href="member_list.do?reqPage=${pageGroupResult.groupEndNumber+1}">》</a>
	</c:if> 

</body>
</html>