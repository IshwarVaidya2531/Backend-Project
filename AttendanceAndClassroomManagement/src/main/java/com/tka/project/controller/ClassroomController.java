package com.tka.project.controller;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.project.entity.Classrooms;
import com.tka.project.service.ClassroomService;

@RestController
@RequestMapping("/api/classrooms")
public class ClassroomController {

	@Autowired
	ClassroomService classroomservice;
	
	@GetMapping
	public List<Classrooms> getAllClassrooms() {
		return classroomservice.getAllClassrooms();
		
	}
	
	@GetMapping("/{id}")
	public Classrooms classroomservice(@PathVariable Long id) {
		return classroomservice.classroomservice(id);
	}
	
	
	@PostMapping
	public String insertClassroom(@RequestBody Classrooms classroom) {
		return classroomservice.insertClassroom(classroom);
		
	}
	
	@PostMapping("/update")
	public String UpdateClassroom(@RequestBody Classrooms classroom) {
		return classroomservice.UpdateClassroom(classroom);
	}
	
	
	@GetMapping("/With{id}")
	public String UpdateById(@PathVariable Long id, @RequestBody Classrooms classroomDetails) {
		Classrooms obj =classroomservice.classroomservice(id);
		if(obj != null) {
			obj.setId(classroomDetails.getId());
			obj.setName(classroomDetails.getName());
		}
		return classroomservice.UpdateById(obj);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteClassroomByID(@PathVariable Long id) {
		return classroomservice.deleteClassroomByID(id);
	}
	
	
	
}
