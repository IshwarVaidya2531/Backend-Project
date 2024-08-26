package com.tka.project.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "faculty_attendance")
public class FacultyAttendence {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "faculty_id", nullable = false)
	private Long facultyId;

	@Column(name = "class_schedule_id", nullable = false)
	private Long classScheduleId;

	@Column(nullable = false)
	private Date date;

	@Column(nullable = false)
	private String status;

	public FacultyAttendence(Long id, Long facultyId, Long classScheduleId, Date date, String status) {
		super();
		this.id = id;
		this.facultyId = facultyId;
		this.classScheduleId = classScheduleId;
		this.date = date;
		this.status = status;
	}

	public FacultyAttendence() {
		super();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(Long facultyId) {
		this.facultyId = facultyId;
	}

	public Long getClassScheduleId() {
		return classScheduleId;
	}

	public void setClassScheduleId(Long classScheduleId) {
		this.classScheduleId = classScheduleId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
