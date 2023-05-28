package com.example.lab4_20173118_20195527_ws.services;

import com.example.lab4_20173118_20195527_ws.entities.Employees;
import com.example.lab4_20173118_20195527_ws.entities.Jobs;
import com.example.lab4_20173118_20195527_ws.repositories.EmployeesRepo;
import com.example.lab4_20173118_20195527_ws.repositories.JobsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TutorRest {
    @Autowired
    EmployeesRepo employeesRepo;
    @Autowired
    JobsRepo jobsRepo;
    @GetMapping("/difPRES")
    public List<Employees> difPresi(){
        Jobs jobs = jobsRepo.findById("AD_PRES").get();
        return employeesRepo.findAllByJobIdNot(jobs);
    }
}
