package com.example.integratedsystem.controllers;
import com.example.integratedsystem.DataObject.MedicineDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PharmacyController {

    @RequestMapping("/addMedicine")
    public String getAddMedicinePage() {
        return "addMedicines.html";
    }

    @RequestMapping("/medicinelist")
    public String getAllMedicineDetails() {
        return "medicineList.html";
    }

    @RequestMapping("/surgicalRequisites")
    public String getSurgicalRequisites() {
        return "surgicalRequisities.html";
    }

    @RequestMapping("/otherProducts")
    public String getOtherProductsPage() {
        return "OtherProducts.html";
    }

    @RequestMapping("/dispensing")
    public String getDispensingPage() {
        return "DispensingPage.html";
    }
}
//    @RequestMapping("/fetchMedicineDetails")
//    public MedicineDTO fetchAllMedicineDetails(){
//        MedicineDTO medicineDTO = new MedicineDTO();
//        try{
//
//            return medicineDTO;
//        }catch(Exception ex){
//               throw ex;
//        }
//}
