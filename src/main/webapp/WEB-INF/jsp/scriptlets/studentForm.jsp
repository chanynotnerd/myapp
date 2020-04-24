<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
</head>
<body>
	<h3>학생 등록</h3>
	<form action="./app/student/addStudent" method="post">
		<p>
			이름: <input type="text" name="name" required autofocus />
		</p>
		<p>
			학과: <input type="text" name="dept" required />
		</p>
		<p>
			<button type="submit">저장</button>
			<button type="button" onclick="history.back()">취소</button>
		</p>
	</form>
</body>
</html>