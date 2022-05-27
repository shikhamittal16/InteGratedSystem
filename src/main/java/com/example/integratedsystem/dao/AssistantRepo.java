package com.example.integratedsystem.dao;

import com.example.integratedsystem.Entities.Assistant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssistantRepo extends CrudRepository<Assistant , String> {

    @Query("SELECT u from Assistant u WHERE u.seniorName like %?1%")
    Assistant fetchAssistantDetailsByDoctorName(String doctorName);
}
