package ma.enset.gestionconsultation.service;

import ma.enset.gestionconsultation.dao.ConsultationDao;
import ma.enset.gestionconsultation.dao.PatientDao;
import ma.enset.gestionconsultation.entities.Patient;

import java.util.List;

public class ServiceTest {
    public static void main(String[] args) {
        ICabinetService service = new CabinetService(new PatientDao(),new ConsultationDao());
        /*
        Patient patient = new Patient();
        patient.setPrenom("Rhita");
        patient.setNom("Chakhtoun");
        patient.setTel("0666913377");
        service.ajouterPatient(patient);

        List<Patient> patients = service.getAllPatient();
        patients.forEach(System.out::println);
        */
        Patient patient = service.getPatientById(1);
        patient.setPrenom("Saad");
        service.modifierPatient(patient);
        System.out.println(patient);


    }
}
