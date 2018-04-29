package cn.photoflash.album.dao.imp;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.photoflash.album.bean.Album;
import cn.photoflash.album.dao.AlbumDao;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class AlbumDaoImp implements AlbumDao {

	private static SqlMapClient sqlMapClient = null;
	// private PhotoDao photoDao = new PhotoDaoImp();
	static {
		try {
			Reader reader = Resources.getResourceAsReader("cn/photoflash/album/bean/SqlMapConfig.xml");
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		} catch (IOException e) {
			System.out.println("AlbumDaoImp：加载出错！");
		}
	}

	@Override
	public void add(Album album) {
		try {
			sqlMapClient.insert("add", album);
		} catch (SQLException e) {
			System.out.println("albumDaoImp:出错");
			e.printStackTrace();
		}
	}

	@Override
	public void deleteById(int aid) {
		try {
			sqlMapClient.delete("deleteById", aid);
		} catch (SQLException e) {
			System.out.println("AlbumDaoImp:deleteById出错了");
		}
	}

	@Override
	public void update(Album album) {
		try {
			sqlMapClient.update("update", album);
		} catch (SQLException e) {
			System.out.println("AlbumDaoImp:update出错了");
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Album> findAll() {
		List<Album> albumList = null;
		try {
			albumList = sqlMapClient.queryForList("findAll");
		} catch (SQLException e) {
			System.out.println("albumDaoImp:findAll出错");
			e.printStackTrace();
		}
		return albumList;
	}

	@Test
	public void fun() {
		AlbumDao albumDao = new AlbumDaoImp();

		System.out.println(albumDao.getTotalrows());
		Map<String, Integer> map = new HashMap<String, Integer>();

		map.put("curpage", 0);
		map.put("pagesize", 9);

		albumDao.findByPage(map);

		System.out.println(albumDao.findByPage(map));

	}

	@Override
	public int getTotalrows() {
		Integer totalRows = null;
		try {
			totalRows = (Integer) sqlMapClient.queryForObject("getTotalrows");
		} catch (SQLException e) {
			System.out.println("AlbumDaoImp:getTotalrows出错了");
			e.printStackTrace();
		}
		return totalRows;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Album> findByPage(Map<String, Integer> map) {
		List<Album> albumList = null;
		try {
			albumList = sqlMapClient.queryForList("findByPage", map);
		} catch (SQLException e) {
			System.out.println("albumDaoImp:findByPage出错");
			e.printStackTrace();
		}
		return albumList;
	}

	@Override
	public Album find(Integer aid) {
		Album album = null;
		try {
			album = (Album) sqlMapClient.queryForObject("findById", aid);
		} catch (SQLException e) {
			System.out.println("albumDaoImp:findById出错");
		}
		return album;
	}

	@Override
	public Album find(String albumname) {

		Album album = null;
		try {
			album = (Album) sqlMapClient.queryForObject("findByAlbumname", albumname);
		} catch (SQLException e) {
			System.out.println("albumDaoImp:findByAlbumname出错");
			e.printStackTrace();
		}

		return album;
	}

	@Override
	// 根据id修改，不修改相册的封面。
	public void updateById(Album album) {
		try {
			sqlMapClient.update("updateById", album);
		} catch (SQLException e) {
			System.out.println("AlbumDaoImp:updateById出错了");
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Album> findPageByUid(Map<String, Integer> map) {
		List<Album> albumList = null;
		try {
			albumList = sqlMapClient.queryForList("findPageByUid", map);
		} catch (SQLException e) {
			System.out.println("albumDaoImp:findPageByUid出错");
		}
		return albumList;
	}

}
