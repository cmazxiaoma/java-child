package cn.photoflash.album.web.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;
import cn.photoflash.album.bean.PageBean;
import cn.photoflash.album.service.AlbumService;
import cn.photoflash.album.service.imp.AlbumServiceImp;
import cn.photoflash.user.bean.User;

@SuppressWarnings("serial")
public class AlbumServlet extends BaseServlet {

	private AlbumService albumService = new AlbumServiceImp();

	/**
	 * 查询所有的相册
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int page = getPc(request);
		int pagesize = 9;
		// 从数据库中查找
		PageBean pb = albumService.findByPage(page, pagesize);
		request.setAttribute("pb", pb);
		return "f:/user/album/albumManage.jsp";

	}

	// page页数
	private int getPc(HttpServletRequest request) {
		String value = request.getParameter("page");
		if (value == null || value.trim().equals("")) {
			return 1;
		}
		return Integer.parseInt(value);
	}

	/**
	 * 此方法用于查找某相册下的所有照片
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findAllPhoto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String albumId = request.getParameter("albumId");

		// 在session中存放当前相册的信息
		request.getSession().setAttribute("album", albumService.find(Integer.parseInt(albumId)));

		// 存放所有的相册名字
		request.setAttribute("albumNameList", albumService.findAll());

		// 转发到PhotoServlet
		request.getRequestDispatcher("PhotoServlet?method=findAllByAid").forward(request, response);
	}

	/**
	 * 检验相册名是否可用
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void check(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 获取校验的相册名
		String albumname = request.getParameter("albumname");

		PrintWriter out = response.getWriter();

		System.out.println("AlbumServlet:check");
		// find方法返回的true时代表该相册名不存在

		System.out.println(albumService.find(albumname));
		if (!albumService.find(albumname)) {
			out.println("xx该相册名已经存在！");
		} else {
			System.out.println("√√相册名有效");
			out.println("√√");
		}
	}

	/**
	 * 根据id查询
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public String find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String getAid = request.getParameter("albumId");
		request.setAttribute("editAlbum", albumService.find(Integer.parseInt(getAid)));
		return "f:/user/album/EditAlbum.jsp";
	}

	public String findMyAlbums(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int page = getPc(request);
		int pagesize = 9;
		User user = (User) request.getSession().getAttribute("user");

		// 从数据库中查找
		PageBean pb = albumService.findByPage(page, pagesize, user.getUid());
		request.setAttribute("Mypb", pb);
		return "f:/user/album/MyAlbum.jsp";
	}

}
