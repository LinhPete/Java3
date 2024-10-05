<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Phân đoạn nội dung bài báo</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<div class="container my-4">
		<h1 class="h3 mb-3">Nội dung bài báo</h1>

		<div class="card p-3">
			<c:set var="content"
				value="Đây là nội dung cần được ngắt thành các dòng với mỗi dòng chứa 20 ký tự. Nội dung này sẽ được xử lý bằng cách chia ra các đoạn khác nhau." />
			<c:set var="words" value="${fn:split(content, ' ')}" />

			<c:set var="currentLine" value="" />
			<c:set var="maxCharsPerLine" value="20" />

			<c:forEach var="word" items="${words}">
				<c:choose>
					<c:when
						test="${fn:length(currentLine) + fn:length(word) + 1 > maxCharsPerLine}">
						<p>
							<c:out value="${currentLine}" />
						</p>
						<c:set var="currentLine" value="${word}" />
					</c:when>
					<c:otherwise>
						<c:set var="currentLine"
							value="${currentLine eq '' ? word : currentLine + ' ' + word}" />
					</c:otherwise>
				</c:choose>
			</c:forEach>

			<c:if test="${fn:length(currentLine) > 0}">
				<p>
					<c:out value="${currentLine}" />
				</p>
			</c:if>

		</div>
	</div>

	<!-- Bootstrap JS and Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
