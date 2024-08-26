package com.tka.project.service;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.project.dao.CoursesDao;
import com.tka.project.entity.Courses;

@Service
public class CoursesService {

	@Autowired
	CoursesDao courseDao;
	public List<Courses> getAllCourses() {
		
		 return courseDao.getAllCourses();
	}
	
	
	public Courses getCourseById(Long id) {
		
		return  courseDao.getCourseById(id);
	}


	public String UpdateCourseWithId(Courses course) {
		return courseDao.UpdateCourseWithId(course);
		
	}


	public String DeleteCourseById(Long id) {
		return courseDao. DeleteCourseById(id);
		
	}

}
