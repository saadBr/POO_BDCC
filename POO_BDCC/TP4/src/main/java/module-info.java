module ma.enset.tp4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ma.enset.tp4 to javafx.fxml;
    exports ma.enset.tp4;
}