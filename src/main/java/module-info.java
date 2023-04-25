module com.example.juegoadivina {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.juegoadivina to javafx.fxml;
    exports com.example.juegoadivina;
}