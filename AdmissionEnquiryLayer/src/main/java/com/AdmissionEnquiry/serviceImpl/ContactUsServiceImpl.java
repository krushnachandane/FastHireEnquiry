package com.AdmissionEnquiry.serviceImpl;

import com.AdmissionEnquiry.entity.ContactUs;
import com.AdmissionEnquiry.repository.ContactUsRepo;
import com.AdmissionEnquiry.serviceI.ContactUsServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactUsServiceImpl implements ContactUsServiceI {

    @Autowired
    private ContactUsRepo contactUsRepo;

    @Override
    public String saveContactUs(ContactUs contactUs) {
        contactUsRepo.save(contactUs);
        return "ContactUs Details saved Successfully";
    }

    @Override
    public ContactUs findContactUs(Long id) {
        return contactUsRepo.findById(id).get();
    }

    @Override
    public List<ContactUs> findAllContactUs() {
        return contactUsRepo.findAll();
    }

    @Override
    public String UpdateContactUs(Long id,ContactUs contactUs) {
        ContactUs existsContactUs = findContactUs(id);
        existsContactUs.setFirstname(contactUs.getFirstname());
        existsContactUs.setLastname(contactUs.getLastname());
        existsContactUs.setEmail(contactUs.getEmail());
        existsContactUs.setContact(contactUs.getContact());
        existsContactUs.setMessage(contactUs.getMessage());
        contactUsRepo.save(existsContactUs);
        return "ContactUs Details Updated Successfully";
    }

    @Override
    public String deleteContactUs(Long id) {
        contactUsRepo.deleteById(id);
        return "ContactUs Details deleted Successfully";
    }
}
