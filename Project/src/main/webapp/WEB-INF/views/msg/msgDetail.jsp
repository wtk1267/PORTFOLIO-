<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쪽지 내용</title>
</head>
<body>
	
	<div>
		<div>
			<div>
				<span>보낸 사람 : </span> ${info.msg_Send_Id } 
			</div>
			<div>
				<span>받는 사람 : </span> ${info.msg_Receive_Id }
			</div>
			<div>
				<span>시간 : </span> ${info.msg_Time }
			</div>
		</div>
		<div>
			<span>제목 : </span> ${info.msg_Subject }
		</div>
		<div>
			<span>내용 : </span> ${info.msg_Contents }
		</div>
	</div>

</body>
</html>