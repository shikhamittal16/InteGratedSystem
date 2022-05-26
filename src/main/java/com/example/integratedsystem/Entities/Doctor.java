package com.example.integratedsystem.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false , unique = true)
    private Integer id;
    @Column(nullable = false)
    private String name ;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false)
    private String DOB;
    @Column(nullable = false)
    private String qualification;
    @Column(nullable = false)
    private String specialization;
    @Column(nullable = false , unique = true)
    private String aadharId;
    @Column(nullable = false , unique = true)
    private String panId ;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String state;
    @Column(nullable = false , unique = true)
    private String phnNo;
    @Column(nullable = false , unique = true)
    private String emailId;
    @Column(nullable = false)
    private String joiningDate;
    @Column(nullable = false , unique = true)
    private String loginId;
    @Column(nullable = false ,  unique = true)
    private String password;
    @Column(nullable = false)
    private String timings ;
    @Column(nullable = false)
    private String availability;
}
