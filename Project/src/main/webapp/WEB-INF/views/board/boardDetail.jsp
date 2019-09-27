<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	#textarea {
		padding-top: 10px;
		padding-left: 5px;
	}

</style>
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
		
		var board_Id = getParameters('board_Id');
		var board_No = getParameters('board_No');
		
		
		$('#gomain').click(function(){
			location.href='/Project/board/boardList?board_Id='+board_Id;
		});
		
		
		 
		$('#modi').click(function(){
			var writer = $('#member_Id').val();	
			$.ajax({
				async : true,
				type : 'post',
				data : writer,
				url : "delOk",
				datatype : "json",
				contentType : "application/json; charset=UTF-8",
				success : function(data){
					if(data.result==1){
						location.href='/Project/board/boardModify?board_Id='+board_Id+'&board_No='+board_No;						
					}else{
						alert('본인이 작성한 글이 아닙니다.');
					}
					
				}//success end 
			});// $.ajax end 
		}); 
	
		$('#del').on('click', function(){
			var writer = $('#member_Id').val();			
			
			$.ajax({
				async : true,
				type : 'post',
				data : writer,
				url : "delOk",
				datatype : "json",
				contentType : "application/json; charset=UTF-8",
				success : function(data){
					if(data.result==1){
						alert('삭제되었습니다. 축하합니다.');
						document.frm.action = 'delcon?board_Id='+board_Id;
						document.frm.method = 'post';
						document.frm.submit();
						
					}else{
						alert('본인이 작성한 글이 아닙니다.');
					
					}
				}
			
					
			});
			
		});
		
	});
	
</script>


  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>게시판</title>

  <!-- Custom fonts for this template-->
  <link href="../resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template-->
  <link href="../resources/css/sb-admin.css" rel="stylesheet">

</head>

<body class="bg-dark">
<%@include file="../include/sidebar.jsp" %>
	<form name="frm">
		<input type="hidden" name="board_No" id="board_No" value="<c:out value="${info.board_No }"></c:out>" />
	</form>



<div>
  <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-body">
          <div class="form-group">
            <div class="form-row">
            
            
              <div class="col-md-3">
                  <input type="text" id="member_Id" name="member_Id" value="${info.member_Id }" class="form-control" placeholder="작성자" required="required" readonly="readonly">
              </div>
              
              <div class="col-md-3">
                  <input type="text" id="board_Time" name="board_Time" value="${info.board_Time }" class="form-control" placeholder="시간" required="required" readonly="readonly">
              </div>
              
              <div class="col-md-3">
                  <input type="text" id="board_Ip" name="board_Ip" value="${info.board_Ip }" class="form-control" placeholder="Ip" required="required" readonly="readonly">
              </div>
              
              <div class="col-md-3">
                  <input type="text" id="board_Hit" name="board_Hit" value="${info.board_Hit }" class="form-control" placeholder="조회수" required="required" readonly="readonly">
              </div>
              
              <div class="col-md-12">
                  <input type="text" id="board_Subject" name="board_Subject" value="${info.board_Subject }" class="form-control" placeholder="제목" required="required" readonly="readonly">
              </div>
              
              <div id="textarea">
                  <textarea name="board_Contents" id="board_Contents"  cols="82" rows="10" placeholder="내용" style="resize: none;" readonly="readonly"> ${info.board_Contents }</textarea>
                </div>
            
                
              </div>
            </div>
          </div>
			<input type="button" value="삭제하기" id="del"/>
			<input type="button" value="메인으로 돌아가기" id="gomain" />
			<%-- <a href="/Project/board/boardList?board_Id=<c:out value="${info.board_Id }"></c:out>"><input type="button" value="메인으로 돌아가기" /></a> --%>
			<input type="button" value="수정하기" id="modi" />
			<%-- <a href="/Project/board/boardModify?board_Id=<c:out value="${info.board_Id }"></c:out>&board_No=<c:out value="${info.board_No }"></c:out>" id="modi"><input type="button" value="수정하기" /></a> --%>
			
      </div>
    </div>
  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="../resources/vendor/jquery/jquery.min.js"></script>
  <script src="../resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="../resources/vendor/jquery-easing/jquery.easing.min.js"></script>

</body>

</html>