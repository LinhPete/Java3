<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<form method="post">
		<table class="table table-bordered">
			<thead class="table-light">
				<tr>
					<c:forTokens var="col" items="Id,Loại tin,Action" delims=","
						varStatus="vs">
						<th ${vs.count==3?'colspan="2"':''}>${col}</th>
					</c:forTokens>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="cate" items="${list}">
					<tr>

						<td>${cate.repId}</td>
						<td><input type="text" name="${cate.repId}" value="${cate.name}"></td>
						<td><input type="button"
							formaction="CateCrudServlet/update?id=${cate.id}" value="Sửa"></td>
						<td><input type="button"
							formaction="CateCrudServlet/delete?id=${cate.id}" value="Xóa"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="CateCrudServlet?id=new">Thêm thể loại</a>
		<c:if test="${param.id=='new'}">
			<label for="newCate">Loại tin: </label>
			<input type="text" name="name" id="newCate">
			<input type="button" formaction="CateCrudServlet/insert" value="Thêm">
		</c:if>
	</form>

</div>
