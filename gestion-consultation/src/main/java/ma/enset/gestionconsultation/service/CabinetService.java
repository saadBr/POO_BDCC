package ma.enset.gestionconsultation.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ma.enset.gestionconsultation.dao.ConsultationDao;
import ma.enset.gestionconsultation.dao.IConsultationDao;
import ma.enset.gestionconsultation.dao.IPatientDao;
import ma.enset.gestionconsultation.dao.PatientDao;
import ma.enset.gestionconsultation.entities.Consultation;
import ma.enset.gestionconsultation.entities.Patient;

import java.sql.SQLException;
import java.util.List;

public class CabinetService implements ICabinetService{
    private static CabinetService instance;
    private IPatientDao patientDao;
    private IConsultationDao consultationDao;
    private ObservableList<Patient> patients = FXCollections.observableArrayList();

    public static CabinetService getInstance() {
        if (instance == null) {
            instance = new CabinetService(new PatientDao(), new ConsultationDao());
        }
        return instance;
    }

    public CabinetService(IPatientDao patientDao, IConsultationDao consultationDao) {
        this.patientDao = patientDao;
        this.consultationDao = consultationDao;
    }
    @Override
    public void ajouterPatient(Patient patient) {
        try {
            patientDao.create(patient);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void supprimerPatient(Patient patient) {
        try {
            patientDao.delete(patient);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void modifierPatient(Patient patient) {
        try {
            patientDao.update(patient);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Patient getPatientById(int id) {
        Patient patient = null;
        try {
            patient = patientDao.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return patient;
    }

    @Override
    public List<Patient> getAllPatient() {
        List<Patient> patients = null;
        try {
            patients = patientDao.findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return patients;
    }

    @Override
    public List<Patient> searchByQuery(String query) {
        List<Patient> patients = null;
        try {
            patients = patientDao.searchByQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return patients;
    }

    @Override
    public void ajouterConsultation(Consultation consultation) {
        try {
            consultationDao.create(consultation);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void supprimerConsultation(Consultation consultation) {
        try {
            consultationDao.delete(consultation);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void modifierConsultation(Consultation consultation) {
        try {
            consultationDao.update(consultation);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Consultation getConsultationById(int id) {
        Consultation consultation = null;
        try {
            consultation = consultationDao.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return consultation;
    }

    @Override
    public List<Consultation> getAllConsultation() {
        List<Consultation> consultations = null;
        try {
            consultations = consultationDao.findAll();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return consultations;
    }
    @Override
    public ObservableList<Patient> getPatients() {
        if (patients.isEmpty()) {
            patients.setAll(getAllPatient());
        }
        return patients;
    }
    @Override
    public void refreshPatients() {
        patients.setAll(getAllPatient());
    }
}
