package com.example.integratedsystem.controllers;

import com.example.integratedsystem.dao.AppointmentRepo;
import com.example.integratedsystem.dao.AssistantRepo;
import com.example.integratedsystem.dao.NurseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sound.midi.SysexMessage;

@Controller
public class doctorController {
    @Autowired
    private AppointmentRepo repo;
    @Autowired
    private AssistantRepo repo2;
    @Autowired
    private NurseRepo repo3;

    @RequestMapping("/doctor")
    public String doctorHomePage()
    {
        return "doctorHomePage.html";
    }

    @RequestMapping("/fetchAppointmentDataByFilter")
    public String fetchAppointmentDataByFilter(@Param("patientName") String patientName , Model model){
        model.addAttribute("list" , repo.findByName(patientName));
        return "appointmentDetails.html";
    }

    @RequestMapping("/doctorAssistantDetails")
    public String doctorAssistantDetails(Model model){
        return "doctorAssistantDetails.html";
    }

    @RequestMapping("/fetchAssistantDetailsByFilter")
    public String fetchAssistantDetailsByFilter(@Param("doctorName") String doctorName , Model model){
        model.addAttribute("list" ,repo2.fetchAssistantDetailsByDoctorName(doctorName));
        model.addAttribute("list", repo3.fetchNurseDetailsByDoctorName(doctorName));
        return "doctorAssistantDetails.html";
    }

}
