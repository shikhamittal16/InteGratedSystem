package com.example.integratedsystem.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Medicines {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false , unique = true)
    private Integer id;
    @Column(nullable = false , unique = true)
    private String medicineName;
    @Column(nullable = false)
    private String quantity;
    @Column(nullable = false)
    private String manufactureDate;
    @Column(nullable = false)
    private String expiryDate;
    @Column(nullable = false)
    private BigDecimal price;
}
