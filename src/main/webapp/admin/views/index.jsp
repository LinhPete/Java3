<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Công Cụ Quản Trị Tin Tức</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="bg-dark text-white text-center py-4">
		<h1>CÔNG CỤ QUẢN TRỊ TIN TỨC</h1>
	</div>
	<div class="container mt-3">
		<nav class="nav justify-content-center mb-4">
			<a class="nav-link" href="AdminServlet?dst=home">Trang chủ</a> <span
				class="nav-link">:</span> <a class="nav-link"
				href="AdminServlet?dst=news">Tin tức</a> <span class="nav-link">:</span>
			<a class="nav-link" href="#">Loại tin</a> <span class="nav-link">:</span>
			<a class="nav-link" href="#">Người dùng</a> <span class="nav-link">:</span>
			<a class="nav-link" href="#">Newsletter</a>
		</nav>
	</div>
	<c:choose>
		<c:when test="${param.dst=='home'}">
			<%@ include file="/admin/views/home.jsp"%>
		</c:when>
		<c:when test="${param.dst=='news'}">
			<%@ include file="/admin/views/news.jsp"%>
		</c:when>
		<c:otherwise><%@ include file="/admin/views/home.jsp"%></c:otherwise>
	</c:choose>
	<div class="footer text-center">
		<h2>Welcome [Họ và tên]</h2>
		<a href="NewsServlet">Về trang chính</a>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>