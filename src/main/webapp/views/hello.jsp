<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello, ${user.name}</h1>
	<form 
		action="${pageContext.request.contextPath }/upload-hello"
		enctype="multipart/form-data"
		method="POST">
		<input type="file" name="upload_file"/>
		<button>Submit</button>
	
	</form>
</body>
</html>