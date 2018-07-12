package com.food.utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import sun.net.www.content.audio.wav;

/**
 * @author Administrator
 */
public class HDFSUtils {
	private static FileSystem fileSystem=null;
	
	public static void init() {
		System.setProperty("HADOOP_USER_NAME", "hadoop");
		System.setProperty("hadoop.home.dir", "D:\\hadoop-2.6.5");
		Configuration conf=new Configuration();
		try {
			fileSystem=FileSystem.get(conf);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @param path
	 * 读取文件中的内容
	 */
	public static String readFileFromHDFS(String path){
		if (fileSystem==null) {
			init();
		}
		BufferedReader reader=null; 
		String buffer=new String();
		try{
			FSDataInputStream in=fileSystem.open(new Path(path));
			reader=new BufferedReader(new InputStreamReader(in));
			String temp="";
			while((temp=reader.readLine())!=null){
				buffer+=temp + "<br />";
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(reader!=null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(buffer);
		return buffer;
	}
	
	/**
	 * @param path
	 * 读取文件中的内容
	 */
	public static String readHDFS(String path){
		if (fileSystem==null) {
			init();
		}
		BufferedReader reader=null; 
		String buffer=new String();
		try{
			FSDataInputStream in=fileSystem.open(new Path(path));
			reader=new BufferedReader(new InputStreamReader(in));
			String temp="";
			while((temp=reader.readLine())!=null){
				buffer+=temp + "\n";
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(reader!=null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(buffer);
		return buffer;
	}
	
	/**
	 * 下载文件
	 * @param hdfsSrc
	 * @param localDst
	 * @return
	 */
	public static boolean download(String hdfsSrc, String localDst){
		if (fileSystem==null) {
			init();
		}
		Path src=new Path(hdfsSrc);
		Path dst=new Path(localDst);
		try {
			fileSystem.copyToLocalFile(src, dst);
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	/**
	 * 上传文件
	 * @param localDst
	 * @param hdfsSrc
	 * @return
	 */
	public static boolean upload(String localDst, String  hdfsSrc){
		if (fileSystem==null) {
			init();
		}
		Path src=new Path(localDst);
		Path dst=new Path(hdfsSrc);
		try {
			fileSystem.copyFromLocalFile(src, dst);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * @param target
	 * 删除文件
	 */
	public static boolean deleteHDFSFile(String target){
		if (fileSystem==null) {
			init();
		}
		Path path=new Path(target);
		boolean flag=true;
		try {
			flag=fileSystem.delete(path, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	/**
	 * 获取文件列表
	 * @return
	 * "/user/hadoop/input/hadoop"
	 */
	public static Path[] getHDFSFileList(String hdfsSrc){
		if (fileSystem==null) {
			init();
		}
		Path temp[]=null;
		Path path=new Path(hdfsSrc);
		try {
			FileStatus fileStatus[]= fileSystem.listStatus(path);
			temp=new Path[fileStatus.length];
			for (int i = 0; i < fileStatus.length; i++) {
				temp[i]=fileStatus[i].getPath();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}
}
