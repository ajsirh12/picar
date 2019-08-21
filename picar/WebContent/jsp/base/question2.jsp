<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>게시판 메인메뉴</title>
		
		<meta name="viewport" content="width=device-width, initial-scale=1">
  		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		
		<script src="js/jquery.xml2json.js">
		
		</script>
		
		<style>
		table {margin-top: 30px}
		</style>
		
		
	</head>
	<body>
	<img onclick="location.href='index.jsp'" src="img/logo1.png" />
		<h1 align="center">문의사항 게시판</h1>
		
		<a href="question_insert.do?memberNum=${picarmember.memberNum}">글작성</a>
				<table border="1" class="table table-striped"> 
					<tr>
						<td>번호</td>
						<td>제목</td>
						<td>작성자</td>
						<td>답변</td>
					</tr>
					<c:forEach var="commentJoinList" items="${commentJoinLists}">
					<tr>
						<td>${commentJoinList.questnum}</td>
						<td><a href="question_detail.do?questnum=${commentJoinList.questnum}" onclick="other">${commentJoinList.questTitle}</a></td>
						<td>${commentJoinList.id}</td>
						<td>${commentJoinList.answer}</td>
					</tr>		
					</c:forEach>
				</table>
				
			<c:if test="${pageGroupResult.beforPage}">
				<a href="question_req_list.do?reqPage=${pageGroupResult.groupStartNumber-1}">《</a>
			</c:if>
	 
					<c:forEach var="index" begin="${pageGroupResult.groupStartNumber}" end="${pageGroupResult.groupEndNumber}">
						<c:choose>
							<c:when test="${pageGroupResult.selectPageNumber==index}">
								<span class="badge badge-secondary"><a href="question_req_list.do?reqPage=${index}">${index}</a></span>
							</c:when>
							<c:otherwise>
								<a href="question_req_list.do?reqPage=${index}">${index}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
	
	 		<c:if test="${pageGroupResult.afterPage}">
				<a href="question_req_list.do?reqPage=${pageGroupResult.groupEndNumber+1}">》</a>
			</c:if> 
	</body>
</html>