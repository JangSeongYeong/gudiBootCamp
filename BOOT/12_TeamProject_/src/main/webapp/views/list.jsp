<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<style>
	table, th, td {
		border: 1px solid black;
		border-collapse: collapse;
		padding: 5px 10px;
	}
	
	input[type="text"]{
		width: 110px;
		background-color: lightgray;
	}
</style>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>팀명</th>
				<th>프로젝트명</th>
				<th>팀리더</th>
				<th>팀원1</th>
				<th>팀원2</th>
				<th>팀원3</th>
				<th>팀원4</th>
				<th>팀원5</th>
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
		    type: 'GET',
		    url: './getTeamList.ajax',
		    dataType: 'json',
		    success: function(data) {
		        var content = '';
		    	data.list.forEach(function(item){
		    	   // class 안에 팀 이름과 컬럼명 정보를 담는다.
		    	   content = '<tr>';
		    	   content += '<td>'+item.team_name+'</td>';
		    	   content += '<td><input type="text" class="'+item.team_name+' project_name"  value="'+item.project_name+'"/></td>';
		    	   content += '<td><input type="text" class="'+item.team_name+' team_leader"  value="'+item.team_leader+'"/></td>';
		    	   content += '<td><input type="text" class="'+item.team_name+' staff1"  value="'+item.staff1+'"/></td>';
		    	   content += '<td><input type="text" class="'+item.team_name+' staff2"  value="'+item.staff2+'"/></td>';
		    	   content += '<td><input type="text" class="'+item.team_name+' staff3"  value="'+item.staff3+'"/></td>';
		    	   content += '<td><input type="text" class="'+item.team_name+' staff4"  value="'+item.staff4+'"/></td>';
		    	   content += '<td><input type="text" class="'+item.team_name+' staff5"  value="'+item.staff5+'"/></td>';
		    	   content += '</tr>';
		    	   
		    	   $('#list').append(content);
				});
		    	// 항상 요소가 출력되고 나서 이벤트를 걸어줄 것!
		    	$('input[type="text"]').focusin(function(){
		    		$(this).css({"background-color":"white"});
		    	});
		    	
		    	$('input[type="text"]').focusout(function(e){
		    		// this : 이벤트를 당한 당사자 객체 (나를 중심)
		    		// e : 이벤트 그 자체 (일어난 이벤트 중심)
		    		$(this).css({"background-color":"lightgray"});
		    		// console.log(e.target.defaultValue, '->', e.target.value);
		    		if (e.target.defaultValue != e.target.value) {
			    		console.log("서버에 변경 요청", $(e.target));
			    		// 팀이름(PK), 변경할 컬럼, 변경할 값
			    		// 1. 팀명 1조의 프로젝트명 이름을 강아지 몰로 바꾸고 싶다.
			    		// -> UPDATE team_project SET project_name = '강아지몰' WHERE team_name = '1조'
			    		// 2. 3조의 팀장을 김영수로 변경
			    		// -> UPDATE team_project SET team_leader = '김영수' WHERE team_name = '3조'
						// column, value, pk

			    		reqUpdate(e.target.classList[1], e.target.value, e.target.classList[0], e.target);
		    		}
		    	});
		    	
		    },
		    error: function(e) {
		        console.log(e);
		    }
		});
	}
	
	function reqUpdate(col, val, pk, ev) {
		console.log('UPDATE team_project SET '+col+' = '+val+' WHERE team_name = '+pk);
		// 서버에 대이터를 보내는 방법
		// 1. 파라메터 형식 : update?col=project_name&val=빈즈마켓&pk=1조 
		// 2. url 방식 : update/project_name/빈즈마켓/1조
		if (val == '') val = ' '; // 공백 넣었을 시에 에러 방지용
		$.ajax({
			type:'PUT',
			url:'update/'+col+'/'+val+'/'+pk,
			data:{},
			dataType:'JSON',
			success:function(data){
				console.log(data);
				// 완료한 후에 변경된 값을 그 컬럼에 기본 값으로 바꿔주기
				if (data.result == 1) {
					if (val == ' ') val = ''; // ' '으로 되면서 ''과 ' '은 다른것으로 취급되기에 다시 바꿔주기
					ev.defaultValue = val;
				}
			},
			error:function(e){
				console.log(e);
				ev.value = ev.defaultValue;
				// location.reload();
			}
		});
		
		
		
	}
	
	
	
	
	
	
	
</script>

</html>