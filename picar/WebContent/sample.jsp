
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
                  <center><h2>Nibh non lobortis mus nibh</h2></center>
                  <p>01.01.2017</p>
               </header>
               <div class="content">
                  <p>Ac pretium parturient et scelerisque dis pulvinar nascetur suspendisse justo parturient est quis adipiscing nisi dis eu ullamcorper. Penatibus aliquet vestibulum dis pretium a ullamcorper accumsan facilisis elit ullamcorper porttitor dictumst per a a potenti interdum fusce a adipiscing nostra ac parturient. Proin a imperdiet at a scelerisque quam et at ante aenean per per faucibus senectus lobortis mi tincidunt a penatibus. Mauris vestibulum aliquet parturient odio dapibus euismod a mi ullamcorper maecenas turpis non scelerisque nibh fermentum natoque erat parturient suspendisse a magna curabitur cum.</p>

                  <p>Aliquet a consectetur semper suscipit ridiculus mattis augue volutpat hendrerit proin hac vel tristique quis amet parturient sem. Adipiscing laoreet blandit vestibulum laoreet fermentum sed sociis lorem class ipsum scelerisque porttitor viverra vestibulum nascetur. Ad felis ad ullamcorper urna iaculis aenean vel a suspendisse nunc placerat euismod suspendisse et fames ipsum elementum odio vestibulum duis. Fringilla condimentum donec tincidunt enim volutpat nam velit quisque laoreet adipiscing nam in suspendisse mattis ad libero parturient scelerisque. Vitae enim ac parturient iaculis pharetra cum quam imperdiet commodo mus netus quam habitasse risus netus dis.</p>

                  <p>Arcu est vestibulum condimentum conubia tempus a porttitor quam urna adipiscing a adipiscing condimentum tortor cubilia parturient per senectus interdum felis suspendisse penatibus auctor pretium ac. Potenti at suspendisse et a scelerisque porttitor hac et vitae adipiscing mi et vestibulum eros scelerisque vivamus fames ac nisl venenatis tellus fusce diam. Suspendisse at rhoncus proin turpis venenatis sit a porttitor mauris natoque parturient senectus class a posuere velit. Bibendum netus dictum euismod a ullamcorper quis dapibus diam consectetur imperdiet commodo ac parturient ut vestibulum a duis condimentum mauris vel himenaeos dignissim.</p>

                  <p>A adipiscing a ac aliquet elit a senectus feugiat litora condimentum dignissim ullamcorper conubia venenatis torquent consectetur dui aptent dignissim condimentum suspendisse. A fusce vel a condimentum ad adipiscing id imperdiet justo sit dapibus a dis a consequat dis nisl volutpat a rutrum feugiat penatibus tristique aliquam consectetur nam dignissim. Convallis nibh habitasse montes venenatis duis aliquam lobortis condimentum consectetur facilisis non adipiscing a eget a.</p>

                  <p>Penatibus vestibulum ullamcorper diam commodo volutpat at a sodales dis id ut condimentum a arcu at nostra pretium urna suspendisse. Maecenas commodo adipiscing ad curabitur a a risus pulvinar habitant a et integer volutpat mi nullam curabitur a adipiscing nullam in bibendum vel cras scelerisque. Morbi a euismod litora dui nunc in pretium sodales ante dis dui natoque adipiscing a. Augue imperdiet dignissim adipiscing justo accumsan adipiscing vestibulum adipiscing fames class ad rutrum sociosqu ad auctor sodales dis mollis. Ac euismod enim ad viverra dui auctor at integer inceptos parturient mi convallis aliquet iaculis ad diam.</p>
               </div>
               <footer>
                  <ul class="actions">
                     <li><a href="#" class="button alt icon fa-chevron-left"><span class="label">Previous</span></a></li>
                     <li><a href="#" class="button alt icon fa-chevron-right"><span class="label">Next</span></a></li>
                  </ul>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
   </body>
</html>