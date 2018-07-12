package com.food.bean;

public class HDFS {
	private String fileName;
	private String filepath;
	private int hid;
	public HDFS() {
		super();
	}
	public HDFS(int hid, String fileName, String filepath) {
		super();
		this.hid = hid;
		this.fileName = fileName;
		this.filepath = filepath;
	}
	public String getFileName() {
		return fileName;
	}
	public String getFilepath() {
		return filepath;
	}
	public int getHid() {
		return hid;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	@Override
	public String toString() {
		return "HDFS [hid=" + hid + ", fileName=" + fileName + ", filepath=" + filepath + "]";
	}
}
