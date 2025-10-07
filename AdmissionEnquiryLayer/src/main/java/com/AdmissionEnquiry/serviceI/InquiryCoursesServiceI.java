package com.AdmissionEnquiry.serviceI;

import com.AdmissionEnquiry.entity.Courses;

import java.util.List;

public interface InquiryCoursesServiceI {

    public String saveCourses(Courses courses);

    public List<Courses> getAllCourses();
}
