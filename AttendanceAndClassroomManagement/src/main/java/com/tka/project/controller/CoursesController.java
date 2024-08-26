package com.tka.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.project.entity.Courses;
import com.tka.project.service.CoursesService;

@RestController
@RequestMapping("/api/courses")
public class CoursesController {

	@Autowired
	CoursesService Courseservice;

	@GetMapping
	public List<Courses> getAllCourses() {
		return Courseservice.getAllCourses();

	}

	@GetMapping("/{id}")
	public Courses getCourseById(@PathVariable Long id) {

		return Courseservice.getCourseById(id);
	}

	@PutMapping("/{id}")
	public String UpdateCourseWithId(@PathVariable Long id, @RequestBody Courses courseDetails) {
		Courses course = Courseservice.getCourseById(id);
		if (course != null) {
			course.setId(courseDetails.getId());
			course.setName(courseDetails.getName());
		}
		return Courseservice.UpdateCourseWithId(course);
	}

	@DeleteMapping("/{id}")
	public String DeleteCourseById(@PathVariable Long id) {
		return Courseservice.DeleteCourseById(id);

	}
}
