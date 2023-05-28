package com.example.lab4_20173118_20195527_ws.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
@Getter
@Setter
@Entity
@jakarta.persistence.Table(name = "job_history", schema = "hr", catalog = "")
public class JobHistory {
    @ManyToOne
    @jakarta.persistence.JoinColumn(name = "employee_id")
    private Employees employeeId;

    @Id
    @jakarta.persistence.Column(name = "start_date")
    private Timestamp startDate;

    @Basic
    @Column(name = "end_date")
    private Timestamp endDate;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Jobs jobId;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departments departmentId;

}
