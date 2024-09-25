<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/user/views/header.jsp" %>
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

	<!-- Main Content -->
	<div class="container my-4">
		<div class="row">

			<!-- Main Section with Slider -->
            <div class="col-md-9">
                <div class="border bg-white p-5">
                    <!-- Carousel Slider for Articles -->
                    <div id="articleSlider" class="carousel slide" data-bs-ride="carousel">
                        <div class="carousel-inner">
                            <!-- Article 1 -->
                            <div class="carousel-item active">
                            <h5>Thủ tướng kêu gọi nhà đầu tư ngoại tăng rót vốn vào Việt Nam</h5>
                                <img src="/SOF203_ASM/photo/home1.jpg" class="d-block w-100" alt="Article 1 Image">
                                <div class="carousel-caption d-none d-md-block">
                                </div>
                            </div>
                            <!-- Article 2 -->
                            <div class="carousel-item">  
                            <h5>Phó thủ tướng: Đường sắt tốc độ 350 km/h cần 'thẳng nhất có thể'</h5>
                                <img src="/SOF203_ASM/photo/home2.jpg" class="d-block w-100" alt="Article 2 Image">
                                <div class="carousel-caption d-none d-md-block">
                                </div>
                            </div>
                            <!-- Article 3 -->
                            <div class="carousel-item">
                            <h5>TP HCM cần chuyển đổi công nghiệp như thế nào</h5>
                                <img src="/SOF203_ASM/photo/home3.jpg" class="d-block w-100" alt="Article 3 Image">
                                <div class="carousel-caption d-none d-md-block">
                                </div>
                            </div>
                            <!-- Add more articles if needed -->
                        </div>
                        <!-- Controls -->
                        <button class="carousel-control-prev" type="button" data-bs-target="#articleSlider" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#articleSlider" data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                </div>
            </div>

			<!-- Sidebar -->
			<div class="col-md-3">
				<div class="d-flex flex-column">
					<a class="bg-warning text-white text-center py-3 mb-3 nav-link" href="#">5 bản tin được xem nhiều</a>
					<a class="bg-secondary text-white text-center py-3 mb-3 nav-link" href="#">5 bản tin mới nhất</a>
					<a class="bg-success text-white text-center py-3 mb-3 nav-link" href="#">5 bản tin đã bạn đã xem</a>
					<div class="bg-light text-center py-3">Newsletter</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    <%@ include file="/user/views/footer.jsp" %>
</html>
