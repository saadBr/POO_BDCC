package ma.enset.gestionconsultation.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import ma.enset.gestionconsultation.dao.ConsultationDao;
import ma.enset.gestionconsultation.dao.PatientDao;
import ma.enset.gestionconsultation.entities.Consultation;
import ma.enset.gestionconsultation.entities.Patient;
import ma.enset.gestionconsultation.service.CabinetService;
import ma.enset.gestionconsultation.service.ICabinetService;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class ConsultationController implements Initializable {
    @FXML private DatePicker dateConsultation;
    @FXML private ComboBox<Patient> comboPatient;
    @FXML private TextArea textDescription;
    private ICabinetService cabinetService;
    private ObservableList<Patient> patients = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cabinetService = new CabinetService(new PatientDao(), new ConsultationDao());
        comboPatient.setItems(patients);
        patients.setAll(cabinetService.getAllPatient());
    }

    public void ajouterConsultation(){
        Consultation consultation = new Consultation();
        consultation.setDescription(textDescription.getText());
        consultation.setDate_consultation(Date.valueOf(dateConsultation.getValue()));
        consultation.setPatient(comboPatient.getSelectionModel().getSelectedItem());
        cabinetService.ajouterConsultation(consultation);
    }

}
