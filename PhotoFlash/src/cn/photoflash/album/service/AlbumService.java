package cn.photoflash.album.service;

import java.util.List;

import cn.photoflash.album.bean.Album;
import cn.photoflash.album.bean.PageBean;
import cn.photoflash.album.service.imp.AlbumException;

/**
 * 服务层 依赖AlbumDao
 * 
 * @author yishuihan
 *
 */
public interface AlbumService {
	// 添加相册
	public void add(Album album);

	// 删除相册
	// 判断该相册下是否有照片，有则不删除
	public void delete(Album album) throws AlbumException;

	// 查询全部相册
	public List<Album> findAll();

	// 分页
	public PageBean findByPage(int page, int pageSize);

	// 我的相册的分页
	public PageBean findByPage(int page, int pageSize, int uid);

	// 通过相册id查询信息
	public Album find(Integer aid);

	// 查询是否相册名重复，重复返回false 不重复返回true
	public boolean find(String albumname);

	// 更新相册
	public void update(Album album);
}
