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

    @Override
    public String deleteEnquiryById(Integer eid) {
        enquiryRepository.deleteById(eid);
        return "Enquiry Deleted Successfully....!";
    }

    @Override
    public String updateEnquiry(Integer eid ,AdmissionEnquiry enquiry) {
        Optional<AdmissionEnquiry> enquiry1 = enquiryRepository.findById(eid);
        if(enquiry1.isPresent()){
            AdmissionEnquiry admissionEnquiry = enquiry1.get();
            admissionEnquiry.setName(enquiry.getName());
            admissionEnquiry.setEmail(enquiry.getEmail());
            admissionEnquiry.setMobileNO(enquiry.getMobileNO());

            enquiryRepository.save(admissionEnquiry);
        }
        return "Admission Enquiry Updated Successfully...!";
    }
}
