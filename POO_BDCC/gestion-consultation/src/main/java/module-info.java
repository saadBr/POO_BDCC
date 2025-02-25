module ma.enset.gestionconsultation {
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;
    requires org.kordamp.bootstrapfx.core;
    requires javafx.controls;


    opens ma.enset.gestionconsultation.controllers to javafx.fxml;
    opens ma.enset.gestionconsultation.entities to javafx.base;
    exports ma.enset.gestionconsultation;
}