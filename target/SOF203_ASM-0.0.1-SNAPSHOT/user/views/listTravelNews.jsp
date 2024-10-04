<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/user/views/header.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bản tin Du Lịch</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container my-4">
        <h1 class="mb-4"></h1>

        <div class="row mb-3">
            <div class="col-md-2">
                <img src="/SOF203_ASM/photo/travel1.jpg" class="img-fluid rounded" alt="Ảnh" style="max-width: 100%;">
            </div>
            <div class="col-md-10">
                <h5>
                    <a href="news-detail1.html" class="text-primary">Thưởng thức món Thái Michelin trên xe buýt ở Bangkok</a>
                </h5>
                <p class="text-muted">
                    Tour xe buýt ở Bangkok thu hút khách quốc tế nhờ kết hợp vừa tham quan vừa thưởng thức những món Thái nổi tiếng, được Michelin tuyển chọn.
                </p>
                <small class="text-muted">
                    Ngày đăng: 01-09-2024 | Tác giả: Tác giả 1
                </small>
            </div>
        </div>
        <hr>

        <div class="row mb-3">
            <div class="col-md-2">
                <img src="/SOF203_ASM/photo/travel2.jpg" class="img-fluid rounded" alt="Ảnh" style="max-width: 100%;">
            </div>
            <div class="col-md-10">
                <h5>
                    <a href="news-detail2.html" class="text-primary">Đi máy bay riêng đắt thế nào</a>
                </h5>
                <p class="text-muted">
                    Chuyến bay riêng tư được nhiều du khách cân nhắc vì các lợi ích như tránh đông đúc, thuận tiện nhưng chi phí lên tới 15.000 USD mỗi giờ.
                </p>
                <small class="text-muted">
                    Ngày đăng: 02-09-2024 | Tác giả: Tác giả 2
                </small>
            </div>
        </div>
        <hr>

        <div class="row mb-3">
            <div class="col-md-2">
                <img src="/SOF203_ASM/photo/travel3.jpg" class="img-fluid rounded" alt="Ảnh" style="max-width: 100%;">
            </div>
            <div class="col-md-10">
                <h5>
                    <a href="news-detail3.html" class="text-primary">Quê Hồ Xuân Hương được công nhận là điểm du lịch</a>
                </h5>
                <p class="text-muted">
                    Làng Quỳnh Đôi - quê hương "bà chúa thơ Nôm" Hồ Xuân Hương, được công nhận là điểm du lịch nhằm phát huy giá trị điểm đến, phục vụ khách tốt hơn
                </p>
                <small class="text-muted">
                    Ngày đăng: 03-09-2024 | Tác giả: Tác giả 3
                </small>
            </div>
        </div>
        <hr>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
    <%@ include file="/user/views/footer.jsp" %>
</html>

