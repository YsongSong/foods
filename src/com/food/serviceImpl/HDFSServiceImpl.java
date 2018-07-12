package com.food.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import org.apache.hadoop.fs.Path;

import com.food.bean.HDFS;
import com.food.dao.HDFSDao;
import com.food.daoImpl.HDFSDaoImpl;
import com.food.service.HDFSService;
import com.food.utils.HDFSUtils;
import com.food.utils.PageBean;

public class HDFSServiceImpl implements HDFSService {
	private HDFSDao hdfsDao=new HDFSDaoImpl();
	
	public String readHDFS(String filePath) {
		return HDFSUtils.readHDFS(filePath);
	}
	
	@Override
	public String detailFile(String filePath) {
		return HDFSUtils.readFileFromHDFS(filePath);
	}
	@Override
	//xxxxx?hid=1;
	public boolean deleteFile(String filePath,int hid) {
		String sql="delete from t_hdfs where hid="+hid;
		boolean t2=hdfsDao.deal(sql, null);
		boolean t1=HDFSUtils.deleteHDFSFile(filePath);
		return t1&t2; 
	}
	@Override
	public List<HDFS> showAllFile() {
		String sql="select * from t_hdfs";
		List<HDFS> list=hdfsDao.find(sql, null);
		return list;
	}
	@Override
	public boolean uploadToHDFS(HDFS hdfs,String hdfsSrc) {
	    boolean t1=HDFSUtils.upload(hdfs.getFilepath(), hdfsSrc);
	    String sql="insert into t_hdfs(filename,filepath) values(?,?);";
	    hdfs.setFilepath("hdfs://192.168.41.130:8020/user/hadoop/input/dishes"+hdfs.getFileName());
	    List<Object> param=new ArrayList<>();
		param.add(hdfs.getFileName());
		param.add(hdfs.getFilepath());
	    boolean t2=hdfsDao.deal(sql, param);
		return t1&t2;
	}
	@Override
	public boolean downloadFromHDFS(String hdfsSrc,String localDst) {
		return HDFSUtils.download(hdfsSrc, localDst);
	}
	@Override
	public void init(String hdfsSrc) {
		String sql="insert into t_hdfs(filename,filepath) values(?,?)";
		List<List<Object>> params=new ArrayList<>();
		Path ao[]= HDFSUtils.getHDFSFileList(hdfsSrc);
		for (int i = 0; i < ao.length; i++) {
			Path path=ao[i];
			List<Object> temp=new ArrayList<>();
			temp.add(path.getName());
			temp.add(path.toString());
			params.add(temp);
		}
		hdfsDao.dealBatch(sql, params);
		System.out.println("初始化完毕！");
	}
	@Override
	public HDFS findHDFSById(int id) {
		String sql="select * from t_hdfs where hid="+id;
		return hdfsDao.find(sql, null).get(0);
	}
	@Override
	public List<HDFS> findHDFS(HDFS hdfs) {
		String sql="select * from t_hdfs where filename=?";
		List<Object> param=new ArrayList<>();
		param.add(hdfs.getFileName());
		return hdfsDao.find(sql, param);
	}
	
public PageBean<HDFS> showAllFile(int pc) {
		
		/*
		 * 1. 得到ps
		 */
		int ps = 10;//每页记录数
		
		
		String sql="select * from t_hdfs";
		List<HDFS> list=hdfsDao.find(sql, null);
		int tr = list.size();
		System.out.println(tr);
		/*
		 * 2. 得到beanList,即当前页记录
		 */
		sql = "select * from t_hdfs limit ?,?";
		List<Object> param = new ArrayList<>();
		
		param.add((pc-1)*ps);//当前页首行记录下标    当前页(ps)-1*每页记录数(ps)
		param.add(ps);//一共查询几行，即每页记录数
		List<HDFS> hdfs=hdfsDao.find(sql, param);
		
		/*
		 * 3. 创建PageBean,设置参数
		 */
		PageBean<HDFS> pb = new PageBean<HDFS>();
		/*
		 * 其中PageBean没有url，这个任务由Servlet完成
		 */
		pb.setBeanList(hdfs);
		int tp = tr/ps;
		tp = tr % ps == 0 ? tp :tp + 1; 
		pb.setPc(pc);
		pb.setPs(ps);
		pb.setTr(tr);
		pb.setTp(tp);
		return pb;
	}

}
