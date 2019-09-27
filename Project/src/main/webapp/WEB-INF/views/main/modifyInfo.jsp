<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>



<html>
<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>정보수정</title>

  <!-- Custom fonts for this template-->
  <link href="../resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template-->
  <link href="../resources/css/sb-admin.css" rel="stylesheet">

</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
 	 $(function(){

		$('#btn').click(function(){
			console.log($('#checkbox').is(":checked"));
			 if($('#checkbox').is(":checked") == true){
				$('#member_OpenInfo').val(1);
			} else{
				$('#member_OpenInfo').val(0);
			}

			
			if($('#member_Password').val() !=$('#confirmPassword').val()){
				alert("비밀번호를 확인하십시오");
				return;
			}else if($('#member_Name').val() == "" ){
				alert("이름을 적어주세요");
				return;
			}else if($('#member_Email').val() == "" ){
				alert("email을 적어주세요");
				return;
			}else if($('#member_Password').val() == "" ){
				alert("비밀번호를 확인하십시오");
				return;
			}else if($('#member_Id').val() == ""){
				alert("아이디를 다시 확인해주세요");
				return;
			}
			
			document.frm.method ='post';
		    document.frm.submit(); 
		});//btn end 
		 
		
 	});//Jquery end 
	
</script>

<body class="bg-dark">
<%@include file="../include/sidebar.jsp" %>
  <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">정보수정</div>
      <div class="card-body">
        <form enctype="multipart/form-data" name="frm">
          <div class="form-group">
            <div class="form-row">
            
              <div class="col-md-12">
                <div class="form-label-group">
                  <input type="text" id="member_Id" name="member_Id" class="form-control" placeholder="Id" required="required" value="${sessionScope.id }" readonly="readonly">
                </div>
              </div>

              <div class="col-md-12">
                <div class="form-label-group">
                  <input type="text" id="member_Name" name="member_Name" class="form-control" placeholder="Name" required="required" readonly="readonly" value="${info.member_Name }">
                </div>
              </div>
              
            </div>
          </div>
          
          <div class="form-group">
            <div class="form-label-group">
              <input type="email" id="member_Email" name="member_Email" class="form-control" placeholder="Email address" required="required">
              <label for="member_Email">Email address</label>
            </div>
          </div>
          
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <div class="form-label-group">
                  <input type="password" id="member_Password" name="member_Password" class="form-control" placeholder="Password" required="required">
                  <label for="member_Password">Password</label>
                </div>
              </div>
              
              <div class="col-md-6">
                <div class="form-label-group">
                  <input type="password" id="confirmPassword" class="form-control" placeholder="Confirm password" required="required">
                  <label for="confirmPassword">Confirm password</label>
                </div>
              </div>
            </div>
          </div>
          
          <br />
          
              <div class="col-md-6">
                <div class="form-label-group">
                	  <select name="member_Interesting" id="member_Interesting">
                	  		<option value=NULL>-----</option>
							<option value="IT">IT</option>
							<option value="Economics">경제학</option>
							<option value="Baseball">야구</option>
							<option value=NULL>없음</option>                	  
                	  </select>
                </div>
              </div>
              
              
              <br />
               <div class="form-group">
            <div class="checkbox">
                <input type="checkbox" name="checkbox" id="checkbox" >
                <input type="hidden" name="member_OpenInfo" id="member_OpenInfo"/>
              <label>
                	자신의 정보를 공개 하시겠습니까?
              </label>
            </div>
          </div>
              	
              	<div>
              <label>이미지 :</label>
         <input type="file" id="file" name="file1" >
              	
              	</div>
              	<br />

    	<input type="button" id="btn" value="수정
    	" class="btn btn-primary btn-block" />      
          
        </form>
        
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