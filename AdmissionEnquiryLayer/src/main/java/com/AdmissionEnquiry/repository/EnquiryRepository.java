package com.AdmissionEnquiry.repository;

import com.AdmissionEnquiry.entity.AdmissionEnquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EnquiryRepository extends JpaRepository<AdmissionEnquiry, Integer> {

//    @Query("SELECT ae FROM AdmissionEnquiry ae JOIN FETCH ae.interestedCourse WHERE ae.eid = :eid")
//   public AdmissionEnquiry findByIdWithCourse(@Param("eid") Integer eid);


}
