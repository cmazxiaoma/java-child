<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<%
 //获取图片地址
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value='/css/button.css'/>">
<title>Insert title here</title>
<style type="text/css">
#banner {
	width:40%;
	background-color: #fff;
	height:100%;
	position:fixed;
	text-align:right;
	font-family:Arial, Helvetica, sans-serif;
	font-size:18px;
	word-spacing:2px;
	padding:20px;
}
#authorpic {
	border-radius:100%;
}
#main {
	width:40%;
	padding-left:650px;
	font-size:14px;
}
.pictures{
	border-radius:30px;
}

#bbb{
color:#FFFFFF;
}


#section1h1{
 line-height:30pt;
}
#section1{
font-family:Arial, Helvetica, sans-serif;
color:#9a9a9a;
letter-spacing:1pt;
word-spacing:2pt;
line-height:25pt;
padding-top:40px;
border-bottom-style:solid;
border-bottom-color:#9a9a9a;
border-bottom-width:2px;
}
</style>
<script type="text/javascript">
function check(){
  var value = document.f.words.value;
  if(value==""){
    alert("评论为空");
    return false;
  }
  return true;
}
</script>
</head>
<body>
<form action="<c:url value='/PhotoServlet'/>" method="post" name="f" onSubmit="return check()">
<input type="hidden" name="method" value="addReply"/>
<input type="hidden" name="photoId" value="${photoDesc.pid }"/>
	<div id="banner">
        <h6 align="center"><img src="<c:url value='/${photoDesc.filepath }'/>" class="pictures"width="400" height="400" /><br/>
        照片名称 :${photoDesc.photoname }<br/>时间 :	<fmt:formatDate value="${photoDesc.uptime }" pattern="YYYY-MM-dd HH:mm:ss"/>
          </h6>
    </div>
    <div id="main">
        <h4 align="center">
		<font size="5">评论区</font><br/>
		<textarea name="content" rows="6"cols="40" style="background-color:transparent"></textarea>
		<br/>
		<input type="submit" name="submit"  value="留言"  ><br/>
		</h4><hr/>
		
         <c:forEach items="${replyList }" var="reply">
		<font size="3" color="#888888">${reply.username }</font><br/> ${reply.content }
	    <br/>
    
    	<font size="2" color="#446644" style="">
    	 <fmt:formatDate value="${reply.replytime }" pattern="YYYY-MM-dd HH:mm:ss"/>
    	<br/>
    	</font>
    	<hr/>
    	</c:forEach>

        </div>
        </form>
 <!--           分享组件                     --> 	
<a class="bshareDiv" href="http://www.bshare.cn/share">分享按钮</a>
<script type="text/javascript" charset="utf-8" src="http://static.bshare.cn/b/buttonLite.js#uuid=&amp;style=3&amp;fs=4&amp;textcolor=#fff&amp;bgcolor=#19D&amp;text=分享到"></script>
<script type="text/javascript" charset="utf-8">
    //获取当前网址
   var curWwwPath = window.document.location.href; 
   //获取主机之后的目录
   var pathName = window.document.location.pathname;
   //获取项目名
   var projectName = pathName.substring(0,pathName.substr(1).indexOf('/')+1);   
   
   var  filepath = "${requestScope.photoDesc.filepath}";
 
   bShare.addEntry({
    title: "来自外星球的PhotoFlash",
    url: "",
    summary: "V1.0",
    pic: '<%=basePath%>'+projectName+'/'+filepath
});
</script>
</body>
</html>