<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改完成</title>
</head>
<body>
<%@include file="head.jsp" %>
<%
String musicname=request.getParameter("musicname");
String author=request.getParameter("author");
String dianji=request.getParameter("dianji");
String id=request.getParameter("id");
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/music","root","xiaoma96");
Statement stmt=con.createStatement();


String sql="update musicinfo set musicname='"+musicname+"',author='"+author+"',dianji="+dianji+" where id="+id;
int i=stmt.executeUpdate(sql);
if(i==1)
{
	out.println("<script language='javaScript'> alert('修改成功,单击确定后自动跳到主页');</script>");
	response.setHeader("refresh","1;url=index.jsp");
}
else{
	out.println("<script language='javaScript'> alert('修改失败,单击确定后自动跳到主页');</script>");
	response.setHeader("refresh","1;url=index.jsp");
	
}
stmt.close();
con.close();
%>
</body>
</html>