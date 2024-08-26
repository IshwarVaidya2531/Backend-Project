package com.tka.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.project.entity.Department;
import com.tka.project.service.DepartmentService;

@Repository
public class DepartmentDao {
	
	@Autowired
	private SessionFactory sessionfactory = null;
	Session session = null;
	Transaction transaction = null;
	List<Department> Dept;

	public List<Department> getAllDepartemnt() {
		try {
			session = sessionfactory.openSession();
			transaction =session.beginTransaction();
			Dept = session.createQuery("FROM Department", Department.class).getResultList();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			transaction.commit();
			if(session != null) {
				session.close();
			}
		}
		
		return Dept;
		
		
	}

	public Department getDepartmentById(Long id) {
		Department Dept=null;
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			Dept  = session.get(Department.class, id);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			transaction.commit();
			if(session != null) {
				session.close();
			}
		}
		return Dept;
	}

	public String CreateNewDeperment(Department obj) {
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			session.save(obj);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			transaction.commit();
			if(session != null) {
				session.close();
			}
		}
		
		return "Department Created Successsfully..!";
		
	}

	public String UpdateDepartment(Department obj) {
		
	try {
		session = sessionfactory.openSession();
		transaction = session.beginTransaction();
		session.saveOrUpdate(obj);
	}catch(Exception e) {
		e.printStackTrace();
	}finally{
		transaction.commit();
		if(session != null) {
			session.close();
		}
	}
	return "Department updated Successfully";
		
	}

	public String deleteDepartmentById(Long id) {
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			Department temp = session.get(Department.class, id);
			session.delete(temp);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			transaction.commit();
			if(session != null) {
				session.close();
			}
		}
		return "Department Deleted Successfully..!";
		
	}

}
