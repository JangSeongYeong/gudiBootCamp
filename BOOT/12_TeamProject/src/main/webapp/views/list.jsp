<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Page</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="css/common.css" type="text/css">
<style>
</style>
</head>
<body>
	<h3>프로젝트 팀 리스트 상세</h3>

	<table>
		<thead>
			<tr>
				<th>팀이름</th>
				<th>프로젝트 이름</th>
				<th>팀 리더</th>
				<th>팀원 1</th>
				<th>팀원 2</th>
				<th>팀원 3</th>
				<th>팀원 4</th>
				<th>팀원 5</th>
			</tr>
		</thead>
		<tbody id="team-list"></tbody>
	</table>
</body>
<script>
	var msg = '${msg}';
	if(msg != ''){
		alert(msg);
	}
	
	listCall();
	
	function listCall() {
		$.ajax({
			type:'GET',
			url: 'list.ajax',
			data:{},
			dataType:'JSON',
			success:function(data){
				console.log(data);
				
				var content = '';
				
				for (team of data.list) {
					content +='<tr>';
					content +=		'<td><input type="text" name="team_name" value="'+team.team_name+'"/></td>';
					content +=		'<td><input type="text" name="project_name" value="'+team.project_name+'"/></td>';
					content +=		'<td><input type="text" name="team_leader" value="'+team.team_leader+'"/></td>';
					content +=		'<td><input type="text" name="staff1" value="'+team.staff1+'"/></td>';
					content +=		'<td><input type="text" name="staff2" value="'+team.staff2+'"/></td>';
					content +=		'<td><input type="text" name="staff3" value="'+team.staff3+'"/></td>';
					content +=		'<td><input type="text" name="staff4" value="'+team.staff4+'"/></td>';
					content +=		'<td><input type="text" name="staff5" value="'+team.staff5+'"/></td>';
					content +='</tr>';
				}

				$('#team-list').html(content);
				
			},
			error:function(e){
				console.log(e);	
			}
		});
	}
</script>
</html>