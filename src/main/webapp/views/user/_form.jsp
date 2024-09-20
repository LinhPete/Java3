<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>User Edition</h3>
	${message}
	<form action="/ps39152_lab4/views/user" method="post">
	Username<input name="username" value="${form.username}"><br>
	Password<input name="password"><br>
	<input name="remember" type="checkbox" ${form.remember?'checked':''}>Remember me?
	<br>
	<button>Create</button>
	</form>
</body>
</html>