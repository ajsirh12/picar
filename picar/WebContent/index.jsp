<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
				<div class="logo"><a href="index.jsp">Road Trip <span>by TEMPLATED</span></a></div>
				<a href="#menu"><span>Menu</span></a>
			</header>

		<!-- Nav -->
			<nav id="menu">
				<ul class="links">      
				   <li><a href="question_req_list.do?reqPage=1">회원 게시판 이동</a></li>
				   	 <li> <a href="insertcar">InsertCar</a></li>
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
						대소문자를 구분해 주세요 . <br />
						<input type="text" name="id" id="id" placeholder="Username" /> <br />
						<input type="password" name="password" id="password" placeholder="password"/> 
						
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
			<section id="banner" class="bg-img" data-bg="banner.jpg">
				<div class="inner">
					<header>
						<h1>This is Road Trip</h1>
					</header>
				</div>
				<a href="#one" class="more">Learn More</a>
			</section>

		<!-- One -->
			<section id="one" class="wrapper post bg-img" data-bg="banner2.jpg">
				<div class="inner">
					<article class="box">
						<header>
							<h2>Nibh non lobortis mus nibh</h2>
							<p>01.01.2017</p>
						</header>
						<div class="content">
							<p>Scelerisque enim mi curae erat ultricies lobortis donec velit in per cum consectetur purus a enim platea vestibulum lacinia et elit ante scelerisque vestibulum. At urna condimentum sed vulputate a duis in senectus ullamcorper lacus cubilia consectetur odio proin sociosqu a parturient nam ac blandit praesent aptent. Eros dignissim mus mauris a natoque ad suspendisse nulla a urna in tincidunt tristique enim arcu litora scelerisque eros suspendisse.</p>
						</div>
						<footer>
							<a href="generic.html" class="button alt">Learn More</a>
						</footer>
					</article>
				</div>
				<a href="#two" class="more">Learn More</a>
			</section>

		<!-- Two -->
			<section id="two" class="wrapper post bg-img" data-bg="banner5.jpg">
				<div class="inner">
					<article class="box">
						<header>
							<h2>Mus elit a ultricies at</h2>
							<p>12.21.2016</p>
						</header>
						<div class="content">
							<p>Scelerisque enim mi curae erat ultricies lobortis donec velit in per cum consectetur purus a enim platea vestibulum lacinia et elit ante scelerisque vestibulum. At urna condimentum sed vulputate a duis in senectus ullamcorper lacus cubilia consectetur odio proin sociosqu a parturient nam ac blandit praesent aptent. Eros dignissim mus mauris a natoque ad suspendisse nulla a urna in tincidunt tristique enim arcu litora scelerisque eros suspendisse.</p>
						</div>
						<footer>
							<a href="generic.html" class="button alt">Learn More</a>
						</footer>
					</article>
				</div>
				<a href="#three" class="more">Learn More</a>
			</section>

		<!-- Three -->
			<section id="three" class="wrapper post bg-img" data-bg="banner4.jpg">
				<div class="inner">
					<article class="box">
						<header>
							<h2>Varius a cursus aliquet</h2>
							<p>11.11.2016</p>
						</header>
						<div class="content">
							<p>Scelerisque enim mi curae erat ultricies lobortis donec velit in per cum consectetur purus a enim platea vestibulum lacinia et elit ante scelerisque vestibulum. At urna condimentum sed vulputate a duis in senectus ullamcorper lacus cubilia consectetur odio proin sociosqu a parturient nam ac blandit praesent aptent. Eros dignissim mus mauris a natoque ad suspendisse nulla a urna in tincidunt tristique enim arcu litora scelerisque eros suspendisse.</p>
						</div>
						<footer>
							<a href="generic.html" class="button alt">Learn More</a>
						</footer>
					</article>
				</div>
				<a href="#four" class="more">Learn More</a>
			</section>

		<!-- Four -->
			<section id="four" class="wrapper post bg-img" data-bg="banner3.jpg">
				<div class="inner">
					<article class="box">
						<header>
							<h2>Luctus blandit mi lectus in nascetur</h2>
							<p>10.30.2016</p>
						</header>
						<div class="content">
							<p>Scelerisque enim mi curae erat ultricies lobortis donec velit in per cum consectetur purus a enim platea vestibulum lacinia et elit ante scelerisque vestibulum. At urna condimentum sed vulputate a duis in senectus ullamcorper lacus cubilia consectetur odio proin sociosqu a parturient nam ac blandit praesent aptent. Eros dignissim mus mauris a natoque ad suspendisse nulla a urna in tincidunt tristique enim arcu litora scelerisque eros suspendisse.</p>
						</div>
						<footer>
							<a href="generic.html" class="button alt">Learn More</a>
						</footer>
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
<body>
	<a href="insertcar">InsertCar</a><br />
	<a href="carlistloc">CarList</a><br />
	<a href="rentedList?reqPage=1">RentedList</a>
	
	
	
	<a href="question_req_list.do?reqPage=1">회원 게시판 이동</a><br/>
	<a href="question_req_admin_list.do?reqPage=1">관리자 게시판 이동</a>
	<ul>
		<li><a href="login_input">로그인</a></li> 		
		<li><a href="rentedList.do?reqPage=1">대여목록</a></li>
		<li><a href="myRentCar.do?membernum=${picarmember.memberNum }">내 차량</a></li>
	</ul>		
	<p>${picarmember.id}</p>
	<c:if test="${picarmember !=null}">
		<form action = "logout">
		<input type = "submit" value="로그 아웃" />
		<input type = "button" value="회원 정보 수정" />			
		</form>
	</c:if>	
</body>
</html>



	
