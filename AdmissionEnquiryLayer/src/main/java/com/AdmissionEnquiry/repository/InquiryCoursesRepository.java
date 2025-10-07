package com.AdmissionEnquiry.repository;

import com.AdmissionEnquiry.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InquiryCoursesRepository extends JpaRepository<Courses, Long> {

}
