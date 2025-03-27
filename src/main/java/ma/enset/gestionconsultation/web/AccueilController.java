package ma.enset.gestionconsultation.web;

    import ma.enset.gestionconsultation.entity.Consultation;
    import ma.enset.gestionconsultation.service.CabinetService;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.GetMapping;

    import java.time.LocalDate;
    import java.time.YearMonth;
    import java.time.format.DateTimeFormatter;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Locale;
    import java.util.Map;

    @Controller
    public class AccueilController {

        private final CabinetService cabinetService;

        public AccueilController(CabinetService cabinetService) {
            this.cabinetService = cabinetService;
        }

        @GetMapping("/accueil")
        public String showAccueilPage(Model model) {
            int totalPatients = cabinetService.getAllPatients().size();
            int consultationsThisMonth = cabinetService.getConsultationsByMonth(YearMonth.now()).size();
            int consultationsToday = cabinetService.getConsultationsByDate(LocalDate.now()).size();
            List<Consultation> latestConsultations = cabinetService.getLatestConsultations();

            // Get consultations for the next 7 days
            Map<LocalDate, List<Consultation>> consultationsByDay = new HashMap<>();
            LocalDate today = LocalDate.now();
            for (int i = 0; i < 7; i++) {
                LocalDate date = today.plusDays(i);
                List<Consultation> consultations = cabinetService.getConsultationsByDate(date);
                consultationsByDay.put(date, consultations);
            }

            model.addAttribute("totalPatients", totalPatients);
            model.addAttribute("consultationsThisMonth", consultationsThisMonth);
            model.addAttribute("consultationsToday", consultationsToday);
            model.addAttribute("latestConsultations", latestConsultations);
            model.addAttribute("consultationsByDay", consultationsByDay);
            model.addAttribute("dates", consultationsByDay.keySet());
            model.addAttribute("currentMonthYear",
                    DateTimeFormatter.ofPattern("MMMM yyyy", Locale.FRENCH)
                            .format(LocalDate.now()).toUpperCase());
            return "accueil";
        }
    }