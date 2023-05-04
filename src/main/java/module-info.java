module com.example.juegoadivina {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.mail;


    opens com.example.juegoadivina to javafx.fxml;
    exports com.example.juegoadivina;
}