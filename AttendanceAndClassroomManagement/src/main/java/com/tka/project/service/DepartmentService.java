package com.tka.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.project.dao.DepartmentDao;
import com.tka.project.entity.Department;

@Service
public class DepartmentService {

	@Autowired
	DepartmentDao Dao;

	public List<Department> getAllDepartemnt() {
		return Dao.getAllDepartemnt();
		
	}

	public Department getDepartmentById(Long id) {
		return Dao.getDepartmentById(id);
		
	}

	public String CreateNewDeperment(Department obj) {
		return Dao.CreateNewDeperment(obj);
		
	}

	public String UpdateDepartment(Department obj) {
		return Dao.UpdateDepartment(obj);
		
	}

	public String deleteDepartmentById(Long id) {
		return Dao.deleteDepartmentById(id);
		
	}
	
}
