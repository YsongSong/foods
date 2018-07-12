package com.food.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.food.bean.Message;
import com.food.dao.MessageDao;
import com.food.daoImpl.MessageDaoImpl;
import com.food.service.MessageService;
import com.food.utils.DateUtil;

public class MessageServiceImpl implements MessageService {
       private MessageDao messageDao=new MessageDaoImpl();
	

	@Override
	public Message findByCondition(int mid) {
		// TODO Auto-generated method stub
		String sql = "select * from t_message where mid=?";
		List<Object> list1 = new ArrayList<>();
		list1.add(mid);
		List<Message> list = messageDao.findByCondition(sql,list1);
		Message mess = list.get(0);
		return mess;
	}


	@Override
	public boolean insert(Message message) {
		String sql="insert into t_message(title,detail,messdate) value(?,?,?)";
		List<Object> list1 = new ArrayList<>();
		list1.add(message.getTitle());
		list1.add(message.getDetail());
		list1.add(DateUtil.formatDate(new Date(), "yyyy-MM-dd"));
		return messageDao.insert(sql,list1);
	}


	@Override
	public boolean delete(int mid) {
		// TODO Auto-generated method stub
		String sql="delete from t_message where mid=?";
		List<Object> list1 = new ArrayList<>();
		list1.add(mid);
		return messageDao.delete(sql, list1);
	}


	@Override
	public boolean update(Message message) {
		// TODO Auto-generated method stub
		String sql="update t_message set title=?,detail=? where mid=?";
		List<Object> list1 = new ArrayList<>();
		list1.add(message.getTitle());
		list1.add(message.getDetail());
		list1.add(message.getMid());
		return messageDao.update(sql,list1);
	}


	@Override
	public List<Message> showAllNotice() {
		// TODO Auto-generated method stub
		String sql="select * from t_message";
		List<Message> list=messageDao.findByCondition(sql, null);
		return list;
	}
	
}

