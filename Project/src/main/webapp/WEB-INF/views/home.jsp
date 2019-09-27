<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<style type="text/css">

   .big{
      width:920px;
      height:610px;
      background: #999;
      margin: 0 10px 0 0;
      align:center;
   }
   
   .small{
      width:300px;
      height:200px;
      border: 1px solid #444444;
      float: left;
      background: #333;
      color: #fff;
      margin: 1px;
   }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
   $(function(){
      $('.small').click(function(){
         location.href='<c:url value="/team1/list/menusignin"></c:url>'   
      });
   });
</script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>Category : ${category }</h1>
   <div class="big">
   <c:forEach var="lc" items="${list }">
      <div class="small">
      가게명 : ${lc.sName } <br />
      전화번호 : ${lc.sPNumber } <br />
      주소 : ${lc.address }<br />
      </div>
   </c:forEach>
   </div>
</body>
</html>