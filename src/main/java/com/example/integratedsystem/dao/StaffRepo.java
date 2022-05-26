package com.example.integratedsystem.dao;
import com.example.integratedsystem.Entities.Staff;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepo extends CrudRepository<Staff,Integer> {

    @Query("SELECT u FROM Staff u WHERE u.name like %?1% AND u.position like 'receptionist' ")
    List<Staff> searchReceptionistByName(String name);

    @Query("SELECT u FROM Staff u WHERE u.name like %?1% AND u.position <> 'receptionist' ")
    List<Staff> searchStaffByName(String name);

    @Query("SELECT u FROM Staff u WHERE u.name = ?1 AND u.loginId = ?2 AND u.password = ?3")
    Staff findByNameLoginIdAndPassword(String name , String loginId , String password);

    @Query("SELECT u FROM Staff u WHERE u.position like 'receptionist'")
    List<Staff> searchAllReceptionist(String name);

}
