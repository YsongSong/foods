package com.food.dao;

import java.util.List;

import com.food.bean.HDFS;

public interface HDFSDao {
	public List<HDFS> find(String sql,List<Object> param);
	public boolean deal(String sql,List<Object> param);
	public  int[] dealBatch(String sql,List<List<Object>> params);
}
