package com.example.integratedsystem.Entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class bloodDetails {
    @Id
    private String bloodGroup;
    private Float quantity;
}
