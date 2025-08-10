package com.app.restaurant_app.Yeahia.controller_classes;

import com.app.restaurant_app.Sakib.model_classes.Inventory_manager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Add_new_staff_scene_controller {
    @FXML
    private ChoiceBox<String> new_staff_type_choicebox;
    @FXML
    private TextField new_staff_id_textfield;
    @FXML
    private TableView new_staff_schedule_tableview;

    public void initialize() {
        new_staff_type_choicebox.getItems().addAll("Waiter staff", "Accountant", "Kitchen staff", "Delivery driver", "Inventory_manager", "Marketing manager");


    }
    @FXML
    public void add_staff_button(ActionEvent actionEvent) {

    }
}
