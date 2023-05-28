package com.example.lab4_20173118_20195527_ws.repositories;

import com.example.lab4_20173118_20195527_ws.entities.JobHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobHistoryRepo extends JpaRepository<JobHistory, Integer> {
}
