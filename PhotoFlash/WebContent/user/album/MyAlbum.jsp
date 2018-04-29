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
    
    <title>My JSP 'MyAblum.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
body {
	font-family: "Microsoft Yahei";
	font-size: 12px;
}

#pic {
	max-width: 200px;
	max-height: 200px;
}

.topDiv {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	color: #999966;
	background-image: url(background/a2.jpg);
	border: 5px solid #FFFFCC;
	position: absolute;
	z-index: 9999;
	display: none;
	width: 500px;
	height: 300px;
	margin-top: 13%;
	margin-left: 30%;
	padding: 10px;
}

.icon {
	margin-left: 150px;
	border: solid 1px gray;
	border-right-width: 30px;
	text-align: center;
	float: left;
	margin-bottom: 30px;
	width: 205px;
	height: 230px;
	border: 0;
	display: inline-block;
}

.pictures {
	border-radius: 30px;
}

div img {
	width: 200px;
	height: 180px;
}

#txt {
	position: absolute;
	bottom: 0px;
	left: 42%;
}
</style>
<script>
	function check() {
		//创建相册提示
		$('#Iframe').on('click', function() {
			layer.open({
				type : 2,
				skin : 'layui-layer-lan',
				title : '创建相册',
				fix : false,
				shadeClose : true,
				maxmin : true,
				area : [ '700px', '500px' ],
				content : 'user/album/CreatAlbum.jsp',

			});
		});
	}
	
</script>
 </head>
  
  <body bgcolor="#ffffff">
  <br />
	<br />
	<center>
		<!-- ------------------------------------------------------------------------------------ -->
		<a href="javascript:void(0);" onclick="check();"> <img
			src="<%=request.getContextPath()%>/background/sha1.png"
			id="Iframe" />
		</a>
		&nbsp;&nbsp;&nbsp;
        <a href="<c:url value='/AlbumServlet?method=findMyAlbums'/>"> <img
			src="<%=request.getContextPath()%>/background/sha2.png"
			 /> </a>
		<!-- ------------------------------------------------------------------------------------ -->
  >
   
		<hr color="#E6E6FA" />
		<c:choose>
			<c:when test="${empty Mypb.albumList}">
         		   没有相册
  			 </c:when>

			<c:otherwise>
				<c:forEach items="${Mypb.albumList }" var="Myalbum">
					<c:choose>
					<c:when test="${Myalbum.power eq 1  or  user.uid eq Myalbum.uid }">
					<div class="icon">
						<a href="<c:url value='/AlbumServlet?method=findAllPhoto&albumId=${album.aid }'/>">
							<img src="<c:url value='/${Myalbum.coverpath }'/>" border="0"
							class="pictures" /> </a> <br />
							 <a href="<c:url value='/AlbumServlet?method=findAllPhoto&albumId=${Myalbum.aid }'/>">${Myalbum.albumname}</a>
						<c:if test="${user.uid eq Myalbum.uid }">
							<a href="<c:url value='/AlbumServlet?method=find&albumId=${Myalbum.aid}'/>">编辑相册</a>
						</c:if>
					</div>
					 </c:when>
					</c:choose>
					
				</c:forEach>

				<p>
				<p id="txt">
					第${Mypb.curpage }页/共${Mypb.totalpage }页
					<c:if test="${Mypb.curpage>1 }">
						<a href="<c:url value='/AlbumServlet?method=findAll&page=${1 }'/>">首页</a>
					</c:if>
					<c:if test="${Mypb.curpage>1 }">
						<a
							href="<c:url value='/AlbumServlet?method=findAll&page=${Mypb.curpage-1 }'/>">上一页</a>
					</c:if>

					<c:choose>
						<c:when test="${Mypb.totalpage<10 }">
							<c:set var="begin" value="1"></c:set>
							<c:set var="end" value="${Mypb.totalpage }"></c:set>
						</c:when>

						<c:otherwise>
							<c:set var="begin" value="${Mypb.curpage-5 }"></c:set>
							<c:set var="end" value="${Mypb.curpage+4 }"></c:set>

							<c:if test="${begin<1 }">
								<c:set var="begin" value="1"></c:set>
								<c:set var="end" value="10"></c:set>
							</c:if>

							<c:if test="${end>Mypb.totalpage }">
								<c:set var="begin" value="${Mypb.totalpage-9}"></c:set>
								<c:set var="end" value="${Mypb.totalpage }"></c:set>
							</c:if>
						</c:otherwise>
					</c:choose>



					<c:forEach var="i" begin="${begin }" end="${end }">
						<c:choose>
							<c:when test="${Mypb.curpage eq i }">
  							[${i }]
					</c:when>
							<c:otherwise>
								<a
									href="<c:url value='/AlbumServlet?method=findAll&page=${i}'/>">[${i}]</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>


					<c:if test="${Mypb.curpage<Mypb.totalpage }">
						<a
							href="<c:url value='/AlbumServlet?method=findAll&page=${Mypb.curpage+1 }'/>">下一页</a>
					</c:if>
					<c:if test="${Mypb.curpage<Mypb.totalpage}">
						<a
							href="<c:url value='/AlbumServlet?method=findAll&page=${Mypb.totalpage }'/>">尾页</a>
					</c:if>
				</p>
			</c:otherwise>
		</c:choose>
	</center>
  </body>
</html>
