package dk.via.mvvm.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CreateAccountViewController {
    @FXML private TextField username;
    @FXML private TextField password;
    @FXML private TextField email;
    @FXML private Label errorLabel;

    @FXML
    protected void createButtonPressed() {
    }

    @FXML
    protected void cancelButtonPressed() {

    }

    @FXML
    public void submitUsername() {
        password.requestFocus();
    }

    @FXML
    public void submitPassword() {
        email.requestFocus();
    }

    @FXML
    public void submitEmail() {
        createButtonPressed();
    }
}