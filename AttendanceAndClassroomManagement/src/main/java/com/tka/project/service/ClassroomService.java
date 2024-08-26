package com.tka.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.project.dao.ClassroomDao;
import com.tka.project.entity.Classrooms;

@Service
public class ClassroomService {

	@Autowired
	ClassroomDao classroomdao;
	
	public List<Classrooms> getAllClassrooms() {
		return classroomdao.getAllClassrooms();
		
	}

	public Classrooms classroomservice(long id) {
		return classroomdao.classroomservice(id);
		
	}

	public String insertClassroom(Classrooms classroom) {
		
		return classroomdao.insertClassroom(classroom);
		
	}

	public String UpdateClassroom(Classrooms classroom) {
		return classroomdao.UpdateClassroom(classroom);
		
	}

	public String UpdateById(Classrooms obj) {
		return classroomdao.UpdateClassroom(obj);
		
	}


	public String deleteClassroomByID(Long id) {
		return classroomdao.deleteClassroomByID(id);
	}

	
}
