package ma.enset.gestionconsultation.web;

import ma.enset.gestionconsultation.entity.Patient;
import ma.enset.gestionconsultation.service.CabinetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PatientController {
    private CabinetService cabinetService;

    public PatientController(CabinetService cabinetService) {
        this.cabinetService = cabinetService;
    }

    @GetMapping("/patients")
    public String getPatients(Model model){
        List<Patient> patients=cabinetService.getAllPatients();
        model.addAttribute("patients",patients);
        return "patients";
    }
    @GetMapping("/patients/new")
    public String newPatient(Model model){
        Patient patient = new Patient();
        model.addAttribute("patient",patient);
        return "add_patient";
    }
    @PostMapping("/patients")
    public String savePatient(@ModelAttribute Patient patient){
        cabinetService.savePatient(patient);
        return "redirect:/patients";
    }
@GetMapping("/deletePatient")
    public String deletePatient(@RequestParam("id") Long id){
        cabinetService.deletePatientById(id);
        return "redirect:/patients";
    }
@GetMapping("/patients/edit/{id}")
    public String editPatient(Model model,@PathVariable("id")Long id){
        Patient patient=cabinetService.getPatientById(id);
        model.addAttribute("patient",patient);
        return "edit_patient";


    }

}
