package com.food.daoImpl;

import java.util.List;
import java.util.Map;

import com.food.bean.HDFS;
import com.food.dao.HDFSDao;
import com.food.utils.ConvertUtils;
import com.food.utils.DBUtils;

public class HDFSDaoImpl implements HDFSDao{
	@Override
	public List<HDFS> find(String sql, List<Object> param) {
		List<Map<String, Object>> list= DBUtils.executeQuery(sql, param);
		return (List<HDFS>) ConvertUtils.convert(list, HDFS.class);
	}
	@Override
	public boolean deal(String sql, List<Object> param) {
		return DBUtils.executeUpdate(sql, param);
	}
	@Override
	public int[] dealBatch(String sql, List<List<Object>> params) {
		return DBUtils.dealBatch(sql, params);
	}

}
