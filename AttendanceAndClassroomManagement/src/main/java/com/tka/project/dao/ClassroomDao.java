package com.tka.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.project.entity.Classrooms;

@Repository
public class ClassroomDao {
	@Autowired
	private SessionFactory sessionfactory;
	Classrooms classroom;
	List<Classrooms> classrooms;
	Session session = null;
	Transaction transaction = null;

	public List<Classrooms> getAllClassrooms() {

		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			classrooms = session.createQuery("FROM Classrooms", Classrooms.class).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			transaction.commit();
			if (session != null) {
				session.close();
			}

		}
		return classrooms;

	}

	public Classrooms classroomservice(long id) {
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			classroom = session.get(Classrooms.class, id);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			transaction.commit();
			if (session != null) {
				session.close();
			}

		}
		return classroom;

	}

	
	
	public String insertClassroom(Classrooms classroom) {

		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			session.save(classroom);

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			transaction.commit();
			if(session != null) {
				session.close();
			}
		}
		
		return "Classroom Added Successfully..";

	}
	

	public String UpdateClassroom(Classrooms classroom) {
		try {

		session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(classroom);
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			transaction.commit();
			if(session != null) {
				session.close();
			}
		}
		return "User update successfully..";

	}


	
	
	
	public String deleteClassroomByID(Long id) {
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			Classrooms classroom = session.get(Classrooms.class, id);
			session.delete(classroom);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			transaction.commit();
			if(session != null) {
				session.close();
			}
		}

		return "User deleted Successfully..";

	}



}
