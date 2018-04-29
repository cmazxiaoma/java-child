<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql. *"%>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>搜索</title>
</head>
<body>
<%@include file="head.jsp" %>
<form action="search.jsp" method="post">
<table align="center" width="50%" border="1">
<caption>搜索歌手或者歌曲</caption>
<tr>
<th width="30%">搜索：</th>
<td width="70%"><input name="neirong"  type="text"></td>
</tr>
<tr>
<td><input type="radio" name="ch" value="0">歌曲搜索</td>
<td><input type="radio" name="ch" value="1">歌手搜索</td>
</tr>
<tr>
<th colspan="2">
<input type="submit" name="submit" value="搜索">
<input type="reset" value="重置">
</th>
</tr>
</table>
</form>
<% 
request.setCharacterEncoding("UTF-8");
String neirong=request.getParameter("neirong");
String submit=request.getParameter("submit");
if(submit!=null&&!submit.equals("")){
	String ch=request.getParameter("ch");
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/music","root","xiaoma96");
	Statement stmt=con.createStatement();
	if(ch!=null){
		int zhi=Integer.parseInt(ch);
		if(zhi==0){
			String s="select * from musicinfo";
			ResultSet rs=stmt.executeQuery(s);
			while(rs.next()){
				String m=rs.getString(2);	
				if(m.equals(neirong))
				{
					out.println("<script language='javaScript'> alert('搜索成功！');</script>");
					out.println("搜索数据库第"+rs.getString(1)+"行数据　|搜索结果：搜索成功！"+"<br>");
					out.println("音乐信息数据如下："+"<br>");
					out.println("歌曲："+rs.getString(2)+"<br>");
					out.println("歌手："+rs.getString(3)+"<br>");
					out.println("点击量："+rs.getInt(4)+"<br>");
					break;
					
				}
				else{
					out.println("搜索数据库第"+rs.getString(1)+"行数据　|搜索结果：搜索失败！"+"<br>");
				}
			}
		}
		if(zhi==1){
			String s="select * from musicinfo";
			ResultSet rs=stmt.executeQuery(s);
			while(rs.next()){
				String m=rs.getString(3);	
				if(m.equals(neirong)){
					out.println("<script language='javaScript'> alert('搜索成功！');</script>");
					out.println("搜索数据库第"+rs.getString(1)+"行数据　|搜索结果：搜索成功！"+"<br>");
					out.println("音乐信息数据如下："+"<br>");
					out.println("歌曲："+rs.getString(2)+"<br>");
					out.println("歌手："+rs.getString(3)+"<br>");
					out.println("点击量："+rs.getInt(4)+"<br>");
					break;
				}
				else{
					out.println("搜索数据库第"+rs.getString(1)+"行数据　|搜索结果：搜索失败！"+"<br>");
				}
			}
		}
	}
}
%>
</body>
</html>