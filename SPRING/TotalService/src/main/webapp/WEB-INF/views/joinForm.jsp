<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/common.css" type ="text/css">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<style>
	input[name="id"]{
		width:65%
	}
</style>
</head>
<body>
	<h3>회원가입</h3>
	<hr/>
	<form action="join.do" method = "post">
		<table>
			<tr>
				<th>ID</th>
				<td>
					<input type="text" name="id"/>
					<input type="button" value="중복체크" onclick="overlay()"/>
				</td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="password" name="pw"/></td>
			</tr>
			<tr>
				<th>PW확인</th>
				<td>
					<input type="password" id="confirm"/>
					<br/>
					<span id="msg"></span>
				</td>
			</tr>
			<tr>
				<th>관리자</th>
				<td><input type="checkbox" name="auth"/>관리자여부</td>
			</tr>
			<tr>
				<th>NAME</th>
				<td><input type="text" name="name"/></td>
			</tr>
			<tr>
				<th>AGE</th>
				<td><input type="text" name="age"/></td>
			</tr>
			<tr>
				<th>GENDER</th>
				<td>
					<input type="radio" name="gender" value="남"/>남자
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="gender" value="여"/>여자
				</td>
			</tr>
			<tr>
				<th>EMAIL</th>
				<td><input type="text" name="email"/></td>
			</tr>
			<tr>
				<th colspan="2"><button type="button" onclick="join()">회원가입</button></th>
			</tr>
		</table>
	</form>
</body>
<script>
	var msg = '${msg}';
	if(msg != '') alert(msg);

	var pwChk = false;
	var overChk = false;
	var overId = '';
	$('#confirm').on('keyup', function(){
		if($('input[name="pw"]').val() == $(this).val()){
			$('#msg').html("비밀번호가 일치합니다.");
			$('#msg').css({'color':'green'});			
			pwChk = true;
		} else {
			$('#msg').html("비밀번호가 일치하지 않습니다.");
			$('#msg').css({'color':'red'});
			pwChk = false;	
		}
	});

	function overlay() {
		var id = $('input[name="id"]').val();
		$.ajax({
			type:'POST',
			url:'./overlay.do',
			data:{'id':id},
			dataType:'JSON',
			success:function(data){
				if(id == '') return alert('공백은 사용하실 수 없습니다.');
				
				if (data.use > 0) {
					alert('이미 사용중인 아이디 입니다.');
					$('input[name="id"]').val('');
				} else {
					alert('사용가능한 아이디 입니다.');
					overChk = true;
					overId = $('input[name="id"]').val();
				}
			},
			error:function(error){
				console.log(error);
			}
		});
	}

	function join() {
		var $id = $('input[name="id"]');
		var $pw = $('input[name="pw"]');
		var $name = $('input[name="name"]');
		var $age = $('input[name="age"]');
		var $gender = $('input[name="gender"]:checked');
		var $email = $('input[name="email"]');

		if ($id.val() == '') {
			alert('id를 입력해주세요.');
			$id.focus();
		} else if (!overChk || overId != $id.val()) {
			alert('id 중복검사가 필요합니다.');
			$id.focus();
		} else if ($pw.val() == '') {
			alert('비밀번호를 입력해주세요.');
			$pw.focus();
		} else if ($name.val() == '') {
			alert('이름을 입력해주세요.');
			$name.focus();
		} else if ($age.val() == '') {
			alert('나이를 입력해주세요.');
			$age.focus();
		} else if ($gender.val() == null) {
			alert('성별을 체크해주세요.'); // 수정필요
		} else if ($email.val() == '') {
			alert('이메일을 입력해주세요.');
			$email.focus();
		} else {
			// 나이를 숫자만 입력
			if(RegExp('[a-zA-Zㄱ-ㅎ가-힣]').test($age.val())){
				alert('숫자만 입력해 주세요');
				$age.val('');
				$age.focus();
				return false;
			}
			$('form').submit();
		}
	}
	
</script>
</html>