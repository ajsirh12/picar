<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!--
	Road Trip by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>
<head>
		<title>Road Trip by TEMPLATED</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	<body class="subpage">

		<!-- Header -->
			<header id="header" class="alt">
				<div class="logo"><a href="index.jsp">PICAR <span>Pick up your CAR</span></a></div>
				<a href="#menu"><span>Menu</span></a>
			</header>

		<!-- Nav -->
			<nav id="menu">
			<ul class="links">
			 <c:if test="${picarmember !=null}">
	         <p>${picarmember.id} 님 <br>어서오세요.</p>   
	         </c:if>  
			   <li><a href="carlistloc">차량리스트</a></li>   
			   <li><a href="question_req_list.do?reqPage=1">회원 게시판 이동</a></li>
			   			   
			   <c:if test="${picarmember.gradeNo==30}">  			  	         
			      <li><a href="question_req_admin_list.do?reqPage=1">관리자 게시판 이동</a></li>
			      <li><a href="member_list?reqPage=1">회원 관리</a></li>			                       
			      <li><a href="rentedList.do?reqPage=1">대여목록</a></li>
			      <li><a href="insertcar">차량등록</a></li>
			      <li><a href="allRentCar.do?reqPage=1">관리자 차량목록</a></li>
			   </c:if>   
			      <li><a href="myRentCar.do?membernum=${picarmember.memberNum }">내 차량</a></li>   
			   <c:if test="${picarmember ==null}">
			      <table>
			      <form action="login" method="post">
					
					<input type="text" name="id" id="id" placeholder="Username" /> <br />
					<input type="password" name="password" id="password" placeholder="password" /> 
					
					<tr>
					<td><input type="submit" value="로그인"></td>		
				</form>
				<td><input type="button" value="회원가입" onclick="location.href='sign_up'" /></td> 
				</tr>
				<tr align="center">
					&nbsp<a href="id_find" class="qwe">아이디찾기</a>&nbsp&nbsp&nbsp
					<a href="password_find" class="qwe">비밀번호 찾기</a>
				</tr>					
				</table>
				<p>${message}</p>
			   </c:if>   
			      
			  <br>
			   <c:if test="${picarmember !=null}">
			      <form action = "logout">
			      <input type = "submit" value="로그 아웃" /> 		
			      <input type="button" value="내 정보" onclick="location.href='member_infor?membernum=${picarmember.memberNum}'" />	         
			      </form>	
			     
			   </c:if>   
			</ul>
		</nav>

		<!-- Banner -->
		<!--
			Note: To show a background image, set the "data-bg" attribute below
			to the full filename of your image. This is used in each section to set
			the background image.
		-->
		<!-- One -->
			<section id="one" class="wrapper post bg-img" data-bg="banner2.jpg">
				<div class="inner">
					<article class="box">
						<header>
							<h2>문의사항 답변게시판</h2>
						</header>
						
						<c:if test="${empty commentJoinLists}">
						검색된 결과가 없습니다.
						</c:if>
				<c:if test="${!empty commentJoinLists}">		
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
						<td><a href="question_admin_detail.do?questNum=${commentJoinList.questnum}" onclick="other">${commentJoinList.questTitle}</a></td>
						<td>${commentJoinList.id}</td>
						<td>${commentJoinList.answer}</td>
					</tr>		
					</c:forEach>
				</table>
				</c:if>
			<form action ="comment_admin_search.do" method="post">
				<input type="text" name="questTitle" placeholder="제목을 입력해주세요" style="width:300px; float:left;" />
				<input type="submit" value = "검색" style="float:left;"/>
			</form>	<br><br>
				
			<c:if test="${pageGroupResult.beforPage}">
				<a href="question_req_admin_list.do?reqPage=${pageGroupResult.groupStartNumber-1}">《</a>
			</c:if>
	 
					<c:forEach var="index" begin="${pageGroupResult.groupStartNumber}" end="${pageGroupResult.groupEndNumber}">
						<c:choose>
							<c:when test="${pageGroupResult.selectPageNumber==index}">
								<span class="badge badge-secondary"><a href="question_req_admin_list.do?reqPage=${index}">${index}</a></span>
							</c:when>
							<c:otherwise>
								<a href="question_req_admin_list.do?reqPage=${index}">${index}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
	
	 		<c:if test="${pageGroupResult.afterPage}">
				<a href="question_req_admin_list.do?reqPage=${pageGroupResult.groupEndNumber+1}">》</a>
			</c:if> 
						
					</article>
				</div>
				
			</section>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>

	</body>
</html>