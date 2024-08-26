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

import com.tka.project.entity.Faculty;
import com.tka.project.service.FacultyService;

@RestController
@RequestMapping("/api/faculties")
public class FacultyController {

	@Autowired
	FacultyService service;

	@GetMapping
	public List<Faculty> getAllFacultties() {

		return service.getAllFacultties();

	}
	
	@GetMapping("/{id}")
	public Faculty getFacultyById(@PathVariable Long id) {
		return service.getFacultyById(id);
	}
	
	@PostMapping
	public String CreateFaculty(@RequestBody Faculty faculty) {
		return service.CreateFaculty(faculty);
	}
	
	@PutMapping("/{id}")
	public String UpdateFaculty(@PathVariable Long id, @RequestBody Faculty facultyDetails) {
		Faculty faculty = service.getFacultyById(id);
		if(faculty != null) {
			faculty.setId(facultyDetails.getId());
			faculty.setName(facultyDetails.getName());
			faculty.setEmail(facultyDetails.getEmail());
			faculty.setDepartmentId(facultyDetails.getDepartmentId());
			
		}
		return service.UpdateFaculty(faculty);
	}
	
	@DeleteMapping("/{id}")
	public String deleteFacultyById(@PathVariable Long id) {
		return service.deleteFacultyById(id);
	}
}
