package com.niit.dao;

import java.util.List;

import com.niit.model.user;

public interface UserDao {

	public boolean save(user userdetails);
	
	public boolean update(user userdetails);
		
		public boolean delete(String id);
		
		public void setOnLine(String userid);
		public void setOffLine(String userid);
		public List<user> list();
				
		public user authenticate(String username, String password);
		
		public user get(String username);

}
