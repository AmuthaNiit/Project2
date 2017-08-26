package com.niit.dao;

import java.util.List;

import com.niit.model.Blog;

public interface BlogDao {
	
	public boolean save(Blog blog);
	
	public boolean update(Blog blog);
	
	public boolean delete(String id);
	
	public List<Blog> getApprovedBlogs();
	
	public Blog getBlogById(String id);

}
