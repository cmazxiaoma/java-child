<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>时光流影</title>
<link rel="shortcut icon" href="background/logo.ico" type="image/x-icon" />
<script type="text/javascript" src="../JS/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="../JS/login.js"></script>
<link href="../css/login2.css" rel="stylesheet" type="text/css" />
<script>
function checkSession(){
	var username= "${sessionScope.user.username}";
	if(username==""){
		alert("请先登录");
		return false;
	}else{
		return true;
	}
}
</script>
</head>
<body background="<%=request.getContextPath()%>/background/1.1.jpg">
	<h4 align="right">
		<font color="#999999">
		  <c:choose>
				<c:when test="${ empty sessionScope.user }">
					<a href="<c:url value='/login.jsp'/>" target="_parent">登&nbsp;&nbsp;录</a> &nbsp;&nbsp;&nbsp;&nbsp;  <a
						href="<c:url value='/register.jsp'/>" target="_parent">注&nbsp;&nbsp;册</a>
				</c:when>
				<c:otherwise>
                                                   您好：${sessionScope.user.username}&nbsp;&nbsp;|&nbsp;&nbsp;
               <a href="<c:url value='/UserServlet?method=quit'/>" target="_parent">退出</a>
				</c:otherwise>
			</c:choose>
		</font>
	</h4>
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<div id="n">
		<ul>
			<li><a href="<c:url value='/index.jsp'/>" target="_parent"
				class="STYLE1">首页</a>
			</li>
			<li><a href="<c:url value='/AlbumServlet?method=findAll'/>"
				target="center" class="STYLE1"   onclick="javascript:return(checkSession());">相册管理</a>
			</li>
			<li><a href="<c:url value='/PhotoServlet?method=findAll'/>"
				target="center" class="STYLE1"  onclick="javascript:return(checkSession());">照片管理</a>
			</li>
			<li><a  target="_parent" class="STYLE1">神龙头</a>
			</li>
			<li><a  target="_parent" class="STYLE1">神龙尾</a>
			</li>
		</ul>
	</div>
</body>
</html>