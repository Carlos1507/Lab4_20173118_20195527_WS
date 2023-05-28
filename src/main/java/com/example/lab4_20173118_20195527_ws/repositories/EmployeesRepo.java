package com.example.lab4_20173118_20195527_ws.repositories;

import com.example.lab4_20173118_20195527_ws.entities.Employees;
import com.example.lab4_20173118_20195527_ws.entities.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeesRepo extends JpaRepository<Employees, Integer> {
    List<Employees> findAllByJobIdNot(Jobs jobid);

}
