package com.food.service;


import java.util.List;

import com.food.bean.Message;

public interface MessageService {
	
	
	public List<Message> showAllNotice();
	//��ʾ���й���
	public Message findByCondition(int id);
	//����������ѯ
    public boolean insert(Message message); 
    //���빫��
    public boolean delete(int id);
    //ɾ������
    public boolean update(Message message);
}
