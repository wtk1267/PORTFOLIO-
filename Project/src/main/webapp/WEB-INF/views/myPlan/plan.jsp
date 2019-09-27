<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@include file="../include/sidebar.jsp" %>
    
<html>
<head>
 <link  rel='stylesheet'  href='../resources/css/fullcalendar.css'  />
 <script  src='../resources/lib/jquery.min.js'></script>
 <script  src='../resources/lib/moment.min.js'></script>
 <script  src='../resources/js/fullcalendar.js'></script>
 <script  src='../resources/js/ko.js'></script>
 <script>
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
  
	 var member_Id = getParameters('member_Id');	
	 var visitor = $('#visitor').val()

	 $('#calendar').fullCalendar({
	   editable : true,
	   naviLink : true,
	   eventLimit : true,
	   locale : "ko",
	   events: function(start, end, timezone, callback) {
		   
		   $.ajax({
				async : true,
				method : 'post',
				dataType : 'json',
				url : 'viewSchedule?member_Id='+member_Id,
				contentType : "application/json; charset=UTF-8",
				success : function(data){
					var events = [];
					 $.each(data, function(key, value) {
						 events.push({
					  	id : value.id,
					  	title : value.title,
					  	start : value.start,
					  	end : value.end
						 });
				   });//each end 
					callback(events);
				}//success end

			 })//ajax end 	   
	
	   },//events end 
	  
	   eventClick: function(event) {
			
		   
		   
			 if(visitor == member_Id){
		   window.open('/Project/plan/popUpModify?id='+event.id, 'window',"width=400,height=300,top="+(screen.availHeight/2-100)+", left="+(screen.availWidth/2-100)+"")
			 }
		   
	   }//eventClick	   
	   
	   

  	 })//calender end
  	 
  	 $('#register').click(function(){
  			
  		 
  		 if(visitor == member_Id){
  		 window.open('/Project/plan/popUp', 'window',"width=400,height=300,top="+(screen.availHeight/2-100)+", left="+(screen.availWidth/2-100)+"")
  		 }else{
			alert('다른 사람의 계획은 바꿀수 없습니다. ');
  		 }
  		 
  	 });
  		 
  
  		
  		
  		});//jquery end	  
 </script>
</head>

	<input type="hidden" name="visitor" id="visitor" value="${sessionScope.id }" />

<div></div>
<div style="padding-top: 30%">
	<input type="button" value="일정 등록 " id="register"/>
</div>


 <div  id="calendar" style="max-width: 900px; margin: 0 auto" >
 </div>


</body>
</html>