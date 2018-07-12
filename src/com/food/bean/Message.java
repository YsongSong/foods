package com.food.bean;

/**
 * @author Administrator
 *公告类
 */
public class Message {
	private String detail;//详情
	private String messdate; //发布日期
	private int mid;  //公告id
	private String title;//标题
	public Message() {
		super();
	}
	public Message(int mid, String title, String detail, String messdate) {
		super();
		this.mid = mid;
		this.title = title;
		this.detail = detail;
		this.messdate = messdate;
	}
	public String getDetail() {
		return detail;
	}
	public String getMessdate() {
		return messdate;
	}
	public int getMid() {
		return mid;
	}
	public String getTitle() {
		return title;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public void setMessdate(String messdate) {
		this.messdate = messdate;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Message [mid=" + mid + ", title=" + title + ", detail=" + detail + ", messdate=" + messdate + "]";
	}

}
