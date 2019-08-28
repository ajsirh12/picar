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
	.qwe{
		color: white;
		text-decoration: none;
	};
	.qwe:hover {
		color: black;
	};
	</style>
</head>
<body>
	<!-- Header -->
		<header id="header">
			<div class="logo"><a href="index.jsp">PICAR <span>Pick your CAR</span></a></div>
			<a href="#menu"><span>Menu</span></a>
		</header>

	<!-- Nav -->
		<nav id="menu">
			<ul class="links">      
			   <li><a href="question_req_list.do?reqPage=1">회원 게시판 이동</a></li>
			   <li><a href="insertcar">InsertCar</a></li>
			   <li><a href="carlistloc">CarList</a></li>
			   <c:if test="${picarmember.gradeNo==30}">         
			      <li><a href="question_req_admin_list.do?reqPage=1">관리자 게시판 이동</a></li>
			      <li><a href="picarmemberlist">회원 관리</a></li>                  
			      <li><a href="rentedList.do?reqPage=1">대여목록</a></li>
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
				<td><a href="sign_up"><button>회원가입</button></a></td>
				</tr>
				<tr align="center">
					&nbsp<a href="id_find" class="qwe">아이디찾기</a>&nbsp&nbsp&nbsp
					<a href="password_find" class="qwe">비밀번호 찾기</a>
				</tr>					
				</table>
				${message}
			   </c:if>   
			      
			   <p>${picarmember.id}</p>
			   <c:if test="${picarmember !=null}">
			      <form action = "logout">
			      <input type = "submit" value="로그 아웃" /> 		
			      <input type="button" value="내 정보" onclick="location.href='member_infor?membernum='${picarmember.memberNum}'" />	         
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
		<section id="banner" class="bg-img" data-bg="header.jpg">
			<div class="inner">
				<header>
					<h1>Pick Car YourSelf</h1>
				</header>
			</div>
			<a href="#one" class="more">Learn More</a>
		</section>

	<!-- One -->
		<section id="one" class="wrapper post bg-img" data-bg="banner2.jpg" heigth>
			<div class="inner">
				<article class="box">
				<header>
					<p style="font-size:35px; color:white">지금 피카에서 함께 떠날차를 골라보세요</p>
				</header>
				<div class="content">
					<img src="img/santape.png" width="100%"/>	
					<br><br><br>
					<img src="img/sonata.png" width="100%"/>
					<br><br>
					<input type="button" onclick="location.href='carlistloc'" value="차량 리스트로 이동"/>
				</div>
				</article>
			</div>
			<a href="#two" class="more">Learn More</a>
		</section>

	<!-- Two -->
		<section id="two" class="wrapper post bg-img" data-bg="banner5.jpg">
			<div class="inner">
				<article class="box">
					<header>
						<p style="font-size:35px; color:white">피카와 함께 떠나는 Trip</p>
					</header>
					<div class="content">
						<video src="img/pick movie.mp4" width="100%" height="100%" controls="controls"></video>
						<h3 align="left">유의사항</h3>
						<div align="left">
						- 피카는 면허증은 기간이 6개월 이하인 회원은 이용이 불가능 합니다<br>
						- 회원가입을 하시지 않을 경우 이용이 불가능 합니다.<br>
						- 대여기간을 지키시지 않을 경우 연체료를 납부해야합니다.<br>
						</div>
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