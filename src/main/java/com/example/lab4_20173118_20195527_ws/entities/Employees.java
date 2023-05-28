package com.example.lab4_20173118_20195527_ws.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
@Getter
@Setter
@Entity
public class Employees {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer employeeId;

    @Basic
    @Column(name = "first_name")
    private String firstName;

    @Basic
    @Column(name = "last_name")
    private String lastName;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "phone_number")
    private String phoneNumber;

    @Basic
    @Column(name = "hire_date")
    private Timestamp hireDate;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Jobs jobId;

    @Basic
    @Column(name = "salary")
    private BigDecimal salary;

    @Basic
    @Column(name = "commission_pct")
    private BigDecimal commissionPct;

    @Basic
    @Column(name = "manager_id")
    private Integer managerId;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departments departmentId;

    @Basic
    @Column(name = "meeting")
    private byte meeting;

    @Basic
    @Column(name = "meeting_date")
    private Timestamp meetingDate;

}
