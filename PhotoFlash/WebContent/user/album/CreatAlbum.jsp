<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="<c:url value='/layer/css/min_123.css'/>">
<script type="text/javascript" src="<c:url value='/layer/jquery.js'/>"></script>
<script type="text/javascript">


$(function(){
    $('.reginpblu-yqm').hide();
    $(".regerror2").toggle(function(){
        $(this).find("span").attr("class","nle-sicon2");
        $(this).parent().find(".reginpblu-yqm").show();  
    },function(){
        $(this).find("span").attr("class","nle-sicon") ;  
        $(this).parent().find(".reginpblu-yqm").hide();   
    });
}) ;

function checkForm(){
		var name = document.f.albumname.value;
		var description = document.f.a_description.value;
		var type = document.f.type.value;
		var file = document.f.filepath.value;

		if (name == "") {
			alert("文件名称不能为空！");
			return false;
		} else if (description == "") {
		   alert("文件描述不能为空！");
		 	return false;
		} else if( type == ""){
		    alert("请填写相册类型");
		    return false;
		}else if (file== ""){
			alert("请选择要上传的文件！");
			return false;
		}
		var c = file.substring(file.lastIndexOf("\\")+1);
	    var fileExt = c.substring(c.lastIndexOf(".")+1);
		if(!(fileExt=="jpg"||fileExt=="gif"||fileExt=="bmp"||fileExt=="png"||fileExt=="jpeg"||fileExt=="ico"||fileExt=="JPG"||fileExt=="GIF"||fileExt=="BMP"||fileExt=="PNG"||fileExt=="JPEG"||fileExt=="ICO")){
			alert("只能上传图片。");
			return false;
		}
	
		
 
 }
 
 function checkalbum() {
   var name = document.f.albumname.value;
    //获取当前网址
   var curWwwPath = window.document.location.href; 
   //获取主机之后的目录
   var pathName = window.document.location.pathname;
   //获取项目名
   var projectName = pathName.substring(0,pathName.substr(1).indexOf('/')+1);   
    //访问validate.do这个servlet，同时把获取的表单内容idField加入url字符串，以便传递给validate.do  
  
     var url = projectName+"/AlbumServlet?method=check"; 
		//对相册名是否可用进行校验
		
			$.ajax({
			  type : 'post',
			  url : url,
				dataType : "html",
				data : "albumname=" + name,
				success : function(data) {
					var res1 = String($.trim(data));
					if (res1 == "xx该相册名已经存在！") {
						$("#checkalbumname").html(data);
						$("#checkalbumname").focus().css("color", "red");
						$('#album').focus().css({
							border : "1px solid red",
							boxShadow : "0 0 2px red"
						});
					} else if (res1 == "√√") {
						$("#checkalbumname").html(data);
						$("#checkalbumname").css("color", "green");
						$('#album').css({
							border : "1px solid green",
							boxShadow : "0 0 2px green"
						});
					}
				}
			});
 }
</script>
</head>
<body id="invest_content">
	<div class="ctn-960 mg shadow-5">
		<form action="<c:url value='/UpAlbumServlet'/>"
			class="js-form-validate" enctype="multipart/form-data" method="post"
			name="f" onSubmit="return checkForm()" data-arg-one="#"
			data-arg-two="100">
			<div class="confirm-info-list mgt clearfix"
				style="position: relative; margin:0 auto; height: 0;">
				<dl class="confirm-info-list-dl confirm-info-list-project">
					<dt class="tc1-title">
						<font size="5">创建相册</font>
					</dt>
				</dl>
				<dl class="confirm-info-list-dl">
					<dt class="tc1-title">&nbsp;</dt>
					<dd>
						<div class="confirmationForm clearfix">
							<div id="invest-paypwd">
								<ul class="agree-protocol">
									<li><label class="plain-text"><span
											class="td-name" style="font-weight:bolder;">名称：</span><span
											class="plain-text"> <input type="text" name="albumname" id="album" placeholder="请输入相册名称"
												onblur="checkalbum();"> <font id="checkalbumname"></font>
										</span> </label>
										<div class="error-container error"
											id="form-invest-confirm-error-pass"></div></li>
									<li><label class="plain-text"><span
											class="td-name" style="font-weight:bolder;">描述：</span><span
											class="plain-text"> <input type="text" value=""
												name="a_description" placeholder="对相册进行描述"> </span> </label>
										<div class="error-container error"
											id="form-invest-confirm-error-pass"></div></li>
									<li><label class="plain-text"><span
											class="td-name" style="font-weight:bolder;">类型：</span><span
											class="plain-text"> <input type="text" value=""
												name="type" placeholder="请输入相册类型" /> </span> </label>
										<div class="error-container error"
											id="form-invest-confirm-error-pass"></div></li>
									<li><label class="plain-text"><span
											class="td-name" style="font-weight:bolder;">权限：</span> <select
											name="power">
												<option selected="selected" value="1">所有人可见</option>
												<option value="2">个人可见</option>
										</select> </label>
										<div class="error-container error"
											id="form-invest-confirm-error-pass"></div></li>
									<li><label class="plain-text"><span
											class="td-name" style="font-weight:bolder;">上传照片：</span><span
											class="plain-text"> <input type="file" name="filepath">
										</span> </label></li>
								</ul>
								<div class="invest-btn-line">
									<input tabindex="3" id="confirm-btn" type="submit" value="创建相册"
										class="i-p-c-i-btn clearButton"> <span id="confirmERR"
										class="error"
										style="vertical-align:top;color:#CB282D;padding-left:20px;line-height:45px"></span>
								</div>
							</div>
						</div>
					</dd>
				</dl>
			</div>
		</form>
	</div>
</body>
</html>