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
	
	
	<form id = "frm" action="./delete" method="post">
		<input id ="num" type="hidden" name="num" value="${requestScope.dto.num}">
	</form>
	<button id="btn">DELETE</button>
	<button id="btn2">UPDATE</button>
	
	
	<script type="text/javascript">
	
	const frm = document.getElementById("frm");
	const btn = document.getElementById("btn");
	const btn2 = document.getElementById("btn2");
//
	btn.addEventListener("click",function(){
		frm.submit();
	})
	
	btn2.addEventListener("click",function(){
		frm.submit();
	})
	
	</script>
	
</body>
</html>