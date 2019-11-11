package com.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.entities.Person;
import com.servicesapi.PersonService;

@Controller
@RequestMapping("/")
public class PersonController {
	
	@Autowired
	PersonService personServices;
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public ModelAndView register(){
		ModelAndView view =new ModelAndView("register");
		return view;
	}
	
	@RequestMapping(value="/search", method = RequestMethod.GET)
	public ModelAndView search(){
		ModelAndView view =new ModelAndView("persons_list");
		return view;
	}
	
	@RequestMapping(value="/saveOrUpdatePerson", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getSaved(Person person){
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(person.getBirthdate() == null)
			person.setBirthdate(new Date());
		if(person.getDoctype() == null)
			person.setDoctype("DNI");
		if(personServices.saveOrUpdatePerson(person)){
			map.put("status","200");
			map.put("message","Datos actualizados correctamente.");
		}
		
		return map;
	}
	
	
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getAll(Person persons){
		Map<String,Object> map = new HashMap<String,Object>();
	
			List<Person> list = personServices.list();
			
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
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> search(String name, int doctype){
		Map<String,Object> map = new HashMap<String,Object>();
	
			List<Person> list = personServices.filtredList(name, doctype);
			
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
	public @ResponseBody Map<String,Object> delete(Person person){
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(personServices.delete(person)){
			map.put("status","200");
			map.put("message","Your record have been deleted successfully");
		}
		
		return map;
	}
}
