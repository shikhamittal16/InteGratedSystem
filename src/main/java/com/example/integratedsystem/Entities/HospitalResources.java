package com.example.integratedsystem.Entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HospitalResources {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;
    @Column(nullable = false)
    private String resourceName;
    @Column(nullable = false)
    private String quantity;
    @Column(nullable = false)
    private String managedBy;
    @Column(nullable = false)
    private String contactNo;

}

