package cn.photoflash.user.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;

import cn.itcast.commons.CommonUtils;
import cn.itcast.mail.Mail;
import cn.itcast.mail.MailUtils;
import cn.itcast.servlet.BaseServlet;
import cn.photoflash.user.bean.User;
import cn.photoflash.user.security.SecurityCode;
import cn.photoflash.user.service.UserService;
import cn.photoflash.user.service.imp.UserException;
import cn.photoflash.user.service.imp.UserServiceImp;
import cn.photoflash.user.smsUtil.SendSms;

/**
 * UserServlet处理用户在页面传来的请求 注册 register 登录 login 通过邮箱找回密码 发送手机验证码 依赖UserService
 * 
 * @author yishuihan
 */
@SuppressWarnings("serial")
public class UserServlet extends BaseServlet {

	private UserService userService = new UserServiceImp();
	@SuppressWarnings("unused")
	private SecurityCode securityCode = new SecurityCode();

	/**
	 * 用户登录
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 封装页面对象user
		// 调用service层的login方法,对异常进行捕捉
		// 没有异常，则登录成功 将user信息保存在session域中 然后跳转到主界面

		User user = CommonUtils.toBean(request.getParameterMap(), User.class);
		try {
			userService.login(user);
		} catch (UserException e) {
			request.setAttribute("login_error", "×" + e.getMessage());
			return "f:/login.jsp";
		}
		// 登录成功 从数据库中获取用户的信息
		user = userService.find(user);
		System.out.println(user);
		request.getSession().setAttribute("user", user);
		return "f:/user/main.jsp";
	}

	/**
	 * 用户注册
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public String register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取页面的表单数据
		User user = CommonUtils.toBean(request.getParameterMap(), User.class);
		String code = request.getParameter("code");
		SecurityCode securityCode = (SecurityCode) request.getSession().getAttribute("securityCode");
		System.out.println(securityCode + ":" + code);
		if (code == null || securityCode == null || !securityCode.getCode().equals(code)) {
			return "r:/false.jsp";
		}
		if (securityCode.isValid()) {
			return "r:/false.jsp";
		}
		userService.register(user);

		return "r:/success.jsp";
	}

	/**
	 * 用户忘记密码，修改自己的密码
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = CommonUtils.toBean(request.getParameterMap(), User.class);

		String code = request.getParameter("code");

		HttpSession session = request.getSession();

		SecurityCode securityCode = (SecurityCode) session.getAttribute("securityCode");

		session.invalidate();

		System.out.println(code + ":" + user + ":" + securityCode);

		if (code == null || securityCode == null || !securityCode.getCode().equals(code)) {
			return "r:/user/findError.jsp";
		} else if (securityCode.isValid()) {
			return "r:/user/findError.jsp";
		}
		userService.update(user);
		return "r:/user/success.jsp";
	}

	/**
	 * 通过邮箱找寻密码 （发送验证码到邮箱 ）
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void sendEmailCode(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取页面传来的邮箱
		String to = request.getParameter("email");
		String code = request.getParameter("code");
		// 配置文件
		Properties pro = new Properties();

		// 加载配置文件
		pro.load(this.getClass().getClassLoader().getResourceAsStream("email_template.properties"));

		// 获取配置的内容
		String host = pro.getProperty("host");
		String username = pro.getProperty("uname");
		String password = pro.getProperty("pwd");
		String from = pro.getProperty("from");
		String subject = pro.getProperty("subject");
		String content = pro.getProperty("content");

		// 将占位符替换成随机数
		content = MessageFormat.format(content, code);
		// 创建会话
		Session session = MailUtils.createSession(host, username, password);
		// 创建邮件
		Mail mail = new Mail(from, to, subject, content);

		try {
			MailUtils.send(session, mail);
		} catch (MessagingException e) {
			System.out.println("发送邮件验证码出错！");
			e.printStackTrace();
		}

	}

	/**
	 * 注册：手机发送验证码
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void sendCode(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取页面传来的邮箱 电话 以及验证码
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String code = request.getParameter("code");

		System.out.println(code + ":" + email);
		System.out.println(code + ":" + phone);
		// 保存验证码
		SecurityCode securityCode = new SecurityCode();
		securityCode.setCode(code);
		securityCode.setTime(new Date());
		request.getSession().setAttribute("securityCode", securityCode);

		// 选择电话发送验证码
		if (email == null && phone != null) {
			SendSms.send(phone, code);
		}

		// 选择邮箱发送验证码
		if (phone == null && email != null) {
			sendEmailCode(request, response);
		}
	}

	public void sendCodeByPhone(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取页面传来的邮箱 电话 以及验证码
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String code = request.getParameter("code");

		System.out.println(code + ":" + email);
		System.out.println(code + ":" + phone);
		// 保存验证码
		SecurityCode securityCode = new SecurityCode();
		securityCode.setCode(code);
		securityCode.setTime(new Date());
		request.getSession().setAttribute("securityCode", securityCode);

		// 选择电话发送验证码
		if (email == null && phone != null) {
			SendSms.sendByPhone(phone, code);
		}

		// 选择邮箱发送验证码
		if (phone == null && email != null) {
			sendEmailCode(request, response);
		}
	}

	/**
	 * 校验输入的验证码 此方法可重用 ：1 添加用户界面， 2 修改密码界面 （通过用户的信息来判断用户是注册还是修改密码 ）
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void checkCode(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取输入的code
		String userCode = request.getParameter("code");

		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();

		SecurityCode securityCode = (SecurityCode) session.getAttribute("securityCode");

		System.out.println("checkCode:" + securityCode);

		// 对验证码进行校验
		if (securityCode != null) {
			if (securityCode.isValid()) {
				out.println("××验证码输入超时!!!");
			} else {
				if (!(securityCode.getCode().equals(userCode))) {
					// 给用户返回错误
					out.println("××验证码不正确!");
				} else {
					// 返回注册成功，同时session令其失效
					out.println("√√验证码正确!");
				}
			}
		}
		if (securityCode == null) {
			out.println("××此验证码不存在");
		}
	}

	/**
	 * 注册时：校验用户名 邮箱 电话是否已经使用
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void check(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = CommonUtils.toBean(request.getParameterMap(), User.class);
		PrintWriter out = response.getWriter();
		System.out.println("校验" + user);
		if (userService.check(user)) {
			if (user.getEmail() != null)
				out.println("√√此邮箱可以绑定!");
			else if (user.getPhone() != null)
				out.println("√√此手机号可以绑定!");
			else if (user.getUsername() != null)
				out.println("√√此用户名可以注册");
		} else {
			if (user.getEmail() != null)
				out.println("××此邮箱已存在!");
			else if (user.getPhone() != null)
				out.println("××此手机号已经绑定!");
			else if (user.getUsername() != null)
				out.println("××此用户名已经存在");
		}

	}

	/**
	 * 用户退出
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String quit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		return "r:/user/main.jsp";
	}

	@Test
	public void fun() {
		// 配置文件
		Properties pro = new Properties();
		// 加载配置文件
		try {
			pro.load(this.getClass().getClassLoader().getResourceAsStream("email_template.properties"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// 获取配置的内容
		String host = pro.getProperty("host");
		String username = pro.getProperty("uname");
		String password = pro.getProperty("pwd");
		String from = pro.getProperty("from");
		String subject = pro.getProperty("subject");
		String content = pro.getProperty("content");

		// 生成随机数5位
		int randomNumber = 1231233;
		System.out.println(randomNumber);
		// 将占位符替换成随机数
		content = MessageFormat.format(content, randomNumber + "");
		// 创建会话
		Session session = MailUtils.createSession(host, username, password);
		// 创建邮件
		Mail mail = new Mail(from, "342834999@qq.com", subject, content);

		System.out.println(content);
		try {
			MailUtils.send(session, mail);
		} catch (Exception e) {
			System.out.println("发送邮件验证码出错！");
			e.printStackTrace();
		}

	}

}
