package cn.photoflash.album.web.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.itcast.commons.CommonUtils;
import cn.photoflash.album.bean.Album;
import cn.photoflash.album.service.AlbumService;
import cn.photoflash.album.service.imp.AlbumServiceImp;
import cn.photoflash.user.bean.User;
import cn.photoflash.utils.DateFormat;

@SuppressWarnings("serial")
public class UpAlbumServlet extends HttpServlet {

	private AlbumService albumService = new AlbumServiceImp();

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		/**
		 * 上传三部曲
		 */
		// 创建工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 创建解析器
		ServletFileUpload sfu = new ServletFileUpload(factory);

		// new出一个对象 保存页面传来的数据
		Album album = new Album();
		album.setTime(new Date());
		// 解析request
		List<FileItem> fileItemList = null;

		try {
			fileItemList = sfu.parseRequest(request);
		} catch (FileUploadException e) {

			System.out.println("解析request出错！");
			e.printStackTrace();
		}
		// 获取表单页面的相册名
		String albumname = fileItemList.get(0).getString("UTF-8");
		album.setAlbumname(albumname);
		// 获取表单页面的相册简介
		String a_description = fileItemList.get(1).getString("UTF-8");
		album.setA_description(a_description);
		// 获取表单页面的类型
		String type = fileItemList.get(2).getString("UTF-8");
		album.setType(type);
		// 获取相册的权限
		String power = fileItemList.get(3).getString("UTF-8");
		System.out.println(power);
		album.setPower(Integer.parseInt(power));

		// 获取用户的id
		User user = (User) request.getSession().getAttribute("user");
		album.setUid(user.getUid());

		// 获取上传的文件(如果没有 使用默认的背景)
		FileItem fi = fileItemList.get(4);

		if (fi == null) {
			album.setCoverpath("");
		} else {
			String root = this.getServletContext().getRealPath("/upimage/");

			System.out.println("root:" + root);
			// 获取上传文件的全称以及后缀
			String filename = fi.getName();
			// 不同的浏览器不同的上传全称，获取后缀名
			int index = filename.lastIndexOf("\\");
			if (index != -1) {
				filename = filename.substring(index + 1);
			}
			// 文件的名字 保存后的文件名
			filename = CommonUtils.uuid() + "_" + filename;
			// 设置文件的保存路径 以当前月份命名
			File dirFile = new File(root, DateFormat.DateToString(new Date()));
			// 生成目录链
			dirFile.mkdirs();
			// 生成文件夹
			File destFile = new File(dirFile, filename);

			// 保存文件的路径
			album.setCoverpath("upimage/" + DateFormat.DateToString(new Date()) + "/" + filename);

			// 将图片上传到指定位置
			try {
				fi.write(destFile);
			} catch (Exception e) {
				System.out.println("文件写入失败！");
			}
		}

		albumService.add(album);
		response.sendRedirect(request.getContextPath() + "/user/album/CreateSuccess.jsp");
	}

}
