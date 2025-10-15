package com.AdmissionEnquiry.controller;

import com.AdmissionEnquiry.entity.Courses;
import com.AdmissionEnquiry.serviceI.InquiryCoursesServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class CourseController {
    private final InquiryCoursesServiceI coursesServiceI;

    // Courses Section

    @PostMapping("/savecourses")
    public ResponseEntity<String> saveCourses(@RequestBody Courses courses){
        return new ResponseEntity<String>(coursesServiceI.saveCourses(courses), HttpStatus.CREATED);
    }

    @GetMapping("/allcourses")
    public ResponseEntity<List<Courses>> listCourses() {
        return ResponseEntity.ok(coursesServiceI.getAllCourses());
    }

    @PutMapping("/updatecourse/{cid}")
    public ResponseEntity<String> updateCourses(@PathVariable("cid") Long cid,@RequestBody Courses courses) {
        String result = coursesServiceI.updateCourses(cid, courses);
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }


    @DeleteMapping("/deletecourse/{cid}")
    public ResponseEntity<String> deleteCourses(@PathVariable("cid") Long cid){
        return new ResponseEntity<>(coursesServiceI.deleteCourses(cid),HttpStatus.OK);
    }
}
