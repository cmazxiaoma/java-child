package cn.photoflash.user.dao.imp;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import org.junit.Test;

import cn.photoflash.user.bean.User;
import cn.photoflash.user.dao.UserDao;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class UserDaoImp implements UserDao {

	// 配置文件
	private static SqlMapClient sqlMapClient = null;

	static {
		try {
			Reader reader = Resources.getResourceAsReader("cn/photoflash/user/bean/SqlMapConfig.xml");
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		} catch (IOException e) {
			System.out.println("userDaoImp:加载出错！");
		}
	}

	@Override
	// 用户登录/注册时调用此方法 可以返回一个对象 （前者找到对应的对象，后者注册时代表用户名重复）
	public User find(User user) {
		System.out.println(user);
		User returnUser = null;
		try {
			returnUser = (User) sqlMapClient.queryForObject("find", user);
		} catch (SQLException e) {
			System.out.println("UseDao:find出问题");
			e.printStackTrace();
		}
		System.out.println(returnUser);
		return returnUser;
	}

	@Override
	// 添加用户到数据库
	public void add(User user) {
		try {
			sqlMapClient.insert("add", user);
		} catch (SQLException e) {
			System.out.println("UserDao:add方法出错了");
		}
	}

	@Override
	// 更新用户
	public void updateByPhone(User user) {
		try {
			sqlMapClient.update("updateByPhone", user);
		} catch (SQLException e) {
			System.out.println("UserDao:updateByPhone出问题");
			e.printStackTrace();
		}
	}

	@Override
	// 更新用户信息之前查询用户信息
	public User findById(int id) {
		User user = null;
		try {
			user = (User) sqlMapClient.queryForObject("findById", id);
		} catch (SQLException e) {
			System.out.println("UserDao:findById方法出错了");
			e.printStackTrace();
		}
		return user;
	}

	@Test
	public void fun() {

		User user = new User();

		// user.setUsername("张三");
		// findByOthers(user);
		// System.out.println(findByOthers(user));

		user.setEmail("342834999@qq.com");
		System.out.println(find(user));
	}

	@Override
	public User findByOthers(User user) {
		User finduser = null;
		try {
			finduser = (User) sqlMapClient.queryForObject("findByOthers", user);
		} catch (SQLException e) {
			System.out.println("UserDao:findByOthers方法出错了");
			e.printStackTrace();
		}
		return finduser;
	}

	@Override
	public void updateByEmail(User user) {
		try {
			sqlMapClient.update("updateByEmail", user);
		} catch (SQLException e) {
			System.out.println("UserDao:updateByEmail出问题");
			e.printStackTrace();
		}
	}

}
