<!DOCTYPE html>
<html>
<body>
	<p> 
		<!-- hello servlet에서 실은 데이터를 꺼낸다. --> 
		request attribute "greeting" :
		<%=request.getAttribute("greeting")%></p>
	<p> 
		<!-- 브라우저에서 실은 데이터를 꺼낸다. -->
		request parameter "name" :
		<%=request.getParameter("name")%></p>
</body>
</html>