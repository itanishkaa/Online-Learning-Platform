package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CourseDao;
import com.example.pojo.CourseDetails;

@Service
public class CourseService {
    @Autowired
    private CourseDao courseDao;

    public CourseDetails addCourse(CourseDetails courseDetails) {
        CourseDetails createdCourse = courseDao.save(courseDetails);
        return createdCourse;
    }

    public List<CourseDetails> getAllCourseDetails() {
        List<CourseDetails> findAll = courseDao.findAll();
        return findAll;
    }
}
