package com.example.web;

import com.example.entities.Patient;
import com.example.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    /*public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }*/

    @GetMapping("/index")
    public String index(Model model){
        List<Patient> patients = patientRepository.findAll();
        model.addAttribute("listPatients", patients);
        return "Patients";
    }

    @GetMapping("/deletePatient")
    public String delete(@RequestParam(name = "id") Long id){
        patientRepository.deleteById(id);
        return "redirect:/index";
    }

}

