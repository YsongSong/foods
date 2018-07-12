package com.food.filter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.food.service.HDFSService;
import com.food.serviceImpl.HDFSServiceImpl;

public class ServletListener implements ServletContextListener {
	private HDFSService HDFSService=new HDFSServiceImpl();
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("开始初始化数据");
		new Thread(new Runnable() {
			@Override
			public void run() {
				HDFSService.init("/user/hadoop/input/dishes");		
			}
		}).start();
		System.out.println("初始化数据完毕……");
	}
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}


}
