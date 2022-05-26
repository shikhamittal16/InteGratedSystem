package com.example.integratedsystem.dao;

import com.example.integratedsystem.Entities.bloodDonor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface DonorRepo extends CrudRepository<bloodDonor , Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM bloodDonor u where u.id = ?1")
    void deleteDonorDetailsById(Integer id);

    @Query("SELECT u from bloodDonor  u where u.id= ?1")
    Optional<bloodDonor> findById(Integer id);

    @Query("SELECT u from bloodDonor u where u.donorName= ?1")
    List<bloodDonor> findByName(String name);
}
