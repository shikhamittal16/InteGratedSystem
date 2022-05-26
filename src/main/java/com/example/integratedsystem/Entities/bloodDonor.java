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
public class bloodDonor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;
    @Column(nullable = false)
    private String donorName;
    @Column(nullable = false , unique = true)
    private String donorAge;
    @Column(nullable = false)
    private String date;
    @Column(nullable = false)
    private String mobileNo;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String donorBloodGroup;
    @Column(nullable = false)
    private String quantity;
}

