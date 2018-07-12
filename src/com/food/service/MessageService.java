package com.food.service;


import java.util.List;

import com.food.bean.Message;

public interface MessageService {
	
	
	public List<Message> showAllNotice();
	//显示所有公告
	public Message findByCondition(int id);
	//根据条件查询
    public boolean insert(Message message); 
    //插入公告
    public boolean delete(int id);
    //删除公告
    public boolean update(Message message);
}
