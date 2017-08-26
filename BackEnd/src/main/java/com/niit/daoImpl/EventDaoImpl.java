package com.niit.daoImpl;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.dao.EventDao;
import com.niit.model.Event;

public class EventDaoImpl implements EventDao{
	@Autowired
	SessionFactory sessionFactory;


	public void create(Event event) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(event);

	}

	public void update(Event event) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(event);

	}

	public void remove(Event event) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(event);

	}

	public Event getEventById(long eventId) {
		// TODO Auto-generated method stub
		String hql = "from Event where eventId=" + eventId;
		Session session = sessionFactory.getCurrentSession();
		Event event = null;
		try {
			event = (Event) session.createQuery(hql).getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
		}
		return event;
	}

	
	public List<Event> getAllEvents() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Event";
		List<Event> events = session.createQuery(hql).getResultList();
		return events;
	}



	
	
	

}
