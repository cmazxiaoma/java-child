package cn.photoflash.photo.dao.imp;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.photoflash.photo.bean.Photo;
import cn.photoflash.photo.dao.PhotoDao;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class PhotoDaoImp implements PhotoDao {

	private static SqlMapClient sqlMapClient = null;

	static {
		try {
			Reader reader = Resources.getResourceAsReader("cn/photoflash/photo/bean/SqlMapConfig.xml");
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		} catch (IOException e) {
			System.out.println("photoDaoImp:出错了");
		}
	}

	@Override
	public void add(Photo photo) {
		try {
			sqlMapClient.insert("add", photo);
		} catch (SQLException e) {
			System.out.println("PhotoDaoImp:add出错了");
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Photo photo) {
		try {
			sqlMapClient.delete("delete", photo);
		} catch (SQLException e) {
			System.out.println("PhotoDaoImp:delete出错了");
		}
	}

	@Override
	public void update(Photo photo) {
		try {
			sqlMapClient.update("update", photo);
		} catch (SQLException e) {
			System.out.println("PhotoDaoImp:update出错了");
		}
	}

	@Override
	public Photo find(int pid) {
		Photo photo = null;
		try {
			photo = (Photo) sqlMapClient.queryForObject("find", pid);
		} catch (SQLException e) {
			System.out.println("PhotoDaoImp:find出错了");
		}
		return photo;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Photo> findAll(int aid) {
		List<Photo> photoList = null;
		try {
			photoList = sqlMapClient.queryForList("findAllByAid", aid);
		} catch (SQLException e) {
			System.out.println("PhotoDaoImp:findAll(aid)出错了");
		}
		return photoList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Photo> findAll() {
		List<Photo> photoList = null;
		try {
			photoList = sqlMapClient.queryForList("findAll");
		} catch (SQLException e) {
			System.out.println("PhotoDaoImp:findAll出错了");
			e.printStackTrace();
		}
		return photoList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Photo> findByPage(Map<String, Integer> map) {
		List<Photo> photoList = null;
		try {
			photoList = sqlMapClient.queryForList("findByPage", map);
		} catch (SQLException e) {
			System.out.println("PhotoDaoImp:findByPage出错了");
		}
		return photoList;
	}

	@Override
	public int getTotalrowsByAid(int aid) {
		Integer totalRows = null;
		try {
			totalRows = (Integer) sqlMapClient.queryForObject("getTotalrowsByAid", aid);
		} catch (SQLException e) {
			System.out.println("PhotoDaoImp:getTotalrowsByAid出错了");
		}
		return totalRows;
	}

	@Override
	public int getTotalrows() {
		Integer totalRows = null;
		try {
			totalRows = (Integer) sqlMapClient.queryForObject("getTotalrows");
		} catch (SQLException e) {
			System.out.println("PhotoDaoImp:getTotalrows出错了");
		}
		return totalRows;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Photo> findByAid(Map<String, Integer> map) {
		List<Photo> photoList = null;
		try {
			photoList = sqlMapClient.queryForList("findByAid", map);
		} catch (SQLException e) {
			System.out.println("PhotoDaoImp:findByAid出错了");
		}
		return photoList;
	}

	/**
	 * 根据用户的id更新
	 */
	@Override
	public void updateById(Photo photo) {
		try {
			sqlMapClient.update("updateById", photo);
		} catch (SQLException e) {
			System.out.println("PhotoDaoImp:updateById出错了");
		}

	}

	/**
	 * 获取该用户的所有的相片记录数
	 */
	@Override
	public int getTotalrowsByUid(int uid) {
		Integer totalRows = null;
		try {
			totalRows = (Integer) sqlMapClient.queryForObject("getTotalrowsByUid", uid);
		} catch (SQLException e) {
			System.out.println("PhotoDaoImp:getTotalrowsByUid出错了");
		}
		return totalRows;
	}

	/**
	 * 分页查询 通过用户的id分页查询
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Photo> findByUid(Map<String, Integer> map) {
		List<Photo> photoList = null;
		try {
			photoList = sqlMapClient.queryForList("findByUid", map);
		} catch (SQLException e) {
			System.out.println("PhotoDaoImp:findByUid出错了");
		}
		return photoList;

	}

	@Test
	public void fun() {
		System.out.println(findAll());
	}
}
