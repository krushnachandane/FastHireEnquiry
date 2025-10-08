package com.AdmissionEnquiry.serviceImpl;

import com.AdmissionEnquiry.entity.Courses;
import com.AdmissionEnquiry.repository.InquiryCoursesRepository;
import com.AdmissionEnquiry.serviceI.InquiryCoursesServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public String updateCourses(Long cid, Courses courses) {
        Optional<Courses> courses1 = inquiryCoursesRepository.findById(cid);
        if(courses1.isPresent()) {
            Courses courses2 = courses1.get();
            courses2.setCourseName(courses.getCourseName());
            inquiryCoursesRepository.save(courses2);
        }
        return "Courses Updated Successfully...!";
    }

    @Override
    public String deleteCourses(Long cid) {
            inquiryCoursesRepository.deleteById(cid);
        return "Courses Deleted Successfully...!";
    }


}
