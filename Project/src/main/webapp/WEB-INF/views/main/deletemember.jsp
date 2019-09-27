<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>


</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$('input:button[value="회원탈퇴"]').click(function(){
		location.href='/Project/main/deleteOk';
	});
	
	$('input:button[value="메인으로 돌아가기"]').click(function(){
		location.href='/Project/main/main';
	});


});//jquery end
</script>


<body>
<%@include file="../include/sidebar.jsp" %>
<div>
<h2>${sessionScope.id }님 정말로 회원을 탈퇴 하시겠습니까?</h2>
<br />
<h2>여기서 회원 탈퇴를 누르면 완전히 탈퇴됩니다~</h2>
<br />

<input type="button" value="회원탈퇴" />
<input type="button" value="메인으로 돌아가기" />
</div>


</body>
</html>