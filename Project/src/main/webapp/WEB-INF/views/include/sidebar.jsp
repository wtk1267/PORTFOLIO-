<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">


  <!-- Custom fonts for this template-->
  <link href="../resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

  <!-- Page level plugin CSS-->
  <link href="../resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="../resources/css/sb-admin.css" rel="stylesheet">

</head>

 <body id="page-top">

  <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

    <a class="navbar-brand mr-1" href="http://15.164.130.215:8080/Project/main/main">커뮤니티사이트</a>

    <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="http://15.164.130.215:8080/Project/main/main">
      <i class="fas fa-bars"></i>
    </button>
    <ul>
	     <li>
	    	<span style="color: white;">${sessionScope.id }님 환영합니다.</span>
	    </li>
    </ul>

    <!-- Navbar -->
    
    <ul class="navbar-nav ml-auto ml-md-0" id="navibar" style="float: right;">
      <li class="nav-item dropdown no-arrow">
        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-user-circle fa-fw"></i>
        </a>
        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
          <a class="dropdown-item" href="http://15.164.130.215:8080/Project/plan/plan?member_Id=${sessionScope.id }">내 계획</a>
          <a class="dropdown-item" href="http://15.164.130.215:8080/Project/main/modifyInfo">내 정보 수정</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="http://15.164.130.215:8080/Project/main/logout">Logout</a>
          <a class="dropdown-item" href="http://15.164.130.215:8080/Project/main/deleteMember">회원 탈퇴</a>
        </div>
      </li>
    </ul>
</nav>

<div id="wrapper">

    <!-- Sidebar -->
    <ul class="sidebar navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="http://15.164.130.215:8080/Project/main/main">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>Main</span>
        </a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-fw fa-folder"></i>
          <span>게시판</span>
        </a>
        
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
          <h6 class="dropdown-header">게시판 목록</h6>
          <a class="dropdown-item" href="http://15.164.130.215:8080/Project/board/boardList?board_Id=%EC%95%BC%EA%B5%AC" >야구 게시판</a>
          <a class="dropdown-item" href="http://15.164.130.215:8080/Project/board/boardList?board_Id=IT">IT 게시판</a>
          <a class="dropdown-item" href="http://15.164.130.215:8080/Project/board/boardList?board_Id=%EA%B2%BD%EC%A0%9C">경제 게시판</a>
           <a class="dropdown-item" href="http://15.164.130.215:8080/Project/board/boardList?board_Id=%EC%8B%A4%ED%97%98%EC%9A%A9">실험용 게시판</a>
         
        </div>
      </li>
      
      <li class="nav-item">
        <a class="nav-link" href="http://15.164.130.215:8080/Project/plan/plan?member_Id=${sessionScope.id }">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>나의 계획</span></a>
      </li>
      
      <li class="nav-item">
        <a class="nav-link" href="http://15.164.130.215:8080/Project/friends/friendsMain?member_Id=${sessionScope.id }">
          <i class="fas fa-fw fa-table"></i>
          <span>친구목록</span></a>
      </li>
      
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-fw fa-folder"></i>
          <span>메시지</span>
        </a>
        
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
          <h6 class="dropdown-header">message Menu:</h6>
          <a class="dropdown-item" href="http://15.164.130.215:8080/Project/msg/receiveMsgMain?member_Id=${sessionScope.id }" >받은 메시지함</a>
          <a class="dropdown-item" href="http://15.164.130.215:8080/Project/msg/sendMsgMain?member_Id=${sessionScope.id }">보낸 메시지함</a>
        </div>
      </li>
    </ul>
    
 <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>
   <!-- Bootstrap core JavaScript-->
  <script src="../resources/vendor/jquery/jquery.min.js"></script>
  <script src="../resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Core plugin JavaScript-->
  <script src="../resources/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="../resources/js/sb-admin.min.js"></script>

</body>

</html>
  