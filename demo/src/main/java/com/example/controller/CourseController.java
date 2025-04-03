package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.CourseDetails;
import com.example.service.CourseService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping(value = "/addCourse", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addCourse(@RequestBody CourseDetails courseDetails) {
        CourseDetails addedCourse = courseService.addCourse(courseDetails);
        if(addedCourse != null) {
            System.out.println("Course Created :: " + addedCourse);
            return new ResponseEntity<>("Course Addition successfull", HttpStatus.OK);
        } else {
            System.out.println("Something went wrong");
            return new ResponseEntity<>("Course Addition failed", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CourseDetails>> getAllCourses() {
        List<CourseDetails> allCourseDetails = courseService.getAllCourseDetails();
        if (allCourseDetails.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(allCourseDetails, HttpStatus.OK);
        }
    }
}
