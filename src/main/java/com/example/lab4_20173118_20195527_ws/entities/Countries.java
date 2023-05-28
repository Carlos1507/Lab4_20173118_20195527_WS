package com.example.lab4_20173118_20195527_ws.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@Entity
public class Countries implements Serializable {
    @Id
    private String countryId;

    @Column(name = "country_name")
    private String countryName;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Regions regionId;
}
