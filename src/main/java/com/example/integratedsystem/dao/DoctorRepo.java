package com.example.integratedsystem.dao;

import com.example.integratedsystem.Entities.Doctor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DoctorRepo extends CrudRepository<Doctor, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Doctor u where u.id= ?1")
    void deleteDoctorInformationById(Integer id);

    @Query("SELECT u FROM Doctor u where u.name like %?1%")
    List<Doctor> searchDoctorByName(String name);

    @Query("SELECT u FROM Doctor u WHERE u.name = ?1 AND u.loginId = ?2 AND u.password = ?3")
    Doctor findByNameLoginIdAndPassword(String name , String loginId , String password);
}
