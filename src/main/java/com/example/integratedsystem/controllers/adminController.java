package com.example.integratedsystem.controllers;

import com.example.integratedsystem.Service.JasperService;
import com.example.integratedsystem.Service.AdminService;
import com.example.integratedsystem.dao.*;
import com.example.integratedsystem.Entities.*;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.FileNotFoundException;
import java.util.List;

@Controller
public class adminController {
    @Autowired
    private DoctorRepo repo1;
    @Autowired
    private DonorRepo repo2;
    @Autowired
    private BloodDetailsRepo repo3;
    @Autowired
    private AmbulanceRepo repo4;
    @Autowired
    private JasperService service;
    @Autowired
    private AdminService adminService;
    @Autowired
    private NurseRepo repo5;
    @Autowired
    private AssistantRepo repo6;
    @Autowired
    private StaffRepo repo7;

    @RequestMapping("/home")
    public String adminHomePage(){
        try {
            return "adminHomePage.html";
        }catch(Exception ex){
            throw ex;
        }
    }

    @RequestMapping("/newDoctor")
    public String addNewDoctor(Model model){
        try {
            model.addAttribute("data", new Doctor());
            return "newDoctor.html";
        }catch(Exception ex){
            throw ex;
        }
    }

    @RequestMapping("/DrList")
    public String getDoctorList(Model model){
        try {
            model.addAttribute("list", repo1.findAll());
            return "doctorDetails.html";
        }catch(Exception ex){
            throw ex;
        }
    }

    @RequestMapping("/deleteDoctor/{id}")
    public String deleteDoctorInfoById(@PathVariable("id") Integer id , RedirectAttributes ra){
        try {
            repo1.deleteDoctorInformationById(id);
            ra.addFlashAttribute("msg" , "Doctor's Information has been Deleted Successfully");
            return "redirect:/DrList";
        }catch(Exception ex){
            ra.addFlashAttribute("msg2", "Something went Wrong");
            throw ex;
        }
    }

    @RequestMapping("/newStaff")
    public String newPatientDetails(Model model){
        try {
            model.addAttribute("data", new Staff());
            return "newStaff.html";
        }catch(Exception ex){
            throw ex;
        }
    }

    @RequestMapping("/newDonor")
    public String newDonorDetails(){
        try {
            return "newDonor.html";
        }catch(Exception ex){
            throw ex;
        }
    }

    @RequestMapping("/saveDonorDetails")
    public String saveBloodDonorDetails(bloodDonor donor){
        try {
            repo2.save(donor);
            return "redirect:/getDonorList";
        }catch(Exception ex){
            throw ex;
        }
    }

    @RequestMapping("/getDonorList")
    public String getDonorList(Model model){
        try {
            model.addAttribute("list", repo2.findAll());
            return "donorDetails.html";
        }catch(Exception ex){
            throw ex;
        }
    }

    @RequestMapping("/getBloodBankDetails")
    public String getBloodBankDetails(Model model){
        try {
            model.addAttribute("list", repo3.findAll());
            return "bloodBankDetails.html";
        }catch(Exception ex){
            throw ex;
        }
    }


    @RequestMapping("/generatecertificate/{id}")
    public ResponseEntity<byte[]> generateCertificate(@PathVariable("id") Integer id) throws FileNotFoundException, JRException {
        return service.generateCertificate(id);
    }

    @RequestMapping("deleteDonor/{id}")
    public String deleteDonorDetailsById(@PathVariable("id") Integer id){
        try {
            repo2.deleteDonorDetailsById(id);
            return "redirect:/getDonorList";
        }catch(Exception ex){
            throw ex;
        }
    }

    @RequestMapping("/donorsearch")
    public String searchDonorById(@Param("donorName") String donorName , Model model){
        try {
            List<bloodDonor> list = repo2.findByName(donorName);
            model.addAttribute("list", list);
            return "redirect:/getDonorList";
        }catch(Exception ex){
            throw ex;
        }
    }

    @RequestMapping("/pharmacy")
    public String pharmacyHomePage(){
        try {
            return "pharmacyHomePage.html";
        }catch(Exception ex){
            throw ex;
        }
    }

    @RequestMapping("/newrecep")
    public String newReceptionist(Model model){
        try {
            model.addAttribute("data", new Staff());
            return "newStaff.html";
        }catch(Exception ex){
            throw ex;
        }
    }

