package com.potato.controller;

import com.potato.EmailManager;
import com.potato.controller.services.LoginService;
import com.potato.model.EmailAccount;
import com.potato.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginWindowController extends BaseController {

    @FXML
    private TextField emailAddressField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    public LoginWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }

    @FXML
    void loginButtonAction() {
        if (fieldsAreValid()) {
            EmailAccount emailAccount = new EmailAccount(emailAddressField.getText(), passwordField.getText());
            LoginService loginService = new LoginService(emailAccount, emailManager);
            loginService.start();
            loginService.setOnSucceeded(event -> {
                EmailLoginResult emailLoginResult = loginService.getValue();

                switch (emailLoginResult) {
                    case SUCCESS:
                        System.out.println("login successful!!!" + emailAccount);
                        return;
                }
            });
        }
        System.out.println("loginButtonAction!");
        /*viewFactory.showMainWindow();
        Stage stage = (Stage) errorLabel.getScene().getWindow();
        viewFactory.closeStage(stage);*/
    }

    private boolean fieldsAreValid() {
        if (emailAddressField.getText().isEmpty()) {
            errorLabel.setText("Please fill email");
            return false;
        }
        if (passwordField.getText().isEmpty()) {
            errorLabel.setText("Please fill password");
            return false;
        }

        return true;
    }
}
