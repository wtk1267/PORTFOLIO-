<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>친구목록</title>

  <!-- Custom fonts for this template-->
  <link href="../resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

  <!-- Page level plugin CSS-->
  <link href="../resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="../resources/css/sb-admin.css" rel="stylesheet">

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
		
		
		$('input:button[value="계획보기"]').click(function(){
			var friends_Id = $(this).parent().parent().children().eq(1).children().text();
			location.href= 'friendsInfo?member_Id='+friends_Id;
		});
		
		$('input:button[value="메시지 보내기"]').click(function(){
			var friends_Id = $(this).parent().parent().children().eq(1).children().text();			

			window.open('/Project/msg/writeMsgMain?friends_Id='+friends_Id, 'window',"width=400,height=300,top="+(screen.availHeight/2-100)+", left="+(screen.availWidth/2-100)+"")
		});
		
		$('input:button[value="상태관리"]').click(function(){
			var friends_Id = $(this).parent().parent().children().eq(1).children().text();
			var member_Id = getParameters('member_Id')
			
			window.open('/Project/friends/friendsStatus?friends_Id='+friends_Id, 'window',"width=400,height=300,top="+(screen.availHeight/2-100)+", left="+(screen.availWidth/2-100)+"")
			
		});
		
		
		
		
		
		
	});// function end 
</script>


  <div class="card mb-3">
<%@include file="../include/sidebar.jsp" %>

          <div class="card-header">
            <i class="fas fa-table"></i>
            		 친구목록</div>
		       
          <div class="card-body">
            <div class="table-responsive">
              <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                  <tr>
                    <th>친구사진</th>
                    <th>친구아이디</th>
                    <th>계획 보기</th>
                    <th>메시지 보내기</th>
                    <th>상태관리</th>
                  </tr>
                </thead>
            <c:forEach var="vo" items="${info }">
                <tbody>
                  <tr>
                    <td><img src="../resources/images/${vo.member_Image }" width="100px" height="100px"
                     alt="디폴트 사진" /></td>
                    <td><span id="idspan">${vo.member_Id }</span></td>
                    <td><input type="button" value="계획보기" /></td>
                    <td><input type="button" value="메시지 보내기" /></td>
                    <td><input type="button" value="상태관리" /></td>
                  </tr>
                </tbody>
            </c:forEach>
              </table>
              
   <div class="showback" align="center">
                
                  </div>
              
              
            </div>
		</div>
		</div>
	
	
	
	
	
		</html>