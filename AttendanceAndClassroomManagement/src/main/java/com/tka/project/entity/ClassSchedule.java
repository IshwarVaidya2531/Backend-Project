package com.tka.project.entity;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "class_schedules")
public class ClassSchedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "classroom_id", nullable =false)
	private Long classroomId;
	
	@Column(name = "day_of_week", nullable = false)
	private String DayofWeek;
	
	@Column(name = "start_time", nullable = false)
	private Time StartTime;
	
	@Column(name = "end_time", nullable = false)
	private Time EndTime;
	
	@Column(name = "subject_id", nullable = false)
	private Long Subjectid;
	
	
	public ClassSchedule(Long id, Long classroomId, String dayofWeek, Time startTime, Time endTime, Long subjectid) {
		super();
		this.id = id;
		this.classroomId = classroomId;
		DayofWeek = dayofWeek;
		StartTime = startTime;
		EndTime = endTime;
		Subjectid = subjectid;
	}


	public ClassSchedule() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getClassroomId() {
		return classroomId;
	}


	public void setClassroomId(Long classroomId) {
		this.classroomId = classroomId;
	}


	public String getDayofWeek() {
		return DayofWeek;
	}


	public void setDayofWeek(String dayofWeek) {
		DayofWeek = dayofWeek;
	}


	public Time getStartTime() {
		return StartTime;
	}


	public void setStartTime(Time startTime) {
		StartTime = startTime;
	}


	public Time getEndTime() {
		return EndTime;
	}


	public void setEndTime(Time endTime) {
		EndTime = endTime;
	}


	public Long getSubjectid() {
		return Subjectid;
	}


	public void setSubjectid(Long subjectid) {
		Subjectid = subjectid;
	}
	

}
