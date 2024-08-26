package com.tka.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.project.entity.Department;
import com.tka.project.entity.Subjects;

@Repository
public class SubjectSDao {

	@Autowired
	private SessionFactory sessionfactory = null;
	Session session = null;
	Transaction transaction = null;
	List<Subjects> subject;

	public List<Subjects> getAllSubjects() {

		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			subject = session.createQuery("FROM Subjects", Subjects.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			transaction.commit();
			if (session != null) {
				session.close();
			}
		}
		return subject;

	}

	public Subjects getSubjectById(Long id) {
		Subjects subject = null;
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			subject = session.get(Subjects.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			transaction.commit();
			if (session != null) {
				session.close();
			}
		}
		return subject;

	}

	public String CreateSubject(Subjects subject) {
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			session.save(subject);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			transaction.commit();
			if(session != null) {
				session.close();
			}
		}
		return"Subject addes successfully..!";
		
	}

	public String UpdateSubject(Subjects subject) {
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(subject);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			transaction.commit();
			if(session != null) {
				session.close();
			}
		}
		return "Subject Updated Successfully..!";
		
	}

	public String DeleteSubjectById(Long id) {
	try {
		session = sessionfactory.openSession();
		transaction = session.beginTransaction();
		Subjects temp = session.get(Subjects.class, id);
		session.delete(temp);
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		transaction.commit();
		if(session != null) {
			session.close();
		}
	}
	return "Subject Deleted Suceessfully..!";
		
		
	}

}
