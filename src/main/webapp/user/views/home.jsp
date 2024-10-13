<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Main Content -->
<div class="container my-4">
	<div class="row">
		<!-- Main Section -->
		<div class="col-md-9">
			<div class="border bg-white p-5">

				<!-- Carousel Slider for Articles -->
				<div id="articleSlider" class="carousel slide"
					data-bs-ride="carousel">
					<div class="carousel-inner">
						<c:forEach var="slider" items="${homePageList}" varStatus="status">
							<div class="carousel-item ${status.index == 0 ? 'active' : ''}">
								<img src="${slider.imagePath}" class="d-block w-100"
									alt="${slider.title}">
								<div class="carousel-caption d-none d-md-block">
									<h5>
										<a href="/user/${slider.id}" style="text-decoration: none;">${slider.title}</a>
									</h5>
								</div>
							</div>
						</c:forEach>
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

		<!-- Latest Articles -->
		<div class="col-md-3">
			<div class="card mb-4">
				<div class="card-header bg-secondary text-white">5 bản tin mới
					nhất</div>
				<ul class="list-group list-group-flush">
					<c:forEach var="lastest" items="${latestList}">
						<div class="row mb-3">
							<div class="col-md-2">
								<a href="/user/${lastest.id}"> <img
									src="${lastest.imagePath}"
									class="img-fluid rounded" alt="Ảnh" style="max-width: 100%;">
								</a>
							</div>
							<div class="col-md-10">
								<h5>
									<a href="/user/${lastest.id}" style="text-decoration: none;">${lastest.title}</a>
								</h5>
							</div>
						</div>
					</c:forEach>
				</ul>
			</div>
		</div>



		<!--Most Viewed Articles -->
		<div class="card mb-3">
			<div class="card-header bg-warning text-white">5 bản tin được
				xem nhiều</div>
			<div class="card-body">
				<div class="row mb-3">
					<c:forEach var="mostViewd" items="${mostViewdList}">
						
						<div class="row mb-3">
							<div class="col-md-2">
								<a href="/user/${mostViewd.id}"> <img
									src="${mostViewd.imagePath}"
									class="img-fluid rounded" alt="Ảnh" style="max-width: 100%;">
								</a>
							</div>
							<div class="col-md-10">
								<h5>
									<a href="/user/${mostViewd.id}" style="text-decoration: none;">${mostViewd.title}</a>
								</h5>
							</div>
						</div>
						
					</c:forEach>
				</div>
			</div>
		</div>

		<!-- 5 Articles Already Viewed -->
		<div class="card mb-3">
			<div class="card-header bg-success text-white">5 bản tin bạn đã
				xem</div>
			<div class="card-body">
				<c:forEach var="viewd" items="${ViewdList}">
					<div class="row mb-3">
						<div class="col-md-2">
							<a href="/user/${viewd.id}"> <img
								src="${viewd.imagePath}"
								class="img-fluid rounded" alt="Ảnh" style="max-width: 60%;">
							</a>
						</div>
						<div class="col-md-10">
							<h5>
								<a href="/user/${viewd.id}">${viewd.title}</a>
							</h5>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>

		<!-- Newsletter Subscription -->
		<div class="card mb-3">
			<div class="card-header bg-secondary text-white">Newsletter</div>
			<div class="card-body">
				<input type="text" class="form-control"
					placeholder="your_email@example.com">
			</div>
		</div>

	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>