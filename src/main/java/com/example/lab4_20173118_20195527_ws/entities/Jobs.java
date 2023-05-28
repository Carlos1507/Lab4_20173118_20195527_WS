package com.example.lab4_20173118_20195527_ws.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
public class Jobs implements Serializable {
    @Id
    @Column(name = "job_id")
    private String jobId;
    @Basic
    @Column(name = "job_title")
    private String jobTitle;
    @Basic
    @Column(name = "min_salary")
    private Integer minSalary;
    @Basic
    @Column(name = "max_salary")
    private Integer maxSalary;
}
