<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8>
<title>picar index</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
   <ul>      
   <a href="question_req_list.do?reqPage=1">회원 게시판 이동</a><br/>
      
   <c:if test="${picarmember.gradeNo==30}">         
      <a href="question_req_admin_list.do?reqPage=1">관리자 게시판 이동</a> <br />
      <a href="picarmemberlist">회원 관리</a>                  
      <li><a href="rentedList.do?reqPage=1">대여목록</a></li>
      <li><a href="allRentCar.do?reqPage=1">관리자 차량목록</a></li>
   </c:if>   
      <li><a href="myRentCar.do?membernum=${picarmember.memberNum }">내 차량</a></li>
   </ul>   

   <c:if test="${picarmember ==null}">
      <li><a href="login_input">로그인</a></li>
   </c:if>   
      
   <p>${picarmember.id}</p>
   <c:if test="${picarmember !=null}">
      <form action = "logout">
      <input type = "submit" value="로그 아웃" />   
      <input type = "submit" value="내 정보" />   
   
      </form>
   </c:if>  
</body>
</html>
