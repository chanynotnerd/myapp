<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.contextPath }/" /><!-- /myapp/ -->
</head>
<body>
	<h3>학생 수정</h3>
	<form action="./app/student/updateStudent" method="post">
		<p>
			학번: <input type="text" name="id" value="${student.id }" readonly />
		</p>
		<p>
			이름: <input type="text" name="name" value="${student.name }" required
				autofocus />
		</p>
		<p>
			학과: <input type="text" name="dept" value="${student.dept }" required />
		</p>
		<p>
			<button type="submit">저장</button>
			<button type="button" onclick="history.back()">취소</button>
		</p>
	</form>
</body>
</html>