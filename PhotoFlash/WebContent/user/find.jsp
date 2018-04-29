<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<title>时光流影-找回密码</title> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../JS/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="../JS/login.js"></script>
<link href="../css/login2.css" rel="stylesheet" type="text/css" />
   <link rel="shortcut icon" href="<c:url value='/background/logo.ico'/>" type="image/x-icon" />
<script type="text/javascript">
  //获取主机之后的目录
 var pathName = window.document.location.pathname;
   //获取项目名
 var projectName = pathName.substring(0,pathName.substr(1).indexOf('/')+1);   
var InterValObj; //timer变量，控制时间  
var count=60; //间隔函数，1秒执行  
var curCount;//当前剩余秒数  
var code =""; //验证码  
var codeLength=6;//验证码长度   
var patrnphone=/^(13[0-9]|14[0-9]|15[0-9]|17[0-9]|18[0-9])\d{8}$/; 
function sendMessage2(){  
    curCount = count;  
  
    var mobilephone = $("#phone").val();
    var patrnPhone  = /^(13[0-9]|14[0-9]|15[0-9]|17[0-9]|18[0-9])\d{8}$/;
    if (!patrnPhone.test(mobilephone)) {alert('手机号码格式不正确，请确认后再输入');return;};
       //产生验证码  
       //ajaxFormPhone();
       //String existphone=(String)request.getSession().getAttribute("existphone");
       //alert(exitphone);
    	   for (var i = 0; i<codeLength;i++) {  
               code += parseInt(Math.random()* 9).toString();  
           }
         
           //设置button效果，开始计时  
           $("#btnSendCode").attr("disabled","true");  
           $("#btnSendCode").val("请在"+curCount+"秒内输入");  
           InterValObj=window.setInterval(SetRemainTime,1000);//启动计时器，1秒执行一次  
           	$.ajax({
				type : "POST", //用POST方式传输  
				dataType : "JSON", //数据格式:JSON  
				url : projectName+'/UserServlet?method=sendCodeByPhone', //目标地址  
				data : "phone=" + mobilephone + "&code=" + code,
				error : function(XMLHttpRequest, textStatus, errorThrown) {
				},
				success : function(msg) {
				}
			});
		}
//timer处理函数  
function SetRemainTime() {
    if (curCount ==0) {
        window.clearInterval(InterValObj);//停止计时器 
        $("#btnSendCode").removeAttr("disabled");//启用按钮  
        $("#btnSendCode").val("重新发送验证码");  
        code=""; //清除验证码。如果不清除，过时间后，输入收到的验证码依然有效      
    }  
    else {  
        curCount--;  
        $("#btnSendCode").val("请在"+curCount+"秒内输入");  
    }  
}







var InterValObj1; //timer变量，控制时间  
var count1 =60; //间隔函数，1秒执行  
var curCount1;//当前剩余秒数  
var code1 = ""; //验证码  
var codeLength1 = 6;//验证码长度   
function sendMessage1() {  
    curCount1 = count1;   
    var email = $("#email").val();
     if(email==""){
       alert("邮箱没填写！");return ;
     }
     
     if($('#email').val()!=""&&($('#email').val().indexOf('@',0)==-1 || $('#email').val().indexOf('.',0)==-1)){
        		 $('#email').focus().css("color", "red");
        		$('#email').css({
					border: "1px solid red",
					boxShadow: "0 0 2px red"
				});
				$('#checkemail').html("<font color='red'><b>×邮箱格式错误</b></font>");
				return false;
        	}
     
     
     
    	   for (var i =0; i< codeLength1;i++) {  
               code1 += parseInt(Math.random()* 9).toString();  
           }
         
           //设置button效果，开始计时  
           $("#btnSendCode1").attr("disabled", "true");  
           $("#btnSendCode1").val("请在"+curCount1 +"秒内输入");  
           InterValObj1 = window.setInterval(SetRemainTime1, 1000); //启动计时器，1秒执行一次  
          $.ajax({
				type : "POST", //用POST方式传输  
				dataType : "JSON", //数据格式:JSON  
				url : projectName+'/UserServlet?method=sendCode', //目标地址  
				data : "email=" + email + "&code=" + code1,
				error : function(XMLHttpRequest, textStatus, errorThrown) {
				},
				success : function(msg) {
				}
			});
}
       //boolean existphone=(boolean)request.getSession.getAttribute(existphone);
