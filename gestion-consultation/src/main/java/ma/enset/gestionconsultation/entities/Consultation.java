package ma.enset.gestionconsultation.entities;

import java.sql.Date;

public class Consultation {
    private int id_consultation;
    private Date date_consultation;
    private String description;
    public Patient patient;

    public Consultation(Date date_consultation, String description,Patient patient) {
        this.date_consultation = date_consultation;
        this.description = description;
        this.patient = patient;
    }
    public Consultation() {
    }
    public int getId_consultation() {
        return id_consultation;
    }
    public void setId_consultation(int id_consultation) {
        this.id_consultation = id_consultation;
    }
    public Date getDate_consultation() {
        return date_consultation;
    }
    public void setDate_consultation(Date date_consultation) {
        this.date_consultation = date_consultation;
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
}
