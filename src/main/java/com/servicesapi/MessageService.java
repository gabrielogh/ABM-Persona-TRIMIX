package com.servicesapi;

import java.util.List;

import com.entities.Message;

public interface MessageService {
	public boolean saveOrUpdate(Message message);
	public List<Message> list();
	public boolean delete(Message message);
}
