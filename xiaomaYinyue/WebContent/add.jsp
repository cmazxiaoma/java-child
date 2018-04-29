<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql. *"%>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加音乐信息</title>
</head>
<body>
<%@include file="head.jsp" %>
<form action="add.jsp" method="post">
<table align="center" width="50%" border="1">
<caption>添加音乐信息</caption>
<tr>
<th width="30%">歌曲名：</th>
<td width="70%"><input name="musicname"  type="text"></td>
</tr>
<tr>
<th>歌手：</th> 
<td><input name="author" type="text"></td>
</tr>
<tr>
<th>点击量：</th>
<td><input name="dianji" type="text"></td>
</tr>
<tr>
<th colspan="2">
<input type="submit" name="submit" value="添加">
<input type="reset" value="重置">
</th>
</tr>
</table>
</form>
<%
request.setCharacterEncoding("UTF-8");

String submit=request.getParameter("submit");
if(submit!=null&&!submit.equals("")){
	String musicname=request.getParameter("musicname");
	String author=request.getParameter("author");
	String dianji=request.getParameter("dianji");
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/music","root","xiaoma96");
	Statement stmt=con.createStatement();
	String sql="insert into musicinfo(musicname,author,dianji) values('"+musicname+"','"+author+"',"+dianji+")";
	int i=stmt.executeUpdate(sql);
	if(i==1)
	{
		out.println("<script language='javaScript'> alert('添加成功，单击确定跳转主页！');</script>");
		response.setHeader("refresh","1;url=index.jsp");
	}
	else{
		out.println("<script language='javaScript'> alert('添加失败，单击确定返回添加界面！');</script>");
		response.setHeader("refresh","2;url=add.jsp");
	}
	stmt.close();
	con.close();
}
%>
</body>
</html>