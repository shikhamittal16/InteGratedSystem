package com.example.integratedsystem.dao;

import com.example.integratedsystem.Entities.Medicines;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MedicineRepo extends CrudRepository<Medicines , String> {

    @Query("SELECT u FROM Medicines u where u.medicineName = ?1")
    List<Medicines> searchMedicinesByMedicineName(String name);
}
