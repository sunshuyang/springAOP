package cn.itcast.service;

public interface PersonService {
	public void save(String name);
	public void update(String name,Integer id);
	public String getPersonName(Integer id);
}
