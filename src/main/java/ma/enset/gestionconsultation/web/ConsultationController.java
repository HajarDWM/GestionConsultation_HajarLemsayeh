package ma.enset.gestionconsultation.web;

import ma.enset.gestionconsultation.entity.Consultation;
import ma.enset.gestionconsultation.entity.Patient;
import ma.enset.gestionconsultation.service.CabinetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Controller
@RequestMapping("/consultation")
public class ConsultationController {
    public CabinetService cabinetService;

    public ConsultationController(CabinetService cabinetService) {
        this.cabinetService = cabinetService;
    }

    @GetMapping
    public String getConsultation(Model model){
        List<Consultation> consultationList= cabinetService.getAllConsultation();
        model.addAttribute("consultationList",consultationList);
        return "consultationList";
    }

    @GetMapping("/new")
    public String addConsultation(Model model){
        List<Patient> patients=cabinetService.getAllPatients();
        Consultation consultation = new Consultation();
        model.addAttribute("patients",patients);
        model.addAttribute("consultation",consultation);
        return "add_consultation";
    }

    @PostMapping
    public String saveConsultation(@ModelAttribute Consultation consultation, @RequestParam Long idPatient) {
        cabinetService.saveConsultation(consultation,idPatient);

        return "redirect:/consultation";
    }
    @GetMapping("/deleteConsultation")
    public String deleteConsultation(@RequestParam("id") Long id){
        Consultation consultation = cabinetService.getConsultationById(id);
        cabinetService.deletConsultationById(id);
        return "redirect:/consultation";
    }
    @GetMapping("/getById/{id}")
    public String getConsultationById(Model model,@PathVariable("id")Long id){
        Consultation consultation = cabinetService.getConsultationById(id);
       model.addAttribute("consultation", consultation);
        model.addAttribute("patients", cabinetService.getAllPatients());
        return "edit_consultation";


    }

    @PostMapping("/update")
    public String updateConsultation(@ModelAttribute Consultation consultation) {
        System.out.println(" Id Patient"+consultation.getPatient().getIdPatient());
        Long idPatient = consultation.getPatient().getIdPatient();
        cabinetService.saveConsultation(consultation, idPatient);
        return "redirect:/consultation";
    }





}
