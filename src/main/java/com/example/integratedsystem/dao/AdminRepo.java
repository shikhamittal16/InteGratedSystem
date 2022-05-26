package com.example.integratedsystem.dao;

import com.example.integratedsystem.Entities.Admin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepo extends CrudRepository<Admin, Integer> {

    @Query("SELECT u FROM Admin u WHERE u.name = ?1 AND u.loginId = ?2 AND u.password = ?3")
    Admin findByNameLoginIdAndPassword(String name , String loginId , String password);
}
