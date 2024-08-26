package com.tka.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.project.entity.Subjects;
import com.tka.project.service.SubjectsService;

@RestController
@RequestMapping("/api/subjects")
public class SubjectsController {

	@Autowired
	SubjectsService service;
	
	@GetMapping
	public List<Subjects> getAllSubjects() {
		return service.getAllSubjects();
	}
	
	@GetMapping("/{id}")
	public void getSubjectById(@PathVariable Long id) {
		service.getSubjectById(id);
	}
	
	@PostMapping
	public String CreateSubject(@RequestBody Subjects subject) {
		return service.CreateSubject(subject);
	}
	
	@PutMapping("/{id}")
	public String UpdateSubject(@PathVariable Long id, @RequestBody Subjects SubjectDetails) {
		Subjects subject = service.getSubjectById(id);
		if(subject != null) {
			subject.setId(SubjectDetails.getId());
			subject.setCourseId(SubjectDetails.getCourseId());
			subject.setName(SubjectDetails.getName());
		}
		return service.UpdateSubject(subject);
		
	}
	
	@DeleteMapping("/{id}")
	public String DeleteSubjectById(@PathVariable Long id) {
		return service.DeleteSubjectById(id);
	}
	
}
