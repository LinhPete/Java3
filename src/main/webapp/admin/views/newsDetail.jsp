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
	<form action="${url}" method="post" enctype="multipart/form-data" target="_blank">
		<select name="category">
		<c:forEach var="cate" items="${categories}">
			<option value="${cate.Id}">cate.Name</option>
		</c:forEach>
		</select>
		<label for="title">Tiêu đề </label><input name="title" type="text" id="title"><br>
		<label for="img">Chọn ảnh</label><br>
		<input type="file" name="img" id="file"><br>
		<label for="content">Nội dung</label><br>
		<textarea rows="50" cols="50" name="content" id="content"></textarea>
		<input type="submit" value="Đăng bài">
	</form>
</body>
</html>