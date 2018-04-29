<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql. *"%>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[五月天|mayday]音乐管理系统</title>
</head>
<body>
<%@include file="head.jsp" %>
<font color='blue'>
<center><a href=add.jsp><font color='pink'>添加音乐信息</font></a></center></p>
<table align="center" width="50%" border=1>
<tr><th>歌曲</th><th>歌手</th><th>点击量</th><th>管理</th>
<%
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/music","root","xiaoma96");
Statement stmt=con.createStatement();
String s="select * from musicinfo";
ResultSet rs=stmt.executeQuery(s);
while(rs.next()){
	int id=rs.getInt(1);
	out.println("<tr><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getInt(4)+"</td><td><a href='edit.jsp?id="+id+"'><font color='pink'>修改</font></a>&nbsp;<a href='del.jsp?id="+id+"'><font color='pink'>删除</font></td></tr>");
}
 rs.close();
 stmt.close();
 con.close();
%>
<h3><a href='search.jsp'>搜索歌曲或者歌手</a></h3>
</table>
</font>
</body>
</html>