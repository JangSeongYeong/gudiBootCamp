<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/common.css" type="text/css">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<style>
</style>
</head>
<body>
	게시판 리스트
	<hr/>
	<button onclick="del()">선택 삭제</button>
	<table>
		<thead>
		<tr>
			<th><input type="checkbox" id="all"/></th>
			<th>글번호</th>
			<th>이미지</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>날짜</th>
		</tr>
		</thead>
		<tbody id="list">
		</tbody>
	</table>
</body>

<script>
	listCall();
	
	function listCall() {
		$.ajax({
			type:'get',
			url:'./list.ajax',
			data:{},
			dataType:'JSON',
			success:function(data){
				drawList(data.list);
			},
			error:function(error){
				console.log(error);
			}
		});
	}
	
	function drawList(list) {
		var content = '';
		
		for (item of list) {
			console.log(item);
			content += '<tr>';
			content +=	'<td><input type="checkbox" name="del" value="'+item.idx+'" /></td>';
			content +=	'<td>'+item.idx+'</td>';
			content +=	'<td>';
			
			var img = item.img_cnt > 0 ? 'image.png' : 'no_image.png';
			content +=	'<img class="icon" src="resources/img/'+img+'"/>';
			
			content +=	'</td>';
			content +=	'<td>'+item.subject+'</td>';
			content +=	'<td>'+item.user_name+'</td>';
			content +=	'<td>'+item.bHit+'</td>';
			content +=	'<td>'+item.reg_date+'</td>';
			content +='</tr>';
		}
	
		$('#list').html(content);
	}
	
	function del() {
		var delArr = [];
		$('input[name="del"]').each(function(){
			if($(this).is(':checked')){
				delArr.push($(this).val());
			}
		});
		
		$.ajax({
			type:'post',
			url:'./del.ajax',
			data:{delList:delArr},
			dataType:'JSON',
			success:function(data){
				if(data.cnt > 0){
					alert("선택하신 "+data.cnt+" 개의 글이 삭제되었습니다.");
					$('#list').empty();
					listCall();
				} 
			},
			error:function(error){
				console.log(error);
			}
		});
	}
	
	$('#all').on('click', function() {
		var $chk = $('input[name="del"]');
		if ($(this).is(':checked')) {
			$chk.prop('checked', true);
		} else{
			$chk.prop('checked', false);
		}
	});
	/*
	function allDiffuse() {
		if($('#all').is(':checked') && !$(this).is(':checked')){
			$('#all').prop('checked', false);
		}
	}
	*/
</script>
</html>