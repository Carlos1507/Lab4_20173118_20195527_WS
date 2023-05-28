package com.example.lab4_20173118_20195527_ws.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@Entity
public class Departments implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int departmentId;

    @Basic
    @Column(name = "department_name")
    private String departmentName;

    @Basic
    @Column(name = "manager_id")
    private Integer managerId;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Locations locationId;

}
