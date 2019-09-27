<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	.subject{
		color: blue; 
	}
	
	.subject:hover{
		font-weight: bold;
	}

</style>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>메시지 목록</title>

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
		
		$('input:button[value="메시지 보내기"]').click(function(){
			window.open('/Project/msg/writeMsgMain', 'window',"width=400,height=300,top="+(screen.availHeight/2-100)+", left="+(screen.availWidth/2-100)+"");
		});
		
		$('.subject').click(function(){
			var msg_Id = $(this).parent().children().eq(5).val();
			window.open('/Project/msg/msgDetail?msg_Id='+msg_Id, 'window',"width=400,height=300,top="+(screen.availHeight/2-100)+", left="+(screen.availWidth/2-100)+"");
		
		});
		
	});

</script>



  <div class="card mb-3">
<%@include file="../include/sidebar.jsp" %>

          <div class="card-header" >
            <i class="fas fa-table"></i>
            받은 메시지 목록
            <br />
          <input type="button" value="메시지 보내기" />  
            </div>
		       
          <div class="card-body">
            <div class="table-responsive">
              <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                  <tr>
                    <th>메시지 번호</th>
                    <th>보낸 사람</th>
                    <th>받는 사람 </th>
                    <th>제목</th>
                    <th>시간</th>
                    
                  </tr>
                </thead>
            <c:forEach var="vo" items="${info}">
                <tbody>
                  <tr>
                    <td>${vo.rownum }</td>
                    <td>${vo.msg_Send_Id} </td>
                    <td>${vo.msg_Receive_Id }</td>
                    <td class="subject">${vo.msg_Subject }</td>
                    <td><fmt:formatDate value="${vo.msg_Time }" pattern="yyyy-MM-dd  HH:mm:ss"/></td>
                    <input type="hidden" name="msg_Id" value="${vo.msg_Id }" />
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