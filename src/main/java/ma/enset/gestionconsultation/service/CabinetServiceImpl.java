package ma.enset.gestionconsultation.service;

import ma.enset.gestionconsultation.entity.Consultation;
import ma.enset.gestionconsultation.entity.Patient;
import ma.enset.gestionconsultation.repository.ConsultationRepository;
import ma.enset.gestionconsultation.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CabinetServiceImpl implements CabinetService {
    private final PatientRepository patientRepository;
    private final ConsultationRepository consultationRepository;

    public CabinetServiceImpl(PatientRepository patientRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public void savePatient(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePatient(Patient patient) {
        patientRepository.delete(patient);
    }

    @Override
    public void deletePatientById(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public void addConsultation(Consultation consultation, Long idPatient) {
        Patient patient = patientRepository.findById(idPatient).orElse(null);
        if (patient != null) {
            consultation.setPatient(patient);
            consultationRepository.save(consultation);
        }
    }

    @Override
    public List<Consultation> getAllConsultation() {
        return consultationRepository.findAll();
    }

    @Override
    public List<Consultation> getConsultationsByMonth(YearMonth month) {
        return consultationRepository.findAll().stream()
                .filter(c -> YearMonth.from(c.getDateConsultation().toLocalDate()).equals(month))
                .collect(Collectors.toList());
    }

    @Override
    public List<Consultation> getConsultationsByDate(LocalDate date) {
        return consultationRepository.findAll().stream()
                .filter(c -> c.getDateConsultation().toLocalDate().equals(date))
                .collect(Collectors.toList());
    }

    @Override
    public List<Consultation> getLatestConsultations() {
        return consultationRepository.findAll().stream()
                .filter(c -> c.getPatient() != null) // Ensure patient is not null
                .sorted((c1, c2) -> c2.getDateConsultation().compareTo(c1.getDateConsultation()))
                .limit(3)
                .collect(Collectors.toList());
    }

    @Override
    public void saveConsultation(Consultation consultation, Long idPatient) {
        consultationRepository.save(consultation);
    }

    @Override
    public Consultation getConsultationById(Long id) {
        return consultationRepository.findById(id).orElse(null);
    }

    @Override
    public void deletConsultation(Consultation consultation) {
        consultationRepository.delete(consultation);
    }

    @Override
    public void deletConsultationById(Long id) {
        consultationRepository.deleteById(id);
    }
}