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

  <title>게시판</title>

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
		    // 리턴값을 위한 변수 선언
		    var returnValue;

		    // 현재 URL 가져오기
		    var url = location.href;

		    // get 파라미터 값을 가져올 수 있는 ? 를 기점으로 slice 한 후 split 으로 나눔
		    var parameters = (url.slice(url.indexOf('?') + 1, url.length)).split('&');

		    // 나누어진 값의 비교를 통해 paramName 으로 요청된 데이터의 값만 return
		    for (var i = 0; i < parameters.length; i++) {
		        var varName = parameters[i].split('=')[0];
		        if (varName.toUpperCase() == paramName.toUpperCase()) {
		            returnValue = parameters[i].split('=')[1];
		            return decodeURIComponent(returnValue);
		        }
		    }
		};//파라미터 받는 함수 종료
		
		
		
		var board_Id = getParameters('board_Id');
		
		
		
		$('input[value="메인으로 가기"]').click(function(){
			location.href='../main/main';
		});
		$('input[value="글쓰기"]').click(function(){
			location.href='boardWrite?board_Id='+board_Id;
		});
		
		
		$('#search').click(function(){
			
			document.frm.action = 'findList';
			document.frm.method = 'get';
			document.frm.submit();
		});
		
		
		
		
	});//jquery end 
</script>


  <div class="card mb-3">
<%@include file="../include/sidebar.jsp" %>

          <div class="card-header">
            <i class="fas fa-table"></i>
            ${param.board_Id } 게시판</div>
		       
          <div class="card-body">
            <div class="table-responsive">
              <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                  <tr>
                    <th>게시글번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>작성 시간</th>
                    <th>조회수</th>
                  </tr>
                </thead>
            <c:forEach var="vo" items="${info }">
                <tbody>
                  <tr>
                    <td id="bno">${vo.rownum }</td>
                    <td><a href="/Project/board/boardDetail?board_Id=<c:out value="${param.board_Id }"></c:out>&board_No=${vo.board_No}">${vo.board_Subject }</a></td>
                    <td>${vo.member_Id }</td>
                    <td><fmt:formatDate value="${vo.board_Time }" pattern="yyyy-MM-dd  HH:mm:ss"/></td>
                    <td>${vo.board_Hit }</td>
                  </tr>
                </tbody>
            </c:forEach>
              </table>
              
   <div class="showback" align="center">
                  <div class="btn-group">
                  <c:if test="${pm.prev }">
                  <a href="boardList${pm.makeUri(pm.startPage -1) }&board_Id=<c:out value="${param.board_Id }"></c:out>">
                    <button type="button">◀</button>
                  </a>
                  </c:if>
                 	
                 	<c:forEach begin="${pm.startPage }" end="${pm.endPage }" var="pNum">
                    <a href="boardList${pm.makeUri(pNum) }&board_Id=<c:out value="${param.board_Id }"></c:out>">
                    <button type="button" >${pNum }</button>
                    </a>
                 	</c:forEach>
                 	
                 	 <c:if test="${pm.next && pm.endPage > 0 }">
                 	<a href="boardList${pm.makeUri(pm.endPage +1) }&board_Id=<c:out value="${param.board_Id }"></c:out>">
                    <button type="button">▶</button>
                    </a>
                 	</c:if> 
                    
                  </div>                  
                  </div>
              
              
            </div>
            
            <form name="frm">
            <select name="searchType" id="searchType">
				<option value="member_Id">작성자</option>
				<option value="board_Subject">제목</option>
				<option value="board_Contents">내용</option>
            </select>
            <input type="text" name="findSome" id="findSome" />
			<input type="hidden" name="board_Id" id="board_Id" value="<c:out value="${param.board_Id }"></c:out>" />            
            </form>
            <input type="button" value="찾기" id="search"/>
            
            
            <input type="button" value="메인으로 가기" />
            <input type="button" value="글쓰기" />
		</div>
		</div>
	
	
	
	
	
		</html>
		        


      <!-- /.container-fluid -->