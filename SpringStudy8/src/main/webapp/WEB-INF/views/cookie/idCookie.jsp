<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>id cookie</h1>

	<!-- action 공백이면 get 방식으로 들어간 현재 경로에 자동 post 요청함 -->
	<form action="" method="post">
		아이디 : <input type="text" name="id" value="${remember}"><br>
		비번 : <input type="password" name="pw"><br> 아이디기억 <input
			type="checkbox" name="remember" value="true"  <c:if test ="${remember != null}">checked</c:if>><br>
		<!-- value에 아무것도 안넣으면 on으로 넘어옴, 체크 안되면 null 넘어옴 -->
		<button type="submit">로그인</button>
	</form>

</body>
</html>