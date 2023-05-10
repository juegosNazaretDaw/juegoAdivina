module com.example.juegoadivina {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.mongodb.driver.sync.client;
    requires org.mongodb.bson;
    requires org.mongodb.driver.core;
//    requires java.mail;


    opens com.example.juegoadivina to javafx.fxml;
    exports com.example.juegoadivina;
}