package com.example.integratedsystem.controllers;
import com.example.integratedsystem.DataObject.MedicineDTO;
import com.example.integratedsystem.Entities.Medicines;
import com.example.integratedsystem.dao.MedicineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.print.attribute.standard.PresentationDirection;

@Controller
public class PharmacyController {

    @Autowired
    private MedicineRepo repo1;

    @RequestMapping("/addMedicines")
    public String getAddMedicinePage(Model model) {
        model.addAttribute("data" , new Medicines());
        return "addMedicines.html";
    }

    @RequestMapping("/medicinelist")
    public String getAllMedicineDetails(Model model) {
        model.addAttribute("list" , repo1.findAll());
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

    @RequestMapping("/saveMedicines")
    public String saveMedicineInfo(Medicines medicines , RedirectAttributes ra){
        try{
            repo1.save(medicines);
            ra.addFlashAttribute("msg", "Medicine Details has been Saved Successfully");
            return "redirect:/addMedicines";
        }catch(Exception ex){
            ra.addFlashAttribute("msg2" , "Something went Wrong");
            return "redirect:/addMedicines";
        }
    }

    @RequestMapping("/searchMedicineByName")
    public String searchMedicineByName(@Param("name") String name , Model model){
        model.addAttribute("list" , repo1.searchMedicinesByMedicineName(name));
        return "medicinelist.html";
    }
}

