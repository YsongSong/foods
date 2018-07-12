package com.food.dao;

import java.util.List;

import com.food.bean.Cartitem;
import com.food.bean.Message;

/**
 * @author Administrator
 *�ͳ��ӿ�
 */
public interface CarDao {
	/**
	 * ����������ѯ
	 * @param sql
	 * @param param
	 * @return
	 */
	public List<Cartitem> findByCondition(String sql,List<Object> param);
	/**
	 * ��ͳ��ڲ�����Ŀ
	 * @param cartitem
	 * @return
	 */
	public boolean insert(String sql,List<Object> param);
	
	
	/**
	 * �ɸ��������������ɾ��
	 * @param sql
	 * @param param
	 * @return
	 */
	public boolean delete(String sql,List<Object> param);
}
