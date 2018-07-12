package com.food.dao;
import java.util.List;

import com.food.bean.Admin;
import com.food.bean.Food;
import com.food.bean.User;
/**
 * @author Administrator
 *�û�dao��ϵͳ����ͨ�û���
 */
public interface UserDao {
	
	public List<User> findUser(String sql,List<Object> param);
	
	public List<Admin> findAdmin(String sql,List<Object> param);
	/**
	 * @param user user������ϸ��Ϣ
	 * ע��
	 */
	public boolean register(String sql,List<Object> param);
	
	/**
	 * ǰ̨,��̨��¼
	 * @param user ������¼��Ҫ����Ϣ������ ���룩
	 * @return
	 * 
	 */
	public boolean login(String sql,List<Object> param);
	
	
	
	/**�����޸ĺ�̨����Ա��Ϣ
	 * @param admin��������Ϣ������ ���룩
	 * @return
	 */
	public boolean update(String sql,List<Object> param);
}
