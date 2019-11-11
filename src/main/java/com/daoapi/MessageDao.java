package com.daoapi;

import java.util.List;

import com.entities.Message;

public interface MessageDao {
	public boolean saveOrUpdate(Message messages);
	public List<Message> list();
	public boolean delete(Message messages);
}
