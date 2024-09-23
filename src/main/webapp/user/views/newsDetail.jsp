<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chi tiết bản tin</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container my-4">
        <h1 class="mb-4"></h1>
        <div class="row">
        
            <!-- Img -->
            <div class="col-md-3">
                <img src="path/to/image-detail.jpg" class="img-fluid rounded" alt="Ảnh" style="max-width: 100%;">
            </div>
            
            <!-- Content -->
            <div class="col-md-9">
                <h5 class="text-primary">Tiêu đề của bản tin</h5>
                <p class="text-muted">
                    Đây là nội dung chi tiết của bản tin. Nội dung có thể bao gồm thông tin về sự kiện, tin tức hoặc thông báo quan trọng. 
                    Phần nội dung này có thể dài hơn so với phần trích đoạn.
                </p>
                <small class="text-muted">
                    <strong>Ngày đăng:</strong> 20/09/2024 | <strong>Tác giả:</strong> Tác giả A
                </small>
            </div>
        </div>

        <div class="mt-3">
            <a href="list-news.jsp" class="btn btn-primary">Quay lại danh sách bản tin</a>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
