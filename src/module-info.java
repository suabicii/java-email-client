module JavaFXEmailClient {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.web;
    requires jakarta.activation;
    requires jakarta.mail;

    opens com.potato;
    opens com.potato.controller;
}