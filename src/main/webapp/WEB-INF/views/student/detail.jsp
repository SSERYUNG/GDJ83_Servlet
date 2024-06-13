<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 학생 한명 정보 </h1>

	<h3>${requestScope.one.num}</h3>
	<h3>${requestScope.one.name}</h3>
	<h3>${requestScope.one.kor}</h3>
	<h3>${requestScope.one.eng}</h3>
	<h3>${requestScope.one.math}</h3>
	<h3>${requestScope.one.total}</h3>
	<h3>${requestScope.one.avg}</h3>
	
</body>
</html>