<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>비밀번호 변경 </title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#passwordForm").validate({
		debug : false,
		
		rules : {								
			password : {
				required : true,	
				minlength : 6,
				maxlength : 10
			},
			repwd :{
				required : true,
				equalTo :"#password"
			}				
		},
	
		messages : {											
			password : {
				required : "비밀번호를 입력하세요",	
				minlength : "비밀번호는 최소{0}글자 입니다.",
				maxlength : "비밀번호는 최대{0}글자 입니다."
			},
			repwd :{
				required : "비밀번호 확인값을 입력하세요.",
				equalTo :"비밀번호가 일치하지 않습니다."
			}
					
		}	 			
	});	
});









</script>

</head>
<body>
<form method="post" id="passwordForm" action="password_update">
	picar 아이디: ${picarmember.id} <br />
	새 비밀번호 : <input id="password" type="password" placeholder="비밀번호는 6~10자리로 입력해주세요." name="password" /><br />
	새 비밀번호 확인 : <input id="repwd" type="password" placeholder="비밀번호를 확인해주세요." name="repwd" /><br />
	<input type="hidden" name="id" value="${picarmember.id}"/><br />
	<input type="hidden" name="name" value="${picarmember.name}"/><br />
	<input type="hidden" name="phone" value="${picarmember.phone}"/><br />
	
	
	<input type="submit" value="확인">
</form>
</body>
</html>