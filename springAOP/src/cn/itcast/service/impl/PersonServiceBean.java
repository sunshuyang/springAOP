package cn.itcast.service.impl;

import cn.itcast.service.PersonService;

public class PersonServiceBean implements PersonService {
	
	public void save(String name) {
		System.out.println("����sava()����");
	}

	public void update(String name, Integer id) {
		System.out.println("����update()����");
	}

	public String getPersonName(Integer id) {
		System.out.println("����getPersonName()����");
		return "xxx";
	}

}
