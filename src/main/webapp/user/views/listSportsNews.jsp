<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/header.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bản tin Thể Thao</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>    
    <div class="container my-4">
        <h1 class="mb-4"></h1>

        <div class="row mb-3">
            <div class="col-md-2">
            	<a href="NewsServlet?id=${news.id}">
                	<img src="/SOF203_ASM/photo/sport1.jpg" class="img-fluid rounded" alt="Ảnh" style="max-width: 100%;">
                </a>
            </div>
            
            <div class="col-md-10">
            	<a href="NewsServlet?id=${news.id}">Tiêu đề bản tin
            	<!-- 	<h5 class="text-primary">${news.title}</h5> -->
                </a>
                <!-- <p>${news.excerpt}</p> -->
                <p class="text-muted">
                    Trích lấy phần đầu (số ký tự phù hợp) của nội dung bản tin 1.
                </p>
                <small class="text-muted">
                    Ngày đăng: 01-09-2024 | Tác giả: Tác giả 1
                </small>
            </div>
        </div>
        <hr>

        <div class="row mb-3">
            <div class="col-md-2">
                <img src="/SOF203_ASM/photo/sport2.jpg" class="img-fluid rounded" alt="Ảnh" style="max-width: 100%;">
            </div>
            <div class="col-md-10">
                <h5>
                    <a href="news-detail2.html" class="text-primary">Tiêu đề bản tin 2</a>
                </h5>
                <p class="text-muted">
                    Trích lấy phần đầu (số ký tự phù hợp) của nội dung bản tin 2.
                </p>
                <small class="text-muted">
                    Ngày đăng: 02-09-2024 | Tác giả: Tác giả 2
                </small>
            </div>
        </div>
        <hr>

        <div class="row mb-3">
            <div class="col-md-2">
                <img src="/SOF203_ASM/photo/sport3.jpg" class="img-fluid rounded" alt="Ảnh" style="max-width: 100%;">
            </div>
            <div class="col-md-10">
                <h5>
                    <a href="news-detail3.html" class="text-primary">Tiêu đề bản tin 3</a>
                </h5>
                <p class="text-muted">
                    Trích lấy phần đầu (số ký tự phù hợp) của nội dung bản tin 3.
                </p>
                <small class="text-muted">
                    Ngày đăng: 03-09-2024 | Tác giả: Tác giả 3
                </small>
            </div>
        </div>
        <hr>
        
        <div class="row mb-3">
            <div class="col-md-2">
                <img src="/SOF203_ASM/photo/sport4.jpg" class="img-fluid rounded" alt="Ảnh" style="max-width: 100%;">
            </div>
            <div class="col-md-10">
                <h5>
                    <a href="news-detail3.html" class="text-primary">Tiêu đề bản tin 4</a>
                </h5>
                <p class="text-muted">
                    Trích lấy phần đầu (số ký tự phù hợp) của nội dung bản tin 4
                </p>
                <small class="text-muted">
                    Ngày đăng: 03-09-2024 | Tác giả: Tác giả 4
                </small>
            </div>
        </div>
        <hr>
        
        <div class="row mb-3">
            <div class="col-md-2">
                <img src="/SOF203_ASM/photo/sport5.jpg" class="img-fluid rounded" alt="Ảnh" style="max-width: 100%;">
            </div>
            <div class="col-md-10">
                <h5>
                    <a href="news-detail3.html" class="text-primary">Tiêu đề bản tin 5</a>
                </h5>
                <p class="text-muted">
                    Trích lấy phần đầu (số ký tự phù hợp) của nội dung bản tin 5
                </p>
                <small class="text-muted">
                    Ngày đăng: 03-09-2024 | Tác giả: Tác giả 5
                </small>
            </div>
        </div>
        <hr>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
    <%@ include file="/views/footer.jsp" %>
</html>

