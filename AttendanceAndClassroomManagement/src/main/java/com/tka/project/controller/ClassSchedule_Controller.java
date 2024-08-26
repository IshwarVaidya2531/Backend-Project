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

import com.tka.project.entity.ClassSchedule;
import com.tka.project.service.ClassSchedule_Service;

@RestController
@RequestMapping("/api/classschedules")
public class ClassSchedule_Controller {

	@Autowired
	ClassSchedule_Service service;

	@GetMapping
	public List<ClassSchedule> getAllclassSchedule() {
		return service.getAllclassSchedule();

	}
	
	
	@GetMapping("/{id}")
	public ClassSchedule getClassScheduleByID(@PathVariable Long id) {
		return service.getClassScheduleByID(id);
	}
	
	@PostMapping
	public String AddClassSchedule(@RequestBody ClassSchedule obj) {
		return service.AddClassSchedule(obj);
	}
	
	 
	@PutMapping("/{id}")
	public String UpdateClassSchedule(@PathVariable Long id, @RequestBody ClassSchedule classDetails ) {
		ClassSchedule classScheduled = service.getClassScheduleByID(id);
		if(classScheduled != null) {
			classScheduled.setId(classDetails.getId());
			classScheduled.setEndTime(classDetails.getEndTime());
			classScheduled.setStartTime(classDetails.getStartTime());
			classScheduled.setSubjectid(classDetails.getSubjectid());
			classScheduled.setClassroomId(classDetails.getClassroomId());
			classScheduled.setDayofWeek(classDetails.getDayofWeek());
			
		}
		return service.UpdateClassSchedule(classScheduled);
	}
	
	@DeleteMapping("/{id}")
	public String DeleteClassScheduleByID(@PathVariable Long id) {
		return service.DeleteClassScheduleByID(id);
	}

}
