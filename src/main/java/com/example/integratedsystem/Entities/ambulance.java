package com.example.integratedsystem.Entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ambulance {
    @Id
    private String ambulanceNo;
    @Column(nullable = false)
    private String driverName;
    @Column(nullable = false)
    private String driverPhn;
    @Column(nullable = false)
    private String driverAddress;
    @Column(nullable = false)
    private String driverAadhar;
    @Column(nullable = false)
    private String nurseName;
    @Column(nullable = false)
    private String nursePhn;
    @Column(nullable = false)
    private String nurseAddress;
    @Column(nullable = false)
    private String nurseAadhar;
}
