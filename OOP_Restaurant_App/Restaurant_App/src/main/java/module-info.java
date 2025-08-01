module com.app.restaurant_app {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.app.restaurant_app to javafx.fxml;
    exports com.app.restaurant_app;
    exports com.app.restaurant_app.P_Controllers.P_common_class_controllers;
    opens com.app.restaurant_app.P_Controllers.P_common_class_controllers to javafx.fxml;
    exports com.app.restaurant_app.P_Common_class;
    opens com.app.restaurant_app.P_Common_class to javafx.fxml;
}