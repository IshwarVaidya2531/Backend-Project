package com.tka.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.project.dao.FcaultyDao;
import com.tka.project.entity.Faculty;

@Service
public class FacultyService {

	@Autowired
	FcaultyDao Dao;
	
	public List<Faculty> getAllFacultties() {
		return Dao.getAllFacultties();
		
	}

	public Faculty getFacultyById(Long id) {
		
		return  Dao.getFacultyById(id);
	}

	public String CreateFaculty(Faculty faculty) {
		
		return Dao.CreateFaculty(faculty);
	}

	public String UpdateFaculty(Faculty faculty) {
		return Dao.UpdateFaculty(faculty);
		
	}

	public String deleteFacultyById(Long id) {
		return Dao.deleteFacultyById(id);
		
	}
	
	

}
