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
	.aaa{
		color : black;
	}
	
	.qwe{
		color: white;
		text-decoration: none;
	}
	.qwe:hover {
		color: black;
	}
	.lic_y{
		float: left;
  width: 33.33%;
	}
	.lic_m{
		float: left;
  width: 33.33%;
	}
	.lic_d{
		float: left;
  width: 33.33%;
	}
	#signupForm input.error, #signupForm textarea.error{
		border : 1px dashed red;			
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
			   <li><a href="carlistloc">차량리스트</a></li>     
			   <li><a href="question_req_list.do?reqPage=1">회원 게시판 이동</a></li>
			      
			   <c:if test="${picarmember.gradeNo==30}">         
			      <li><a href="question_req_admin_list.do?reqPage=1">관리자 게시판 이동</a></li>
			      <li><a href="member_list?reqPage=1">회원 관리</a></li>                  
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
					<td><input type="button" value="회원가입" onclick="location.href='sign_up'"></td>				
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

		<section id="post" class="wrapper bg-img" data-bg="banner2.jpg">
			<div class="inner">
				<article class="box">
					<header>
						<center><h2>회원 가입</h2></center>						
					</header>
					<div class="content">
						
					<form method="post" id="signupForm" action="member_save">
						
					<table align="center">
					<tr>
						<td>아이디</td>				
						<td><input style="width:450px;" id="id" type="text" placeholder="아이디를 입력해주세요" onKeyup="this.value=this.value.replace(/[^0-9a-zA-Z]/g,'');" maxlength="20" name="id" /></td>
						<td><input type="button" align="right" id="checkid" value="중복 확인" /><br /></td>
					</tr>				
																														
					<td><div class="console"></div></td>
					
					<tr>
						<td>비밀번호</td>
						<td><input id="password" type="password" placeholder="비밀번호는 6~20자리로 입력해주세요." maxlength="20" name="password" onKeyup="this.value=this.value.replace(' ','');"/><br /></td>
					</tr>
					<tr>
						<td>비밀번호 확인</td>
						<td><input id="repwd" type="password" placeholder="비밀번호를 확인해주세요." name="repwd" onKeyup="this.value=this.value.replace(' ','');"/><br /></td>
					</tr>
					<tr>
						<td>이름</td>
						<td><input id="name" type ="text" placeholder="이름을 입력해주세요" name="name" onKeyup="this.value=this.value.replace(/[^가-힣]/g,'');"/><br /></td>
					</tr>
					<tr>
						<td>전화번호</td>
						<td><input id="phone" type ="text" placeholder="전화번호를 입력해주세요" maxlength="13" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" name="phone" onKeyup="this.value=this.value.replace(' ','');"/><br /></td>
					</tr>
					<tr>
						<td>면허증번호</td>
						<td><input id="license" type =text placeholder="면허증번호 10자리를 입력해주세요" maxlength="10" name="license" onKeyup="this.value=this.value.replace(' ','');"/></td>
					</tr>
					 </table> 
					 면허유효기간<br>
					<span class="ps_box">
					<div class="lic_y">			
						<select name = years width="8px">
							<c:forEach var="year" begin="2019" end="2050" step="1" >			
								<option value = "${year}" class="aaa">${year}년 </option>											
							</c:forEach>
						</select>			
					</div>
						
					
					<div class="lic_m">			
						<select name = month>			
							<option value = "01" class="aaa">01월</option>
							<option value = "02" class="aaa">02월</option>
							<option value = "03" class="aaa">03월</option>
							<option value = "04" class="aaa">04월</option>
							<option value = "05" class="aaa">05월</option>
							<option value = "06" class="aaa">06월</option>
							<option value = "07" class="aaa">07월</option>
							<option value = "08" class="aaa">08월</option>
							<option value = "09" class="aaa">09월</option>
							<option value = "10" class="aaa">10월</option>
							<option value = "11" class="aaa">11월</option>
							<option value = "12" class="aaa">12월</option>													
						</select>
					</div>
					
					<div class="lic_d">			
						<select name = days >		
							<option value = "01" class="aaa">01일</option>	
							<option value = "02" class="aaa">02일</option>	
							<option value = "03" class="aaa">03일</option>	
							<option value = "04" class="aaa">04일</option>	
							<option value = "05" class="aaa">05일</option>	
							<option value = "06" class="aaa">06일</option>	
							<option value = "07" class="aaa">07일</option>	
							<option value = "08" class="aaa">08일</option>	
							<option value = "09" class="aaa">09일</option>	
							<option value = "10" class="aaa">10일</option>	
							<option value = "11" class="aaa">11일</option>
							<option value = "12" class="aaa">12일</option>	
							<option value = "13" class="aaa">13일</option>	
							<option value = "14" class="aaa">14일</option>	
							<option value = "15" class="aaa">15일</option>	
							<option value = "16" class="aaa">16일</option>	
							<option value = "17" class="aaa">17일</option>
							<option value = "18" class="aaa">18일</option>
							<option value = "19" class="aaa">19일</option>
							<option value = "20" class="aaa">20일</option>
							<option value = "21" class="aaa">21일</option>
							<option value = "22" class="aaa">22일</option>
							<option value = "23" class="aaa">23일</option>
							<option value = "24" class="aaa">24일</option>
							<option value = "25" class="aaa">25일</option>
							<option value = "26" class="aaa">26일</option>
							<option value = "27" class="aaa">27일</option>
							<option value = "28" class="aaa">28일</option>
							<option value = "29" class="aaa">29일</option>	
							<option value = "30" class="aaa">30일</option>		
							<option value = "31" class="aaa">31일</option>	
						</select>
						
						</div>
						</span>
						</div><br>									
				
					<center><input style="width:750px;" type="submit" value="가입" id="join"/></center> 
					</form>
					
					</div>
									
				</article>
			
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
		<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
		<script type="text/javascript">

		$(function(){
			alert("면허증 유효기간은 6개월 이상 남아있어야 예약이 가능 합니다.");		
		});		
			
		$(function(){
			$("#join").click(function(){
				if(picarmember.phone == 0){
					alert("중복된 전화번호 입니다.");				
				}					
			});					
		});
		
		/* 아이디 중복체크 */
		var idck = 0;
		$(function(){     
	    	$("#checkid").click(function(){
	        	var input_val =$("#id").val();     
	         
	        	if(!input_val){
	        		alert("아이디를 입력해주세요");
	            	return false;         
	         	}
	         
	        	var url="idcheck";
	         
	        	$.get(url,{"id":input_val},function(xml){
	            
		        	var result = $(xml).find("result").text();
		        	var count = $(xml).find("count").text();
		                     
		            $(".console").html(result);
		           
		            if(count>=1){
		            	idck = 0;
		            	return false;
		            	
		            }else{
		            	idck = 1;
		            	return true;
		            }           
		    
		        });         	    	
	      	});      
	   });
		
		//중복 체크 확인
		$(function(){     
	    	$("#join").click(function(){
	    		if(idck==1){
	    			return true;
	    		}else{
	    			alert("아이디 중복체크는 필수입니다.");
	    			return false;
	    		}
	      	});      
	   });		
			
		$(function(){
			$("#signupForm").validate({
				debug : false,
				
				rules : {								
					id : {
						required : true,	
						minlength : 4,
						maxlength : 20
					},				
					password : {
						required : true,	
						minlength : 6,
						maxlength : 10
					},
					repwd :{
						required : true,
						equalTo :"#password"
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
					id : {
						required : "아이디는 필수 항목 입니다.",	
						minlength : "아이디는 최소 {0}글자 이상 입력하세요",
						maxlength : "아이디는 최대{0}글자 입니다."
					},
					password : {
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