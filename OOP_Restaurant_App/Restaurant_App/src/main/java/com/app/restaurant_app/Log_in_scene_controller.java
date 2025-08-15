package com.app.restaurant_app;
import com.app.restaurant_app.Yeahia.controller_classes.Restaurant_manager_dashboard_controller;
import com.app.restaurant_app.Yeahia.controller_classes.Waiter_dashboard_controller;
import com.app.restaurant_app.Yeahia.model_classes.Restaurant_manager;
import com.app.restaurant_app.Yeahia.model_classes.Waiter_staff;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import static com.app.restaurant_app.Utility.*;

import java.io.IOException;



public class Log_in_scene_controller {

    @javafx.fxml.FXML
    private TextField gmail_textfield;
    @javafx.fxml.FXML
    private TextField password_textfield;

    @javafx.fxml.FXML
    public void Login_button_on_action(ActionEvent actionEvent) throws IOException{

        String unique_identifier = gmail_textfield.getText();
        if (is_integer(unique_identifier)){

            int employee_id = Integer.parseInt(unique_identifier);
            Employee employee = Employee.verify_login_and_return_employee(employee_id,password_textfield.getText());

            switch (employee) {
                case null -> {

                }
                case Waiter_staff waiterStaff -> {
                    scene_changer(actionEvent, "Yeahia/Waiter_staff_dashboard_scene.fxml");
                    Waiter_dashboard_controller.get_resources(waiterStaff);
                }
                case Restaurant_manager restaurantManager -> {
                    scene_changer(actionEvent, "Yeahia/Restaurant_manager_dashboard.fxml");
                    Restaurant_manager_dashboard_controller.get_resources(restaurantManager);
                }
                default -> {
                }
            }
        }
        else {

//            ArrayList<Object> customer_arraylist = new ArrayList<>(Utility.read_object("data_files/customer_data.bin"));
//
//            for (Object customer : customer_arraylist) {
//                if (unique_identifier.equals(((Customer)customer).getGmail())){
//                   scene_changer(actionEvent,"Ashik/Customer_dashboard");
//                    Customer_dashboard_controller.get_resources(((Customer)customer));
//                }
            return;
        }
        gmail_textfield.clear();
        password_textfield.clear();
    }

    public void Sign_in_button_on_action(ActionEvent actionEvent) throws IOException {
        scene_changer(actionEvent,"Sign_in_scene.fxml");
    }
}

