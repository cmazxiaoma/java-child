<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base target="center">
<title>时光流影</title>
<!-- ---------------------- -->
<script src="<c:url value='/layer/jquery.min.js'/>"></script>
<script src="<c:url value='/layer/layer.js'/>"></script>

<!-- ---------------------- -->
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

		<hr color="#E6E6FA" />
		<c:choose>
			<c:when test="${empty pb.albumList}">
         		   没有相册
  			 </c:when>

			<c:otherwise>
				<c:forEach items="${pb.albumList }" var="album">
					<c:choose>
					<c:when test="${album.power eq 1  or  user.uid eq album.uid }">
					<div class="icon">
						<a
							href="<c:url value='/AlbumServlet?method=findAllPhoto&albumId=${album.aid }'/>">
							<img src="<c:url value='/${album.coverpath }'/>" border="0"
							class="pictures" /> </a> <br /> <a
							href="<c:url value='/AlbumServlet?method=findAllPhoto&albumId=${album.aid }'/>">${album.albumname}</a>
						<c:if test="${user.uid eq album.uid }">
							<a href="<c:url value='/AlbumServlet?method=find&albumId=${album.aid}'/>">编辑相册</a>
						</c:if>
					</div>
					 </c:when>
					 <c:otherwise>
					  <div class="icon">
						<a onclick="alert('您没有权限查看！')">
							<img src="<c:url value='/background/default.png'/>" border="0"
							class="pictures" /> </a> <br /> 
							<a onclick="alert('您没有权限查看！');">${album.albumname}</a>
					
					</div>
					  </c:otherwise>
					</c:choose>
					
				</c:forEach>

				<p>
				<p id="txt">
					第${pb.curpage }页/共${pb.totalpage }页
					<c:if test="${pb.curpage>1 }">
						<a href="<c:url value='AlbumServlet?method=findAll&page=${1 }'/>">首页</a>
					</c:if>
					<c:if test="${pb.curpage>1 }">
						<a
							href="<c:url value='AlbumServlet?method=findAll&page=${pb.curpage-1 }'/>">上一页</a>
					</c:if>

					<c:choose>
						<c:when test="${pb.totalpage<10 }">
							<c:set var="begin" value="1"></c:set>
							<c:set var="end" value="${pb.totalpage }"></c:set>
						</c:when>

						<c:otherwise>
							<c:set var="begin" value="${pb.curpage-5 }"></c:set>
							<c:set var="end" value="${pb.curpage+4 }"></c:set>

							<c:if test="${begin<1 }">
								<c:set var="begin" value="1"></c:set>
								<c:set var="end" value="10"></c:set>
							</c:if>

							<c:if test="${end>pb.totalpage }">
								<c:set var="begin" value="${pb.totalpage-9}"></c:set>
								<c:set var="end" value="${pb.totalpage }"></c:set>
							</c:if>
						</c:otherwise>
					</c:choose>



					<c:forEach var="i" begin="${begin }" end="${end }">
						<c:choose>
							<c:when test="${pb.curpage eq i }">
  							[${i }]
					</c:when>
							<c:otherwise>
								<a
									href="<c:url value='/AlbumServlet?method=findAll&page=${i}'/>">[${i}]</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>


					<c:if test="${pb.curpage<pb.totalpage }">
						<a
							href="<c:url value='/AlbumServlet?method=findAll&page=${pb.curpage+1 }'/>">下一页</a>
					</c:if>
					<c:if test="${pb.curpage<pb.totalpage}">
						<a
							href="<c:url value='/AlbumServlet?method=findAll&page=${pb.totalpage }'/>">尾页</a>
					</c:if>
				</p>
			</c:otherwise>
		</c:choose>
	</center>
</body>
</html>