package com.springtest.springtest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springtest.springtest.SpringtestApplication;
import com.springtest.springtest.entities.Course;
import com.springtest.springtest.services.courseService;

@RestController
public class myControllers {

	
	
	
    private final SpringtestApplication springtestApplication;
	@Autowired
	courseService cs;

    myControllers(SpringtestApplication springtestApplication) {
        this.springtestApplication = springtestApplication;
    }
    
   
	//get all courses
	@GetMapping("/courses")
	public List<Course> getcourses(){
		return this.cs.getcourses();
	}
	// get single course
	@GetMapping("/courses/{course_id}")
	public Course getSinglecourse(@PathVariable long course_id) {
		return this.cs.getSingleCourse(course_id);
	}
	
	//updating the course
	@PutMapping("/updatecourse")
	public Course updateCourse(Course course) {
		return this.cs.updateCourse(course);
	}
	//add courses and return the course which is added
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return this.cs.addCourse(course);
	}
	
	//delete the course from its id
	@DeleteMapping("/deletecourse/{course_id}")
	public ResponseEntity<Object> deleteCousre(@PathVariable long course_id) {
//	 this.cs.deleteCourse( course_id);****************************************this can be ok but if u want to send the request
		try {
			this.cs.deleteCourse(course_id);
			return new ResponseEntity<>(HttpStatus.OK);
			
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
