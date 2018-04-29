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
    
    <title>My JSP 'EditPhoto.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="<c:url value='/layer/css/min_123.css'/>">
<script type="text/javascript" src="<c:url value='/layer/jquery.js'/>"></script>
<script type="text/javascript">
$(function(){
    $('.reginpblu-yqm').hide();
    $(".regerror2").toggle(function(){
        $(this).find("span").attr("class","nle-sicon2");
        $(this).parent().find(".reginpblu-yqm").show();  
    },function(){
        $(this).find("span").attr("class","nle-sicon");   
        $(this).parent().find(".reginpblu-yqm").hide();   
    });
});  
</script>
  </head>
  
  <body>
  
<div class="ctn-960 mg shadow-5" style="background-color:white;">
  <form  action="<c:url value='/UpdatePhotoServlet'/>" class="js-form-validate" method="post" onSubmit="return checkForm()" name="f" enctype="multipart/form-data" data-arg-one="#" data-arg-two="100">
   
    <input type="hidden" name="pid"  value="${editPhoto.pid }"/>
    <div class="confirm-info-list mgt clearfix" style="position: relative; margin:0 auto; height: 0;">
      <dl class="confirm-info-list-dl confirm-info-list-project">
        <dt class="tc1-title">
          	<font size="5">编辑相片</font>
        </dt>
      </dl>
      <dl class="confirm-info-list-dl">
        <dt class="tc1-title">&nbsp;</dt>
        <dd>
          <div class="confirmationForm clearfix" style="width:100%;">
            <div id="invest-paypwd" style="width:60%;float:left">
              <ul class="agree-protocol">
                <li>
                  <label class="plain-text"><span class="td-name" style="font-weight:bolder;">名称：</span><span class="plain-text">
                    <input  type="text"  id="album"value="${editPhoto.photoname }" name="photoname" placeholder="请输入相册名称" >
                    <font ></font></span></label>
                  <div class="error-container error" id="form-invest-confirm-error-pass"></div>
                </li>
				<li>
                  <label class="plain-text"><span class="td-name" style="font-weight:bolder;">描述：</span><span class="plain-text">
                    <input  type="text"  name="a_description" value="${editPhoto.p_description }" placeholder="对相册进行描述" >
                    </span></label>
                  <div class="error-container error" id="form-invest-confirm-error-pass"></div>
                </li>
				
				<li>
                 
                  <label class="plain-text"><span class="td-name" style="font-weight:bolder;">所属相册：</span>
                  
                  <select  name="aid">
												<c:forEach items="${albumNameList }" var="albumnameList">
													<option value="${albumnameList.aid }"
													<c:if test="${requestScope.editPhoto.aid eq  albumnameList.aid }">
                     								 selected="selected"</c:if>>
														${albumnameList.albumname }</option>
												</c:forEach>
							</select>
                  </label>
                  <div class="error-container error" id="form-invest-confirm-error-pass"></div>
                </li>
				<li>
                  <label class="plain-text"><span class="td-name" style="font-weight:bolder;">上传照片：</span><span class="plain-text">
                 
					 <input type="file" name="filepath" />

                    </span></label>
				</li>
              </ul>
              <div class="invest-btn-line">
                <input tabindex="3" id="confirm-btn" type="submit" value="编辑相片" class="i-p-c-i-btn clearButton">
                <span id="confirmERR" class="error" style="vertical-align:top;color:#CB282D;padding-left:20px;line-height:45px"></span> </div>
            </div>
			
			<div style="width:40%;float:right;">
		  	<img src="<c:url value='/${editPhoto.filepath }'/>" width="250" height="250"/>
			</div>
          </div>
        </dd>
      </dl>
    </div>
  </form>
</div>
  
  </body>
</html>
