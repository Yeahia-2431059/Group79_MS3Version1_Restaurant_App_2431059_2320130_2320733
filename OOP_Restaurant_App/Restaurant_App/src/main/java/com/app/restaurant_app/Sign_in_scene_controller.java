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
        boolean allFieldsEmpty =
                gmail_textfield.getText().isEmpty() &&
                        mobile_number_textfield.getText().isEmpty() &&
                        password_textfield.getText().isEmpty() &&
                        name_textfield.getText().isEmpty();

        boolean gmailValid =
                (gmail_textfield.getText().length() == 6 && is_integer(gmail_textfield.getText())) ||
                        gmail_textfield.getText().endsWith("@gmail.com");
        String alert_string;
        Alert alert;
        if((!allFieldsEmpty && gmailValid)) {
            String unique_identifier = gmail_textfield.getText();

            if (is_integer(unique_identifier)) {

                int employee_id = Integer.parseInt(unique_identifier);
                ArrayList<Object> employee_arraylist = new ArrayList<Object>(Utility.read_object("data_files/employee_data.bin"));

                for (Object employee : employee_arraylist) {

                    if ((((Employee) employee).getEmployee_id()) == employee_id) {

                        if (((Employee) employee).getPassword().isEmpty()) {
                            ((Employee) employee).setPassword(password_textfield.getText());

                            if (employee instanceof Waiter_staff) {
                                ((Waiter_staff) employee).setName(name_textfield.getText());
                                ((Waiter_staff) employee).setMobile_number(Long.parseLong(mobile_number_textfield.getText()));
                                Waiter_staff.setSame_type_staff_count((byte) (Waiter_staff.getSame_type_staff_count() + 1));

                                write_object("data_files/employee_data.bin", employee);

                                scene_changer(actionEvent, "Yeahia/Waiter_staff_dashboard_scene.fxml");
                                Waiter_dashboard_controller.get_resources((Waiter_staff) employee);
                            }
                            //                        else if (employee instanceof Restaurant_manager) {
                            //                            ((Restaurant_manager) employee).setName(name_textfield.getText());
                            //                            ((Restaurant_manager) employee).setMobile_number(Long.parseLong(mobile_number_textfield.getText()));
                            //
                            //                            scene_changer(actionEvent,"Yeahia/Restaurant_manager_dashboard.fxml");
                            //                            Restaurant_manager_dashboard_controller.get_resources((Restaurant_manager)employee);
                            //                        }
                        } else {
                            alert = new Alert(Alert.AlertType.INFORMATION, "Already exists!, please log in instead");
                            alert.showAndWait();
                        }
                    }
                }
            } else {

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
            alert = new Alert(Alert.AlertType.INFORMATION,"Invalid input");
            alert.showAndWait();
        }
    }
}
