package com.tka.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.project.dao.ClassSchedule_Dao;
import com.tka.project.entity.ClassSchedule;

@Service
public class ClassSchedule_Service {

	@Autowired
	ClassSchedule_Dao Dao;
	
	public List<ClassSchedule> getAllclassSchedule() {
		return  Dao.getAllclassSchedule();
		
	}
	public ClassSchedule getClassScheduleByID(Long id) {
		return  Dao.getClassScheduleByID(id);
	}
	
	
	public String AddClassSchedule(ClassSchedule obj) {
		
		return Dao.AddClassSchedule(obj);
	}
	
	
	public String UpdateClassSchedule(ClassSchedule classScheduled) {
		return Dao.UpdateClassSchedule(classScheduled);
	}
	public String DeleteClassScheduleByID(Long id) {
		return Dao.DeleteClassScheduleByID(id);
		
	}

}
