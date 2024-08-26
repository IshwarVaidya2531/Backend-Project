package com.tka.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.project.entity.Faculty;

@Repository
public class FcaultyDao {

	@Autowired
	SessionFactory factory = null;
	Session session = null;
	Transaction transaction = null;
	List<Faculty> faculties;

	public List<Faculty> getAllFacultties() {
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			faculties = session.createQuery("FROM Faculty", Faculty.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			transaction.commit();
			if (session != null) {
				session.close();
			}
		}

		return faculties;

	}

	public Faculty getFacultyById(Long id) {
		Faculty faculty = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			faculty = session.get(Faculty.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			transaction.commit();
			if (session != null) {
				session.close();
			}
		}
		return faculty;

	}

	public String CreateFaculty(Faculty faculty) {
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.save(faculty);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			transaction.commit();
			if (session != null) {
				session.close();
			}
		}
		return " Faculty created Successfully..!";

	}

	public String UpdateFaculty(Faculty faculty) {
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(faculty);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			transaction.commit();
			if (session != null) {
				session.close();
			}
		}
		return "Faculty Updated Successfully..!";

	}

	public String deleteFacultyById(Long id) {
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			Faculty tempObj = session.get(Faculty.class, id);
			session.delete(tempObj);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			transaction.commit();
			if(session != null) {
				session.close();
			}
		}
		return "Faculty Deleted Successfully..!";
		
	}

}
