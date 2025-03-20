package ma.enset.gestionconsultation.service;

import ma.enset.gestionconsultation.entity.Consultation;
import ma.enset.gestionconsultation.entity.Patient;
import ma.enset.gestionconsultation.repository.ConsultationRepository;
import ma.enset.gestionconsultation.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CabinetServiceImpl implements CabinetService{
   private PatientRepository patientRepository;
   private ConsultationRepository consultationRepository;

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
        return patientRepository.findById(id).get();
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
       Patient patient= patientRepository.findById(idPatient).get();
       consultation.setPatient(patient);
        consultationRepository.save(consultation);

    }

    @Override
    public List<Consultation> getAllConsultation() {
        return consultationRepository.findAll();
    }

    @Override
    public void saveConsultation(Consultation consultation , Long idPatient) {
        consultationRepository.save(consultation);
    }



    @Override
    public Consultation getConsultationById(Long id) {
        return consultationRepository.findById(id).get();
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
