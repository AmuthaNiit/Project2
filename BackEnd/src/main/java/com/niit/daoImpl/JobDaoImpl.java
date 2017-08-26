package com.niit.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.JobDao;
import com.niit.model.Job;

@Repository
public class JobDaoImpl implements JobDao {

	@Autowired
	private SessionFactory sessionFactory;

	 
	public void postJob(Job job) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.save(job);
		session.flush();
		session.close();

	} 

	
	public List<Job> getAllJobs() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Job");
		List<Job> jobs=query.list();
		session.close();
		return jobs;
	}

	public Job getJobDetail(int jobId) {
		
		Session session=sessionFactory.openSession();
		Job job=(Job)session.get(Job.class, jobId);
		session.close();
		return job;
	}

}
 