package com.AdmissionEnquiry.serviceI;

import com.AdmissionEnquiry.entity.AdmissionEnquiry;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface EnquiryServiceI {

    public String saveAllEnquiryDetails(Long courseId,AdmissionEnquiry enquiry);

    public List<AdmissionEnquiry> getAllEnquirys();

    public AdmissionEnquiry getEnquiryById(Integer id);
}
