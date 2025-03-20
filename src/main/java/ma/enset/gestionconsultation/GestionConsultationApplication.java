package ma.enset.gestionconsultation;

import lombok.Data;
import ma.enset.gestionconsultation.entity.Consultation;
import ma.enset.gestionconsultation.entity.Patient;
import ma.enset.gestionconsultation.repository.ConsultationRepository;
import ma.enset.gestionconsultation.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;

@SpringBootApplication
public class GestionConsultationApplication implements CommandLineRunner {

    PatientRepository patientRepository;
    ConsultationRepository consultationRepository;
@Autowired
    public GestionConsultationApplication(PatientRepository patientRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.consultationRepository = consultationRepository;
    }

    public GestionConsultationApplication(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(GestionConsultationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
      /*  Patient patient=new Patient();
        patient.setNom("Chihab");
        patient.setPrenom("BenMoussa");
        patient.setEmail("Chihab@gmail.com");
        patient.setTel("0654789632");
        patientRepository.save(patient);*/

        Patient patient= patientRepository.findById(2L).get();
        /*patient.setNom("Hajar");
        patient.setPrenom("Lemsayeh");
        patient.setEmail("Hajar@gmail.com");
        patient.setTel("0652317895");
        patientRepository.save(patient);

        Patient patient1=patientRepository.findById(3L).get();
        patient1.setNom("Fayssal");
        patient1.setPrenom("BenMoussa");
        patient1.setEmail("Fayssal@gmail.com");
        patient1.setTel("0632147895");
        patientRepository.save(patient1);*/

        /*Consultation consultation= new Consultation();
        LocalDate date=LocalDate.of(2024,Month.APRIL,25);

        consultation.setDateConsultation(Date.valueOf(date));
        consultation.setDescription("test_1_Consultation");
        consultation.setPatient(patient);
        consultationRepository.save(consultation);*/

    }
}
