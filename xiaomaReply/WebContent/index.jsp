<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql. *"%>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
<form action="/xiaomanetvip/panduan.do" method="post">
<table align="center" width="50%" border="1">
<caption>游客|管理员登录</caption>
<tr>
<td><input type="radio" name="ch" value="youke">游客登录</td>
<td><input type="radio" name="ch" value="admin">管理员登录</td>
<tr>
<th colspan="3">
<input type="submit" name="submit" value="登录">
</th>
</tr>
</table>
</form>
</body>
</html>