//timer处理函数  
function SetRemainTime1() {
    if (curCount1 == 0) {
        window.clearInterval(InterValObj1);//停止计时器 
        $("#btnSendCode1").removeAttr("disabled");//启用按钮  
        $("#btnSendCode1").val("重新发送验证码");  
        code1 = ""; //清除验证码。如果不清除，过时间后，输入收到的验证码依然有效      
    }  
    else {  
        curCount1--;  
        $("#btnSendCode1").val("请在"+curCount1+"秒内输入");  
    }  
}  

/*        邮箱找回整体js             */
function submit1() {
	
	if ($('#email').val() == "") {
		$('#email').focus().css({
			border: "1px solid red",
			boxShadow: "0 0 2px red"
		});
		$('#checkemail').html("<font color='red'><b>×邮箱不能为空</b></font>");
		return false;
	}

   if ($('#email').val().indexOf('@',0)==-1 || $('#email').val().indexOf('.',0)==-1) {
       $('#email').focus().css({
		border: "1px solid red",
		boxShadow: "0 0 2px red"
		});
		$('#checkemail').html("<font color='red'><b>×邮箱格式错误</b></font>");
		return false;
			}
	
 	if ($('#code1').val() == "") {
		$('#code1').css({
			border: "1px solid red",
			boxShadow: "0 0 2px red"
		});
		$('#checkcode1').html("<font color='red'><b>×验证码不能为空</b></font>");
		return false;
	}

	   if ($('#passwd1').val().length < pwdmin) {
	  	 $('#passwd1').focus().css({
			border: "1px solid red",
			boxShadow: "0 0 2px red"
			});
			$('#checkpwd11').html("<font color='red'><b>×密码不能小于" + pwdmin + "位</b></font>");
			return false;
		}
	
		if ($('#passwd21').val() != $('#passwd1').val()) {
		  $('#passwd21').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#checkpwd21').html("<font color='red'><b>×两次密码不一致！</b></font>");
			return false;
		
		}	
		
		$('#regUser1').submit();
	

		
	}
	
	/*        手机找回 整体判断js       */
	function submit2() {
	
		
   
	if ($('#phone').val() == "") {
			$('#checkphone').html("<font color='red'><b>×电话不能为空</b></font>");
			return false;
	}
	if ($('#code').val() == "") {
		$('#code').css({
			border: "1px solid red",
			boxShadow: "0 0 2px red"
		});
		$('#checkcode').html("<font color='red'><b>×验证码不能为空</b></font>");
		return false;
	}
	if ($('#passwd').val().length < pwdmin) {
	   $('#passwd1').focus().css({
		border: "1px solid red",
		boxShadow: "0 0 2px red"
		});
		$('#checkpwd1').html("<font color='red'><b>×密码不能小于" + pwdmin + "位</b></font>");
		return false;
		}
		
		if ($('#passwd2').val() != $('#passwd').val()) {
			$('#passwd2').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#checkpwd2').html("<font color='red'><b>×两次密码不一致！</b></font>");
			return false;
		}
		
		$('#regUser2').submit();
	}
	

        /*var wait = 60;
        function time(btn) {
            
            var mobilephone = $("#phone").val();
            var patrnPhone  = /^(13[0-9]|14[0-9]|15[0-9]|17[0-9]|18[0-9])\d{8}$/;
            if (!patrnPhone.test(mobilephone)) {alert('手机号码格式不正确，请确认后在输入');return;};
 
            btn.removeAttribute("disabled");
            if (wait == 60) {
                $.post("./mobile_validate_code", { 
                	"mobile": mobilephone 
                	},
                    function(data){
                }, "json");
            }
 
            if (wait == 0) {
              btn.removeAttribute("disabled");
              btn.value = "获取验证码";
              wait = 60;
            } else {
              btn.setAttribute("disabled", true);
              btn.value = wait + "秒后重新获取";
              wait--;
              setTimeout(function () {
                  time(btn);
              },
              1000)
            }
        }*/
    //检测密码强度
    
        function ajaxForm(){
        	var sb = document.getElementById("user").value;
        	$.ajax({
                type: 'post',
                url: projectName+'/UserServlet?method=check',
				dataType:"html",
				data:"username="+sb,
                success:function(data){
                	var res1=String($.trim(data));
                	if(res1=="××此用户名已经存在"){
                		$("#checkuser").html(data);
    					$("#checkuser").focus().css("color","red");
    					$('#user').focus().css({
    	    				border: "1px solid red",
    	    				boxShadow: "0 0 2px red"
    	    			});
                	}else if(res1=="√√此用户名可以注册"){
                		$("#checkuser").html(data);
    					$("#checkuser").css("color","green");
    					$('#user').css({
    	    				border: "1px solid green",
    	    				boxShadow: "0 0 2px green"
    	    			});
                	}
                }
        	});
		}
        function ajaxFormEmail(){
        	var email=document.getElementById("email").value;;
        	$.ajax({
                type: "POST",
                url: projectName+'/UserServlet?method=check',
				dataType:"html",
				data:"email="+email,
                success:function(data){
                	var res1=String($.trim(data));
                	if(res1=="××此邮箱已存在!"){
                		$("#checkemail").html("<b>√√√</b>");
    					$("#checkemail").css("color","green");
    					$('#email').css({
    	    				border: "1px solid green",
    	    				boxShadow: "0 0 2px green"
    	    			});
    					$("#btnSendCode1").attr('disabled',false);
                	}else if(res1=="√√此邮箱可以绑定!"){
                		$("#checkemail").html("<b>××此邮箱未绑定！</b>");
    					$("#checkemail").css("color","red");
    					$('#email').focus().css({
    	    				border: "1px solid red",
    	    				boxShadow: "0 0 2px red"
    	    			});
    					$("#btnSendCode1").attr('disabled',true);
                	}
                }
                	});
        }
        function ajaxFormPhone(){
        	$("#btnSendCode").removeAttr("disabled");
        	var phone=document.getElementById("phone").value;
        	$.ajax({
        		type:'post',
        		url:projectName+'/UserServlet?method=check',
        		dataType:"html",
				data:"phone="+phone,
                success:function(data){
                	var res=String($.trim(data));
                	if(res=="××此手机号已经绑定!"){
                		$("#checkphone").html("<b>√√√</b>");
    					$("#checkphone").css("color","green");
    					$('#phone').css({
    	    				border: "1px solid green",
    	    				boxShadow: "0 0 2px green"
    	    			});
    					$("#btnSendCode").attr('disabled',false);
                	}else if(res=="√√此手机号可以绑定!"){
                		$("#checkphone").html("<b>××此手机号未注册！</b>");
    					$("#checkphone").css("color","red");
    					$('#phone').focus().css({
    	    				border: "1px solid red",
    	    				boxShadow: "0 0 2px red"
    	    			});
    					$("#btnSendCode").attr('disabled',true);
                	}
                }
                	});
        }
        /*var loginname=doucment.getElementById("uuu").value;
        function ajaxForm(loginname){
        	$.ajax({
                type: 'post',
                url: 'DoAjaxServlet?method=getLoginname',
				dataType:"html",
				data:"username2="+loginname,
                success:function(data){
                	$("#outu").html(data);
					$("#outu").css("color","green");
					$("#uuu").css({
						border: "1px solid green",
        				boxShadow: "0 0 2px green"
					});
                }
                	
            });
		}
        */
        /*if(data.toString().equals("√此用户名可以注册")){
		$('#checkuser').css({
			border: "1px solid green",
			boxShadow: "0 0 2px green"
		});
		$("#checkuser").html(data);
	}else{
		$('#checkuser').css({
			border: "1px solid red",
			boxShadow: "0 0 2px red"
		});
		$("#checkuser").html(data);
	}*/
        /*window.open("checkName.action?username="+encodeURI(username),"check","menubar=no,height=300,width=400,left=300,top=80");
        */
        function checkpwd(){
        	/*var sbb=$("#passwd").val();
        	alert(sbb);*/
        	if ($('#passwd').val().length>=6) {
        		$('#passwd').css({
    				border: "1px solid green",
    				boxShadow: "0 0 2px green"
    			});
    			$('#checkpwd1').html("<font color='green'><b>√√√</b></font>");
    			return false;
    		}
        	else{
        		$('#passwd').css({
    				border: "1px solid red",
    				boxShadow: "0 0 2px red"
    			});
    			$('#checkpwd1').html("<font color='red'><b>×密码不能小于6位</b></font>");
    			return false;
        	}
        }
        function checkrepwd(){
        	if ($('#passwd2').val() != $('#passwd').val()||$('#passwd').val()=="") {
    			$('#passwd2').css({
    				border: "1px solid red",
    				boxShadow: "0 0 2px red"
    			});
    			$('#checkpwd2').html("<font color='red'><b>×两次密码不一致！</b></font>");
    			return false;
    		}
        	else{
        		$('#passwd2').css({
    				border: "1px solid green",
    				boxShadow: "0 0 2px green"
    			});
        		$('#checkpwd2').html("<font color='green'><b>√√√</b></font>");
    			return false;
        	}
        }
        function checkpwd1(){
        	/*var sbb=$("#passwd").val();
        	alert(sbb);*/
        	if ($('#passwd1').val().length>=6) {
        		$('#passwd1').css({
    				border: "1px solid green",
    				boxShadow: "0 0 2px green"
    			});
    			$('#checkpwd11').html("<font color='green'><b>√√√</b></font>");
    			return false;
    		}
        	else{
        		$('#passwd1').css({
    				border: "1px solid red",
    				boxShadow: "0 0 2px red"
    			});
    			$('#checkpwd11').html("<font color='red'><b>×密码不能小于6位</b></font>");
    			return false;
        	}
        }
        function checkrepwd1(){
        	if ($('#passwd21').val() != $('#passwd1').val()||$('#passwd1').val()=="") {
    			$('#passwd21').css({
    				border: "1px solid red",
    				boxShadow: "0 0 2px red"
    			});
    			$('#checkpwd21').html("<font color='red'><b>×两次密码不一致！</b></font>");
    			return false;
    		}
        	else{
        		$('#passwd21').css({
    				border: "1px solid green",
    				boxShadow: "0 0 2px green"
    			});
        		$('#checkpwd21').html("<font color='green'><b>√√√</b></font>");
    			return false;
        	}
        }
        function checkemail(){
        	if ($('#email').val() == "") {
        	     $('#email').focus().css("color", "red");
    			$('#email').css({
    				border: "1px solid red",
    				boxShadow: "0 0 2px red"
    			});
    			$('#checkemail').html("<font color='red'><b>×邮箱不能为空</b></font>");
    			return false;
    		}
        	if($('#email').val()!=""&&($('#email').val().indexOf('@',0)==-1 || $('#email').val().indexOf('.',0)==-1)){
        		 $('#email').focus().css("color", "red");
        		$('#email').css({
					border: "1px solid red",
					boxShadow: "0 0 2px red"
				});
				$('#checkemail').html("<font color='red'><b>×邮箱格式错误</b></font>");
				return false;
        	}
        	if($('#email').val()!=""&&!($('#email').val().indexOf('@',0)==-1 || $('#email').val().indexOf('.',0)==-1)){
        		//alert("sb");
        		$('#email').css({
					border: "1px solid green",
					boxShadow: "0 0 2px green"
				});
        		$('#checkemail').html("<font color='green'><b>√√√</b></font>");
        		//alert("sb2");
        		ajaxFormEmail();
				return false;
        	}

        }
        function checkcode(){
        	if ($('#code').val() == "") {
    			$('#code').css({
    				border: "1px solid red",
    				boxShadow: "0 0 2px red"
    			});
    			$('#checkcode').html("<font color='red'><b>×验证码不能为空</b></font>");
    			return false;
    		}
        	else{
        		$('#code').css({
    				border: "1px solid green",
    				boxShadow: "0 0 2px green"
    			});
        		$('#checkcode').html("<font color='green'><b>√成功填入验证码</b></font>");
    			return false;
        	}
        }
        function checkcode1(){
        	if ($('#code1').val() == "") {
    			$('#code1').css({
    				border: "1px solid red",
    				boxShadow: "0 0 2px red"
    			});
    			$('#checkcode1').html("<font color='red'><b>×验证码不能为空</b></font>");
    			return false;
    		}
        	else{
        		$('#code1').css({
    				border: "1px solid green",
    				boxShadow: "0 0 2px green"
    			});
        		$('#checkcode1').html("<font color='green'><b>√成功填入验证码</b></font>");
    			return false;
        	}
        }
        function checkphone(){
        	var patrnPhone  = /^(13[0-9]|14[0-9]|15[0-9]|17[0-9]|18[0-9])\d{8}$/;
        	if ($('#phone').val()== "") {
    			$('#checkphone').html("<font color='red'><b>×手机号不能为空</b></font>");
    			return false;
    		}if(!patrnPhone.test($('#phone').val())){
    			$('#phone').css({
    				border: "1px solid red",
    				boxShadow: "0 0 2px red"
    			});
    			$('#checkphone').html("<font color='red'><b>×手机号格式错误</b></font>");
    			return false;
    		}if(patrnPhone.test($('#phone').val())){
    			$('#phone').css({
    				border: "1px solid green",
    				boxShadow: "0 0 2px green"
    			});
    			$('#checkphone').html("<font color='green'><b>√√手机格式正确</b></font>");
    			ajaxFormPhone();
    			return false;
    		}
        }

 
       
        	
