package ma.enset.gestionconsultation.service;

import ma.enset.gestionconsultation.dao.IConsultationDao;
import ma.enset.gestionconsultation.dao.IPatientDao;
import ma.enset.gestionconsultation.entities.Consultation;
import ma.enset.gestionconsultation.entities.Patient;

import java.sql.SQLException;
import java.util.List;

public class CabinetService implements ICabinetService{
    private IPatientDao patientDao;
    private IConsultationDao consultationDao;

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
    public void ajouterConsultation(Consultation consultation) {
        try {
            consultationDao.create(consultation);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void supprimerConsultation(Consultation consultation) {

    }

    @Override
    public void modifierConsultation(Consultation consultation) {

    }

    @Override
    public Consultation getConsultationById(int id) {
        return null;
    }

    @Override
    public List<Consultation> getAllConsultation() {
        return List.of();
    }
}
