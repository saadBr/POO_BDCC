package ma.enset.gestionconsultation.entities;

import java.util.List;

public class Patient {
    private int id_patient;
    private String nom;
    private String prenom;
    private String tel;
    private List<Consultation> consultations;

    public Patient(String nom, String prenom, String tel) {
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
    }
    public Patient() {
    }
    public int getId_patient() {
        return id_patient;
    }
    public void setId_patient(int id_patient) {
        this.id_patient = id_patient;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }

    @Override
    public String toString() {
        return prenom+" "+nom;
    }
}
