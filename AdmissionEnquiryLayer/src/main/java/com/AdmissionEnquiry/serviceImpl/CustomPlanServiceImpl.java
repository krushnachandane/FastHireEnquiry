package com.AdmissionEnquiry.serviceImpl;

import com.AdmissionEnquiry.entity.CustomPlan;
import com.AdmissionEnquiry.repository.CustomPlanRepo;
import com.AdmissionEnquiry.serviceI.CustomPlanServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomPlanServiceImpl implements CustomPlanServiceI {

    @Autowired
    private CustomPlanRepo customPlanRepo;

    @Override
    public String saveCustomPlanDetails(CustomPlan customPlan) {
        customPlanRepo.save(customPlan);
        return "Custom Plan Saved Successfully";
    }

    @Override
    public List<CustomPlan> getAllCustomPlan() {
        return customPlanRepo.findAll();
    }


    @Override
    public CustomPlan getById(Integer id) {
        Optional<CustomPlan>  customPlan = customPlanRepo.findById(id);
        if(customPlan.isPresent()){
            return customPlan.get();
        }
        return null;
    }

    @Override
    public CustomPlan update(Integer id, CustomPlan plan) {
        // You could throw exception if not exists
        Optional<CustomPlan> opt = customPlanRepo.findById(id);
        if (opt.isPresent()) {

            CustomPlan existingPlan = opt.get();
            // Update fields (except id)
            existingPlan.setName(plan.getName());
            existingPlan.setEmail(plan.getEmail());
            existingPlan.setMobNo(plan.getMobNo());
            existingPlan.setNumberOfJobOpenings(plan.getNumberOfJobOpenings());
            existingPlan.setAdditionalMessage(plan.getAdditionalMessage());

            customPlanRepo.save(existingPlan);
            return existingPlan;
        }
        return null;
    }


    @Override
    public String delete(Integer id) {
        customPlanRepo.deleteById(id);
        return "Custom Plan Deleted Successfully";
    }
}

