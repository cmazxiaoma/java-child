package servlets;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;
import way.bean.xiaomanetinfo;
import java.io.*;

public class xiaomacontroller extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String actionUrl = request.getServletPath();
		if (actionUrl.equals("/list.do")) {
			ArrayList<xiaomanetinfo> list = xiaomanetinfo.getxiaomanetList();
			request.setAttribute("list", list);
			request.getRequestDispatcher("/liuyanofadmin.jsp").forward(request, response);
		} else if (actionUrl.equals("/add.do")) {
			String username = request.getParameter("username");
			String liuyan = request.getParameter("liuyan");
			String shenhe = "未审核";
			String hide = "否";
			String ch = request.getParameter("ch");
			int zhi = Integer.parseInt(ch);
			if (zhi == 0) {
				username = username.replace(username, "匿名"); // 替换Sting
																// username里面的值，当匿名单选框被选中时，zhi=0
			}
			int r = xiaomanetinfo.addxiaonetinfo(username, liuyan, shenhe, hide);
			if (r == 1) {
				request.getRequestDispatcher("/success.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/failure.jsp").forward(request, response);
			}
		} else if (actionUrl.equals("/panduan.do")) {
			String ch = request.getParameter("ch");
			if (ch != null && ch.equals("youke")) {
				request.getSession().setAttribute("login", "true");
				request.getRequestDispatcher("/liuyanofyouke.jsp").forward(request, response);
			} else if (ch != null && ch.equals("admin")) {
				request.getSession().setAttribute("login", "true");
				request.getRequestDispatcher("/liuyanofadmin.jsp").forward(request, response);
			} else {
				response.sendRedirect("/xiaomanetvip/index.jsp");
			}
		} else if (actionUrl.equals("/edit.do")) {
			String id = request.getParameter("id");
			xiaomanetinfo xmm1 = xiaomanetinfo.getxiaonetinfoById(id);
			request.setAttribute("xmm1", xmm1);
			request.getRequestDispatcher("/edit.jsp").forward(request, response);
		} else if (actionUrl.equals("/update.do")) {
			String username = request.getParameter("username");
			String liuyan = request.getParameter("liuyan");
			String shenhe = request.getParameter("shenhe");
			String id = request.getParameter("id");
			String hide = request.getParameter("hide");
			int r = xiaomanetinfo.updatexiaonetinfo(id, username, liuyan, shenhe, hide);
			if (r == 1) {
				request.getRequestDispatcher("/success.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/failure.jsp").forward(request, response);
			}
		} else if (actionUrl.equals("/del.do")) {
			String id = request.getParameter("id");
			int r = xiaomanetinfo.deletexiaonetinfo(id);
			if (r == 1) {
				request.getRequestDispatcher("/success.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/failure.jsp").forward(request, response);
			}
		}
	}

}
