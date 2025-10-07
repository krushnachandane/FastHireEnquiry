package com.AdmissionEnquiry.serviceImpl;

import com.AdmissionEnquiry.entity.Courses;
import com.AdmissionEnquiry.repository.InquiryCoursesRepository;
import com.AdmissionEnquiry.serviceI.InquiryCoursesServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InquiryCoursesServiceImpl implements InquiryCoursesServiceI {

    @Autowired
    private InquiryCoursesRepository inquiryCoursesRepository;

    @Override
    public String saveCourses(Courses courses) {
        inquiryCoursesRepository.save(courses);
        return "Courses Saved Successfully...!";
    }

    @Override
    public List<Courses> getAllCourses() {
        return inquiryCoursesRepository.findAll();
    }
}
