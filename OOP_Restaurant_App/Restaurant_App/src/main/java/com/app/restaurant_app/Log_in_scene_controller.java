package com.app.restaurant_app;
import javafx.event.ActionEvent;


import java.io.IOException;

public class Log_in_scene_controller {

    public void Login_button_on_action(ActionEvent actionEvent) throws IOException{
        Utility.scene_changer(actionEvent, "Yeahia/Restaurant_manager_dashboard.fxml");
        Utility.new_scene("Yeahia/Restaurant_manager_dashboard.fxml");
    }
}
