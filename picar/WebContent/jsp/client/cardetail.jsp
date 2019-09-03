
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
   }
   .qwe:hover {
      color: black;
   }
   .firstdate{
   	color: black;
   }
   .lastdate {
   	color: black;
   }
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
                  <center><h2>차량 상세정보</h2></center>
               </header>
               <div class="content">
	<form action="reserveCar.do" method="post" id="frm">
		<table border=1>
			<tr>
				<td>차량번호</td>
				<td>차량종류</td>
				<td>보유지점</td>
				<td>대여비용</td>
				<td>탑승인원</td>
				<td>연료종류</td>
			</tr>
			<tr>
				<td>${detail.carnum}</td>
				<td>${detail.carname}</td>
				<td>${detail.location}</td>
				<td>${detail.cost} <span> * DAY</span></td>
				<td>${detail.people}</td>
				<td>${detail.fueltype}</td>
			</tr>
			<tr>
				<td>대여일</td>
				<td colspan="2"><input type="date" name="firstdate" class="firstdate" required="required" value="" /></td>
				<td>반납일</td>
				<td colspan="2"><input type="date" name="lastdate" class="lastdate" required="required" /></td>
			</tr>
		</table>
		<input type="hidden" value="${detail.carnum}" name="carnum" />
		<input type="hidden" value="${picarmember.memberNum }" name="membernum" />
		<input type="hidden" value="${picarmember.validate}" class="validate" />
		<div align="center">
		<c:if test="${picarmember.rented == 'Y' }">
			<input type="button" value="예약하기" id="reservebtn" />	
		</c:if>
		<c:if test="${picarmember.rented != 'Y' }">
			<input type="button" value="예약불가" id="nobtn" />	
		</c:if>
	</form>
	<input type="button" value="뒤로가기" onclick="history.back(-1);" /></div>
	
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
	$("#reservebtn").click(function() {
		var date = 24 * 60 * 60 * 1000;
		
		var firstdate = $(".firstdate").val();
		var stdate = new Date(firstdate);
		var lastdate = $(".lastdate").val();
		var endate = new Date(lastdate);
		var cost = ${detail.cost};
		
		var rented = (endate-stdate)/date+1;
		
		var valid = $(".validate").val();
		var validate = new Date(valid);
		var today = new Date();
		var lesssix = (validate-today)/date;
		
		if(lesssix>=180){
			if(confirm("총 대여일은 "+rented+"일 대여비용은 " + rented*cost + "원 입니다. 예약하시겠습니까?")){
		        document.getElementById('frm').submit();
		        return false;
			}
		}
		else{
			alert("면허기간이 6개월 미만입니다. 예약이 불가능합니다.");
		}
	});
	$("#nobtn").click(function() {
		if(${picarmember.rented != null}){
			alert("고객님은 이미 차량을 대여중입니다.");	
		}
		if(${picarmember.rented == null}){
			alert("로그인하고 이용해주세요.");	
		}
		
	});
});
</script>	
   </body>
</html>

