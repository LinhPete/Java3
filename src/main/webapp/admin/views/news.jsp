<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Thêm tin tức</h1>
	<c:url value="/AdminServlet" var="url"/>
	<form action="${url}" method="post" enctype="multipart/form-data">
		<label for="title">Tiêu đề: </label><input name="title" type="text" id="title"><br>
		<label for="file">Chọn file<input type="file" name="file" id="file" hidden="hidden"></label><br>
		<input type="submit" value="Đăng bài">
	</form>	
</body>
</html>