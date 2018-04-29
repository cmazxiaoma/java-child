var InterValObj; //timer变量，控制时间  
		var count = 60; //间隔函数，1秒执行  
		var curCount;//当前剩余秒数  
		var code = ""; //验证码  
		var codeLength = 6;//验证码长度   
		var patrnphone = /^(13[0-9]|14[0-9]|15[0-9]|17[0-9]|18[0-9])\d{8}$/;
		function sendMessage() {
			curCount = count;
			var mobilephone = $("#phone").val();
			var patrnPhone = /^(13[0-9]|14[0-9]|15[0-9]|17[0-9]|18[0-9])\d{8}$/;
			if (!patrnPhone.test(mobilephone)) {
				alert('手机号码格式不正确，请确认后在输入');
				return;
			}
			;
			//产生验证码  ;
			for ( var i = 0; i < codeLength; i++) {
				code += parseInt(Math.random() * 9).toString();
			}
			//设置button效果，开始计时  
			$("#btnSendCode").attr("disabled", "true");
			$("#btnSendCode").val("请在" + curCount + "秒内输入");
			InterValObj = window.setInterval(SetRemainTime, 1000); //启动计时器，1秒执行一次  
			//向后台发送处理数据  
			$.ajax({
				type : "POST", //用POST方式传输  
				dataType : "JSON", //数据格式:JSON  
				url : 'UserServlet?method=sendCode', //目标地址  
				data : "phone=" + mobilephone + "&code=" + code,
				error : function(XMLHttpRequest, textStatus, errorThrown) {
				},
				success : function(msg) {
				}
			});
		}
		//boolean existphone=(boolean)request.getSession.getAttribute(existphone);
		//timer处理函数  
		function SetRemainTime() {
			if (curCount == 0) {
				$('smscode').removeAttr();
				window.clearInterval(InterValObj);//停止计时器 
				$("#btnSendCode").removeAttr("disabled");//启用按钮  
				$("#btnSendCode").val("重新发送验证码");
				code = ""; //清除验证码。如果不清除，过时间后，输入收到的验证码依然有效      
			} else {
				curCount--;
				$("#btnSendCode").val("请在" + curCount + "秒内输入");
			}
		}

		function ajaxForm() {
			var sb = document.getElementById("user").value;
			$.ajax({
				type : 'post',
				url : 'UserServlet?method=check',
				dataType : "html",
				data : "username=" + sb,
				success : function(data) {
					var res1 = String($.trim(data));
					if (res1 == "××此用户名已经存在") {
						$("#checkuser").html(data);
						$("#checkuser").focus().css("color", "red");
						$('#user').focus().css({
							border : "1px solid red",
							boxShadow : "0 0 2px red"
						});
					} else if (res1 == "√√此用户名可以注册") {
						$("#checkuser").html(data);
						$("#checkuser").css("color", "green");
						$('#user').css({
							border : "1px solid green",
							boxShadow : "0 0 2px green"
						});
					}
				}
			});
		}
		function ajaxFormEmail() {
			var email = document.getElementById("email").value;
			
			$.ajax({
				type : 'post',
				url : 'UserServlet?method=check',
				dataType : "html",
				data : "email=" + email,
				success : function(data) {
					var res1 = String($.trim(data));
					if (res1 == "××此邮箱已存在!") {
						$("#checkemail").html(data);
						$("#checkemail").css("color", "red");
						$('#email').focus().css({
							border : "1px solid red",
							boxShadow : "0 0 2px red"
						});
					} else if (res1 == "√√此邮箱可以绑定!") {
						$("#checkemail").html(data);
						$("#checkemail").css("color", "green");
						$('#email').css({
							border : "1px solid green",
							boxShadow : "0 0 2px green"
						});
					}
				}
			});
		}
		function ajaxFormPhone() {
			$("#btnSendCode").removeAttr("disabled");
			var phone = document.getElementById("phone").value;
			$.ajax({
				type:'post',
				url:'UserServlet?method=check',
				dataType:"html",
				data:"phone=" + phone,
				success : function(data) {
					var res = String($.trim(data));
					if (res=="××此手机号已经绑定!") {
						$("#checkphone").html(data);
						$("#checkphone").focus().css("color", "red");
						$('#phone').css({
							border : "1px solid red",
							boxShadow : "0 0 2px red"
						});
						$("#btnSendCode").attr('disabled', true);
					} else if (res == "√√此手机号可以绑定!") {
						$("#checkphone").html(data);
						$("#checkphone").css("color", "green");
						$('#phone').css({
							border : "1px solid green",
							boxShadow : "0 0 2px green"
						});
						$("#btnSendCode").attr('disabled', false);
					}else if(res=="××此手机号不存在!"){
						$("#checkphone").html(data);
						$("#checkphone").focus().css("color", "red");
						$('#phone').css({
							border : "1px solid red",
							boxShadow : "0 0 2px red"
						});
						$("#btnSendCode").attr('disabled', true);
					}else if(res == "√√"){
						$("#checkphone").html(data);
						$("#checkphone").css("color", "green");
						$('#phone').css({
							border : "1px solid green",
							boxShadow : "0 0 2px green"
						});
						$("#btnSendCode").attr('disabled', false);
					}
				}
			});
		}
		
		
		
		

		function checkname() {
			if ($('#user').val() == "") {
				$('#user').css({
					border : "1px solid red",
					boxShadow : "0 0 2px red"
				});
				$('#checkuser')
						.html("<font color='red'><b>×用户名不能为空</b></font>");
				return false;
			}
			if ($('#user').val().length < 4 || $('#user').val().length > 16) {
				$('#user').css({
					border : "1px solid red",
					boxShadow : "0 0 2px red"
				});
				$('#checkuser').html(
						"<font color='red'><b>××用户名只能为4-16个字符内</b></font>");
				return false;
			}
			if ($('#user').val().length >= 4 || $('#user').val().length <= 16) {
				$('#user').css({
					border : "1px solid green",
					boxShadow : "0 0 2px green"
				});
				$('#checkuser').html("<font color='green'><b>√格式正确</b></font>");
				ajaxForm();
				return false;
			}
		}

		function checkpwd() {

			if ($('#passwd').val().length >= 6) {
				$('#passwd').css({
					border : "1px solid green",
					boxShadow : "0 0 2px green"
				});
				$('#checkpwd1').html("<font color='green'><b>√√√</b></font>");
				return false;
			} else {
				$('#passwd').css({
					border : "1px solid red",
					boxShadow : "0 0 2px red"
				});
				$('#checkpwd1').html(
						"<font color='red'><b>×密码不能小于6位</b></font>");
				return false;
			}
		}
		function checkrepwd() {
			if ($('#passwd2').val() != $('#passwd').val()
					|| $('#passwd').val() == "") {
				$('#passwd2').css({
					border : "1px solid red",
					boxShadow : "0 0 2px red"
				});
				$('#checkpwd2').html(
						"<font color='red'><b>×两次密码不一致！</b></font>");
				return false;
			} else {
				$('#passwd2').css({
					border : "1px solid green",
					boxShadow : "0 0 2px green"
				});
				$('#checkpwd2').html("<font color='green'><b>√√√</b></font>");
				return false;
			}
		}
		function checkemail() {
			if ($('#email').val() == "") {
				$('#email').css({
					border : "1px solid red",
					boxShadow : "0 0 2px red"
				});
				$('#checkemail')
						.html("<font color='red'><b>×邮箱不能为空</b></font>");
				return false;
			}
			if ($('#email').val() != ""
					&& ($('#email').val().indexOf('@', 0) == -1 || $('#email')
							.val().indexOf('.', 0) == -1)) {
				$('#email').css({
					border : "1px solid red",
					boxShadow : "0 0 2px red"
				});
				$('#checkemail')
						.html("<font color='red'><b>×邮箱格式错误</b></font>");
				return false;
			}
			if ($('#email').val() != ""
					&& !($('#email').val().indexOf('@', 0) == -1 || $('#email')
							.val().indexOf('.', 0) == -1)) {
				$('#email').css({
					border : "1px solid green",
					boxShadow : "0 0 2px green"
				});
				$('#checkemail').html("<font color='green'><b>√√√</b></font>");
				ajaxFormEmail();
				return false;
			}

		}
		function checkcode() {
			if ($('#code').val() == "") {
				$('#code').css({
					border : "1px solid red",
					boxShadow : "0 0 2px red"
				});
				$('#checkcode')
						.html("<font color='red'><b>×验证码不能为空</b></font>");
				return false;
			} else {
				$('#code').css({
					border : "1px solid green",
					boxShadow : "0 0 2px green"
				});
				$('#checkcode').html(
						"<font color='green'><b>√成功填入验证码</b></font>");
				checkCode();
				return false;
			}
		}
		function checkphone() {
			var patrnPhone = /^(13[0-9]|14[0-9]|15[0-9]|17[0-9]|18[0-9])\d{8}$/;
			if ($('#phone').val() == "") {
				$('#checkphone').html(
						"<font color='red'><b>×手机号不能为空</b></font>");
				return false;
			}
			if (!patrnPhone.test($('#phone').val())) {
				$('#phone').css({
					border : "1px solid red",
					boxShadow : "0 0 2px red"
				});
				$('#checkphone').html(
						"<font color='red'><b>×手机号格式错误</b></font>");
				return false;
			}
			if (patrnPhone.test($('#phone').val())) {
				$('#phone').css({
					border : "1px solid green",
					boxShadow : "0 0 2px green"
				});
				$('#checkphone').html(
						"<font color='green'><b>√√手机格式正确</b></font>");
				ajaxFormPhone();

				return false;
			}
		}
		
		function checkforphone(){
			var patrnPhone = /^(13[0-9]|14[0-9]|15[0-9]|17[0-9]|18[0-9])\d{8}$/;
			if ($('#phone').val() == "") {
				$('#checkphone').html(
						"<font color='red'><b>×手机号不能为空</b></font>");
				return false;
			}
			if (!patrnPhone.test($('#phone').val())) {
				$('#phone').css({
					border : "1px solid red",
					boxShadow : "0 0 2px red"
				});
				$('#checkphone').html(
						"<font color='red'><b>×手机号格式错误</b></font>");
				return false;
			}
			if (patrnPhone.test($('#phone').val())) {
				$('#phone').css({
					border : "1px solid green",
					boxShadow : "0 0 2px green"
				});
				$('#checkphone').html(
						"<font color='green'><b>√√手机格式正确</b></font>");
				ajaxFormPhone();
		
				return false;
			}
		}
		
		
		
		function checkCode(){
		   var code = document.getElementById("code").value;
			$.ajax({
				type : 'post',
				url : 'UserServlet?method=checkCode',
				dataType : "html",
				data : "code=" + code,
				success : function(data) {
					var res1 = String($.trim(data));
					if (res1 == "××验证码不正确!") {
						$("#checkcode").html(data);
						$("#checkcode").css("color", "red");
						$('#code').focus().css({
							border : "1px solid red",
							boxShadow : "0 0 2px red"
						});
						return false;
					} else if( res1 == "××验证码输入超时!!!"){
					   $("#checkcode").html(data);
						$("#checkcode").css("color", "green");
						$('#code').css({
							border : "1px solid green",
							boxShadow : "0 0 2px green"
						});
						return false;
					}else if(res1 == "××此验证码不存在"){
						$("#checkcode").html(data);
						$("#checkcode").css("color", "red");
						$('#code').focus().css({
							border : "1px solid red",
							boxShadow : "0 0 2px red"
						});
						return false;
					}else if (res1 == "√√验证码正确!") {
						$("#checkcode").html(data);
						$("#checkcode").css("color", "green");
						$('#code').css({
							border : "1px solid green",
							boxShadow : "0 0 2px green"
						});
						return true;
					}
				}
			});
		
		}
		
		 function Select(){
	        	var cb=document.getElementById("checkbox");
	        	if(cb.checked==false){
	        	    alert("没有勾选注册协议，请先看完注册协议！");
	        	    return false;
	        	 }
	        	return true;
	        }
		
		//输入手机修改密码
		function checkphoneCode(){
			checkphone();
			checkcode();
		    checkCode();
		
		}
		
		//邮箱修改密码
		function checkemailCode(){
			checkemail();
			checkcode();
			checkCode();
		}
		
		
	
		