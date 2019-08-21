<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8>
<title>차량 렌트목록</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<c:if test="${picarmember.gradeNo == 30 }">
<h2>차량 렌트목록</h2>
<table border="1">
	<tr>
		<form action="rentedSearch.do?reqPage=1" method="post">
		<td colspan="7"><input type="text" name="carNum" /> <input type="submit" /></td>
		</form>
	</tr>
	<tr>
		<th>carNum</th>
		<th>name</th>
		<th>phone</th>
		<th>rentStart</th>
		<th>rentEnd</th>
		<th>late</th>
		<th>반납</th>
	</tr>
	<c:forEach var="rented" items="${rentedList }">
	<tr>
		<td>${rented.carNum }</td>
		<td>${rented.name }</td>
		<td>${rented.phone }</td>
		<td>${rented.rentStart }</td>
		<td>${rented.rentEnd}</td>
		<td>
			<c:if test="${rented.late > 0}">${rented.late * rented.cost * 2}</c:if>
			<c:if test="${rented.late <= 0}">0</c:if>
		</td>
		<td><a href="carInfo.do?carNum=${rented.carNum }"><button>반납</button></a></td>
		<%-- <form action="returnCar.do?carNum=${rented.carNum }" method="post" id="frm">
			<input type="hidden" value="${rented.late }" class="late" />
			<input type="hidden" value="${rented.cost }" class="cost" />
			<c:forEach var="rented2" items="${rentedList }">
				<c:if test="${rented.carNum == rented2.carNum }">
					<td><input type=button value="반납" class="returnbtn" /></td>
					<td><a href="returnCar.do?carNum=${rented.carNum }" class="returnbtn"><button>반납</button></a></td>
					<!-- <td><button class="returnbtn">반납</button></td> -->
				</c:if>
			</c:forEach>
		</form> --%>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="7" align="center">
			<c:if test="${pageGroupResult.beforPage}">
				<a href="rentedList.do?reqPage=${pageGroupResult.groupStartNumber - 1}">&lt;</a>
			</c:if>
			<c:if test="${!pageGroupResult.beforPage}">
				&lt;
			</c:if>&nbsp&nbsp&nbsp
			<c:forEach var="index" begin="${pageGroupResult.groupStartNumber }" end="${pageGroupResult.groupEndNumber }">
				<c:if test="${index == pageGroupResult.selectPageNumber }">
					<span id="select"><a href="rentedList.do?reqPage=${index }">${index }</a></span>
				</c:if>
				<c:if test="${index != pageGroupResult.selectPageNumber }">
					<a href="rentedList.do?reqPage=${index }">${index }</a>
				</c:if>
			</c:forEach>&nbsp&nbsp&nbsp
			<c:if test="${pageGroupResult.afterPage}">
				<a href="rentedList.do?reqPage=${pageGroupResult.groupEndNumber + 1}">&gt;</a>
			</c:if>
			<c:if test="${!pageGroupResult.afterPage}">
				&gt;
			</c:if>
		</td>
	</tr>
</table>
</c:if>
<c:if test="${picarmember.gradeNo != 30 }">
	<h1>잘못된 접근입니다.</h1>
	<a href="go_index">홈으로 돌아가기</a>
</c:if>
<script type="text/javascript">
$(function() {
	$(".returnbtn").click(function() {
		//<c:forEach var="rented" items="${rentedList }">
			//alert(${rented.late});
			var late = $(".late").val();
			var cost = $(".cost").val();
			if(late <= 0){
				late = 0;
			}
			var latefee = late * cost * 2;
			//var late = ${rented.late};
			//var cost = ${rented.cost};
			//var carnum = ${rented.carNum};
			//var latefee = late * cost * 2;
			//alert(carnum);
			
		//</c:forEach>
		if(confirm("연체료는 "+latefee+"원 입니다. 반납하시겠습니까?")){
	        document.getElementById('frm').submit();
	        return false;
		}
	})
});
</script>	
</body>
</html>