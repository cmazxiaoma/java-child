<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>失败</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <link rel="shortcut icon" href="<c:url value='/background/logo.ico'/>" type="image/x-icon" />

  </head>
  
  <body>
  <table align="center">
<tr><td height="100"></td></tr>
<tr><td align="center"><img src="<c:url value='/background/false.PNG'/>" width="200" height="150" /></td></tr>
<tr><td height="100" align="center"><font color="#707070" size="5">
  修改密码失败，3秒后自动跳转到找回密码页面<br/>
 
点击<a href="<c:url value='find.jsp'/>">跳转</a>快速跳转到找回密码页面</font>
	<%response.setHeader("refresh","3,url=find.jsp"); %>
</td></tr>
</table>
  </body>
</html>
