<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<script type="text/javascript">
	window.onload = function() { // 브라우저가 페이지 로딩을 끝냈을 때 이벤트
		document.getElementById("deleteBtn").onclick = onDelete;
	}

	function onDelete() {
		if (!confirm("삭제하시겠습니까?"))
			return false; // [Cancel] 할 경우 링크 진행 안됨
	}
</script>
</head>
<body>
	<h3>학생 상세정보</h3>
	<p>학번: ${student.id }</p>
	<p>이름: ${student.name }</p>
	<p>학과: ${student.dept }</p>
	<p>
		<a href="./app/student/studentList">목록</a> <a
			href="./app/student/studentEdit?id=${student.id }">수정</a> <a
			id="deleteBtn" href="./app/student/deleteStudent?id=${student.id }">삭제</a>
	</p>
</body>
</html>