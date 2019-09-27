<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일정등록</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script src="../resources/js/datepicker-ko.js"></script>
<script type="text/javascript">
$(function(){

	
	
	
	 $("#schedule_StartDate").datepicker();
	 $("#schedule_EndDate").datepicker();
	 

	
	
	$('#save').click(function(){
		
		var schedule_Subject = $('#schedule_Subject').val();
		var schedule_StartDate = $('#schedule_StartDate').val();
		var schedule_EndDate = $('#schedule_EndDate').val();
		
		
		$.ajax({
			dataType : "json",
			url : "saveSchedule",
			type : 'post',
			async : false,
			contentType : "application/json; charset=UTF-8",
			data : JSON.stringify({schedule_Subject : schedule_Subject, schedule_StartDate : schedule_StartDate, schedule_EndDate : schedule_EndDate}),
			success : function(data){
				if(data.result == 1){
					alert('정상적으로 저장되었습니다.')
				}else{
					alert('저장에 실패하였습니다.')
				}
			}
		})//ajax end 
	});
	
	
	$('#exit').click(function(){
		window.close();
	});
	
	
});//jquery end
</script>

<body>
<form name="frm">
<div>
	<span>일정 제목</span><input type="text" name="schedule_Subject" id="schedule_Subject" />
</div>
<div>
	<span>시작 날짜</span><input type="text" name="schedule_StartDate" id="schedule_StartDate" />
</div>
<div>
	<span>종료 날짜</span><input type="text" name="schedule_EndDate" id="schedule_EndDate" />
</div>	
</form>
<div>
	<input type="button" value="저장하기" id="save" />
	<input type="button" value="종료" id="exit" />
</div>
	
	
</body>
</html>
