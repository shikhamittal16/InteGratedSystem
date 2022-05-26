package com.example.integratedsystem.dao;

import com.example.integratedsystem.Entities.Appointment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppointmentRepo extends CrudRepository<Appointment, Integer> {

    @Query("SELECT u FROM Appointment u WHERE u.firstname = ?1")
    List<Appointment> findByName(String name);
}
