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
	 <%@ include file="/views/header.jsp" %>

	<!-- Main Content -->
	<div class="container my-4">
		<div class="row">

			<div class="col-md-9">
				<div class="border bg-white text-center p-5">
					<h2>Thay đổi theo trang</h2>
				</div>
			</div>

			<!-- Sidebar -->
			<div class="col-md-3">
				<div class="d-flex flex-column">
					<div class="bg-warning text-white text-center py-3 mb-3">5 bản tin được xem nhiều</div>
					<div class="bg-secondary text-white text-center py-3 mb-3">5 bản tin mới nhất</div>
					<div class="bg-success text-white text-center py-3 mb-3">5 bản tin đã bạn đã xem</div>
					<div class="bg-light text-center py-3">Newsletter</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    <%@ include file="/views/footer.jsp" %>
</html>
