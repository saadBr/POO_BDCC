package ma.enset.gestionconsultation.service;

import javafx.collections.ObservableList;
import ma.enset.gestionconsultation.entities.Consultation;
import ma.enset.gestionconsultation.entities.Patient;

import java.util.List;

public interface ICabinetService {
    void ajouterPatient(Patient patient);
    void supprimerPatient(Patient patient);
    void modifierPatient(Patient patient);
    Patient getPatientById(int id);
    List<Patient> getAllPatient();
    ObservableList<Patient> getPatients();
    void refreshPatients();
    List<Patient> searchByQuery(String query);
    void ajouterConsultation(Consultation consultation);
    void supprimerConsultation(Consultation consultation);
    void modifierConsultation(Consultation consultation);
    Consultation getConsultationById(int id);
    List<Consultation> getAllConsultation();


}
