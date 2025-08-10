package com.app.restaurant_app;
import com.app.restaurant_app.Ashik.controller_classes.Customer_dashboard_controller;
import com.app.restaurant_app.Ashik.model_classes.Customer;
import com.app.restaurant_app.Yeahia.controller_classes.Restaurant_manager_dashboard_controller;
import com.app.restaurant_app.Yeahia.controller_classes.Waiter_dashboard_controller;
import com.app.restaurant_app.Yeahia.model_classes.Restaurant_manager;
import com.app.restaurant_app.Yeahia.model_classes.Waiter_staff;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;


import java.io.IOException;
import java.util.ArrayList;

import static com.app.restaurant_app.Utility.*;

public class Log_in_scene_controller {

    @javafx.fxml.FXML
    private TextField gmail_textfield;
    @javafx.fxml.FXML
    private TextField password_textfield;

    @javafx.fxml.FXML
    public void Login_button_on_action(ActionEvent actionEvent) throws IOException{
        String alert_string;
        Alert alert;
        String unique_identifier = gmail_textfield.getText();
        if (is_integer(unique_identifier)){

            int employee_id = Integer.parseInt(unique_identifier);
            ArrayList<Object> employee_arraylist = new ArrayList<Object>(Utility.read_object("data_files/employee_data.bin"));

            for (Object employee : employee_arraylist){
                if ((((Employee)employee).getEmployee_id()) == employee_id){
                    if (employee instanceof Waiter_staff){
                        scene_changer(actionEvent,"Yeahia/Waiter_staff_dashboard_scene.fxml");
                        Waiter_dashboard_controller.get_resources((Waiter_staff)employee);
                    }
                    else if (employee instanceof Restaurant_manager) {
                        scene_changer(actionEvent,"Yeahia/Restaurant_manager_dashboard.fxml");
                        Restaurant_manager_dashboard_controller.get_resources((Restaurant_manager)employee);
                    }
                }
            }
        }
        else {

            ArrayList<Object> customer_arraylist = new ArrayList<>(Utility.read_object("data_files/customer_data.bin"));

            for (Object customer : customer_arraylist) {
                if (unique_identifier.equals(((Customer)customer).getGmail())){
                   scene_changer(actionEvent,"Ashik/Customer_dashboard");
                    Customer_dashboard_controller.get_resources(((Customer)customer));
                }
            }
        }
    }

}
