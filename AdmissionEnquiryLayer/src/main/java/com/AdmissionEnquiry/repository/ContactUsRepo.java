package com.AdmissionEnquiry.repository;

import com.AdmissionEnquiry.entity.ContactUs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactUsRepo extends JpaRepository<ContactUs,Long> {

}
