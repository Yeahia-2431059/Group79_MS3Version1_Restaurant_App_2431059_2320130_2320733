package com.app.restaurant_app.Yeahia.controller_classes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class Add_new_staff_scene_controller {
    @FXML
    private ChoiceBox<String> new_staff_type_choicebox;
    @FXML
    private TextField new_staff_id_textfield;
    @FXML
    private ChoiceBox choose_shift_choicebox;
    @FXML
    private TextArea selected_working_days_text_area;
    @FXML
    private ChoiceBox select_working_days_choicebox;


    public void initialize() {
        new_staff_type_choicebox.getItems().addAll("Waiter staff", "Accountant");

    }
    @FXML
    public void add_staff_button(ActionEvent actionEvent) {

    }

    @FXML
    public void add_to_schedule_button_on_action(ActionEvent actionEvent) {
    }

    @FXML
    public void remove_from_schedule_on_action(ActionEvent actionEvent) {
    }
}
