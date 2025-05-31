package ma.enset.gestionconsultation.dao;

import ma.enset.gestionconsultation.entities.Patient;

import java.sql.SQLException;
import java.util.List;

public interface IPatientDao extends Dao<Patient, Integer> {
    List<Patient> searchByQuery(String query) throws SQLException;
}
