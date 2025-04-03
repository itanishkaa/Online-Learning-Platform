package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.pojo.CourseDetails;

public interface CourseDao extends JpaRepository<CourseDetails, Integer> {

}
