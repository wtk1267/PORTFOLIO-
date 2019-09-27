<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메시지 쓰기</title>
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
		
		var friends_Id = getParameters('friends_Id'); 
		
		if(friends_Id != null){
			document.getElementById("msg_Receive_Id").value=friends_Id;
		}
		
		$('input:button[value="메시지 전송"]').click(function(){
			document.frm.method = 'post';				
			document.frm.submit();
			alert('메시지가 성공적으로 전송되었습니다.');
			window.close();
		})
		
		$('input:button[value="나가기"]').click(function(){
			window.close();
		});
		
	});//jquery end 
</script>


<body>
	<div>
		<form name="frm">
			<div>
				<span>보낼 아이디 </span><input type="text" name="msg_Receive_Id" id="msg_Receive_Id" />
			</div>
		
			<div>
				<span>제목</span><input type="text" name="msg_Subject" id="msg_Subject" /> 
			</div>
			
			<div>
				<span>내용</span><textarea name="msg_Contents" id="msg_Contents" cols="30" rows="10"></textarea>
			</div>
		</form>
		
		<div>
			<input type="button" value="메시지 전송" />
			<input type="button" value="나가기" />
		</div>
		
	</div>

</body>
</html>