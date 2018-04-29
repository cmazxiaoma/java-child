<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>时光流影</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="JS/jquery-1.9.0.min.js"></script>
	<script type="text/javascript" src="JS/login2.js"></script>
	<script type="text/javascript" src="JS/login.js"></script>
	<script type="text/javascript" src="JS/stage.js"></script>
	<link href="css/login2.css" rel="stylesheet" type="text/css" />
	<link rel="shortcut icon" href="background/logo.ico"
		type="image/x-icon" />
	<style>
#ttt {
	position: absolute;
	bottom: 0px;
	left: 80%;
}
</style>
</head>

<body background="<%=request.getContextPath()%>/background/1.jpg">
	<h1>
		PhotoFlash<sup>2016</sup>
	</h1>

	<div class="login" style="margin-top:50px;">

		<div class="header">
			<div class="switch" id="switch">
				<a class="switch_btn_focus" id="switch_qlogin"
					href="javascript:void(0);" tabindex="7">快速登录</a> <a
					class="switch_btn" id="switch_login" href="javascript:void(0);"
					tabindex="8">快速注册</a>
				<div class="switch_bottom" id="switch_bottom"
					style="position: absolute; width: 64px; left: 0px;"></div>
			</div>
		</div>


		<div class="web_qr_login" id="web_qr_login"
			style="display:block; height:235px;">

			<!--登录-->
			<div class="web_login" id="web_login">


				<div class="login-box">


					<div class="login_form">
						<form action="<c:url value='/UserServlet'/>" name="loginform"
							accept-charset="utf-8" id="login_form" class="loginForm"
							method="post" onsubmit="return check()" target="_top">
							<input type="hidden" name="method" value="login" />
							<div id="login_error" align="center">${login_error }</div>
							<div class="uinArea" id="uinArea">
								<label class="input-tips" for="u">帐号：</label>
								<div class="inputOuter" id="uArea">
									<input type="text" id="uuu" name="username" class="inputstyle"
										style="width: 150px; height:32px;" onfocus="clearloginname();"
										onblur="checkloginname();" />
									<div id="outu"></div>
								</div>
							</div>
							<div class="pwdArea" id="pwdArea">
								<label class="input-tips" for="p">密码：</label>
								<div class="inputOuter" id="pArea">
									<input type="password" id="p" name="password"
										class="inputstyle" style="width: 150px; height: 32px;"
										onblur="checkloginpwd();" onfocus="clearloginpwd();" />
									<div id="pwd"></div>
								</div>
							</div>

							<div style="padding-left:50px;margin-top:20px;">
								<input type="submit" value="登 录" style="width:150px;"
									class="button_blue" />
							</div>

						</form>
					</div>

				</div>
				<p id="ttt">
					<a href="<c:url value='/user/find.jsp'/>">忘记密码</a>
				</p>
			</div>
			<!--登录end-->
		</div>



		<!--注册-->
		<div class="qlogin" id="qlogin" style="display:none;">

			<div class="web_login">
				<form name="form2" id="regUser" onsubmit="return Select()"
					accept-charset="utf-8" method="post"
					action="<c:url value='/UserServlet'/>" target="_top">
					<input type="hidden" name="method" value="register" />
					<ul class="reg_form" id="reg-ul" style="width:350px;">
						<div id="userCue" class="cue">
							<font color="339999">欢迎注册，PhotoFlash<sup>2016</sup> </font>
						</div>
						<li><label for="user" class="input-tips2">用户名：</label>
							<div class="inputOuter2">
								<input type="text" id="user" name="username" maxlength="16"
									class="inputstyle2" style="width:140px;height:28px;"
									onblur="checkname();" />
								<div id="checkuser"></div>
							</div>
						</li>

						<li><label for="passwd" class="input-tips2">密码：</label>
							<div class="inputOuter2">
								<input type="password" id="passwd" name="password"
									maxlength="16" class="inputstyle2"
									style="width: 140px; height: 28px;" onblur="checkpwd();" />
								<div id="checkpwd1"></div>
							</div>
						</li>
						<li><label for="passwd2" class="input-tips2">确认密码：</label>
							<div class="inputOuter2">
								<input type="password" id="passwd2" name="password"
									maxlength="16" class="inputstyle2"
									style="width: 140px; height: 28px;" onblur="checkrepwd();" />
								<div id="checkpwd2"></div>
							</div>
						</li>



						<li><label for="email" class="input-tips2">邮箱：</label>
							<div class="inputOuter2">
								<input type="text" id="email" name="email" maxlength="30"
									class="inputstyle2" style="width: 140px; height: 28px;"
									onblur="checkemail();" />
								<div id="checkemail"></div>
							</div>
						</li>

						<li><label for="phone" class="input-tips2">手机号：</label>
							<div class="inputOuter2">
								<input type="text" id="phone" name="phone" maxlength="16"
									class="inputstyle2" style="width: 140px; height: 28px;"
									onblur="checkphone();" />
								<div id="checkphone"></div>
							</div>
						</li>


						<li><label for="code" class="input-tips2">验证码：</label>
							<div class="inputOuter2">
								<input type="text" id="code" name="code" maxlength="7" size="10"
									class="inputstyle2" style="width:70px; height:30px;"
									onblur="checkcode();" /> <input id="btnSendCode" name="button"
									type="button" value='获取验证码' onclick="sendMessage()"
									style="width:90x; height:34px;" class="codebutton" /><font
									color="green"></font>
								<div id="checkcode"></div>
								<!--  time(this)-->
							</div>
						</li>

						<li>
							<div class="inputArea">
								<input type="button" id="reg"
									style="margin-top:10px;margin-left:85px;" class="button_blue"
									value="同意协议并注册" /> <input type="checkbox" id="checkbox" /> <a
									href="<c:url value='/common/agreement.jsp'/>" target="_blank">GVRP</a>

							</div>
						</li>
						<div class="cl"></div>
					</ul>
				</form>

			</div>
		</div>
		<!--注册end-->
	</div>

</body>
</html>