package com.example.integratedsystem.dao;


import com.example.integratedsystem.Entities.SearchCriteriaDataObject;
import com.example.integratedsystem.Entities.Staff;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Component("StaffRepo")
@Configuration
public interface IStaffDao {

    List<Staff> getAllStaffDetails(SearchCriteriaDataObject searchCriteriaDataObject);
}
