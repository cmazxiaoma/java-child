package cn.photoflash.photo.web.servlet;

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
import cn.photoflash.photo.bean.Photo;
import cn.photoflash.photo.service.PhotoService;
import cn.photoflash.photo.service.Imp.PhotoServiceImp;
import cn.photoflash.user.bean.User;
import cn.photoflash.utils.DateFormat;

public class UpdatePhotoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2507539898912829505L;
	private PhotoService photoService = new PhotoServiceImp();

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		Photo photo = new Photo();

		// 获取工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 获取解析器
		ServletFileUpload sfu = new ServletFileUpload(factory);

		List<FileItem> fileItemList = null;
		// 解析request
		try {
			fileItemList = sfu.parseRequest(request);
		} catch (FileUploadException e) {
			System.out.println("解析request失败！");
		}

		// 获取照片id
		String pid = fileItemList.get(0).getString();
		photo.setPid(Integer.parseInt(pid));
		// 获取照片的名称
		String photoname = fileItemList.get(1).getString("UTF-8");
		photo.setPhotoname(photoname);

		// 获取照片的描述
		String p_description = fileItemList.get(2).getString("UTF-8");
		photo.setP_description(p_description);

		// 获取相册的id
		String aid = fileItemList.get(3).getString("UTF-8");
		photo.setAid(Integer.parseInt(aid));

		FileItem fi = fileItemList.get(4);
		if (!(fi.getName() == null || fi.getName().equals(""))) {
			// 获取上传的文件名以及所有
			String filename = fi.getName();

			// 获取上传的路径
			String root = this.getServletContext().getRealPath("/upimage/");

			// 修改文件名
			int index = filename.lastIndexOf("\\");

			if (index != -1) {
				filename = filename.substring(index + 1);
			}
			// 文件名修改
			filename = CommonUtils.uuid() + "_" + filename;

			// 文件存放位置
			File dirFile = new File(root, DateFormat.DateToString(new Date()));

			// 生成目录链
			dirFile.mkdirs();

			// 目的文件位置
			File desFile = new File(dirFile, filename);

			// 存放信息
			photo.setFilepath("upimage/" + DateFormat.DateToString(new Date()) + "/" + filename);

			// 从session中获取用户信息
			User user = (User) request.getSession().getAttribute("user");
			photo.setUid(user.getUid());

			// 将文件写入目的地
			try {
				fi.write(desFile);
				photoService.add(photo);
			} catch (Exception e) {
				System.out.println("写入文件失败！");
			}

			response.sendRedirect(request.getContextPath() + "/user/photo/PhotoManage.jsp?method=findAll");
		}

		photoService.update(photo);
		response.sendRedirect(request.getContextPath() + "/PhotoServlet?method=findAll");

	}

}
