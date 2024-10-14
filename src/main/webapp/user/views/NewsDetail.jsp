<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
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
        <h1 class="mb-4 text-center"></h1>
        <div class="row">
            <div class="col-md-4">
                <img src="${news.imagePath}" class="img-fluid rounded" alt="Ảnh chi tiết" style="max-width: 100%;">
            </div>
            <div class="col-md-8">
                <h5 class="text-primary" style="text-decoration: none;">${news.title}</h5>
                <p class="text-muted">${news.content}</p>
                <small class="text-muted">
                    <strong>Ngày đăng:</strong> ${news.postedDate} | <strong>Tác giả:</strong> ${news.getAuthorName()}
                </small>
            </div>
        </div>

         <!-- Related News Section -->
        <div class="mt-4">
        <c:if test="${not empty relatedNewsList}">
			<h4>Các tin tức liên quan</h4>
		</c:if>        
            <div class="row">
                <c:forEach var="relatedNews" items="${relatedNewsList}">
                    <div class="col-md-4">
                        <div class="card mb-3">
                            <img src="/photo/${relatedNews.imagePath}" class="card-img-top" alt="Tin tức liên quan" style="width: 100%; height: auto;">
                            <div class="card-body">
                                <h5 class="card-title">${relatedNews.title}</h5>
                                <p class="card-text">${relatedNews.excerpt}</p>
                                <a href="NewsDetailServlet?id=${relatedNews.id}" class="btn btn-primary">Xem chi tiết</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="col-md-4">
                    <div class="card mb-3">
                        <img src="/SOF203_ASM/photo/sport4.jpg" class="card-img-top" style="max-width: 60%; height: auto;">
                        <div class="card-body">
                            <h5 class="card-title">Tiêu đề tin tĩnh</h5>
                            <p class="card-text">Mô tả ngắn gọn về tin tức liên quan tĩnh</p>
                        </div>
                    </div>
                </div>
        </div>

        <div class="mt-4 text-center">
            <a href="/SOF203_ASM/user/views/home.jsp" class="btn btn-primary position-fixed bottom-0 end-0 m-4">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-list" viewBox="0 0 16 16">
			  <path fill-rule="evenodd" d="M2.5 12a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5m0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5m0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5"/>
			</svg>
            </a>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
