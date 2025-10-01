package com.springtest.springtest.services;

import java.util.List;

import com.springtest.springtest.entities.Course;

public interface courseService {

	public List<Course> getcourses();
	public Course getSingleCourse(long course_id);
	public Course addCourse(Course course);
	public Course updateCourse(Course course);
	public void deleteCourse(long course_id);

}

