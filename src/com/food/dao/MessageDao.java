package com.food.dao;

import java.util.List;

import com.food.bean.Message;

/**
 * @author Administrator
 *公告DAO
 */
public interface MessageDao {
	
	/**
	 * 根据条件查询
	 * @param sql
	 * @param param
	 * @return
	 */
	public List<Message> findByCondition(String sql,List<Object> param);
	/**
	 * 增加公告
	 * @param message
	 * @return
	 */
	public boolean insert(String sql,List<Object> param);
	
	/**
	 * 可根据条件删除
	 * @param sql
	 * @param param
	 * @return
	 */
	public boolean delete(String sql,List<Object> param);
	
	/**
	 * 可根据条件修改
	 * @param sql
	 * @param param
	 * @return
	 */
	public boolean update(String sql,List<Object> param);
}
