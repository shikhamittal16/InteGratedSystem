package com.example.integratedsystem.DataObject;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Getter
@Setter
public class MedicineDataObject {
    private String medicineName;
    private String quantity;
    private String manufactureDate;
    private String expiryDate;
    private BigDecimal price;
}
