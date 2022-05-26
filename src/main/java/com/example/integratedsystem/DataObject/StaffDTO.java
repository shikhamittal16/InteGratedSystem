package com.example.integratedsystem.DataObject;

import com.example.integratedsystem.Entities.Staff;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StaffDTO {
    private List<Staff> data;
}
