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
    <h1 class="mb-4">${category}</h1>
        <c:forEach var="news" items="${newsList}">
        <div class="row mb-3">
            <div class="col-md-2">
                <a href="/SOF203_ASM/user/detail/${news.id}">
                    <img src="${news.imagePath}" class="img-fluid rounded" alt="Ảnh"
                         style="max-width: 100%;">
                </a>
            </div>
            <div class="col-md-10">
                <h5>
                    <a href="/SOF203_ASM/user/detail/${news.id}" style="text-decoration: none;">${news.title}</a>
                </h5>
                <p class="text-muted">${news.excerpt}</p>
                <small class="text-muted"> Ngày đăng: ${news.postedDate} | Tác giả: ${news.authorName} </small>
            </div>
        </div>
    </c:forEach>
    
    <hr>
</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

