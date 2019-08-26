<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>회원정보수정</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#out").click(function(){
		alert("탈퇴되었습니다.");
		return true;
		}); 
	});
	
	$(function(){
		$("#revision").click(function(){
			alert("회원정보 수정 완료");
			return true;
		});		
	});
	
	//현재 비밀번호 확인
	$(function(){ 
		
      $("#pw_check").click(function(){
         var input_val =$("#password").val();
         
         if(!input_val){
         	alert("비밀번호를 입력해주세요");
            return false;        
            
         }
         var url="passwodcheck";
         
         $.get(url,{"password":input_val},function(xml){
            
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

</head>
<body>
	<header id="header" class="alt">
		<div class="logo"><a href="index.jsp">PICAR <span>Pick up your CAR</span></a></div>
	</header>
<h3>내 정보 </h3>
	<form action="member_infor_update?membernum=${picarmember.memberNum}" id="infor_check" method="post">
		
		 <input type="hidden" name="memberNum" value="${picarmember.memberNum}" disabled="disabled" /> <br /> 
		
		아이디: <input type="text" name="id" value="${picarmember.id}" disabled="disabled"/> <br />		
		현재 비밀번호 : <input id="password" type="password" placeholder="현재 비밀번호" maxlength="20" name="password" onKeyup="this.value=this.value.replace(' ','');"/>
		<input type="button" id="pw_check" value="비밀번호 확인" /><br />	
		
		새 비밀번호<input id="newpwd" type="password" placeholder="비밀번호는 6~20자리로 입력해주세요." maxlength="20" name="newpassword" onKeyup="this.value=this.value.replace(' ','');"/><br />
		비밀번호 확인<input id="repwd" type="password" placeholder="비밀번호를 확인해주세요." name="repwd" onKeyup="this.value=this.value.replace(' ','');"/><br />		  
		이름 : <input type="text" name="name" value="${picarmember.name}"  onKeyup="this.value=this.value.replace(/[^가-힣]/g,'');" /> <br /> 
																	
		전화번호 : <input type="tel" name="phone" value="${picarmember.phone}" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/> <br />
		면허증번호 : <input type="text" name="license" value="${picarmember.license}" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/><br />
		면허증 유효기간 : <input type="text" name="validate" value="${picarmember.validate}" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/> <br />

		 <input type="submit" class="btn btn-primary" id="revision" value="수정" />
		 <input type="button" id="out" value="회원탈퇴" onclick="location.href='picarmember_delete?membernum=${picarmember.memberNum}'" />

	</form>
	<div class="console"></div>
</body>
</html>