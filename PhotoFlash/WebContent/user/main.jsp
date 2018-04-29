<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>时光流影</title>
    <link rel="shortcut icon" href="<c:url value='/background/logo.ico'/>" type="image/x-icon" />
    	<style type="text/css">
		* {
			font-size:10pt;
		}
		body{
			text-align:center;
		}
		.table{
			width:1024px;
			height:100%;
			
		}
		
		iframe {
			width: 1200px;
			height: 100%;
			border: none;
		}
	</style>   
  </head>
  <body>
  <table class="table" align="center" cellpadding="0" cellspacing="0" border="0" > 
	<tr style=" height:350px; width:1800px; ">
		<td  align="center">
			<iframe frameborder="0" src="<c:url value='/common/header.jsp'/>" name="top"></iframe>
		</td>
	</tr>
	<tr>
		<td width="120" style="padding:5px;" align="center" valign="top" height="900px">
			<iframe frameborder="0" width="120" src="<c:url value='/user/welcome.jsp'/>" name="center" ></iframe>
		</td>
		</tr>
		<tr>
		<td>
			<iframe frameborder="0" src="<c:url value='/common/bottom.jsp'/>" name="bottom"></iframe>
		</td>
	</tr>
</table>
  </body>
</html>
