package com.example.integratedsystem.controllers;

import com.example.integratedsystem.dao.*;
import com.example.integratedsystem.Entities.Admin;
import com.example.integratedsystem.Entities.Patient;
import com.example.integratedsystem.Entities.Staff;
import com.example.integratedsystem.Entities.Doctor;
import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.print.Doc;

@Controller
public class commonController {

    @Autowired
    private AppointmentRepo repo1;
    @Autowired
    private PatientRepo repo2;
    @Autowired
    private DoctorRepo repo3;
    @Autowired
    private StaffRepo repo4;
    @Autowired
    private AdminRepo repo5;
    private String name;
    private String loginId;
    private String password;

    @RequestMapping("/login")
    public String loginPage()
    {
        return "loginPage.html";
    }

    @RequestMapping("/website")
    public String website()
    {
        return "website.html";
    }

    @RequestMapping("/app_details")
    public String getAppointmentDetails(Model model){
        model.addAttribute("list",repo1.findAll());
        return "appointmentDetails.html";
    }

    @RequestMapping("/patient_detail")
    public String getPatientDetail(Model model){
        model.addAttribute("list", repo2.findAll());
        return "patientDetails.html";
    }

    @RequestMapping("patientSearch_1")
    public String patientSearch_1(Patient p , Model model){
       model.addAttribute("list",repo2.searchByPhn(p.getPhn()));
       return "patientDetails.html";
    }

    @RequestMapping("/patientSearch_2")
    public String patientSearch_2(@Param("aadhar") String aadhar, Model model){
        model.addAttribute("list", repo2.searchByAadhar(aadhar));
        return "patientDetails.html";
    }

    @RequestMapping("/homePage")
    public String homePage(RedirectAttributes ra , @Param("loginId") String loginId , @Param("password") String password , @Param("name") String name){
        this.name = name;
        this.loginId = loginId;
        this.password = password;
        try {
            if (loginId !=null && loginId.startsWith("admin")) {
                Admin data = repo5.findByNameLoginIdAndPassword(name,loginId,password);
                if(data != null) {
                    return "adminHomePage.html";
                }
                else{
                    ra.addFlashAttribute("msg", "Invalid login credentials");
                   return "redirect:/login";
                }
            }
            if (loginId !=null && loginId.startsWith("recep")) {
                Staff data = repo4.findByNameLoginIdAndPassword(name,loginId,password);
                if(data != null) {
                    return "receptionistHomePage.html";
                }
                else{
                    ra.addFlashAttribute("msg", "Invalid login credentials");
                    return "redirect:/login";
                }
            }
            if (loginId !=null && loginId.startsWith("dr")){
                Doctor data = repo3.findByNameLoginIdAndPassword(name,loginId,password);
                if(data != null) {
                    return "doctorHomePage.html";
                }
                else{
                    ra.addFlashAttribute("msg", "Invalid login credentials");
                    return "redirect:/login";
                }
            }
            else{
                ra.addFlashAttribute("msg", "Invalid login credentials");
                return "redirect:/login";
            }
        }catch(Exception ex){
            ra.addFlashAttribute("msg", "Something went Wrong");
            return "redirect:/login";
        }
    }

    @RequestMapping("/myProfile")
    public String myProfile(Model model , RedirectAttributes ra){
        System.out.println(name);
        System.out.println(loginId);
        if (loginId !=null && loginId.startsWith("admin")){
            Admin data = repo5.findByNameLoginIdAndPassword(name,loginId,password);
            if(data != null){
                model.addAttribute("data" , data);
            }
            else{
                ra.addFlashAttribute("msg", "User Not Found");
            }
        }
        if (loginId !=null && loginId.startsWith("recep")){
            Staff data = repo4.findByNameLoginIdAndPassword(name,loginId,password);
            if(data != null) {
                model.addAttribute("data" , data);
            }
            else{
                ra.addFlashAttribute("msg", "User Not Found");
            }
        }
        if (loginId !=null && loginId.startsWith("dr")){
            Doctor data = repo3.findByNameLoginIdAndPassword(name,loginId,password);
            if(data != null) {
                model.addAttribute("data" , data);
            }
            else{
                ra.addFlashAttribute("msg", "User Not Found");
            }
        }
            return "myProfile.html";
    }

    @RequestMapping("/editMyProfile")
    public String editMyProfile(RedirectAttributes ra , Admin admin , Doctor doctor , Staff staff){
        if(loginId.startsWith("admin")){
            repo5.save(admin);
        }
        else if(loginId.startsWith("dr")){
            repo3.save(doctor);
        }
        else if(loginId.startsWith("recep")){
            repo4.save(staff);
        }
        ra.addFlashAttribute("msg", "Information has been Saved Successfully");
        return "redirect:/myProfile";
    }

    @RequestMapping("/searchDoctorByNameAndDepartment")
    public String searchDoctorByNameAndDepartment(Model model ,@Param("name") String name , @Param("department") String department , @Param("disorder") String disorder){
        if(department != "" && name != ""){
            model.addAttribute("list" , repo3.searchByDoctorNameAndDepartment(name , department));
        }
        if(disorder!= "" && name != ""){
            model.addAttribute("list", repo3.searchByDoctorNameAndDepartment(name , disorder));
        }

        if(name != "" && department == "" && disorder == ""){
            model.addAttribute("list", repo3.searchDoctorByName(name));
        }
        if(department != "" && name == "" && disorder == ""){
            model.addAttribute("list" , repo3.searchDoctorByDepartment(department));
        }
        if(disorder != "" && name == "" && department == ""){
            model.addAttribute("list" , repo3.searchDoctorByDepartment(disorder));
        }
        if(name == "" && department != "" && disorder != ""){
            model.addAttribute("list" , repo3.searchDoctorByDepartment(department));
        }
        if(name != "" && disorder != "" && department != ""){
            model.addAttribute("list" , repo3.searchByDoctorNameAndDepartment(name , department));
        }
        else if(name == "" && disorder == "" && department == ""){
            model.addAttribute("list" , repo3.findAll());
        }
        return "DrInfoAtReceptionHomePage.html";
    }

    @RequestMapping("/backToSpecificPage")
    public String backToSpecificPage(){
        if(loginId != null) {
            if (loginId.startsWith("admin")) {
                return "adminHomePage.html";
            }
            if (loginId.startsWith("dr")) {
                return "doctorHomePage.html";
            }
            if (loginId.startsWith("recep")) {
                return "receptionistHomePage.html";
            } else {
                return "login.html";
            }
        }
        else {
            return "login.html";
        }
    }

    @RequestMapping("/editPatientDetails/{id}")
    public String editPatientDetails(@PathVariable("id") Integer id , Model model){
        model.addAttribute("data" , repo2.findPatientById(id));
        return "newPatient.html";
    }

    @RequestMapping("/assistantOrNurseInfoSave")
    public String saveAssistantOrNurseInfo(){

    }

}


