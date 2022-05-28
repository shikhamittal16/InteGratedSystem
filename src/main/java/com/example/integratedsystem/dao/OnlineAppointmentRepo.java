package com.example.integratedsystem.dao;

import com.example.integratedsystem.Entities.Appointment;
import com.example.integratedsystem.Entities.OnlineAppointment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OnlineAppointmentRepo extends CrudRepository<OnlineAppointment , Integer> {

    @Query("SELECT u FROM OnlineAppointment u WHERE u.doctorname like %?1%")
    List<OnlineAppointment> searchAppointmentByDoctorName(String doctorName);
}
