package com.example.integratedsystem.dao;

import com.example.integratedsystem.Entities.Nurse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface NurseRepo extends CrudRepository<Nurse , String> {

    @Query("SELECT u from Nurse u WHERE u.doctorName = ?1")
    Nurse fetchNurseDetailsByDoctorName(String doctorName);
}

