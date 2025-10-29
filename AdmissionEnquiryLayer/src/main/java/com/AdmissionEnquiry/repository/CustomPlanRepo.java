package com.AdmissionEnquiry.repository;

import com.AdmissionEnquiry.entity.CustomPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface CustomPlanRepo extends JpaRepository<CustomPlan,Integer> {

    }

