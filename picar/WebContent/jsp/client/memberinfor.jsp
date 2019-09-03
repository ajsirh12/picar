<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
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
      color: black;
      text-decoration: none;
   }
   .qwe:hover {
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
         <c:if test="${picarmember !=null}">
         <p>${picarmember.id} 님 <br>어서오세요.</p>   
         </c:if>       
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
            </c:if>   
               
            <c:if test="${picarmember !=null}">
               <form action = "logout">
               <input type = "submit" value="로그 아웃" />   
               </form>
            </c:if>   
         </ul>
      </nav>

      <section id="post" class="wrapper bg-img" data-bg="banner2.jpg">
         <div class="inner">
            <article class="box">
               <header>
                  <center><h2>내 정보</h2></center>                 
               </header>
               <form action="member_infor_update?membernum=${picarmember.memberNum}" id="infor_check" method="post">
		
					 <input type="hidden" name="memberNum" value="${picarmember.memberNum}" disabled="disabled" /> <br /> 
					
					아이디 <input type="text" name="id" value="${picarmember.id}" disabled="disabled"/> <br />		
					현재 비밀번호 <input id="now_password" type="password" placeholder="현재 비밀번호" maxlength="20" name="now_password" onKeyup="this.value=this.value.replace(' ','');"/> 							
					<div class="console"></div>
					<div align="right"><input type="button" id="pw_check" value="비밀번호 확인" /></div><br />
					새 비밀번호<input id="newpwd" type="password" placeholder="비밀번호는 6~20자리로 입력해주세요." maxlength="20" name="newpassword" onKeyup="this.value=this.value.replace(' ','');"/><br />
					비밀번호 확인<input id="repwd" type="password" placeholder="비밀번호를 확인해주세요." name="repwd" onKeyup="this.value=this.value.replace(' ','');"/><br />		  					
					이름  <input type="text" name="name" value="${picarmember.name}"  onKeyup="this.value=this.value.replace(/[^가-힣]/g,'');" /> <br /> 																				
					전화번호  <input type="text" name="phone" value="${picarmember.phone}" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/> <br />
					면허증번호  <input type="text" name="license" value="${picarmember.license}" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/><br />
					면허증 유효기간  <input type="text" name="validate" value="${picarmember.validate}" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/> <br />
			
					 <div align="center"> <input type="submit" class="btn btn-primary" id="revision" value="수정" /></div>
					 <div align="right"> <input type="button" id="out" value="회원탈퇴" onclick="location.href='picarmember_delete?membernum=${picarmember.memberNum}'" /></div>
			
				</form>
               
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
	<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
	<script type="text/javascript">

	$(function(){
		$("#out").click(function(){
			if (confirm("정말 탈퇴하시겠습니까??") == true){    //확인
				 alert("탈퇴 되었습니다");
			}else{   //취소
			    return;
			};		
		});
	});

	//현재 비밀번호 확인
	$(function(){ 		
      $("#pw_check").click(function(){
         var input_val=$("#now_password").val();

         if(!input_val){
         	alert("비밀번호를 입력해주세요");
            return false;                   
         }
         var url="passwordcheck";
         
         $.get(url,{"now_password":input_val},function(xml){
        	 var result = $(xml).find("result").text();           
            $(".console").html(result);
          
         });       
      });     
   });
		
	//유효성검사
	$(function(){
		$("#infor_check").validate({
			debug : false,
			
			rules : {												
				password : {
					required : true	
				},
				newpwd :{
					required : true,	
					minlength : 6,
					maxlength : 10					
				},
				
				repwd :{
					required : true,
					equalTo :"#newpwd"
				},
				name : "required",									
			
				phone : {
					required : true,
					maxlength : 11
				},																										
				license : {
					required : true,
					minlength : 10,
					maxlength : 10
				},				
				validate : "required"						
			},
		
			messages : {								
				password : {
					required : "비밀번호를 입력하세요"
				},
				newpwd :{
					required : "비밀번호를 입력하세요",	
					minlength : "비밀번호는 최소{0}글자 입니다.",
					maxlength : "비밀번호는 최대{0}글자 입니다."					
				},				
				repwd :{
					required : "비밀번호 확인값을 입력하세요.",
					equalTo :"비밀번호가 일치하지 않습니다."
				},
				name : "이름은 필수 항목입니다.",								
				
				phone : {
					required : "숫자만 입력해 주세요 (- 제외 11자리)",
					maxlength : "전화번호는 최대{0}글자 입니다."					
				},
				license : {
					required :"면허증 입력은 필수 사항입니다.",
					minlength : "면허증번호 최소 {0}글자 입니다.",
					maxlength : "면허증번호 최대 {0}글자 입니다."
				},				 
				validate : "유효기간을 확인해주세요."				
			}	 
		});
	});	

	</script>      
   </body>
</html>