<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Page</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<style>
	table, th, td {
		border: 1px solid black;
		border-collapse: collapse;
		padding: 5px 10px;
	}
</style>
</head>
<body>
	<table>
 		<tr>
 			<th>글번호</th>
 			<th>제목</th>
 			<th>작성자</th>
 			<th>조회수</th>
 			<th>작성일</th>
 			<th>삭제</th>
 		</tr>
 		<c:forEach items="${list}" var="bbs">
 		<tr>
 			<td>${bbs.idx}</td>
 			<td><a href="detail?idx=${bbs.idx}"> ${bbs.subject}</a></td>
 			<td>${bbs.user_name}</td>
 			<td>${bbs.bHit}</td>
 			<td>${bbs.reg_date}</td>
 			<td><a href="#">삭제</a></td>
 		</tr>
 		</c:forEach>
 	</table>

</body>
<script>
	function add(or){
		//console.log(or);
		//console.log(content);
		var content = $(or).closest('li').html();
		$('#search_name').append('<li>'+content+'</li>');
	}
	
	function details(id){
		console.log('상세 보기 조회',$(id).val());
		 /* $.ajax({
	         type:'get',
	         url:'./getDetail.ajax',
	         data:{
	            'id':		$(id).val()
	         },
	         dataType:'json',
	         success:function(result){
	         },
	         error:function(error){
	            console.log(error);
	         }
	      }); */
	}
</script>
</html>