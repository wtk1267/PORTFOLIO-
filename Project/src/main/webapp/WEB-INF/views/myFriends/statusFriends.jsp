<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>친구 상태창</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		
		var getParameters = function (paramName) {
		    var returnValue;
		    var url = location.href;
		    var parameters = (url.slice(url.indexOf('?') + 1, url.length)).split('&');
		    for (var i = 0; i < parameters.length; i++) {
		        var varName = parameters[i].split('=')[0];
		        if (varName.toUpperCase() == paramName.toUpperCase()) {
		            returnValue = parameters[i].split('=')[1];
		            return decodeURIComponent(returnValue);
		        }
		    }
		};//파라미터를 받는 함수 
		
		//var member_Id = getParameters('member_Id');
		var friends_Id = getParameters('friends_Id');
	
		$('input:button[value="메시지 차단"]').click(function(){

			$.ajax({
				type : 'post',
				data : friends_Id,
				url : '/friends/friendsMsgBan',
				datatype : "json",
				contentType : "application/json; charset=UTF-8",
				success : function(data){
					if(data.result == 1){
						alert('메시지차단이 성공하셨습니다.');
					}else{
						alert('메시지차단이 실패하셨습니다.');
					}//else end 
				}
			});// $.ajax end 
		});//메시지 차단 end
		
		$('input:button[value="메시지 차단 해제"]').click(function(){
			
			$.ajax({
				type : 'post',
				data : friends_Id,
				url : '/friends/friendsMsgBanCancel',
				datatype : "json",
				contentType : "application/json; charset=UTF-8",
				success : function(data){
					if(data.result == 1){
						alert('메시지 차단 해제에 성공하셨습니다.');
					}else{
						alert('메시지 차단 해제에 실패하셨습니다.');
					}//else end 
				}
			});// $.ajax
		});//메시지 차단 해제  end 
		
		
		$('input:button[value="친구 삭제"]').click(function(){
			$.ajax({
				type : 'post',
				data : friends_Id,
				url : '/friends/deleteFriends',
				datatype : "json",
				contentType : "application/json; charset=UTF-8",
				success : function(data){
					if(data.result == 1){
						alert('친구 목록에서 삭제에 성공하셨습니다.');
					}else{
						alert('친구 목록에서 삭제에 실패하셨습니다.');
					}//else end 
				}
			});// $.ajax
			
		});//친구 삭제 end 


	});//function() end 
</script>

<body>

<div>

	<c:if test="${fvo.friends_Status eq '0'}">
		<input type="button" value="메시지 차단" />
	</c:if>
	<c:if test="${fvo.friends_Status eq '1'}">
		<input type="button" value="메시지 차단 해제" />
	</c:if>
	

	<input type="button" value="친구 삭제" />
</div>
		

</body>
</html>