</script>
</head>

<body background="<%=request.getContextPath()%>/background/1.jpg">
<h1>PhotoFlash<sup>2016</sup></h1>

<div class="login" style="margin-top:50px;">
    
    <div class="header">
        <div class="switch" id="switch"><a class="switch_btn_focus" id="switch_qlogin" href="javascript:void(0);" tabindex="7">邮箱找回</a>
			<a class="switch_btn" id="switch_login" href="javascript:void(0);" tabindex="8">手机找回</a><div class="switch_bottom" id="switch_bottom" style="position: absolute; width: 64px; left: 0px;"></div>
        </div>
    </div>    
  
  <div class="web_qr_login" id="web_qr_login" style="display:block;">
			<!--邮箱找回-->
			<div class="web_login" id="web_login">
				<div class="login-box">
					<div class="login_form">
					
						<form name="form2" id="regUser1" accept-charset="utf-8" method="post" action="<c:url value='/UserServlet'/>">
					<input type="hidden" name="method" value="update" />
					<ul class="reg_form" id="reg-ul" style="width: 350px;">
					
					<li>
				<label for="email" class="input-tips2">邮箱：</label>
					<div class="inputOuter2">
						<input type="text" id="email" name="email" maxlength="30" class="inputstyle2" style="width: 140px; height: 28px;color:black;" onblur="checkemail();"/>
						<div id="checkemail"></div>
					</div>	 
				</li>
						

						<li><label for="code" class="input-tips2">验证码：</label>
							<div class="inputOuter2">
