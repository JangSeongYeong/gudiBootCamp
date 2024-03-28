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
   게시판 리스트
   <hr/>
   <button onclick="del()">선택 삭제</button>
   <select id="pagePerNum">
   	<option value="5">5</option>
   	<option value="10">10</option>
   	<option value="15">15</option>
   	<option value="20">20</option>
   </select>
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
</body>
<script>
var showPage = 1;

listCall(showPage);

function del() {
    var delArr = [];
    $("input[name='del']").each(function(index, item) {
      if ($(item).is(":checked")) {
         var val = $(this).val();
         console.log(val);
         delArr.push(val);
      }
   });
     $.ajax({
         type:'post' // method 방식
         ,url:'./del.ajax' // 요청할 주소 // 파라미터 
         ,data:{delList:delArr}
        ,dataType:'json' // 기본 데이터 타입은 JSON 이다
         ,success:function(data){
            if(data.cnt>0){
            	alert('선택하신'+data.cnt+'개의 클이 삭제되었습니다.');
            	$('#list').empty();
            	listCall();
            }
        	 console.log(data);
         } 
         ,error:function(error){ // 통신 실패한 경우
             console.log(error);
         }
     });
}

$('#all').on('click',function(){
	var $chk = $('input[name="del"]');
	if($(this).is(":checked")){
		$chk.prop('checked',true);	
	}else{
		$chk.prop('checked',false);
	}
	
});

$('#pagePerNum').on('change', function(){
	$('#pagination').twbsPagination('destroy');
	listCall(showPage);	
});



function listCall(page){
      $.ajax({
         type:'get',
         url:'./list.ajax',
         data:{
        	 'page':page,
        	 'cnt':$('#pagePerNum').val()
         },
         dataType:'json',
         success:function(data){
            drawList(data.list);
            
            var startPage = data.currPage > data.totalPages ? data.totalPages : data.currPage;
            // 플러그인 추가
            $('#pagination').twbsPagination({
				startPage : startPage, // 시작 페이지
				totalPages : data.totalPages, // 총 페이지 갯수 
				visiblePages : 5, // 보여줄 페이지 수[1][2][3][4][5]
				onPageClick:function(evt, pg){ // 페이지 클릭시 실행 함수
					// evt : 이벤트 객체, pg : 클릭한 이벤트 번호
					console.log(evt);
					console.log(pg);
					showPage = pg;
					listCall(pg); // showPage 로 넣어도 상관없음
				}
            });
         },
         error:function(error){
            console.log(error)
         }
      });
}

function drawList(list){
   var content = '';
   for(item of list){
      console.log(item);
      content += '<tr>';
      content += '<td><input type="checkbox" name="del" value="' + item.idx +'"/></td>';
      content += '<td>' + item.idx + '</td>';
      content += '<td>';
      
      var img = item.img_cnt > 0 ?'image.png' : 'no_image.png';
      content += '<img class="icon" src="resources/img/' + img + '"/>';
   

      content += '</td>';
      content += '<td>' + item.subject + '</td>';
      content += '<td>' + item.user_name + '</td>';
      content += '<td>' + item.bHit +'</td>';
      
      //java.sql.Date 는 javascript에서는 밀리세컨드로 변환하여 표시한다.
      //방법 1. Back-end : DTO의 반환 날짜 타입을 문자열로 변경 (서버를 껐다 켜야하니 웬만하면 프론트에서 해야햄)
      //content += '<td>' + item.reg_date + '</td>';
      //방법 2. Front-end : js에서 직접 변환
      var date = new Date(item.reg_date);
      var dateStr = date.toLocaleDateString("ko-KR"); //en-US
      content += '<td>' + dateStr + '</td>';
      
      
      content += '</tr>';
   }
   
   $('#list').html(content);
}

</script>
</html>