package com.AdmissionEnquiry.serviceImpl;

import com.AdmissionEnquiry.entity.AdmissionEnquiry;
import com.AdmissionEnquiry.entity.Courses;
import com.AdmissionEnquiry.repository.EnquiryRepository;
import com.AdmissionEnquiry.repository.InquiryCoursesRepository;
import com.AdmissionEnquiry.serviceI.EnquiryServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnquiryServiceImpl implements EnquiryServiceI {

    @Autowired
    private EnquiryRepository enquiryRepository;

    @Autowired
    private InquiryCoursesRepository courseRepo;

    @Override
    public String saveAllEnquiryDetails(Long courseId, AdmissionEnquiry enquiry) {
        Optional<Courses> course = courseRepo.findById(courseId);
        if(course.isPresent()) {
            enquiry.setInterestedCourse(course.get().getCourseName());
            enquiryRepository.save(enquiry);
        }
        return "Admission Enquiry Saved Successfully...!";
    }


    @Override
    public List<AdmissionEnquiry> getAllEnquirys() {
        return enquiryRepository.findAll();
    }

    @Override
    public AdmissionEnquiry getEnquiryById(Integer id) {
        Optional<AdmissionEnquiry> enquiry = enquiryRepository.findById(id);
        if(enquiry.isPresent()){
            return enquiry.get();
        }
        return null;
    }
}
