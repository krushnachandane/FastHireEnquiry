package com.AdmissionEnquiry.controller;

import com.AdmissionEnquiry.entity.ContactUs;
import com.AdmissionEnquiry.serviceI.ContactUsServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contactus")
@CrossOrigin(origins = {"http://localhost:5173", "https://wayabroad.in"})
public class ContactUsController {

    @Autowired
    private ContactUsServiceI contactUsService;

    // Save ContactUs Details
    @PostMapping("/contact-us")
    public ResponseEntity<String> saveContactUs(@RequestBody ContactUs contactUs) {
        return new ResponseEntity<String>(contactUsService.saveContactUs(contactUs), HttpStatus.CREATED);
    }

    // Find By Id ContactUs
    @GetMapping("/getbyid/{id}")
    public ResponseEntity<ContactUs> getByIdContactUs(@PathVariable Long id){
        return new ResponseEntity<ContactUs>(contactUsService.findContactUs(id) ,HttpStatus.OK);
    }

    // Get All ContactUs
    @GetMapping("/getall")
    public ResponseEntity<List<ContactUs>> getAllContactUs() {
        return new ResponseEntity<>( contactUsService.findAllContactUs() ,HttpStatus.OK);
    }

    // Update ContactUs Details
    @PutMapping("/update-contactus/{id}")
    public ResponseEntity<String> updateContactUs(@PathVariable("id") Long id ,@RequestBody ContactUs contactUs) {
        return new ResponseEntity<>(contactUsService.UpdateContactUs(id,contactUs) ,HttpStatus.OK);
    }

    // Delete By Id ContactUs
    @DeleteMapping("/delete-contactus/{id}")
    public ResponseEntity<String> deleteContactUs(@PathVariable("id") Long id){
        return new ResponseEntity<String>( contactUsService.deleteContactUs(id) ,HttpStatus.OK);
    }
}
