package com.app.restaurant_app;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Log_in_scene_controller {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}