package com.AdmissionEnquiry.serviceI;

import com.AdmissionEnquiry.entity.CustomPlan;

import java.util.List;

public interface CustomPlanServiceI {

    public String saveCustomPlanDetails(CustomPlan customPlan);

    public List<CustomPlan> getAllCustomPlan();

    public CustomPlan getById(Integer id);

    public CustomPlan update(Integer id, CustomPlan plan);

    public String delete(Integer id);
}
