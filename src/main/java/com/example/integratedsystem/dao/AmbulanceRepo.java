package com.example.integratedsystem.dao;

import com.example.integratedsystem.Entities.ambulance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmbulanceRepo extends CrudRepository<ambulance, String> {
}
