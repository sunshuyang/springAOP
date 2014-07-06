package cn.itcast.service.impl;

import cn.itcast.service.PersonService;

public class PersonServiceBean implements PersonService {
	
	public void save(String name) {
		System.out.println("我是sava()方法");
	}

	public void update(String name, Integer id) {
		System.out.println("我是update()方法");
	}

	public String getPersonName(Integer id) {
		System.out.println("我是getPersonName()方法");
		return "xxx";
	}

}
