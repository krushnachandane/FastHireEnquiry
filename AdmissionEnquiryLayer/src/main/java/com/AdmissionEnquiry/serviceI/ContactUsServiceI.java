package com.AdmissionEnquiry.serviceI;


import com.AdmissionEnquiry.entity.ContactUs;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ContactUsServiceI {


    public String saveContactUs(ContactUs contactUs);

    public ContactUs findContactUs(Long id);

    public List<ContactUs> findAllContactUs();

    public String UpdateContactUs(Long id,ContactUs contactUs);

    public String deleteContactUs(Long id);
}
