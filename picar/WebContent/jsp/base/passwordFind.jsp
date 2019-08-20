<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title> 비밀번호 찾기</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#findForm").validate({
			debug : false,
			
			rules : {
				id :"required",
				name :"required",
				phone :"required"					
			},
		
			messages : {
				id :"아이디를 입력해주세요",
				name :"이름을 입력해주세요",
				phone :"전화번호를 입력해주세요"				
			}
		});		
	});
	
	
</script>
</head>
<body>
<h1>passwordfind</h1>
대소문자를 구분해 주세요
<form method="post" id="passwordfindForm" action="passwordfind">
아이디 :<input type="text" id="id" name="id"/> <br />
이름 :<input type="text" id="name" name="name" /> <br />
전화번호 :<input type="text" id="phone" name=phone /> <br />
<input type="hidden" name="password" value="${picarmember.password}"/><br />

<input type="submit" value="찾기"/>
</form>
</body>
</html>