<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){

		$('input:button[value="예"]').click(function(){
			document.frm.action = "registFriends";
			document.frm.submit();
			alert('친구추가를 성공하셨습니다.');
			window.close();
		});
			
		
		$('input:button[value="아니오"]').click(function(){
			window.close();
		});
		
		
	});//function
</script>




<body>
	<div>
		<h2>${friends_Id }님을 친구로 추가하시겠습니까?</h2>
	</div>
	
	<div>
		<input type="button" value="예" />
		<input type="button" value="아니오" />
	</div>	
	
	<form name="frm">
		<input type="hidden" name="friends_Id" value="${friends_Id }" />
	</form>
	
	
</body>
</html>