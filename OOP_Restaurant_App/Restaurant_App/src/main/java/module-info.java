module com.app.restaurant_app {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.app.restaurant_app to javafx.fxml;
    exports com.app.restaurant_app;
    opens com.app.restaurant_app.Yeahia.controller_classes to javafx.fxml;
    exports com.app.restaurant_app.Yeahia.controller_classes;
}
