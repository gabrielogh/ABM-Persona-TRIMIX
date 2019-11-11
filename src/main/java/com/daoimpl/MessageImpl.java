package com.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daoapi.MessageDao;
import com.entities.Message;


@Repository
@Transactional
public class MessageImpl implements MessageDao{

	@Autowired
	SessionFactory session;
	
	public boolean saveOrUpdate(Message message) {
		session.getCurrentSession().saveOrUpdate(message);
		return true;
	}

	public List<Message> list() {
		return session.getCurrentSession().createQuery("from messages").list();
	}

	public boolean delete(Message message) {
		try{
			session.getCurrentSession().delete(message);
		}catch(Exception ex){
			return false;
		}
		
		return true;
	}
	
	
}
