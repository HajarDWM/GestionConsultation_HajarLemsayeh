package ma.enset.gestionconsultation.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
@Entity

public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConsultation;
    private Date dateConsultation;
    @Column(length = 300)
    private String description;
    @ManyToOne
    private Patient patient;

    public Consultation() {
    }

    public Consultation(Long idConsultation, Date dateConsultation, String description, Patient patient) {
        this.idConsultation = idConsultation;
        this.dateConsultation = dateConsultation;
        this.description = description;
        this.patient = patient;
    }

    public Long getIdConsultation() {
        return idConsultation;
    }

    public void setIdConsultation(Long idConsultation) {
        this.idConsultation = idConsultation;
    }

    public Date getDateConsultation() {
        return dateConsultation;
    }

    public void setDateConsultation(Date dateConsultation) {
        this.dateConsultation = dateConsultation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Consultation{" +
                "idConsultation=" + idConsultation +
                ", dateConsultation=" + dateConsultation +
                ", description='" + description + '\'' +
                ", patient=" + patient +
                '}';
    }
}
