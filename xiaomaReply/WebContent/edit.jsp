<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp" %>
<%@ page import="way.bean.xiaomanetinfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改留言并且审核</title>
</head>
<body>

<%
 xiaomanetinfo xmm1=(xiaomanetinfo)request.getAttribute("xmm1");
%>
<form action="/xiaomanetvip/update.do" method="post">
<table align="center" width="50%" border="1">
<caption>修改留言并且审核</caption>
<tr>
<th widh="30%">昵称:</th>
<td width="70%"><input name="username" type="text" value="<%=xmm1.getUsername()%>">
</td>
</tr>
<tr>
<th>留言:</th>
<td><input name="liuyan" type="text" value="<%=xmm1.getLiuyan()%>"></td></tr>
<tr>
<tr>
<th>审核:</th>
<td><input name="shenhe" type="text" value="<%=xmm1.getShenhe()%>"></td></tr>
<tr>
<tr>
<th>屏蔽(屏蔽填 是， 不屏蔽 填 否):</th>
<td><input name="hide" type="text" value="<%=xmm1.getHide()%>"></td></tr>
<tr>
<th colspan="2">
<input type="hidden" name="id" value="<%=xmm1.getId() %>">
<input type="submit" value="修改">
<input type="reset" value="重置">
</th>
</tr>
</table>
</form>
<a href="javascript:history.back()">返回</a>
</body>
</html>