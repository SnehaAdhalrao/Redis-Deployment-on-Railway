package com.springtest.springtest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.springtest.springtest.dao.courseDao;
import com.springtest.springtest.entities.Course;
@Service
public class courseServiceImplement implements courseService {
//	List<Course> list=new ArrayList<>();
//
//	public courseServiceImplement() {
//		Course c1=new Course( 101,"java course","thisis first course");
//		list.add(c1);
//		Course c2=new Course(102,"java course","thisis first course");
//		list.add(c2);
//	}
	@Autowired
	courseDao csdaoobj;
	
	@Override
	public List<Course> getcourses() {
		// TODO Auto-generated method stub
//		return list;
		return csdaoobj.findAll();
		
	}


	@Override
	@Cacheable(value="cachekanamehain", key="#course_id")
	public Course getSingleCourse(long course_id) {
		// TODO Auto-generated method stub
//		return csdaoobj.getOne(course_id);
		return csdaoobj.getById(course_id);
		
	}


	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
	return csdaoobj.save(course);
	}


	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		//update krne keliye course pas krna===parameter ka course db mein hona
		return csdaoobj.save(course);
	}


	@Override
	public void deleteCourse(long course_id) {
		csdaoobj.deleteById(course_id);
		// TODO Auto-generated method stub
		
	}

}
