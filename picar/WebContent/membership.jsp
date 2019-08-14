<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>회원가입</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style type="text/css">
	#signupForm input.error, #signupForm textarea.error{
		border : 1px dashed red;			
	}
		
</style>

<!-- --유효성 검사plugin-- -->
<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script type="text/javascript">
	$(function(){
		alert("면허증 유효기간은 6개월 이상 남아있어야 회원 가입이 가능 합니다.");		
	});	
	
	/* 전화번호,면허번호 숫자만 받기 */
	$(function inNumber(){
        if(event.keyCode<48 || event.keyCode>57){
           event.returnValue=false;
        }
    });
	
	/* 아이디 중복체크 */
	$(function(){
      
      $("#checkid").click(function(){
         var input_val =$("#id").val();
         //alert(input_val);      
         
         if(!input_val){
         
            return false;         
         }
         
         var url="idcheck";
         
         $.get(url,{"id":input_val},function(xml){
            
            var result = $(xml).find("result").text();
            $(".console").html(result);
            
         });
         
      });
      
   });
	
		
	$(function(){
		$("#signupForm").validate({
			debug : false,
			
			rules : {								
				id : {
					required : true,	
					minlength : 4
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
				validdate : "required"						
			},
		
			messages : {								
				id : {
					required : "아이디를 입력하세요.",	
					minlength : "아이디는 최소 {0}글자 이상 입력하세요"					
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
					maxlength : "면허증번호 최소 {0}글자 입니다."
				},				 
				validdate : "유효기간을 확인해주세요."
				
			}	 
		});
	});	
	
	
</script>
</head>
<body>
	<h1>회원 가입</h1>
	<form method="post" id="signupForm" action="member_save">
				
		아이디<input id="id" type="text" name="id" />
		<input type="button"  id="chekcid" value="아이디중복검사" />
		<br />
		비밀번호<input id="password" type="password" placeholder="비밀번호는 6~10자리로 입력해주세요." name="password" /><br />
		비밀번호 확인<input id="repwd" type="password" name="repwd" /><br />
		이름<input id="name" type ="text" name="name"/><br />
		전화번호 <input id="phone" type ="text" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" name="phone"/><br />
		면허증번호 <input id="license" type ="text" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" name="license"/><br />
		면허유효기간 <input id="validdate" type ="text" placeholder="유효기간(170101)" name="validdate"/><br />
				
		<hr />
		<input type="submit" value="가입" />
	</form>
	<div class="console"></div>
</body>
</html>