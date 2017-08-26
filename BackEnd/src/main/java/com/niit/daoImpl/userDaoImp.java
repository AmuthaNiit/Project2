package com.niit.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.UserDao;
import com.niit.model.user;

@EnableTransactionManagement
@Repository("userdetailsDAO")

public class userDaoImp implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;


	 
	public userDaoImp() {
		this.sessionFactory = sessionFactory;
	}

		public boolean save(user userdetails) {
			sessionFactory.getCurrentSession().save(userdetails);
			return true;

	}

	public boolean update(user userdetails) {
		sessionFactory.getCurrentSession().update(userdetails);
		return true;

	}

	public boolean delete(String id) {
		user CategoryToDelete = new user();
		//CategoryToDelete.set
		//CategoryToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(CategoryToDelete);
	
	return true;

	}

	public void setOnLine(String userid) {
		// TODO Auto-generated method stub
		String hql ="update Userdetails SET is_online='Y' where userid= "+" '" +userid+ "'";
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
		query.executeUpdate();

		
		
	}

	public void setOffLine(String userid) {
		// TODO Auto-generated method stub
		String hql ="update Userdetails SET is_online='N' where userid= "+" '" +userid+ "'";
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
		query.executeUpdate();

	}

	public List<user> list() {
		// TODO Auto-generated method stub
		return null;
	}

	public user authenticate(String username, String password) {
		// TODO Auto-generated method stub
	   System.out.println("DAO IMPLEMENTATION..");
		String hql = "from Userdetails where userid= '" + username + "' and " + " password ='" + password + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		
		List<user> list = (List<user>) query.list();

		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}

		return null ;

	}

	public user get(String username) {
		// TODO Auto-generated method stub
		String hql = "from Userdetails where userid= "+" '" +username+ "'";
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
		
		List<user > list = query.list();
		if(list == null || list.isEmpty())
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}

}
