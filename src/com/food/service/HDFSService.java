package com.food.service;

import java.util.List;

import com.food.bean.HDFS;
import com.food.utils.PageBean;

public interface HDFSService {
	public String detailFile(String path);
	public boolean deleteFile(String path,int hid);
	public List<HDFS> showAllFile();
	public boolean uploadToHDFS(HDFS hdfs,String hdfsSrc);
	public boolean downloadFromHDFS(String hdfsSrc,String localDst);
	public void init(String hdfsSrc);
	public HDFS findHDFSById(int id);
	public List<HDFS> findHDFS(HDFS hdfs);
	public PageBean<HDFS> showAllFile(int pc);
	public String readHDFS(String filePath);
}
