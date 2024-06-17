<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>학생 한명 정보</h1>

	<h3>${requestScope.one.num}</h3>
	<h3>${requestScope.one.name}</h3>
	<h3>${requestScope.one.kor}</h3>
	<h3>${requestScope.one.eng}</h3>
	<h3>${requestScope.one.math}</h3>
	<h3>${requestScope.one.total}</h3>
	<h3>${requestScope.one.avg}</h3>

	<form action="./delete" method="post" id="fo">

		<input type="hidden" name="number" value=${requestScope.one.num}>
		<input type="hidden" name="name" value=${requestScope.one.name}>
		<input type="hidden" name="kor" value=${requestScope.one.kor}>
		<input type="hidden" name="eng" value=${requestScope.one.eng}>
		<input type="hidden" name="math" value=${requestScope.one.math}>

		<button type="submit" id="btn1">해당학생 삭제</button>
		<button type="submit" id="btn2">해당학생 수정</button>

	</form>

	<script>
		const btn1 = document.getElementById("btn1")
		const btn2 = document.getElementById("btn2")
		const fo = document.getElementById("fo")

		btn1.addEventListener("click", function() {
			fo.submit()
		})

		btn2.addEventListener("click", function() {
			fo.setAttribute("method", "get")
			fo.setAttribute("action", "./update")
		})
	</script>



</body>
</html>