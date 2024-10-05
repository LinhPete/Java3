<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Chi tiết bản tin</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<!-- Header -->
	<header class="bg-dark text-white text-center py-3">
		<h1 class="h2">Sam Altman: AI thông minh hơn con người trong vài
			nghìn ngày tới</h1>
	</header>

	<!-- Main Content -->
	<main class="container mt-4">
		<article>
			<div class="row">
				<!-- Image Section -->
				<div class="col-md-8">
					<img
						src="https://i-vnexpress.vnecdn.net/2024/09/28/sam-altman-ai-4796649-169-5078-1312-1695967267.jpg?w=1020&h=0&q=100&dpr=1&fit=crop&s=-rWoXKxTICPKIogqbw8rDA"
						class="img-fluid" alt="Sam Altman AI">
				</div>

				<!-- Article Info -->
				<div class="col-md-4">
					<p class="text-muted">
						<small>Ngày 28/09/2024 - Bởi VnExpress</small>
					</p>
					<p>
						<strong>Sam Altman</strong>, CEO của OpenAI, tin rằng trí tuệ nhân
						tạo sẽ vượt qua con người trong vài nghìn ngày tới, đánh dấu một
						bước ngoặt trong lịch sử nhân loại.
					</p>
				</div>
			</div>

			<!-- Article Content -->
			<div class="mt-4">
				<h2 class="h4">AI vượt qua trí tuệ con người</h2>

				<p>
					Trong một cuộc phỏng vấn mới đây, <strong>Sam Altman</strong> chia
					sẻ rằng AI đang tiến hóa với tốc độ vượt bậc, và chúng ta có thể
					chứng kiến sự xuất hiện của những hệ thống AI thông minh hơn con
					người trong một khoảng thời gian ngắn.
				</p>
				<p>Altman nói rằng trong tương lai gần, những phát triển về AI
					có thể thay đổi cách chúng ta sống, làm việc, và tương tác với thế
					giới xung quanh.</p>

				<blockquote class="blockquote">
					<p>
						"Chúng ta chỉ còn cách sự thông minh vượt trội của AI vài nghìn
						ngày nữa, và đó sẽ là thời điểm mà chúng ta phải định nghĩa lại
						nhiều điều trong cuộc sống." - <strong>Sam Altman</strong>
					</p>
				</blockquote>
			</div>
		</article>
	</main>

	<div class="mt-3">
		<a href="list-news.jsp" class="btn btn-primary">Quay lại danh sách
			bản tin</a>
	</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
<%@ include file="/user/views/footer.jsp"%>
</html>
