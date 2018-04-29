<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="<c:url value='/layer/css/min_123.css'/>">
<script type="text/javascript" src="<c:url value='/layer/jquery.js'/>"></script>
<script type="text/javascript">
function checkForm(){
		var name = document.f.photoname.value;
		var description = document.f.p_description.value;
		
		var file = document.f.filepath.value;

		if (name == "") {
			alert("相片名称不能为空！");
			return false;
		} else if (description == "") {
		   alert("相片描述不能为空！");
		 	return false;
		} else if (file== ""){
			alert("请选择要上传的照片！");
			return false;
		}
		var c = file.substring(file.lastIndexOf("\\")+1);
	    var fileExt = c.substring(c.lastIndexOf(".")+1);
		if(!(fileExt=="jpg"||fileExt=="gif"||fileExt=="bmp"||fileExt=="png"||fileExt=="jpeg"||fileExt=="ico"||fileExt=="JPG"||fileExt=="GIF"||fileExt=="BMP"||fileExt=="PNG"||fileExt=="JPEG"||fileExt=="ICO")){
			alert("只能上传图片。");
			return false;
		}
	
		return true;
 
 }
	$(function() {
		$('.reginpblu-yqm').hide();
		$(".regerror2").toggle(function() {
			$(this).find("span").attr("class", "nle-sicon2");
			$(this).parent().find(".reginpblu-yqm").show();
		}, function() {
			$(this).find("span").attr("class", "nle-sicon");
			$(this).parent().find(".reginpblu-yqm").hide();
		});
	});
</script>
</head>
<body id="invest_content">

	<div class="ctn-960 mg shadow-5">
		<form action="<c:url value='/UpPhotoServlet'/>" name="f"  class="js-form-validate"  method="post"
			onSubmit="return checkForm()" data-arg-one="#" data-arg-two="100" enctype="multipart/form-data">
			<div class="confirm-info-list mgt clearfix"
				style="position: relative; margin:0 auto; height: 0;">
				<dl class="confirm-info-list-dl confirm-info-list-project">
					<dt class="tc1-title">
						<font size="5">上传照片</font>
					</dt>
				</dl>
				<dl class="confirm-info-list-dl">
					<dt class="tc1-title">&nbsp;</dt>
					<dd>
						<div class="confirmationForm clearfix" style="width:100%;">
							<div id="invest-paypwd" style="width:60%;float:left">
								<ul class="agree-protocol">
									<li><label class="plain-text"><span
											class="td-name" style="font-weight:bolder;">名称：</span><span
											class="plain-text"> <input type="text" value=""
												placeholder="请输入照片名称" name="photoname"> </span>
									</label>
										<div class="error-container error"
											id="form-invest-confirm-error-pass"></div></li>
									<li><label class="plain-text"><span
											class="td-name" style="font-weight:bolder;">说明：</span><span
											class="plain-text"> <input type="text" name="p_description"
												value="" placeholder="对照片进行说明"> </span>
									</label>
										<div class="error-container error"
											id="form-invest-confirm-error-pass"></div></li>
									<li><label class="plain-text"><span
											class="td-name" style="font-weight:bolder;">选择相册：</span> 
											<select  name="aid">
												<c:forEach items="${albumNameList }" var="albumList">
													<option value="${albumList.aid }"
														<c:if test="${sessionScope.album.aid eq albumList.aid }">
                     								 selected="selected"</c:if>>
														${albumList.albumname }</option>
												</c:forEach>
										</select> </label>
										<div class="error-container error"
											id="form-invest-confirm-error-pass"></div></li>
									<li><label class="plain-text"><span
											class="td-name" style="font-weight:bolder;">上传照片：</span><span
											class="plain-text"> <input type="file" name="filepath"/>

										</span>
									</label></li>
								</ul>
								<div class="invest-btn-line">
									<input tabindex="3" id="confirm-btn" type="submit" value="照片上传"
										class="i-p-c-i-btn clearButton"> <span id="confirmERR"
										class="error"
										style="vertical-align:top;color:#CB282D;padding-left:20px;line-height:45px"></span>
								</div>
							</div>

							<div style="width:40%;float:right;">
								<img src="<%=request.getContextPath()%>/background/9.png"
									width="250" height="250" />
							</div>
						</div>
					</dd>
				</dl>
			</div>
		</form>
	</div>
</body>
</html>