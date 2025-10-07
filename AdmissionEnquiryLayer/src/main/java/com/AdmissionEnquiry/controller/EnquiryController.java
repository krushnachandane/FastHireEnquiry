package com.AdmissionEnquiry.controller;

import com.AdmissionEnquiry.entity.AdmissionEnquiry;
import com.AdmissionEnquiry.entity.Courses;
import com.AdmissionEnquiry.serviceI.EnquiryServiceI;
import com.AdmissionEnquiry.serviceI.InquiryCoursesServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnquiryController {

    @Autowired
    private EnquiryServiceI enquiryServiceI;

    @Autowired
    private InquiryCoursesServiceI coursesServiceI;

    // Courses Section

    @PostMapping("savecourses")
    public ResponseEntity<String> saveCourses(@RequestBody Courses courses){
        return new ResponseEntity<String>(coursesServiceI.saveCourses(courses), HttpStatus.CREATED);
    }

    @GetMapping("/allcourses")
    public ResponseEntity<List<Courses>> listCourses() {
        return ResponseEntity.ok(coursesServiceI.getAllCourses());
    }


    //Enquiry Section

    @PostMapping("/courses/{courseId}")
    public ResponseEntity<String> saveEnquiry(@PathVariable Long courseId , @RequestBody AdmissionEnquiry enquiry){
        return new ResponseEntity<String>(enquiryServiceI.saveAllEnquiryDetails(courseId,enquiry), HttpStatus.CREATED);
    }

    @GetMapping("getallenquiry")
    public ResponseEntity<List<AdmissionEnquiry>> getAllEnquiry(){
        List<AdmissionEnquiry> enquirys = enquiryServiceI.getAllEnquirys();
        return new ResponseEntity<List<AdmissionEnquiry>>(enquirys,HttpStatus.OK);
    }

    @GetMapping("getenquirybyid/{id}")
    public ResponseEntity<AdmissionEnquiry> getAllEnquiry(@PathVariable("id") Integer id){
        return new ResponseEntity<AdmissionEnquiry>(enquiryServiceI.getEnquiryById(id),HttpStatus.OK);
    }

//    @DeleteMapping("enquirydelete")
//    public ResponseEntity<String> deleteEnquiry(){
//
//        return
//    }
}
