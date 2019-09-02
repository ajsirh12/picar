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
	<style>
	
	textarea {
		height: 300px;
	}
	
		h3 {
		text-align:left;
	}
	
	
	</style>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
	<script type="text/javascript">
	
	$(function(){
		$("#commcheck").click(function(){
        	var input_val =$("#commText").val();
         
        	if(!input_val){
        		alert("답변을 입력해주세요");  
        		return false;
         	}
		});
	});
	
	$(function(){
		$("#deletebutton").click(function(){
			var result = confirm("정말 게시물을 삭제하시겠습니까?");
			if(result == true) {
				alert("삭제되었습니다.");
			}
			else if (result == false) {
				return false;
			}
		});
		
	});
	
	</script>
	<body class="subpage">

		<!-- Header -->
			<header id="header" class="alt">
				<div class="logo"><a href="index.jsp">PICAR <span>Pick up your CAR</span></a></div>
				<a href="#menu"><span>Menu</span></a>
			</header>

		<!-- Nav -->
			<nav id="menu">
			<ul class="links">
			   <li><a href="carlistloc">차량리스트</a></li>      
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
							<h2>답변달기</h2>
						</header>
						<form action="commlist.update.do" method="post" style="display:inline">
						<h3>제목</h3>
						<input type="text" value="${commentJoinList.questTitle}" readOnly />
						<h3>내용</h3>
						<input type="text" value="${commentJoinList.questText}" readOnly />
						<h3>답변</h3>
						<input type="hidden" name="commNum" value="${commList.commNum}"></input>
						<input type="hidden" name="memberNum" value="${commentJoinList.memberNum}"/>
						<input type="hidden" name="questNum" value="${commentJoinList.questnum}" />
						<textarea rows="5" cols="40" id="commText" name = "commText">${commList.commText}</textarea><br>
						<input type="submit" value="수정하기" id="commcheck" />
						</form>
						<form action="question_admin_delete.do?questNum=${commentJoinList.questnum}" style="display:inline">
						<input type="hidden" name="questnum" value="${commentJoinList.questnum}" />
						<input type="submit" value="삭제하기" id="deletebutton">
						</form>
						<input type="button" value="뒤로가기" onclick="location.href='question_req_admin_list.do?reqPage=1'"> 
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