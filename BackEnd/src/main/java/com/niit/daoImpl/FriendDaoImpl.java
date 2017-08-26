package com.niit.daoImpl;

import java.util.List;

//import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.FriendDao;

import com.niit.model.Friend;

@EnableTransactionManagement
@Repository("FriendDao")

public class FriendDaoImpl implements FriendDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public FriendDaoImpl() {
		
		this.sessionFactory = sessionFactory;

	}
	
	@Transactional
	public List<Friend> getMyFriends(String userID) {
		String hql = "from Friend where userid= "+" '" +userID+ "' and status='"+"A'";
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
		List<Friend> list = query.list();
		return list;
		
	}

	
	@Transactional
	public Friend get(String userID, String friendID) {
		
		String hql = "from Friend where userid= '" + userID + "' and " + " friendid ='" + friendID + "'";
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Friend> list = (List<Friend>) query.list();

		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}

		return null ;
	}
    
	@Transactional
	public boolean save(Friend friend) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(friend);
		return true;
 	
	
	}

	@Transactional
	public boolean update(Friend friend) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(friend);
		return true;
	}

	@Transactional
	public void delete(String userID, String friendID) {
		// TODO Auto-generated method stub
		Friend FriendToDelete = new Friend();
		FriendToDelete.setUserid(userID);
		FriendToDelete.setFriendid(friendID);
			sessionFactory.getCurrentSession().delete(FriendToDelete);

	}

	@Transactional
	public List<Friend> getNewFriendRequests(String userID) {
		// TODO Auto-generated method stub
		String hql = "from Friend where userid= "+" '" +userID+ "' and status='"+"N'";
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
		List<Friend> list = query.list();
		return list;

	}
   
	@Transactional
	public void setOnline(String userID) {
		// TODO Auto-generated method stub
		String hql ="update Friend SET is_online='Y' where userid= "+" '" +userID+ "'";
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
		query.executeUpdate();

	}

	@Transactional
	public void setOffLine(String userID) {
		// TODO Auto-generated method stub
		String hql ="update Friend SET is_online='N' where userid= "+" '" +userID+ "'";
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
		query.executeUpdate();

	}

}
