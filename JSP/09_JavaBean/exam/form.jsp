<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- form.jsp 에서 보낸 내용을 beanProc.jsp 에서 저장시키고 beanResult.jsp 에서 저장된 내용을 확인한다. -->
	<form action="beanProc.jsp">
		이름 : <input type="text" name="userName"/>
		<button>전송</button><!-- button 태그는 form 안에 있으면 submit 역할을 수행, 그냥 버튼을 만들고 싶으면 input type="button" -->
	</form>
</body>
</html>