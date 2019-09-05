
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
	<title>PICAR - Pick your CAR</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<link rel="stylesheet" href="assets/css/main.css" />
	<link rel="apple-touch-icon" sizes="57x57" href="favicon//apple-icon-57x57.png">
	<link rel="apple-touch-icon" sizes="60x60" href="favicon//apple-icon-60x60.png">
	<link rel="apple-touch-icon" sizes="72x72" href="favicon//apple-icon-72x72.png">
	<link rel="apple-touch-icon" sizes="76x76" href="favicon//apple-icon-76x76.png">
	<link rel="apple-touch-icon" sizes="114x114" href="favicon//apple-icon-114x114.png">
	<link rel="apple-touch-icon" sizes="120x120" href="favicon//apple-icon-120x120.png">
	<link rel="apple-touch-icon" sizes="144x144" href="favicon//apple-icon-144x144.png">
	<link rel="apple-touch-icon" sizes="152x152" href="favicon//apple-icon-152x152.png">
	<link rel="apple-touch-icon" sizes="180x180" href="favicon//apple-icon-180x180.png">
	<link rel="icon" type="image/png" sizes="192x192"  href="favicon/android-icon-192x192.png">
	<link rel="icon" type="image/png" sizes="32x32" href="favicon/favicon-32x32.png">
	<link rel="icon" type="image/png" sizes="96x96" href="favicon/favicon-96x96.png">
	<link rel="icon" type="image/png" sizes="16x16" href="favicon/favicon-16x16.png">
	<link rel="manifest" href="favicon/manifest.json">
	<meta name="msapplication-TileColor" content="#ffffff">
	<meta name="msapplication-TileImage" content="/ms-icon-144x144.png">
	<meta name="theme-color" content="#ffffff">
	<style>
	.asd{
		color: black;
	}
	.qwe{
		color: white;
		text-decoration: none;
	};
	.qwe:hover {
		color: black;
	};
	</style>
