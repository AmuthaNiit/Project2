package com.niit.daoImpl;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;


import com.niit.dao.BlogDao;
import com.niit.model.Blog;

@Repository("BlogDao")
@EnableTransactionManagement
@Transactional
public class BlogDaoImpl implements BlogDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public void create(Blog blog) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(blog);
	}

	public boolean update(Blog blog) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(blog);
		return true;
	}
	
	public boolean delete(String id) {
		/*Session session = sessionFactory.getCurrentSession();
		session.delete(blog);
		return true;
*/	
		Blog BlogToDelete = new Blog();
		BlogToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(BlogToDelete);
	
	return true;
	
	}

	public Blog getBlogById(String blogId) {
		String hql = "from Blog where blogId=" + blogId;
		Session session = sessionFactory.getCurrentSession();
		Blog blog = null;
		try {
			blog = (Blog) session.createQuery(hql).getSingleResult();
		} catch (NoResultException e) {
			System.err.println("Error Getting Blog with Id: " + blogId);
			System.err.println("Error Message: " + e.getMessage());
		}
		return blog;
	}

		public List<Blog> getAllBlogs() {
		Session session = sessionFactory.getCurrentSession();
		List<Blog> blogs = session.createQuery("from Blog").getResultList();
		return blogs;
	}

	
	public List<Blog> getApprovedBlogs() {
		Session session = sessionFactory.getCurrentSession();
		List<Blog> blogs = session.createQuery("from Blog where status='APPROVED'").getResultList();
		return blogs;
	}

	public boolean save(Blog blog) {
		// TODO Auto-generated method stub
		return false;
	}
	

	

	
}