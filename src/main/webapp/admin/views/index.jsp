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
	<c:if test="${sessionScope.currUser!=null}">
		<div class="bg-dark text-white text-center py-4">
			<h1>CÔNG CỤ QUẢN TRỊ TIN TỨC</h1>
		</div>
		<c:if test="${sessionScope.currUser.role==true}">
			<div class="container mt-3">
				<nav class="nav justify-content-center mb-4">
					<a class="nav-link" href="/SOF203_ASM/admin/news">Tin tức</a> <span
						class="nav-link">:</span> <a class="nav-link"
						href="/SOF203_ASM/admin/category">Loại tin</a> <span
						class="nav-link">:</span> <a class="nav-link"
						href="/SOF203_ASM/admin/user">Người dùng</a> <span
						class="nav-link">:</span> <a class="nav-link"
						href="/SOF203_ASM/admin/letter">Newsletter</a>
				</nav>
			</div>
		</c:if>
		<jsp:include page="${path}" />
		<div class="footer text-center">
			<h2>Welcome ${sessionScope.currUser.fullname}</h2>
			<a href="/SOF203_ASM/user/home">Về trang chủ</a>
		</div>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
	</c:if>
	<c:if test="${sessionScope.currUser.role!=true}">
	<h1>Cần đăng nhập để tiếp tục</h1>
	<a href="/SOF203_ASM/login">Nhấn vào đây để đăng nhập</a>
	</c:if>
</body>
</html>