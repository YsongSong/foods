package com.food.dao;
import java.util.List;
import com.food.bean.Food;
import com.food.bean.Type;
import com.food.utils.PageBean;

/**
 * @author Administrator
 * ����ز����ӿ�
 */
public interface FoodDao {
	
	/**����Ӧ������ѯ
	 * @param sql sql�������������������磺select * from food where foodid=?
	 * @param param �����Ѱ�����������ʺű�ʾ������
	 * @return List<Food>
	 */
	public List<Type> findFoodType(String sql,List<Object> param);
	
	/**����Ӧ������ѯ
	 * @param sql sql�������������������磺select * from food where foodid=?
	 * @param param �����Ѱ�����������ʺű�ʾ������
	 * @return List<Food>
	 */
	public List<Food> findByCondition(String sql,List<Object> param);
	
	/**
	 * ����ʳƷ
	 * @param food
	 * @return
	 */
	public boolean insertFood(String sql,List<Object> param);
	/**
	 * ��������
	 * @param type ʳ����
	 * @return
	 */
	public boolean insertFoodType(String sql,List<Object> param);
	
	/**
	 * ��������ɾ��
	 * @param sql
	 * @param param
	 * @return
	 */
	public boolean delete(String sql,List<Object> param);
	
	/**
	 * ���������޸�
	 * @param sql
	 * @param param
	 * @return
	 */
	public boolean update(String sql,List<Object> param);
	
	public List<Type> findType(String sql,List<Object> param);

	PageBean<Food> findByPage(int pc);
	
}
