package cn.photoflash.reply.dao.imp;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import cn.photoflash.reply.bean.Reply;
import cn.photoflash.reply.dao.ReplyDao;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class ReplyDaoImp implements ReplyDao {

	private static SqlMapClient sqlMapClient = null;

	static {
		try {
			Reader reader = Resources.getResourceAsReader("cn/photoflash/reply/bean/SqlMapConfig.xml");
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
		} catch (IOException e) {
			System.out.println("ReplyDaoImp:加载出错！");
		}
	}

	@Override
	public void add(Reply reply) {
		try {
			sqlMapClient.insert("add", reply);
		} catch (SQLException e) {
			System.out.println("ReplyDaoImp:add出错！");
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Reply reply) {
		try {
			sqlMapClient.insert("delete", reply);
		} catch (SQLException e) {
			System.out.println("ReplyDaoImp:delete出错！");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reply> findAll(int pid) {
		List<Reply> replyList = null;
		try {
			replyList = sqlMapClient.queryForList("findAll", pid);
		} catch (SQLException e) {
			System.out.println("ReplyDaoImp:findAll出错！");
		}
		return replyList;
	}

}
