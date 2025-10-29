package com.AdmissionEnquiry.controller;

import com.AdmissionEnquiry.entity.CustomPlan;
import com.AdmissionEnquiry.serviceI.CustomPlanServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomPlanController {

    @Autowired
    private CustomPlanServiceI customPlanService;

    // Save custom plan
    @PostMapping("/customplanadd")
    public ResponseEntity<String> saveCustomPlan(@RequestBody CustomPlan customPlan) {
        String message = customPlanService.saveCustomPlanDetails(customPlan);
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }

    // Get all custom plan
    @GetMapping("/getall-customplan")
    public ResponseEntity<List<CustomPlan>> getAllCustomPlan() {
        return new ResponseEntity<List<CustomPlan>>(customPlanService.getAllCustomPlan(), HttpStatus.OK);
    }


    // Get by id
    @GetMapping("/getplanbyid/{id}")
    public ResponseEntity<CustomPlan> getPlanById(@PathVariable Integer id) {
        return new ResponseEntity<CustomPlan>(customPlanService.getById(id), HttpStatus.OK);
    }

    // Update plan
    @PutMapping("/updateplan/{id}")
    public ResponseEntity<CustomPlan> updatePlan(@PathVariable Integer id, @RequestBody CustomPlan plan) {
        return ResponseEntity.ok(customPlanService.update(id, plan));
    }


    // Delete By Id
    @DeleteMapping("/deleteplan/{id}")
    public ResponseEntity<String> deletePlanById(@PathVariable Integer id) {
        String msg = customPlanService.delete(id);
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }
}