<input type="text" id="code1" name="code" maxlength="7" size="10" class="inputstyle2" style="width:70px; height:30px;" onblur="checkcode1();" />
<input id="btnSendCode1" name="button1" type="button" value='获取验证码' onclick="sendMessage1();" style="width:90x; height:34px;" class="codebutton" />
								<!--  time(this)-->
								<div id="checkcode1"></div>
							</div></li>
							<li>
                <label for="passwd" class="input-tips2">密码：</label>
                    <div class="inputOuter2">
                        <input type="password" id="passwd1"  name="password" maxlength="16" class="inputstyle2" style="width: 140px; height: 28px;" onblur="checkpwd1();"/>
                        <div id="checkpwd11"></div>
                    </div>
                    
                </li>
                <li>
                <label for="passwd2" class="input-tips2">确认密码：</label>
                    <div class="inputOuter2">
                        <input type="password" id="passwd21" name="password" maxlength="16" class="inputstyle2" style="width: 140px; height: 28px;" onblur="checkrepwd1();"/>
                        <div id="checkpwd21"></div>
                    </div>
                    
                </li>
						<li>
							<div class="inputArea">
								<input type="button" id="reg1"
									style="margin-top:10px;margin-left:85px;width:140px" class="button_blue"
									value="确定" onclick="submit1();"/> 		
							</div>
							</li>
							
					</ul>
				</form>
					</div>

				</div>
				
			</div>
			<!--邮箱找回end-->
		</div>
    
  

  <!--手机找回密码-->
    <div class="qlogin" id="qlogin" style="display:none;">
   
    <div class="web_login"><form name="form2"   id="regUser2" accept-charset="utf-8"  method="post" action="<c:url value='/UserServlet'/>">
	      <input type="hidden" name="method" value="update"/>
		      		    
        <ul class="reg_form" id="reg-ul" style="width: 350px;">
        		<div id="userCue" class="cue" ><font color="339999">找回密码<sup></sup></font></div>
        		<li>
				<label for="phone" class="input-tips2">手机号：</label>
					<div class="inputOuter2">
						<input type="text" id="phone" name="phone" maxlength="16" class="inputstyle2" style="width: 140px; height: 28px;" onblur="checkphone();"/>
						<div id="checkphone"></div>
					</div>	 
				</li>
                <li>
                	
                    <label for="code"  class="input-tips2">验证码：</label>
                    <div class="inputOuter2">
                        <input type="text" id="code" name="code" maxlength="7" size="10" class="inputstyle2" style="width:70px; height:30px;" onblur="checkcode();"/>
                        <input id="btnSendCode" name="button" type="button" value='获取验证码' onclick="sendMessage2();" style="width:90x; height:34px;" class="codebutton" /><font color="green"></font>
                        <div id="checkcode"></div>                  <!--  time(this)-->
                  </div>
                    
                </li>
                <li>
                <label for="passwd" class="input-tips2">密码：</label>
                    <div class="inputOuter2">
                        <input type="password" id="passwd"  name="password" maxlength="16" class="inputstyle2" style="width: 140px; height: 28px;" onblur="checkpwd();"/>
                        <div id="checkpwd1"></div>
                    </div>
                    
                </li>
                <li>
                <label for="passwd2" class="input-tips2">确认密码：</label>
                    <div class="inputOuter2">
                        <input type="password" id="passwd2" name="password" maxlength="16" class="inputstyle2" style="width: 140px; height: 28px;" onblur="checkrepwd();"/>
                        <div id="checkpwd2"></div>
                    </div>
                    
                </li>
                		
                <li>
                    <div class="inputArea">
                        <input type="button" id="reg"  style="margin-top:10px;margin-left:85px;width:140px" class="button_blue" value="确定" onclick="submit2();" />
                    </div>
                    
                </li>
                
              <!--   <div class="cl"></div>-->
            </ul>
            </form>
 
    </div> 
    </div>
    <!--注册end-->
</div>

</body></html>