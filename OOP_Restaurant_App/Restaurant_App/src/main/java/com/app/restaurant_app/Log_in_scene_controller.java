package com.app.restaurant_app;
import com.app.restaurant_app.Ashik.model_classes.Accountant;
import com.app.restaurant_app.Sakib.controller_classes.Inventory_manager_dashboard_controller;
import com.app.restaurant_app.Sakib.controller_classes.Kitchen_staff_dashboard_controller;
import com.app.restaurant_app.Sakib.model_classes.Inventory_manager;
import com.app.restaurant_app.Sakib.model_classes.Kitchen_staff;
import com.app.restaurant_app.Soyaiminul.controller_classes.Delivery_driver_dashboard_controller;
import com.app.restaurant_app.Soyaiminul.controller_classes.Marketing_manager_dashboard_controller;
import com.app.restaurant_app.Soyaiminul.model_classes.Delivery_driver;
import com.app.restaurant_app.Soyaiminul.model_classes.Marketing_manager;
import com.app.restaurant_app.Yeahia.controller_classes.Restaurant_manager_dashboard_controller;
import com.app.restaurant_app.Yeahia.controller_classes.Waiter_dashboard_controller;
import com.app.restaurant_app.Yeahia.model_classes.Restaurant_manager;
import com.app.restaurant_app.Yeahia.model_classes.Waiter_staff;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
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

            if (employee == null) {
                // do nothing
            }
            else if (employee instanceof Waiter_staff waiter_staff) {

                Waiter_dashboard_controller controller =  scene_changer_returns_controller(actionEvent, "Yeahia/Waiter_staff_dashboard_scene.fxml");
                controller.get_resources(waiter_staff);
            }
            else if (employee instanceof Restaurant_manager restaurant_manager) {
                Restaurant_manager_dashboard_controller controller = scene_changer_returns_controller(actionEvent, "Yeahia/Restaurant_manager_dashboard.fxml");
                controller.get_resources(restaurant_manager);
            }
            else if (employee instanceof Marketing_manager marketing_manager){
                Marketing_manager_dashboard_controller controller = scene_changer_returns_controller(actionEvent,"Soyaiminul/marketing_manager_dashboard.fxml");
                controller.get_resources(marketing_manager);
            }
            else if (employee instanceof Delivery_driver delivery_driver) {
                Delivery_driver_dashboard_controller controller = scene_changer_returns_controller(actionEvent,"Soyaiminul/delivery_driver_dashboard.fxml");
                controller.get_resources(delivery_driver);
            }
            else if (employee instanceof Inventory_manager inventory_manager) {
                Inventory_manager_dashboard_controller controller = scene_changer_returns_controller(actionEvent,"Sakib/Inventory_manager_dashboard.fxml");
                controller.get_resources(inventory_manager);
            }
            else if (employee instanceof Kitchen_staff kitchen_staff){
                Kitchen_staff_dashboard_controller controller = scene_changer_returns_controller(actionEvent,"Sakib/kitchen_staff_dashboard.fxml");
                controller.get_resources(kitchen_staff);
            }
            else {

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

