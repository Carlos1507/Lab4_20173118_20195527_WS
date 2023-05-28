package com.example.lab4_20173118_20195527_ws.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
public class Regions implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "region_id")
    private Integer regionId;
    @Basic
    @Column(name = "region_name")
    private String regionName;
}
