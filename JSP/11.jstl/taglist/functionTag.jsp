<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="java.util.HashMap"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		HashMap map = new HashMap();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");
		map.put("5", "5");
	%>	
	
	<c:set var="map" value="<%= map %>" />
	<c:set var="str1" value="zer0box 카페, http://cafe.naver.com/goingdeveloper/"/>
	<c:set var="str2" value="카페" />
	<c:set var="tokens" value="1,2,3,4,5,6,7,8,9,10" />
	
	<h1>Function 태그</h1>
	*length(map) : ${ fn:length(map) }<br><!-- 5  -->
	*length(str1) : ${ fn:length(str1) }<br><!-- 49  -->
	
	toUpperCase(str1) : ${ fn:toUpperCase(str1)}<br><!-- ZER0BOX 카페, HTTP://CAFE.NAVER.COM/GOINGDEVELOPER/ -->
	toLowerCase(str1) : ${ fn:toLowerCase(str1)}<br><!-- zer0box 카페, http://cafe.naver.com/goingdeveloper/ -->
	<!--~ 부터 보여주고, ~ 부터 잘라낸다.-->
	*substring(str1, 19, 40) : ${ fn:substring(str1, 12, 48) }<br><!-- http://cafe.naver.com/goingdeveloper -->
	<!--str2 를 기준으로 뒤만 보여줌-->
	substringAfter(str1, str2) : ${ fn:substringAfter(str1, str2) }<br><!--,  http://cafe.naver.com/goingdeveloper/ -->
	<!--str2 를 기준으로 앞만 보여줌-->
	substringBefore(str1, str2) : ${ fn:substringBefore(str1, str2) }<br><!-- zer0box  -->
	
	<!--str1 의 " " 을 ^ 로 변환-->
	*replace(str1, src, dest) : ${ fn:replace(str1, " ", "^") }<br><!-- zer0box^카페,^http://cafe.naver.com/goingdeveloper/ -->
	<!--str1 에서 str2 를 찾으면 몇번 인덱스에 있는가?-->
	indexOf(str1, str2) : ${ fn:indexOf(str1, str2) }<br><!-- 8 -->
	<!--str2 로 시작하는 값이 있나?-->
	startsWith(str1, str2) : ${ fn:startsWith(str1, 'zer0') }<br><!-- true -->
	<!--str2 로 끝나는 값이 있나?-->
	endsWith(str1, str2) : ${ fn:endsWith(str1, '/') }<br><!-- true -->
	<!--str2 를 포함하는 값이 있나?-->
	*contains(str1, str2) : ${ fn:contains(str1, str2) }<br><!-- true -->
	<!--str2 로 시작하는 값이 있나?(대소문자 구분 없이)-->
	containsIgnoreCase(str1, str2) : ${ fn:containsIgnoreCase(str1, str2) }<br><!-- true -->
	
	<!--구분자로 끊어서 배열에 삽입-->
	<c:set var="array" value="${ fn:split(tokens, ',') }" />
	join(array, "-") : ${ fn:join(array, "-") }<br><!-- 1-2-3-4-5-6-7-8-9-10 -->
	
	
	<!-- html 에서는 태그 형태를 html 태그로 오인한다. -->
	<welcome-file>default.htm</welcome-file>
	<!-- escapeXml() 을 사용하면 태그를 문자열로 인식할 수 있도록 해 준다. -->
	escapeXml("xmltag") : ${ fn:escapeXml("<welcome-file>default.htm</welcome-file>") }<!-- zer0box 카페, http://cafe.naver.com/goingdeveloper/ -->
</body>
</html>