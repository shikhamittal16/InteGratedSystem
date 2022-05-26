package com.example.integratedsystem.Entities;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "Staff")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Staff {
    @Id
    @Column(nullable = false)
    private String aadharId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String phnNo;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String state;
    @Column(nullable = false)
    private String position;
    @Column(nullable = false)
    private String panId;
    @Column(nullable = false)
    private String loginId;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String bankAccount;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false)
    private Long salary;
    @Column(nullable = false)
    private String timings;
    @Column(nullable = false)
    private String joiningDate;
    @Column(nullable = false)
    private String availability;

}
