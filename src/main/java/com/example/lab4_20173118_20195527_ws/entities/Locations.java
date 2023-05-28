package com.example.lab4_20173118_20195527_ws.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@Entity
public class Locations implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "location_id")
    private int locationId;
    @Basic
    @Column(name = "street_address")
    private String streetAddress;
    @Basic
    @Column(name = "postal_code")
    private String postalCode;
    @Basic
    @Column(name = "city")
    private String city;
    @Basic
    @Column(name = "state_province")
    private String stateProvince;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Countries countryId;
}
