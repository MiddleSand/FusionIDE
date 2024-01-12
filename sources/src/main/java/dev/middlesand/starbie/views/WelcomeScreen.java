package dev.middlesand.starbie.views;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class WelcomeScreen {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onSetupButton() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}