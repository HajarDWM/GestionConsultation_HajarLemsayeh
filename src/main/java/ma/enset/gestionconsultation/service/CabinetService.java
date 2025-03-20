package ma.enset.gestionconsultation.service;

import ma.enset.gestionconsultation.entity.Consultation;
import ma.enset.gestionconsultation.entity.Patient;

import java.util.List;

public interface CabinetService {
     void savePatient(Patient patient) ;

    List<Patient> getAllPatients();
    Patient getPatientById(Long id);

    void deletePatient(Patient patient);
    void deletePatientById(Long id);





    void addConsultation(Consultation consultation, Long idPatient);

    List<Consultation> getAllConsultation();

    void saveConsultation(Consultation consultation, Long id);
    void deletConsultation(Consultation consultation);
    void deletConsultationById(Long id);
    Consultation getConsultationById(Long id);
}
