package com.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.entities.Message;
import com.servicesapi.MessageService;

@Controller
@RequestMapping("messages")
public class MessageController {
	
	@Autowired
	MessageService messageServices;
	
	@RequestMapping(value="/page", method = RequestMethod.GET)
	public ModelAndView getPage(){
		ModelAndView view =new ModelAndView("messages");
		return view;
	}
	
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getSaved(Message message){
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(messageServices.saveOrUpdate(message)){
			map.put("status","200");
			map.put("message","Your record have been saved successfully");
		}
		
		return map;
	}
	
	
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getAll(Message message){
		Map<String,Object> map = new HashMap<String,Object>();
	
			List<Message> list = messageServices.list();
			
			if (list != null){
				map.put("status","200");
				map.put("message","Data found");
				map.put("data", list);
			}else{
				map.put("status","404");
				map.put("message","Data not found");
				
			}
		
		return map;
	}
	
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> delete(Message message){
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(messageServices.delete(message)){
			map.put("status","200");
			map.put("message","Your record have been deleted successfully");
		}
		
		return map;
	}
}
