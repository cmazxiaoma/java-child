<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql. *"%>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改音乐信息</title>
</head>
<body>
<%@include file='head.jsp' %>
<%request.setCharacterEncoding("gb2312");
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/music","root","xiaoma96");
Statement stmt=con.createStatement();
String id=request.getParameter("id");
ResultSet rs=stmt.executeQuery("select * from musicinfo where id="+id);
rs.next();
%>
<form action="update.jsp" method="post">
<table align="center" width="50%" border="1">
<caption>修改音乐信息</caption>
<tr>
<th widh="30%">歌曲名:</th>
<td width="70%"><input name="musicname" type="text" value="<%=rs.getString(2)%>">
</td>
</tr>
<tr>
<th>歌手:</th>
<td><input name="author" type="text" value="<%=rs.getString(3)%>"></td></tr>
<tr>
<th>点击量:</th>
<td><input name="dianji" type="text" value="<%=rs.getInt(4) %>"></td>
</tr>
<tr>
<th colspan="2">
<input type="hidden" name="id" value="<%=id %>">
<input type="submit" value="修改">
<input type="reset" value="重置">
</th>
</tr>
</table>
</form>
<%
rs.close();
stmt.close();
con.close();
%>
</body>
</html>