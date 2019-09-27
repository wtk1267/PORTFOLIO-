<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<style type="text/css">

   .big{
      width:1520px;
      height:2000px;
      background: #999;
      margin: 0 10px 0 0;
      align:center;
   }
   
   .small{
      width:490px;
      height:200px;
      border: 1px solid #444444;
      float: left;
      background: #333;
      color: #fff;
      margin: 1px;
   }
   
   img {
   		width: 150px;
   		height: 150px;
   		float: left;
    }
    
   
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	 $(function(){
		 
		$('input:button[value="메시지보내기"]').click(function(){
			var friends_Id = $(this).siblings('#idspan').text();//상대방 아이디
			window.open('/Project/msg/writeMsgMain?friends_Id='+friends_Id, 'window',"width=400,height=300,top="+(screen.availHeight/2-100)+", left="+(screen.availWidth/2-100)+"")
		});
		 
 		$('input:button[value="상세보기"]').click(function(){
		 var member_Id = $(this).siblings('#idspan').text();//상대방 아이디
 			location.href ='selectInfo?member_Id='+member_Id;
 		});	//상세보기 end
		
 		$('input:button[value="친구추가"]').click(function(){
 			var friends_Id = $(this).siblings('#idspan').text();//상대방 아이디
 			
			$.ajax({
				type : 'post',
				data : friends_Id,
				url : '../friends/FriendsCheck',
				datatype : "json",
				contentType : "application/json; charset=UTF-8",
				success : function(data){
					if(data.result == 1){
						alert('이미 존재하는 친구입니다.')
					}else{
						window.open('/Project/friends/addFriends?friends_Id='+friends_Id, 'window',"width=400,height=300,top="+(screen.availHeight/2-100)+", left="+(screen.availWidth/2-100)+"")						
					}//else end 
				}
			});// $.ajax end 

 		});//친구추가 end
 		
 		
	}); //jquery end
</script>

<meta charset="UTF-8">
<title>main</title>
</head>
<body>
<%@include file="../include/sidebar.jsp" %>



   <div class="big">
   <c:forEach var="list" items="${allList }">
      <div class="small">
	  <img src="../resources/images/${list.member_Image }" alt='사진오류' />
   	  ID : <span id="idspan">${list.member_Id }</span> <br />
       	 관심분야 : ${list.member_Interesting }<br />
      <input type="button" value="상세보기" />
      <input type="button" value="메시지보내기" />
      <input type="button" value="친구추가" />
      </div>
   </c:forEach>
   </div>
</body>
</html>