    @RequestMapping("/drsave")
    public String saveDoctorInformation(Doctor dr , RedirectAttributes ra){
        try{
            repo1.save(dr);
            ra.addFlashAttribute("msg", "Doctor Information has been saved successfully");
            return "redirect:/newDoctor";
        }catch(DataIntegrityViolationException ex){
           ra.addFlashAttribute("msg2", "Doctor's Personal Information must be unique like aadharId , PanId , LoginId , Password etc");
           return "redirect:/newDoctor";
        }
        catch(Exception ex){
            throw ex;
        }
    }

    @RequestMapping("/back")
    public String backtoAdminNomePage(){
        try {
            return "adminHomePage.html";
        }catch(Exception ex){
            throw ex;
        }
    }

    @RequestMapping("/getAmbulancePage")
    public String ambulancePage(){
        try {
            return "ambulance.html";
        }catch(Exception ex){
            throw ex;
        }
    }

    @RequestMapping("/getAmbulanceDetails")
    public String getAmbulanceList(Model model){
        try {
            model.addAttribute("list", repo4.findAll());
            return "ambulanceDetails.html";
        }catch(Exception ex){
            throw ex;
        }
    }

    @RequestMapping("/saveambulance")
    public String saveAmbulanceInformation(ambulance ambulance){
        try {
            repo4.save(ambulance);
            return "redirect:/getAmbulanceDetails";
        }catch(Exception ex){
            throw ex;
        }
    }

    @RequestMapping("/staffList")
    public String getStaffDetails(){
        try {
            return "staffList.html";
        }catch(Exception ex){
            throw ex;
        }
    }

    @RequestMapping("/searchStaffByName")
    public String fetchStaffDetail(@Param("name") String name,Model model){
        try{
            model.addAttribute("list", repo7.searchStaffByName(name));
            return "staffList.html";
        }catch(Exception ex){
            throw ex;
        }
    }

    @RequestMapping("/hospitalResources")
    public String getHospitalResources(){
        try {
            return "HospitalResources.html";
        }catch(Exception ex){
            throw ex;
        }
    }

    @RequestMapping("/newAssistant")
    public String getNewAssistantDetails(Model model){
        try {
            model.addAttribute("data", new Assistant());
            return "newAssistant.html";
        }catch(Exception ex){
                throw ex;
        }
    }

    @RequestMapping("/newNurse")
    public String getNewNurseDetails(Model model){
        try {
            model.addAttribute("data", new Nurse());
            return "newNurse.html";
        }catch(Exception ex){
            throw ex;
        }
    }

    @RequestMapping("/nurseList")
    public String getNurseDetails(Model model){
        try {
            model.addAttribute("list", repo5.findAll());
            return "NurseList.html";
        }catch(Exception ex){
            throw ex;
        }
    }

    @RequestMapping("/assistantList")
    public String getAssistantDetails(Model model){
        try {
            model.addAttribute("list", repo6.findAll());
            return "AssistantList.html";
        }catch(Exception ex){
            throw ex;
        }
    }

    @RequestMapping("/assistantInfoSave")
    public String saveAssistantInfo(Assistant assistant){
        try {
            repo6.save(assistant);
            return "redirect:/newNurse";
        }catch(Exception ex){
            throw ex;
        }
    }

    @RequestMapping("/searchDoctorByName")
    public String searchDoctorByName(@Param("name") String name , Model model){
        try {
            model.addAttribute("list", repo1.searchDoctorByName(name));
            return "doctorDetails.html";
        }catch(Exception ex){
            throw ex;
        }
    }

    @RequestMapping("/recepList")
    public String getReceptionistList(){
        try{
            return "ReceptionistList.html";
        }catch(Exception ex){
            throw ex;
        }
    }

    @RequestMapping("/saveStaff")
    public String saveStaffInformation(Staff staff , RedirectAttributes ra){
        try {
            repo7.save(staff);
            ra.addFlashAttribute("msg", "Staff Information has been saved Successfully");
            return "redirect:newStaff";
        }catch(Exception ex){
            ra.addFlashAttribute("msg2", "Something went Wrong");
            return "redirect:newStaff";
        }
    }

    @RequestMapping("/searchReceptionistByName")
    public String searchReceptionistByName(@Param("name") String name , Model model){
        try{
            model.addAttribute("list", repo7.searchReceptionistByName(name));
            return "ReceptionistList.html";
        }catch(Exception ex){
            throw ex;
        }
    }

    @RequestMapping("/newAdmin")
    public String createNewAdmin(Model model){
        try {
            model.addAttribute("data", new Admin());
            return "newAdmin.html";
        }catch(Exception ex){
            throw ex;
        }
    }

}

