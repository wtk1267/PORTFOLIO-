<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		$('#btn').click(function(){
			document.frm.method ='post';
			document.frm.submit();
		});
	});

</script>


  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>게시판 글쓰기</title>

  <!-- Custom fonts for this template-->
  <link href="../resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template-->
  <link href="../resources/css/sb-admin.css" rel="stylesheet">

</head>

<body class="bg-dark">

<div>
<%@include file="../include/sidebar.jsp" %>
  <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-body">
      
      
        <form name="frm">
        	
        	<input type="hidden" name="member_Id" value="${sessionScope.id }"/>
        
          <div class="form-group">
            <div class="form-row">


              <div class="col-md-12">
                  <input type="text" id="board_Subject" name="board_Subject" class="form-control" placeholder="제목" required="required" autofocus="autofocus">
              </div>
              
              
              
              <div id="textarea">
                  <textarea name="board_Contents" id="board_Contents" cols="82" rows="10" placeholder="내용" style="resize: none;"></textarea>
                </div>
              </div>
              
              
            </div>
            </form>
          </div>
			<input type="button" class="btn btn-primary btn-block" value="등록" id="btn"/>        
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