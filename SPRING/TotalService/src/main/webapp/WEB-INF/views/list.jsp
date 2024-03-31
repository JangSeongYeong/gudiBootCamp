<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/common.css" type="text/css">
<!-- twbs 플러그인을 사용하기 위한파일등 -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>    
<script src="resources/js/jquery.twbsPagination.js" type="text/javascript"></script>
<style>
</style>
</head>
<body>
   <h3>게시판 리스트</h3>
   <hr/>
   페이지당 게시물 
   <select id="pagePerNum">
   	<option value="5">5</option>
   	<option value="10">10</option>
   	<option value="15">15</option>
   	<option value="20">20</option>
   </select>
   <button onclick="location.href='write.go'">글쓰기</button>
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
      <tbody id="list"></tbody>
      <tr>
      	<td colspan="7">
      		<div class="container">                           
               <nav aria-label="Page navigation" style="text-align:center">
                  <ul class="pagination" id="pagination"></ul>
               </nav>               
            </div>
      	</td>
      </tr>
   </table>
   <button onclick="del()">선택 삭제</button>
</body>
<script>
var showPage = 1;
listCall(showPage);

$('#all').on('click',function(){
	var $chk = $('input[name="del"]');
	if($(this).is(":checked")){
		$chk.prop('checked', true);	
	}else{
		$chk.prop('checked', false);
	}
	
});

$('#pagePerNum').on('change', function(){
	$('#pagination').twbsPagination('destroy');
   listCall(showPage);
});

function listCall(page){
	$.ajax({
      type:'GET',
      url:'./list.ajax',
      data:{
         'page':page,
         'cnt':$('#pagePerNum').val()
      },
      success:function(data){
         drawList(data.list);

         var startPage = data.currPage > data.totalPages ? data.totalPages : data.currPage;
         $('#pagination').twbsPagination({
            startPage : startPage,
            totalPages : data.totalPages,
            visiblePages : 5,
            onPageClick:function(evt, pg){
               showPage = pg;
               listCall(pg);
            }
         });
      },
      error:function(error){
         console.log(error);
      }
   });
}

function drawList(list){
   var content = '';
   for(item of list){
      content += '<tr>';
      content += '<td><input type="checkbox" name="del" value="' + item.idx +'"/></td>';
      content += '<td>' + item.idx + '</td>';
      
      content += '<td>';
      var img = item.img_cnt > 0 ?'image.png' : 'no_image.png';
      content += '<img class="icon" src="resources/img/' + img + '"/>';
      content += '</td>';
      
      content += '<td><a href="detail?idx='+item.idx+'">' + item.subject + '</a></td>';
      content += '<td>' + item.user_name + '</td>';
      content += '<td>' + item.bHit +'</td>';
      content += '<td>' + item.reg_date + '</td>';
      content += '</tr>';
   }
   if(list.length < 1) content += '<tr><td colspan="7" class="noData">작성된 게시글이 없습니다.</td></tr>';
   
   $('#list').html(content);
   
   $('.noData').css({'text-align':'center'});
   $('table').css({
      'border':'1px solid black',
      'border-collapse': 'collapse',
      'text-align':'center'
   });
   $('th').css({
      'border':'1px solid black',
      'border-collapse': 'collapse',
      'padding': '5px 5px',
      'text-align':'center'
   });
   $('td').css({
      'border':'1px solid black',
      'border-collapse': 'collapse',
      'padding': '5px',
      'text-align':'center'
   });

}

function del() {
   var delArr = [];
   $('input[name="del"]:checked').each(function(){
      delArr.push($(this).val());
   });
   console.log(delArr);

   $.ajax({
      type:'POST',
      url:'./del.ajax',
      data:{'delList':delArr},
      dataType:'JSON',
      success:function(data){
         if (data.cnt > 0) {
            alert('선택하신 '+data.cnt+' 개의 글이 삭제 되었습니다.');
            $('#list').empty();
            listCall(showPage);
         }
      },
      error:function(error){
         console.log(error);
      }
   });

}

</script>
</html>