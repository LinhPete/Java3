<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/user/views/header.jsp" %>
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
            	<h5><a href="NewsServlet?id=${news.id}">Vinicius bị miệt thị là 'cặn bã'</h5>
            	<!-- 	<h5 class="text-primary">${news.title}</h5> -->
                </a>
                <!-- <p>${news.excerpt}</p> -->
                <p class="text-muted">
                   Theo cựu chủ tịch của Valencia Paco Roig, màu da không phải là lý do khiến Vinicius bị tẩy chay ở Tây Ban Nha.
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
                    <a href="news-detail2.html" class="text-primary">Lê Tuấn Minh - người hùng thầm lặng của Việt Nam ở Olympiad cờ vua</a>
                </h5>
                <p class="text-muted">
                    Đại kiện tướng Lê Tuấn Minh lần đầu dự Olympiad cờ vua ở tuổi 28, nhưng đoạt HC đồng và nhiều lần giành điểm quyết định cho Việt Nam.
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
                    <a href="news-detail3.html" class="text-primary">Pháp, Iran bị tố 'không muốn thắng' để gặp Thái Lan ở Futsal World Cup</a>
                </h5>
                <p class="text-muted">
                    Pháp và Iran bị chỉ trích về thái độ thi đấu, khi gặp nhau ở lượt cuối bảng F FIFA futsal World Cup 2024 ở Uzbekistan tối 22/9.
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
                    <a href="news-detail3.html" class="text-primary">Tân binh Mazraoui: 'Man Utd danh tiếng hơn Bayern'</a>
                </h5>
                <p class="text-muted">
                    Hậu vệ Noussair Mazraoui giải thích việc chia tay Bayern Munich sau hai năm để chuyển tới Man Utd vì muốn tìm kiếm thử thách mới.
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
                    <a href="news-detail3.html" class="text-primary">Quyết Chiến, Phương Vinh ra quân World Championship</a>
                </h5>
                <p class="text-muted">
                    Các cơ thủ hàng đầu Việt Nam sẽ ra quân ở giải billiards carom 3 băng vô địch thế giới - World Championship 2024 tại Phan Thiết, hôm nay.
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
    <%@ include file="/user/views/footer.jsp" %>
</html>

