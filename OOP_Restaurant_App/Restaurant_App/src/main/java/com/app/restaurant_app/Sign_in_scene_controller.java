package com.app.restaurant_app;

import com.app.restaurant_app.Ashik.controller_classes.Customer_dashboard_controller;
import com.app.restaurant_app.Ashik.model_classes.Customer;
import com.app.restaurant_app.Yeahia.controller_classes.Restaurant_manager_dashboard_controller;
import com.app.restaurant_app.Yeahia.controller_classes.Waiter_dashboard_controller;
import com.app.restaurant_app.Yeahia.model_classes.Restaurant_manager;
import com.app.restaurant_app.Yeahia.model_classes.Waiter_staff;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

import static com.app.restaurant_app.Employee.verify_sign_in_and_return_employee;
import static com.app.restaurant_app.Utility.*;


public class Sign_in_scene_controller {
    @FXML
    private TextField gmail_textfield;
    @FXML
    private TextField mobile_number_textfield;
    @FXML
    private TextField password_textfield;
    @FXML
    private TextField name_textfield;

    @FXML
    public void sign_in_on_action(ActionEvent actionEvent) throws IOException {

        boolean are_any_fields_empty =
                gmail_textfield.getText().isEmpty() &&
                        mobile_number_textfield.getText().isEmpty() &&
                        password_textfield.getText().isEmpty() &&
                        name_textfield.getText().isEmpty();
        boolean is_number_valid =
                (mobile_number_textfield.getText().length() == 11) && is_long(mobile_number_textfield.getText()) && mobile_number_textfield.getText().startsWith("0");
        boolean is_gmail_valid =
                (gmail_textfield.getText().length() == 6 && is_integer(gmail_textfield.getText())) ||
                        gmail_textfield.getText().endsWith("@gmail.com");

        if(!are_any_fields_empty && is_gmail_valid && is_number_valid) {
            String unique_identifier = gmail_textfield.getText();

            if (is_integer(unique_identifier)) {
                Employee employee = verify_sign_in_and_return_employee(Integer.parseInt(unique_identifier));
                switch (employee) {

                    case Waiter_staff waiter_staff -> {
                        waiter_staff.setMobile_number(Long.parseLong(mobile_number_textfield.getText()));
                        waiter_staff.setPassword(password_textfield.getText());
                        waiter_staff.setName(name_textfield.getText());
                        scene_changer(actionEvent, "Yeahia/Waiter_staff_dashboard_scene.fxml");
                        Waiter_dashboard_controller.get_resources(waiter_staff);
                        write_object("data_files/employee_data.bin", employee);
                    }
                    case Restaurant_manager restaurant_manager -> {
                        if (Restaurant_manager.getSame_type_staff_count() == 0) {
                            restaurant_manager.setMobile_number(Long.parseLong(mobile_number_textfield.getText()));
                            restaurant_manager.setPassword(password_textfield.getText());
                            restaurant_manager.setName(name_textfield.getText());

                            Restaurant_manager.setSame_type_staff_count((byte) (Restaurant_manager.getSame_type_staff_count() + 1));
                            scene_changer(actionEvent, "Yeahia/Restaurant_manager_dashboard.fxml");
                            Restaurant_manager_dashboard_controller.get_resources(restaurant_manager);
                            write_object("data_files/employee_data.bin", restaurant_manager);
                        } else {
                            show_information_alert(Alert.AlertType.INFORMATION, "Restaurant manager already exists");
                        }
                    }
                    case null ->{

                    }
                    default -> {
                        write_object("data_files/employee_data.bin",employee);
                        show_information_alert(Alert.AlertType.INFORMATION,"employee was returned, and was valid but didn't match any instance check, please debug the code");
                    }
                }
            }
            else {
                String alert_string;
                Alert alert;
                ArrayList<Object> customer_arraylist = new ArrayList<>(Utility.read_object("data_files/customer_data.bin"));

                for (Object customer : customer_arraylist) {
                    if (unique_identifier.equals(((Customer) customer).getGmail())) {
                        alert_string = "Gmail already used, please go login or use another gmail";
                        alert = new Alert(Alert.AlertType.INFORMATION, alert_string);
                        alert.showAndWait();
                        return;
                    }
                }
                write_object("data_files/customer_data", (new Customer(
                        gmail_textfield.getText(),
                        Long.parseLong(mobile_number_textfield.getText()),
                        name_textfield.getText(),
                        password_textfield.getText()))
                );
                scene_changer(actionEvent, "Ashik/Customer_dashboard");
                Customer_dashboard_controller.get_resources((new Customer(
                        gmail_textfield.getText(),
                        Long.parseLong(mobile_number_textfield.getText()),
                        name_textfield.getText(),
                        password_textfield.getText()))
                );
            }
        }
        else {
            show_information_alert(Alert.AlertType.INFORMATION,"Invalid input");

        }
        gmail_textfield.clear();
        password_textfield.clear();
        mobile_number_textfield.clear();
        name_textfield.clear();
    }

}
