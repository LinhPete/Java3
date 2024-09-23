<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>News</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="bg-primary text-white text-center py-3">
		<h1>Header</h1>
	</div>

	<!-- Nav -->
	<nav class="bg-light text-center py-2">
		<a href="NewsServlet?page=home" class="text-decoration-none mx-2">Trang chủ</a> 
		<a href="NewsServlet?page=culture" class="text-decoration-none mx-2">Văn hóa</a> 
		<a href="NewsServlet?page=law" class="text-decoration-none mx-2">Pháp luật</a> 
		<a href="NewsServlet?page=sports" class="text-decoration-none mx-2">Thể thao</a> 
		<a href="NewsServlet?page=travel" class="text-decoration-none mx-2">Du lịch</a>
	</nav>

</body>

</html>
