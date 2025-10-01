package com.springtest.springtest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springtest.springtest.entities.Course;

public interface courseDao extends JpaRepository<Course,Long>{

}
