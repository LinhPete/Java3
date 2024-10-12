<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Danh sách bản tin</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container my-4">
		<h1 class="mb-4"></h1>

		<c:forEach var="news" items="${newsList}">
			<div class="row mb-3">
				<div class="col-md-2">
					<a href="NewsServlet?id=${news.id}"> <img
						src="/photo/${news.imagePath}" class="img-fluid rounded" alt="Ảnh"
						style="max-width: 100%;">
					</a>
				</div>
				<div class="col-md-10">
					<h5>
						<a href="NewsDetailServlet?id=${news.id}">${news.title}</a>
					</h5>
					<p class="text-muted">${news.excerpt}</p>
					<small class="text-muted"> Ngày đăng: ${news.postedDate} |
						Tác giả: ${news.author} </small>
				</div>
		</c:forEach>
		<hr>

		<div class="row mb-3">
			<div class="col-md-2">
				<img src="path/to/image2.jpg" class="img-fluid rounded" alt="Ảnh" style="max-width: 100%;">
			</div>
			<div class="col-md-10">
				<h5>
					<a href="news-detail2.html" class="text-primary">Tiêu đề bản tin tĩnh</a>
				</h5>
				<p class="text-muted">Trích lấy phần đầu của nội dung bản tin tĩnh.</p>
				<small class="text-muted"> Ngày đăng: 02-09-2024 | Tác giả: Tác giả 2 </small>
			</div>
		</div>
		<hr>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

