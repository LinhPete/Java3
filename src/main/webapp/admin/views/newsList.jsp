<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<body>
	<table class="table table-bordered">
		<thead class="table-light">
			<tr>
				<c:forTokens var="col"
					items="Id,Tác giả,Loại tin,Tiêu đề,Ngày đăng tải,Lượt xem,Nội dung"
					delims=",">
					<th>${col}</th>
				</c:forTokens>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="news" items="${list}">
				<tr>
					
					<td>${news.repId}</td>
					<td>${news.authorName}</td>
					<td>${news.categoryName}</td>
					<td>${news.title}</td>
					<td>${news.postedDate}</td>
					<td>${news.viewCount}</td>
					<td><a
						href="NewsCrudServlet?id=${news.id}" target="_blank">Xem
							chi tiết...</a></td>
				</tr>

			</c:forEach>
		</tbody>
	</table>
</body>
