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
<style>
.dropdown:hover 
    .dropdown-menu {
	display: block;
	min-width: auto;
	width: max-content;
	padding: 0;
}

.dropdown-item {
	display: block;
	width: 100%;
	padding: 8px 16px;
	text-align: left;
	white-space: nowrap;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row align-items-center">
			<!-- Newspaper Name -->
			<div class="col-md-4 text-start">
				<h1>Báo Dân Trí</h1>
			</div>

			<!-- Search Bar -->
			<div class="col-md-4 text-center">
				<form class="d-inline-block w-100">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Tìm kiếm">
						<button class="btn btn-outline-light" type="submit">
							<svg xmlns="http://www.w3.org/2000/svg" x="0px" y="0px"
								width="25" height="25" viewBox="0 0 50 50">
								<path
									d="M 21 3 C 11.601563 3 4 10.601563 4 20 C 4 29.398438 11.601563 37 21 37 C 24.355469 37 27.460938 36.015625 30.09375 34.34375 L 42.375 46.625 L 46.625 42.375 L 34.5 30.28125 C 36.679688 27.421875 38 23.878906 38 20 C 38 10.601563 30.398438 3 21 3 Z M 21 7 C 28.199219 7 34 12.800781 34 20 C 34 27.199219 28.199219 33 21 33 C 13.800781 33 8 27.199219 8 20 C 8 12.800781 13.800781 7 21 7 Z"></path>
							</svg>
						</button>
					</div>
				</form>
			</div>

			<div class="col-md-4 text-end">
				<!-- User Icon -->
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
						<li><a class="dropdown-item" href="NewsServlet?page=login">Đăng nhập</a></li>
						<li><a class="dropdown-item" href="NewsServlet?page=register">Đăng ký</a></li>
					</ul>
				</div>

				<button class="btn btn-light bell-icon">
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
						fill="currentColor" class="bi bi-bell-fill" viewBox="0 0 16 16">
                        <path
							d="M8 16a2 2 0 0 0 2-2H6a2 2 0 0 0 2 2m.995-14.901a1 1 0 1 0-1.99 0A5 5 0 0 0 3 6c0 1.098-.5 6-2 7h14c-1.5-1-2-5.902-2-7 0-2.42-1.72-4.44-4.005-4.901" />
                    </svg>
				</button>
			</div>
		</div>
	</div>
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
