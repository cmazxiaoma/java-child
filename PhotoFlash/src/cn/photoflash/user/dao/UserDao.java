package cn.photoflash.user.dao;

import cn.photoflash.user.bean.User;

/**
 * 用户操作Dao接口
 * 
 * @author yishuihan
 */
public interface UserDao {

	// 查询用户（用于登录）
	public User find(User user);

	// 通过电话修改用户信息
	public void updateByPhone(User user);

	// 通过邮箱修改用户信息
	public void updateByEmail(User user);

	// 通过id查询用户
	public User findById(int id);

	// 用户注册
	public void add(User user);

	// 查找邮箱或者电话
	public User findByOthers(User user);
}
