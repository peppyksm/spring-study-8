<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>str</h1>
	
	<!-- 고정된 하드코딩 10줄 -->
	<p>스트링 리스트입니다</p>
	<p>스트링 리스트입니다</p>
	<p>스트링 리스트입니다</p>
	<p>스트링 리스트입니다</p>
	<p>스트링 리스트입니다</p>
	<p>스트링 리스트입니다</p>
	<p>스트링 리스트입니다</p>
	<p>스트링 리스트입니다</p>
	<p>스트링 리스트입니다</p>
	<p>스트링 리스트입니다</p>
	<p>스트링 리스트입니다</p>
	
	<c:forEach var="str" items="${strList}">
		<p>strList 스트링 리스트 입니다</p>
	</c:forEach>

</body>
</html>