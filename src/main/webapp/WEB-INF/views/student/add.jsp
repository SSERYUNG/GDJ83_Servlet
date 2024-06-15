<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 <h1>학생정보입력 페이지</h1>
 
 	<form action="/student/add" method="post">
 	 		
 		<div>
 			<label for="name">이름&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
 			<input type="text" id="name" name="name">
 		</div>
 		
 		 <div>
 			<label for="kor">국어점수</label>
 			<input type="text" id="kor" name="kor">
 		</div>
 		
  		 <div>
 			<label for="eng">영어점수</label>
 			<input type="text" id="eng" name="eng">
 		</div>
 		
 		 <div>
 			<label for="math">수학점수</label>
 			<input type="text" id="math" name="math">
 		</div>
 		
 		
 		<div>
 			<input type="submit" value="등록">
 			<button type="submit">작성</button>
 		</div>
 	
 	</form>

</body>
</html>