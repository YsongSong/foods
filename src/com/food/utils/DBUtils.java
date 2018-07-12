package com.food.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DBUtils {
	private static String driverUrl="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://localhost/food?useUnicode=true&characterEncoding=gb2312";
	private static String userName="root";
	private static String userPwd="root";
	private static Connection conn=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;

	private static void setConnection(){
		try {
			Class.forName(driverUrl);
			conn =DriverManager.getConnection(url, userName, userPwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void setStatement(String sql,List<Object> param){
		setConnection();
		if(conn!=null){
			try {
				ps=conn.prepareStatement(sql);
				if (param!=null) {
					for (int i = 0; i < param.size(); i++) {
						ps.setObject(i+1, param.get(i));
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static List<Map<String, Object>> executeQuery(String sql,List<Object> param){
		setStatement(sql,param);
		List<Map<String, Object>> list=new ArrayList<>();
		if(ps!=null){
			try {
				rs=ps.executeQuery();
				ResultSetMetaData resultSetMetaData=rs.getMetaData();
				int col=resultSetMetaData.getColumnCount();
				while(rs.next()){
					Map<String, Object> map=new HashMap<>();
					for (int i = 0; i <col; i++) {
						map.put(resultSetMetaData.getColumnName(i+1), rs.getObject(i+1));
					}
					list.add(map);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
		}
		 
		return list;
	}

	/**处理指定语句的批处理
	 * @param sql 指定sql
	 * @param params 循环参数
	 * @return
	 */
	public static int[] dealBatch(String sql,List<List<Object>> params){
		setConnection();
		try {
			ps=conn.prepareStatement(sql);
			for (List<Object> list : params) {
				for (int i = 0; i < list.size(); i++) {
					ps.setObject(i+1, list.get(i));
				}
				ps.addBatch();
			}
			int ao[]=ps.executeBatch();
			return ao;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return null;
	}
	public static boolean executeUpdate(String sql,List<Object> param){
		setStatement(sql,param);
		try {
			int i=ps.executeUpdate();
			return i>0?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}
		return false;
	}
	
	
	private static void close(){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}