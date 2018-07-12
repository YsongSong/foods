package com.food.utils;

import java.util.List;

import com.food.bean.Message;

/**
 * 分页Bean，它会在各层之间传递！
 * @author Administrator
 *
 * @param <T>
 */
public class PageBean<T> {
	private int pc;//当前页码
	private int tr;//总记录数
	private int ps;//每页记录数
	private String url;//请求路径，例如： /FoodServlet?method=findXXX
	private int tp;
	
	private int total;		//总数量   供餐车使用
	private double subtotal;	//总价格   餐车，订单使用

	private List<T> beanList;//当前页内容
	
	public int getPc() {
		return pc;
	}

	public void setPc(int pc) {
		this.pc = pc;
	}

	public int getTr() {
		return tr;
	}

	public void setTr(int tr) {
		this.tr = tr;
	}

	public int getPs() {
		return ps;
	}

	public void setPs(int ps) {
		this.ps = ps;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getTp() {
		return tp;
	}

	public void setTp(int tp) {
		this.tp = tp;
	}

	public List<T> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	@Override
	public String toString() {
		return "PageBean [pc=" + pc + ", tr=" + tr + ", ps=" + ps + ", url=" + url + ", tp=" + tp + ", total=" + total
				+ ", subtotal=" + subtotal + ", beanList=" + beanList + "]";
	}

}
