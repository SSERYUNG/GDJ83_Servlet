<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>수정 페이지</h1>
	
		<form action="./update" method="post">
		
		<input type="hidden" name="num" value="${requestScope.dto.num}">
		
		<div>
			<label>도시명</label>
			<input type="text" name="city" value="${requestScope.dto.city}">
		</div>
		
		<div>
			<label>기온</label>
			<input type="text" name="gion" value="${requestScope.dto.gion}">
		</div>
	
		<div>
			<label>습도</label>
			<input type="text" name="humidity" value="${requestScope.dto.humidity}">
		</div>

		<div>
			<label>상태</label>
			<input type="text" name="status" value="${requestScope.dto.status}">
		</div>
		
		
		<input type="submit" value="등록">
		<button type="submit">등록</button>

	</form>

</body>
</html>