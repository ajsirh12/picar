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
		<title>myrentcar</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<style>
		#renew{
			color: black;
		}
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
					<li><a href="index.jsp">Home</a></li>
					<li><a href="generic.html">Generic</a></li>
					<li><a href="elements.html">Elements</a></li>
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
						<c:if test="${rentinfo.memberNum == picarmember.memberNum }">
							<img src="${car.carImage }" alt="" width="500" />
							<table border="1">
								<tr align="center">
									<td>차종</td>
									<td>${car.carName }</td>
								</tr>
								<tr align="center">
									<td>차량번호</td>
									<td>${rentinfo.carNum }</td>
								</tr>
								<tr align="center">
									<td>1일 대여비용</td>
									<td>${carlist.cost }</td>
								</tr>
								<tr align="center">
									<td>연료종류</td>
									<td>${car.fuelType }</td>
								</tr>
								<tr align="center">
									<td>대여일</td>
									<td>${rentinfo.rentStart }</td>
								</tr>
								<tr align="center">
									<td>반납일</td>
									<td>${rentinfo.rentEnd }</td>
								</tr>
								<form action="renew_car.do" method="post" id="frm">
								<tr align="center">
									<td>연장일수</td>
									<td>
									<input type="number" name="renew" id="renew" required="required" min="1" max="7" value="1"/>
									<input type="hidden" name="rentnum" value="${rentinfo.rentNum }"/>
									<input type="hidden" name="membernum" value="${rentinfo.memberNum }"/>
									</td>
								</tr>
								<tr align="center">
									<td colspan="2"><input type=button value="연장" id="renewbtn" /></td>	
								</tr>
								</form>
							</table>
						</c:if>
						<c:if test="${rentinfo.memberNum != picarmember.memberNum }">
							<h1>잘못된 접근입니다.</h1>
							<a href="go_index">홈으로 돌아가기</a>
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
<script type="text/javascript">
$(function() {
	$("#renewbtn").click(function() {
		var renew = $("#renew").val();
		var cost = ${carlist.cost} * $("#renew").val();
		if(confirm(renew+"일 연장 비용은 "+cost+" 원 입니다. 연장하시겠습니까?")){
	        document.getElementById('frm').submit();
	        return false;
		}
	})
});
</script>
</body>
</html>