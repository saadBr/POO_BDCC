package ma.enset.gestionconsultation.dao;

import ma.enset.gestionconsultation.entities.Consultation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ConsultationDao implements IConsultationDao{
    @Override
    public void create(Consultation consultation) throws SQLException {
        Connection connection = DBconnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO CONSULTATION(date_consultation,description,id_patient)" + "values(?,?,?)");
        pstm.setDate(1,consultation.getDate_consultation());
        pstm.setString(2,consultation.getDescription());
        pstm.setInt(3,consultation.getPatient().getId_patient());
        pstm.executeUpdate();
    }

    @Override
    public void update(Consultation consultation) {

    }

    @Override
    public void delete(Consultation consultation) {

    }

    @Override
    public List<Consultation> findAll() {
        return List.of();
    }

    @Override
    public Consultation findById(Integer id) {
        return null;
    }
}
