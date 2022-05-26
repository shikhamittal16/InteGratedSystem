package com.example.integratedsystem.Entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String phn;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private String doctorname;
    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private String aadharno;

    @Column(nullable = false)
    private Float fees;

    @Column(nullable = false)
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date date;

}
