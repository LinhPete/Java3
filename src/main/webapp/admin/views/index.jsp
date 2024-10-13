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
			<div class="dropdown d-inline-block mx-2">
					<button class="btn btn-light account-icon" type="button"
						id="dropdownMenuButton" data-bs-toggle="dropdown"
						aria-expanded="false">
						<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20"
							fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
                            <path
								d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6m2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0m4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4m-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10s-3.516.68-4.168 1.332c-.678.678-.83 1.418-.832 1.664z" />
                        </svg>
					</button>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
							<li><a class="dropdown-item" href="/SOF203_ASM/admin/user/edit/${sessionScope.currUser.id}">Trang
									cá nhân</a></li>
									<li><a class="dropdown-item" href="/SOF203_ASM/admin/changePass">Đổi mật khẩu</a></li>
							<li><a class="dropdown-item" href="/SOF203_ASM/user/home?logout=true">Đăng
									xuất</a></li>
					</ul>
				</div>
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