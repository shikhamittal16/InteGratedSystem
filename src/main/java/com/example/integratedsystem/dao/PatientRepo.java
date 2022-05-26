package com.example.integratedsystem.dao;

import com.example.integratedsystem.Entities.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepo extends CrudRepository<Patient, Integer> {

    @Query("select u from Patient u where u.phn = ?1")
    Patient searchByPhn(String phn);

    @Query("select u from Patient u where u.aadhar = ?1")
    Patient searchByAadhar(String aadhar);
}
