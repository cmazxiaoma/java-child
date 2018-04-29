<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'UpSuccess.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <table align="center">
<tr><td height="100"></td></tr>
<tr><td align="center"><img src="<c:url value='background/createSuccess.jpg'/>" width="200" height="150" /></td></tr>
<tr><td height="100" align="center"><font color="#707070" size="5">
   上传相片成功！<br/>
 
点击<a href="<c:url value='/PhotoServlet?method=findAll'/>" target="center">跳转</a>回到相片界面</font>
</td></tr>
</table>
   
  </body>
</html>
