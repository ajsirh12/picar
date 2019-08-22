<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<title>datail</title>
</head>
<body>

	<h1>회원 정보 수정</h1>
	<form method="post">
	회원번호: <input type="text" name="memberNum" value="${picarmember.memberNum}" disabled="disabled"/> <br />
	아이디 : <input type="text" name="id" value="${picarmember.id}"/> <br />
	비밀번호 : <input type="text" name="password" value="${picarmember.password}" /> <br />
	이름 : <input type="text" name="name" value="${picarmember.name}"/> <br />
	전화번호 : <input type="text" name="phone" value="${picarmember.phone}"/> <br />
	면허증 번호 : <input type="text" name="license" value="${picarmember.license}"/> <br />
	면허증 유효기간 : <input type="text" name="validate" value="${picarmember.validate}"/> <br />
	
	
	<%-- 회원등급 :
	<select name="membergrade">
		<c:forEach var="member" items="${membergrades}">
		
			<c:if test="${picarmember.gradeno == member.gradeno}">
				<option value="${member.gradeno}" selected="selected">${member.membergrade}</option>		
			</c:if>	
			
			<c:if test="${picarmember.gradeno != member.gradeno}">
				<option value="${member.gradeno}">${member.membergrade}</option>
			</c:if>	
			
		</c:forEach>
	</select> --%>
	<br />
	
	<input type="submit" class="btn btn-primary" value="수정" /> 
	<a href="employee_delete?empno=${picarmember.memberNum}">삭제</a>
	
	</form>

</body>
</html>