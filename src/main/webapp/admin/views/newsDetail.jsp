<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/news" var="url" />
<div class="container">
	<h1 class="mt-4">Tin tức</h1>
	<h2>Tác giả: ${news.authorName}</h2>
	<h2>Ngày đăng: ${news.postedDate}</h2>

	<form action="${url}" method="post" enctype="multipart/form-data"
		target="_blank">
		<div class="mb-3">
			<c:if test="${user==null || user.role=='true'}">
				<h4>Loại tin: ${news.categoryName}</h4>
			</c:if>
			<c:if test="${user.role=='false'}">
				<label for="category" class="form-label">Chọn loại tin</label>
				<select name="category" id="category" class="form-select">
					<c:forEach var="cate" items="${categories}">
						<option value="${cate.id}"
							${news.categoryId==cate.id?'selected':''}>${cate.name}</option>
					</c:forEach>
				</select>
			</c:if>
		</div>

		<div class="mb-3">
			<label for="title" class="form-label">Tiêu đề</label> <input
				name="title" type="text" id="title" class="form-control"
				value="${news.title}" ${user==null||user.role=='true'?'readonly':''}>
		</div>

		<div class="mb-3">
			<label for="img" class="form-label">Chọn ảnh</label>
			<div>
				<c:if test="${news==null}">
					<input type="file" name="img" id="file">
					<br>
				</c:if>
				<c:if test="${news!=null}">
					<img alt="${news.image}" src="/uploads/${news.image}"
						class="img-fluid mb-2">
					<br>
				</c:if>
			</div>
		</div>

		<div class="mb-3">
			<label for="content" class="form-label">Nội dung</label>
			<textarea rows="10" name="content" id="content" class="form-control"
				${user==null||user.role=='true'?'readonly':''}>${news.content}</textarea>
		</div>
		<c:if test="${user==null||user.role=='true'}">
			<input type="checkbox" name="home">
			<label>Cho phép lên trang chủ?</label>
			<br>
		</c:if>
		<c:if test="${user.role=='false'}">
			<button formaction="${url}/insert" class="btn btn-primary">Đăng
				bài</button>
		</c:if>
		<button formaction="${url}/update?id=${news.id}"
			class="btn btn-primary">Cập nhật</button>
	</form>
</div>