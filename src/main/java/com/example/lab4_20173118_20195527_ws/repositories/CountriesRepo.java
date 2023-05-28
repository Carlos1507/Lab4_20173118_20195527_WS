package com.example.lab4_20173118_20195527_ws.repositories;

import com.example.lab4_20173118_20195527_ws.entities.Countries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountriesRepo extends JpaRepository<Countries, String> {
}
