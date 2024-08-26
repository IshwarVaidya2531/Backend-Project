package com.tka.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.project.dao.SubjectSDao;
import com.tka.project.entity.Subjects;

@Service
public class SubjectsService {

	
	@Autowired
	SubjectSDao Dao;
	
	public List<Subjects> getAllSubjects() {
		return Dao.getAllSubjects();
		
	}

	public Subjects getSubjectById(Long id) {
		return Dao.getSubjectById(id);
		
	}

	public String CreateSubject(Subjects subject) {
		
		return Dao.CreateSubject(subject);
	}

	public String UpdateSubject(Subjects subject) {
		
		return Dao.UpdateSubject(subject);
	}

	public String DeleteSubjectById(Long id) {
		return Dao.DeleteSubjectById(id);
		
	}

}
