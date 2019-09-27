<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
	var schedule_Id = getParameters('id');

	$('#modify').click(function(){
		document.modifyFrm.action = 'modifyPlan';
		document.modifyFrm.method = 'post';
		document.modifyFrm.submit();
		
		alert('성공적으로 수정했습니다.')
		window.close();
	});
	
	$('#delete').click(function(){
		document.deleteFrm.action = 'deletePlan';
		document.deleteFrm.submit();		

		alert('성공적으로 삭제했습니다.');
		window.close();
	});	
		
});//jquery end

</script>
<body>
	
<form name="modifyFrm">
<div>
	<span>일정 제목</span><input type="text" name="schedule_Subject" id="schedule_Subject" />
</div>
<div>
	<span>시작 날짜</span><input type="text" name="schedule_StartDate" id="schedule_StartDate" />
</div>
<div>
	<span>종료 날짜</span><input type="text" name="schedule_EndDate" id="schedule_EndDate" />
</div>
<div>
	<input type="hidden" name="schedule_Id" id="schedule_Id" value="${param.id }"/>
</div>	
</form>
<div>
	<input type="button" value="일정 수정하기" id="modify"/>
	<input type="button" value="일정 삭제하기" id="delete"/>
</div>

<form name="deleteFrm">
	<input type="hidden" name="schedule_Id" id="schedule_Id" value="${param.id }"/>
</form>
	
</body>
</html>