package com.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daoapi.MessageDao;
import com.entities.Message;
import com.servicesapi.MessageService;

@Service
public class MessageServiceImpl implements MessageService{

	@Autowired
	MessageDao messageDao;
	
	public boolean saveOrUpdate(Message message) {
		return messageDao.saveOrUpdate(message);
	}

	public List<Message> list() {
		return messageDao.list();
	}

	public boolean delete(Message message) {
		return messageDao.delete(message);
	}	
	
}
