package com.example.integratedsystem.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Assistant {
    @Id
    @Column(nullable = false , unique = true)
    private String emailId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false)
    private String qualification;
    @Column(nullable = false)
    private String specialization;
    @Column(nullable = false)
    private String mobileNo;
    @Column(nullable = false)
    private String joiningDate;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String state;
    @Column(nullable = false)
    private String trainingPeriod;
    @Column(nullable = false)
    private String seniorName;
    @Column(nullable = false)
    private String timings;
    @Column(nullable = false , unique = true)
    private String aadharId;
    @Column(nullable = false , unique = true)
    private String panId;
    @Column(nullable = false)
    private String dob;
    @Column(nullable = false)
    private Long salary;
}
