<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${requestScope.dto.city}</h1>
	<h1>${requestScope.dto.gion}</h1>
	<h1>${requestScope.dto.status}</h1>
	<h1>${requestScope.dto.humidity}</h1>
	
	
	<form action="./delete" method="post">
	</form>
	<button id="btn">DELETE</button>
	
	
	<script type="text/javascript">
	
	const btn = document.getElementById("btn");
	btn.addEventListener("click",function(){
		alert("test");
	})
	
	</script>
	
</body>
</html>