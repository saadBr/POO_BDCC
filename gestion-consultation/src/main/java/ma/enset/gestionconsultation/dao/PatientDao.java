package ma.enset.gestionconsultation.dao;

import ma.enset.gestionconsultation.entities.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientDao implements IPatientDao{

    @Override
    public void create(Patient patient) throws SQLException {
        Connection connection = DBconnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO PATIENTS(nom,prenom,tel)" + "values(?,?,?)");
        pstm.setString(1,patient.getNom());
        pstm.setString(2,patient.getPrenom());
        pstm.setString(3,patient.getTel());
        pstm.executeUpdate();
    }

    @Override
    public void update(Patient patient) throws SQLException {
        Connection connection = DBconnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE PATIENTS SET nom = ?, prenom = ?, tel = ? WHERE ID_PATIENT = ?");
        pstm.setString(1,patient.getNom());
        pstm.setString(2,patient.getPrenom());
        pstm.setString(3,patient.getTel());
        pstm.setInt(4,patient.getId_patient());
        pstm.executeUpdate();

    }

    @Override
    public void delete(Patient patient) throws SQLException {
        Connection connection = DBconnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM PATIENTS WHERE ID_PATIENT = ?");
        pstm.setInt(1,patient.getId_patient());
        pstm.executeUpdate();
    }

    @Override
    public List<Patient> findAll() throws SQLException {
        Connection connection = DBconnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM PATIENTS");
        ResultSet rs = pstm.executeQuery();
        List<Patient> patients = new ArrayList<>();
        while (rs.next()){
            Patient p = new Patient();
            p.setId_patient(rs.getInt("ID_PATIENT"));
            p.setNom(rs.getString("NOM"));
            p.setPrenom(rs.getString("PRENOM"));
            p.setTel(rs.getString("TEL"));
            patients.add(p);
        }
        return patients;
    }

    @Override
    public Patient findById(Integer id) throws SQLException {
        Connection connection = DBconnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM PATIENTS WHERE ID_PATIENT=?");
        pstm.setInt(1,id);
        ResultSet rs = pstm.executeQuery();
        Patient p = new Patient();
        if (rs.next()){
            p.setId_patient(rs.getInt("ID_PATIENT"));
            p.setNom(rs.getString("NOM"));
            p.setPrenom(rs.getString("PRENOM"));
            p.setTel(rs.getString("TEL"));
        }
        return p;
    }
    @Override
    public List<Patient> searchByQuery(String query) throws SQLException {
        Connection connection = DBconnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM PATIENTS WHERE NOM LIKE ? OR PRENOM LIKE ?");
        pstm.setString(1,"%"+query+"%");
        pstm.setString(2,"%"+query+"%");
        ResultSet rs = pstm.executeQuery();
        List<Patient> patients = new ArrayList<>();
        while (rs.next()){
            Patient p = new Patient();
            p.setId_patient(rs.getInt("ID_PATIENT"));
            p.setNom(rs.getString("NOM"));
            p.setPrenom(rs.getString("PRENOM"));
            p.setTel(rs.getString("TEL"));
            patients.add(p);
        }
        return patients;
    }
}