</head>
<body class="subpage">
	<!-- Header -->
		<header id="header" class="alt">
			<div class="logo"><a href="index.jsp">PICAR <span>Pick your CAR</span></a></div>
			<a href="#menu"><span>Menu</span></a>
		</header>

	<!-- Nav -->
		<nav id="menu">
			<ul class="links">
			 <c:if test="${picarmember !=null}">
	         <p>${picarmember.id} 님 <br>어서오세요.</p>   
	         </c:if>  
			   <li><a href="carlistloc">차량리스트</a></li>   
			   <li><a href="question_req_list?reqPage=1">회원 게시판 이동</a></li>
			   			   
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

	<!-- Content -->
	<!--
		Note: To show a background image, set the "data-bg" attribute below
		to the full filename of your image. This is used in each section to set
		the background image.
	-->
		<section id="post" class="wrapper bg-img" data-bg="banner2.jpg">
			<div class="inner">
				<article class="box">
					<header>
						<center><h2>차량 상세정보</h2></center>
					</header>
					<div class="content">
						<c:if test="${picarmember.gradeNo == 30}">
						<table>
						<c:forEach var="car" items="${carList}">
							<c:if test="${car.carType == carListList.carType}">
							<tr>
								<td colspan="2"><img src="${car.carImage}" width="100%" alt="" /></td>
							</tr>
							</c:if>
						</c:forEach>
						<form action="carInfoUpdate.do" method="post">
						<tr>
							<td>차량번호</td>
							<td><input type="text" disabled="disabled" value="${carListList.carnum}" />
							<input type="hidden" value="${carListList.carnum}" name="carnum" /></td>
						</tr>
						<tr>
							<td>차량종류</td>
							<td>
							<c:forEach var="car" items="${carList}">
							<c:if test="${car.carType == carListList.carType}">
							<input type="text" disabled="disabled" value="${car.carName}"/>
							</c:if>
							</c:forEach>
							</td>
						</tr>
						<tr>
							<td>차량색상</td>
							<td>
							<c:forEach var="car" items="${carList}">	
							<c:if test="${car.carType == carListList.carType}">
							<input type="text" disabled="disabled" value="${car.colorType}"/>
							</c:if>
							</c:forEach>
							</td>
						</tr>
						<tr>
							<td>차량연료</td>
							<td>
							<c:forEach var="car" items="${carList}">
							<c:if test="${car.carType == carListList.carType}">
							<input type="text" disabled="disabled" value="${car.fuelType}"/>
							</c:if>
							</c:forEach>
							</td>
						</tr>
						<tr>
							<td>승차인원</td>
							<td>
							<c:forEach var="car" items="${carList}">
							<c:if test="${car.carType == carListList.carType}">
							<%-- <input type="number" class="asd" disabled="disabled" value="${car.people }"/> --%>
							${car.people}
							</c:if>
							</c:forEach>
							 명
							</td>
						</tr>
						<tr>
							<td>대여비용</td>
							<td><input type="number" class="asd" name="cost" min="0" value="${carListList.cost}" /> 원</td>
						</tr>
						<tr>
							<td>지점위치 </td>
							<td>
							<select name="carloc">
							<c:forEach var="loc" items="${locationList}">
								<c:if test="${carListList.carLoc == loc.carLoc}">
									<option value="${loc.carLoc}" class="asd" selected="selected">${loc.location}</option>
								</c:if>
								<c:if test="${loc.carLoc != carListList.carLoc}">
									<option value="${loc.carLoc}" class="asd">${loc.location}</option>
								</c:if>
							</c:forEach>
							</select>
							</td>
						</tr>
						<tr>
							<td>대여가능여부</td>
							<td>
							<select name="validrent">
								<c:if test="${carListList.validRent == 'Y' || carListLIst.validRent == 'y'}">
									<option value="Y" class="asd" selected="selected">대여가능</option>
									<option value="N" class="asd">대여불가</option>
								</c:if>
								<c:if test="${carListList.validRent == 'N' || carListLIst.validRent == 'n'}">
									<option value="Y" class="asd">대여가능</option>
									<option value="N" class="asd" selected="selected">대여불가</option>
								</c:if>
							</select>
							<%-- <c:if test="${carListList.validRent == 'Y' || carListLIst.validRent == 'y' }">
							보유중<input type="radio" class="asd" name="validrent" value="Y" checked="checked"/>
							대여중<input type="radio" class="asd" name="validrent" value="N"/>
							</c:if>
							<c:if test="${carListList.validRent == 'N' || carListLIst.validRent == 'n' }">
							보유중<input type="radio" class="asd" name="validrent" value="Y"/>
							대여중<input type="radio" class="asd" name="validrent" value="N" checked="checked"/>
							</c:if> --%>
							</td>
						</tr>
						<tr>
							<td>대여횟수</td>
							<%-- <td><input type="number" class="asd" min="${carListList.usedTime }" max="${carListList.usedTime+1 }" value="${carListList.usedTime }" disabled="disabled"/></td> --%>
							<td>${carListList.usedTime} 회</td>
						</tr>
						<tr align="center">
							<td colspan="2">
							<input type="submit" value="수정" /></form>
							<input type="button" value="삭제" onclick="location.href='carInfoDelete.do?carnum=${carListList.carnum}'"/>
							<input type="button" value="뒤로" onclick="history.back(-1);"/>
							<%-- <a href="carInfoDelete.do?carnum=${carListList.carnum }"><button>삭제</button></a>
							<a href="allRentCar.do?reqPage=1"><button>뒤로</button></a> --%>
							</td>
						</tr>
						</table>
					</c:if>
					<c:if test="${picarmember.gradeNo != 30}">
						<h1>잘못된 접근입니다.</h1>
						<a href="go_index">홈으로 돌아가기</a>
					</c:if>	
					</div>
				</article>
			</div>
		</section>
		<footer id="footer">
			<div class="inner" align="center">
				(주)피카 대표자:임동건
				<div class="copyright">
					&copy; Untitled. Design: <a href="https://templated.co">TEMPLATED</a>. Images: <a href="https://unsplash.com">Unsplash</a>.
				</div>

			</div>
		</footer>
<!-- Scripts -->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/jquery.scrolly.min.js"></script>
<script src="assets/js/jquery.scrollex.min.js"></script>
<script src="assets/js/skel.min.js"></script>
<script src="assets/js/util.js"></script>
<script src="assets/js/main.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	</body>
</html>