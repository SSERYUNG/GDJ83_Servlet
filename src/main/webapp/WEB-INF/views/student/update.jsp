<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h1>학생 정보 수정</h1>

	<form action="./update" method="post">
		<div>
			<label for="name">이름</label> <input type="hidden" id="name"
				name="num" value="${requestScope.st.num}"> <input
				type="text" id="name" name="name" value="${requestScope.st.name}">


		</div>

		<div>
			<label for="kor">국어 점수</label> <input type="text" id="kor" name="kor"
				value="${requestScope.st.kor}">


		</div>


		<div>
			<label for="eng">영어 점수</label> <input type="text" id="eng" name="eng"
				value="${requestScope.st.eng}">


		</div>

		<div>
			<label for="math">수학 점수</label> <input type="text" id="math"
				name="math" value="${requestScope.st.math}">


		</div>

		<button type=submit>수정 완료</button>
	</form>


</body>
</html>