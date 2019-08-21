<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	차량번호 : ${carList.carnum } <br />
	연체료 : 
	<c:if test="${joinRent.late > 0}">${joinRent.late * joinRent.cost * 2}</c:if>
	<c:if test="${joinRent.late <= 0}">0</c:if> <br />
	차량상태 <br />
	<form action="returnCar.do" method="post" id="frm">
		<input type="hidden" value="${carList.carnum }" name="carNum" />
		<input type="hidden" value="${joinRent.late }" class="late" />
		<input type="hidden" value="${joinRent.cost }" class="cost" />
		<textarea rows="20" cols="60" name="carinfo">${carList.carInfo }</textarea> <br />
		<input type="button" id="returnbtn" value="반납" />
	</form>
<script type="text/javascript">
$(function() {
	$("#returnbtn").click(function() {
			var late = $(".late").val();
			var cost = $(".cost").val();
			if(late <= 0){
				late = 0;
			}
			var latefee = late * cost * 2;
		if(confirm("연체료는 "+latefee+"원 입니다. 반납하시겠습니까?")){
	        document.getElementById('frm').submit();
	        return false;
		}
	})
});
</script>	
</body>
</html>