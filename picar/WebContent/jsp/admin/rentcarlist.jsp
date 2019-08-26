
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
<body class="subpage">
	<!-- Header -->
		<header id="header" class="alt">
			<div class="logo"><a href="index.jsp">PICAR <span>Pick your CAR</span></a></div>
			<a href="#menu"><span>Menu</span></a>
		</header>

	<!-- Nav -->
		<nav id="menu">
			<ul class="links">      
			   <li><a href="question_req_list.do?reqPage=1">회원 게시판 이동</a></li>
			      
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
						<center><h2>차량 렌트목록</h2></center>
					</header>
					<div class="content">
						<c:if test="${picarmember.gradeNo == 30 }">
						<table border="1">
							<tr>
							<form action="rentedSearch.do?reqPage=1" method="post">
							<td colspan="2"><input type="text" name="carNum" placeholder="차량번호" /> <td><input type="submit" value="검색" /></td>
							<td colspan="4">
							</form>
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
								<td><a href="carInfo.do?carNum=${rented.carNum }"><button>반납</button></a></td>
								<%-- <form action="returnCar.do?carNum=${rented.carNum }" method="post" id="frm">
									<input type="hidden" value="${rented.late }" class="late" />
									<input type="hidden" value="${rented.cost }" class="cost" />
									<c:forEach var="rented2" items="${rentedList }">
										<c:if test="${rented.carNum == rented2.carNum }">
											<td><input type=button value="반납" class="returnbtn" /></td>
											<td><a href="returnCar.do?carNum=${rented.carNum }" class="returnbtn"><button>반납</button></a></td>
											<!-- <td><button class="returnbtn">반납</button></td> -->
										</c:if>
									</c:forEach>
								</form> --%>
							</tr>
							</c:forEach>
							<tr>
								<td colspan="7" align="center">
									<c:if test="${pageGroupResult.beforPage}">
										<a href="rentedList.do?reqPage=${pageGroupResult.groupStartNumber - 1}">&lt;</a>
									</c:if>
									<c:if test="${!pageGroupResult.beforPage}">
										&lt;
									</c:if>
									<c:forEach var="index" begin="${pageGroupResult.groupStartNumber }" end="${pageGroupResult.groupEndNumber }">
										<c:if test="${index == pageGroupResult.selectPageNumber }">
											<span id="select"><a href="rentedList.do?reqPage=${index }">${index }</a></span>
										</c:if>
										<c:if test="${index != pageGroupResult.selectPageNumber }">
											<a href="rentedList.do?reqPage=${index }">${index }</a>
										</c:if>
									</c:forEach>
									<c:if test="${pageGroupResult.afterPage}">
										<a href="rentedList.do?reqPage=${pageGroupResult.groupEndNumber + 1}">&gt;</a>
									</c:if>
									<c:if test="${!pageGroupResult.afterPage}">
										&gt;
									</c:if>
								</td>
							</tr>
						</table>
						</c:if>
						<c:if test="${picarmember.gradeNo != 30 }">
							<h1>잘못된 접근입니다.</h1>
							<a href="go_index">홈으로 돌아가기</a>
						</c:if>
					</div>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	$(".returnbtn").click(function() {
		//<c:forEach var="rented" items="${rentedList }">
			//alert(${rented.late});
			var late = $(".late").val();
			var cost = $(".cost").val();
			if(late <= 0){
				late = 0;
			}
			var latefee = late * cost * 2;
			//var late = ${rented.late};
			//var cost = ${rented.cost};
			//var carnum = ${rented.carNum};
			//var latefee = late * cost * 2;
			//alert(carnum);
			
		//</c:forEach>
		if(confirm("연체료는 "+latefee+"원 입니다. 반납하시겠습니까?")){
	        document.getElementById('frm').submit();
	        return false;
		}
	})
});
</script>	
	</body>
</html>