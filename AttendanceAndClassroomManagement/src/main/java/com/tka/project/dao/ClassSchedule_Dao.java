package com.tka.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.project.entity.ClassSchedule;

@Repository
public class ClassSchedule_Dao {

	@Autowired
	private  SessionFactory sessionfactory;
	Session session=null;
	Transaction transaction=null;
	ClassSchedule scheduleClass;
	List<ClassSchedule> schedule;

	public List<ClassSchedule> getAllclassSchedule() {
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			schedule = session.createQuery("FROM ClassSchedule", ClassSchedule.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			transaction.commit();
			if (session != null) {
				session.close();
			}
		}
		return schedule;

	}

	public ClassSchedule getClassScheduleByID(Long id) {
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			scheduleClass =  session.get(ClassSchedule.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			transaction.commit();
			if (session != null) {
				session.close();
			}
			
		}
		return scheduleClass;

	}

	public String AddClassSchedule(ClassSchedule classScheduled) {
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			session.save(classScheduled);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			transaction.commit();
			if(session!=null) {
				session.close();
			}
			
		}
		return "Class Scheduled Successfully..!";
		
	}

	
	
	public String UpdateClassSchedule(ClassSchedule classDetails) {
		
		try{
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
		
			session.saveOrUpdate(classDetails);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			transaction.commit();
			if(session != null) {
				session.close();
			}
		}
		return "Class Schedule Updated Successfully..!";

	}

	public String DeleteClassScheduleByID(Long id) {
		
	try {
		session = sessionfactory.openSession();
		transaction = session.beginTransaction();
		ClassSchedule tempObj = session.get(ClassSchedule.class, id);
		session.delete(tempObj);
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		transaction.commit();
		if(session!= null) {
			session.close();
		}
	}
	return "Class Scheduled Deleted Successfully...!";
		
		
	}

}
