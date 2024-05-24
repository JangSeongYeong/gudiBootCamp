<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- static 폴더의 내용을 호출 할 때는 그냥 호출해도 된다. -->
<!-- application.properties 설정에 의해 특정 요청명일 경우만 static 폴더를 보도록 할 수 있다. -->
<link rel="stylesheet" href="resources/css/list.css" type="text/css">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<style>
	h3 {
		margin: 10px 0;
	}
	table, th, td {
		text-align: center;
		padding: 5px 10px;
		
		border: 1px solid black;
		border-collapse: collapse;
	}
</style>
</head>

<body>
	<div class="top-div">
		<div class="top-left-div">
			<span>${loginId}</span>
		</div>
		<div class="top-right-div">
			<button style="margin: 5px" onclick="location.href='./logout'">로그아웃</button>
		</div>
	</div>
	
	<div class="subject-div">
		<h3>게시판</h3>
	</div>

	<div class="button-div">
		<div class="button-left-div">
			<!-- <select name="pagePerNum" style="height:30px">
				<option val="5">5</option>
				<option val="10">10</option>
				<option val="15">15</option>
				<option val="20">20</option>
			</select> -->
		</div>
		<div class="button-right-div">
			<button style="margin: 5px" onclick="location.href='./write.go'">글 작성</button>
			<button onclick="delBbs()" style="margin: 5px">삭제</button>
		</div>
	</div>

	<div class="table-div">
		<table>
			<thead>
				<tr>
					<th>No</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>등록일</th>
					<th><input type="checkbox" name="all" /></th>
				</tr>
			</thead>
			<tbody id="bbsList">
				<c:if test="${list.size() < 1}">
					<tr>
						<td colspan="7">작성된 게시글이 없습니다.</td>
					</tr>
				</c:if>
				<c:forEach items="${list}" var="item">
					<tr class="bbs_item">
						<td class="bbs_idx">${item.idx}</td>
						<td>${item.subject}</td>
						<td>${item.user_name}</td>
						<td>${item.bHit}</td>
						<td class="reg_date_toDate">${item.reg_date}</td>
						<td><input type="checkbox" name="del" class="delCheck" value="${item.idx}"/></td>
					</tr>
				</c:forEach>
			</tbody>
			<tbody id="page">				
			</tbody>
		</table>
	</div>
</body>

<script>
	var msg = '${msg}';
	if (msg != '') {
		alert(msg);
	}
	
	$('.reg_date_toDate').each(function() {
		var ori_date = $(this).text();
		var new_date = ori_date.split(' ')[0];
		$(this).text(new_date);
	});
	
	$('.bbs_item').on('click', function() {
		var bbs_idx = $(this).find('.bbs_idx').text();
		window.location.href="./detail.go?bbs_idx="+bbs_idx;
	});
	
	
	
	
	// 삭제 전체 선택
	$('input[name="all"]').on('click', function() {
		var $chk = $('input[name="del"]');
	    if ($(this).is(':checked')) {	
	        $chk.prop('checked', true);	
	    } else {
	        $chk.prop('checked', false);	
	    }
	});
	// 삭제
	function delBbs() {
		var delArr = [];
		
		$('input[name="del"]').each(function(index, item){
			if ($(this).is(":checked")) {
				var val = $(this).val();
				delArr.push(val);
			}
		});
		
		$.ajax({
			type: 'get',
			url: './del.ajax',
			data: {'delArr': delArr},
			dataType: 'JSON',
			success: function(data) {
				alert(data.cnt+'개의 글이 삭제 되었습니다.');
				window.location.href='<c:url value="/list.go"/>';
			}, error: function(error) {
				
			}
		});
	}
	
	// 개별 삭제 체크박스
	$('.delCheck').on('click', function(event) {
		// 이벤트 버블링 방지 (하트 누를 때 게시글 이동 방비)
		event.stopPropagation();
	});
</script>

</html>