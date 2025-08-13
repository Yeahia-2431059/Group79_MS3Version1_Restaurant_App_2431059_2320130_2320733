package com.app.restaurant_app.Yeahia.controller_classes;

import com.app.restaurant_app.Yeahia.model_classes.Restaurant_manager;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

import javax.imageio.IIOException;

import java.io.IOException;

import static com.app.restaurant_app.Utility.*;

public class Restaurant_manager_dashboard_controller {
    @javafx.fxml.FXML
    private ChoiceBox staff_filter_choice_box;
    @javafx.fxml.FXML
    private Label filtered_staff_count_label;
    @javafx.fxml.FXML
    private Button filter_staff_button;
    @javafx.fxml.FXML
    private TableView staff_tableview;
    @javafx.fxml.FXML
    private Label Designation_label;
    @javafx.fxml.FXML
    private Label ID_label;
    @javafx.fxml.FXML
    private Label name_label;


    public void initialize(){

    }

    public static void get_resources(Restaurant_manager restaurant_manager){

    }
    @javafx.fxml.FXML
    public void Manage_staff_button(ActionEvent actionEvent) {

    }

    @javafx.fxml.FXML
    public void add_staff_button(ActionEvent actionEvent)throws IOException {
        scene_changer(actionEvent,"Yeahia/Add_new_staff_scene.fxml");
    }

    @javafx.fxml.FXML
    public void see_profile_button_on_action(ActionEvent actionEvent) {

    }
}
