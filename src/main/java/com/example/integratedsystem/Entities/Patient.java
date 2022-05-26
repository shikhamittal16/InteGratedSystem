package com.example.integratedsystem.Entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;
    @Column(nullable = false)
    private String fullname;
    @Column(nullable = false)
    private Integer age;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false , unique = true)
    private String phn;
    @Column(nullable = false)
    private String doctorname;
    @Column(nullable = false)
    private String department;
    @Column(nullable = false)
    private String bloodgroup;
    @Column(nullable = false)
    private String bloodpressure;
    @Column(nullable = false)
    private String bloodsugar;
    @Column(nullable = false , unique = true)
    private String aadhar;
    @Column(nullable = false)
    private String patientcondition;

}
