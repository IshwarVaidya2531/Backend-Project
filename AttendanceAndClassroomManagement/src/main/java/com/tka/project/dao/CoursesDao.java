package com.tka.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.tka.project.entity.Courses;

@Repository
public class CoursesDao {

	@Autowired
	SessionFactory sessionfactory;
	Session session;
	Transaction transaction;
	List<Courses> courses;
	Courses course;

	public List<Courses> getAllCourses() {
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			courses = session.createQuery("FROM Courses", Courses.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			transaction.commit();
			if (session != null) {
				session.close();
			}
		}
		return courses;

	}

	public Courses getCourseById(Long id) {

		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			course = session.get(Courses.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			transaction.commit();
			if (session != null) {
				session.close();
			}
		}
		return course;

	}

	public String UpdateCourseWithId(Courses course) {
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(course);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			transaction.commit();
			if (session != null) {
				session.close();
			}
		}

		return "Course Updated Successfully..!";

	}

	public String DeleteCourseById(Long id) {
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			Courses tempCource = session.get(Courses.class, id);
			session.delete(tempCource);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			transaction.commit();
			if(session != null) {
				session.close();
			}
		}
		return "User Deleted Successfully..!";
		
	}
	
	

}
