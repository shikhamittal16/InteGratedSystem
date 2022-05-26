package com.example.integratedsystem.dao;

import com.example.integratedsystem.Entities.bloodDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodDetailsRepo extends CrudRepository<bloodDetails , Integer> {
}
