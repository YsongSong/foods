package com.food.service;
import java.util.List;

import com.food.bean.Admin;
import com.food.bean.User;
/**
 * @author Administrator
 *�û�dao��ϵͳ����ͨ�û���
 */
public interface UserService {
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
