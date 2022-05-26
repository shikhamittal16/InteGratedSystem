package com.example.integratedsystem.Service;


import com.example.integratedsystem.DataObject.StaffDTO;
import com.example.integratedsystem.dao.StaffRepo;
import com.example.integratedsystem.Entities.SearchCriteriaDataObject;
import com.example.integratedsystem.Entities.Staff;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Service
@Configuration
public class AdminService {

     @Autowired
     private StaffRepo staffDao;

    public StaffDTO getStaffDetails(SearchCriteriaDataObject searchCriteriaDataObject){
        StaffDTO staffDTO = new StaffDTO();
        try{
            List<Staff> staffList = (List<Staff>) staffDao.findAll();
            staffDTO.setData(staffList);
            return staffDTO;
        }catch(Exception ex){
            throw ex;
        }
    }
}
