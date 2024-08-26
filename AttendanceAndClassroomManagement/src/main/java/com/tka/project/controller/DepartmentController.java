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

import com.tka.project.entity.Department;
import com.tka.project.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

	@Autowired
	DepartmentService service;
	
	@GetMapping
	public List<Department> getAllDepartemnt() {
		return service.getAllDepartemnt();
	}
	
	@GetMapping("/{id}")
	public Department getDepartmentById(@PathVariable Long id) {
		return service.getDepartmentById(id);
	}
	
	@PostMapping
	public String CreateNewDeperment(@RequestBody Department Obj) {
		return service.CreateNewDeperment(Obj);
	}
	
	@PutMapping("/{id}")
	public String UpdateDepartment(@PathVariable Long id, @RequestBody Department DeptDetails) {
		Department Obj =service.getDepartmentById(id);
		if(Obj != null) {
			Obj.setId(DeptDetails.getId());
			Obj.setName(DeptDetails.getName());
		}
		return service.UpdateDepartment(Obj);
	}
	
	@DeleteMapping("/{id}")
	public String deleteDepartmentById(@PathVariable Long id) {
		return service.deleteDepartmentById(id);
	}
}
