<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<!-- Main Content -->
	<div class="container my-4">
		<div class="row">

			<!-- Main Section with Slider -->
			<div class="col-md-9">
				<div class="border bg-white p-5">
					<!-- Carousel Slider for Articles -->
					<div id="articleSlider" class="carousel slide"
						data-bs-ride="carousel">
						<div class="carousel-inner">
							<!-- Article 1 -->
							<div class="carousel-item active">
								<h5>Thủ tướng kêu gọi nhà đầu tư ngoại tăng rót vốn vào
									Việt Nam</h5>
								<img src="/SOF203_ASM/photo/home1.jpg" class="d-block w-100"
									alt="Article 1 Image">
								<div class="carousel-caption d-none d-md-block"></div>
							</div>
							<!-- Article 2 -->
							<div class="carousel-item">
								<h5>Phó thủ tướng: Đường sắt tốc độ 350 km/h cần 'thẳng
									nhất có thể'</h5>
								<img src="/SOF203_ASM/photo/home2.jpg" class="d-block w-100"
									alt="Article 2 Image">
								<div class="carousel-caption d-none d-md-block"></div>
							</div>
							<!-- Article 3 -->
							<div class="carousel-item">
								<h5>TP HCM cần chuyển đổi công nghiệp như thế nào</h5>
								<img src="/SOF203_ASM/photo/home3.jpg" class="d-block w-100"
									alt="Article 3 Image">
								<div class="carousel-caption d-none d-md-block"></div>
							</div>
							<!-- Add more articles if needed -->
						</div>
						<!-- Controls -->
						<button class="carousel-control-prev" type="button"
							data-bs-target="#articleSlider" data-bs-slide="prev">
							<span class="carousel-control-prev-icon" aria-hidden="true"></span>
							<span class="visually-hidden">Previous</span>
						</button>
						<button class="carousel-control-next" type="button"
							data-bs-target="#articleSlider" data-bs-slide="next">
							<span class="carousel-control-next-icon" aria-hidden="true"></span>
							<span class="visually-hidden">Next</span>
						</button>
					</div>
				</div>
			</div>

    <!-- Latest Articles Section (Next to the Slider) -->
			<div class="col-md-3">
				<div class="card mb-4">
					<div class="card-header bg-secondary text-white">5 bản tin mới nhất</div>
					<ul class="list-group list-group-flush">
						<li class="list-group-item"><a href="#">Bài báo mới 1</a></li>
						<li class="list-group-item"><a href="#">Bài báo mới 2</a></li>
						<li class="list-group-item"><a href="#">Bài báo mới 3</a></li>
						<li class="list-group-item"><a href="#">Bài báo mới 4</a></li>
						<li class="list-group-item"><a href="#">Bài báo mới 5</a></li>
					</ul>
				</div>
			</div>
		</div>
		

			<!-- 5 Most Viewed Articles -->
			<div class="card mb-3">
				<div class="card-header bg-warning text-white">5 bản tin được
					xem nhiều</div>
				<div class="card-body">
					<!-- Article 1 -->
					<div class="row mb-3">
						<div class="col-md-2">
							<img src="/SOF203_ASM/photo/culture1.jpg"
								class="img-fluid rounded" alt="Ảnh" style="max-width: 100%;">
						</div>
						<div class="col-md-10">
							<h5>
								<a href="news-detail1.html" class="text-primary">Làn sóng sa
									thải Gen Z Mỹ</a>
							</h5>
							<p class="text-muted">Báo cáo tháng 8 của hãng nghiên cứu thị
								trường lao động Intelligent.com cho thấy các công ty đang cắt
								giảm nhân sự Gen Z "nhiều đến mức đáng lo ngại".</p>
							<small class="text-muted">Ngày đăng: 01-09-2024 | Tác
								giả: Tác giả 1</small>
						</div>
					</div>
					<hr>

					<!-- Article 2 -->
					<div class="row mb-3">
						<div class="col-md-2">
							<img src="/SOF203_ASM/photo/culture2.jpg"
								class="img-fluid rounded" alt="Ảnh" style="max-width: 100%;">
						</div>
						<div class="col-md-10">
							<h5>
								<a href="news-detail2.html" class="text-primary">Cuộc đua
									công nghệ AI đang bùng nổ</a>
							</h5>
							<p class="text-muted">Các công ty công nghệ lớn trên toàn cầu
								đang cạnh tranh khốc liệt trong việc phát triển trí tuệ nhân tạo
								và ứng dụng AI trong nhiều lĩnh vực.</p>
							<small class="text-muted">Ngày đăng: 02-09-2024 | Tác
								giả: Tác giả 2</small>
						</div>
					</div>
					<hr>

					<!-- Repeat for other articles as needed -->
				</div>
			</div>

			<!-- 5 Articles Already Viewed -->
			<div class="card mb-3">
				<div class="card-header bg-success text-white">5 bản tin bạn
					đã xem</div>
				<div class="card-body">
					<!-- Same article format as above -->
				</div>
			</div>

			<!-- Newsletter Subscription -->
			<div class="bg-light text-center py-3">Newsletter</div>

		</div>
	</div>

