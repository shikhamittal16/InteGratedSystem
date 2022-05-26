package com.example.integratedsystem.controllers;

import com.example.integratedsystem.dao.AppointmentRepo;
import com.example.integratedsystem.dao.DoctorRepo;
import com.example.integratedsystem.dao.PatientRepo;
import com.example.integratedsystem.Entities.Appointment;
import com.example.integratedsystem.Entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class receptionistController {

    @Autowired
    private AppointmentRepo repo1;
    @Autowired
    private PatientRepo repo2;
    @Autowired
    private DoctorRepo repo3;

    @RequestMapping("/reception")
    public String receptionistHomePage()
    {
        return "receptionistHomePage.html";
    }

    @RequestMapping("/newAppointment")
    public String newAppointment(Model model)
    {
        return "newAppointment.html";
    }

    @RequestMapping("/saveAppointment")
    @ResponseBody
    public String saveAppointment(Appointment app)
    {
        try {
            if(app.getGender().equalsIgnoreCase("not selected"))
            {
                return "select gender";
            }
            else if(app.getDepartment().equalsIgnoreCase("not selected"))
            {
                return "select dept";
            }
            else if(app.getFirstname().equals("") || app.getLastname().equals(""))
            {
                return "select name";
            }
            else {
                repo1.save(app);
                return "success";
            }
        }catch(Exception ex)
        {
            return "fail";
        }
    }

    @RequestMapping("/newPatient")
    public String newPatient()
    {
        return "newPatient.html";
    }

    @RequestMapping("/savePatient")
    @ResponseBody
    public String savePatientDetails(Patient patient)
    {
        try {
            if(patient.getBloodgroup().equalsIgnoreCase("not selected") || patient.getDepartment().equalsIgnoreCase("not selected")
            || patient.getBloodpressure().equalsIgnoreCase("not selected") || patient.getFullname().equals("")
        || patient.getAge()=='\0' || patient.getGender().equalsIgnoreCase("not selected") || patient.getDoctorname().equals("")
            || patient.getBloodsugar().equals("") || patient.getPatientcondition().equals(""))
            {
               return "incomplete";
            }
            else {
                repo2.save(patient);
                return "success";
            }
        }catch(DataIntegrityViolationException ex){
            return "exist";
        }
        catch (Exception ex){
            System.out.println(ex);
            return "fail";
        }
    }

    @RequestMapping("/drInfoAtReceptionHomePage")
    public String drInfoAtReceptionHomePage(Model model){
        model.addAttribute("doctorListForReceptionHomePage", repo3.findAll());
        return "DrInfoAtReceptionHomePage.html";
    }
}
