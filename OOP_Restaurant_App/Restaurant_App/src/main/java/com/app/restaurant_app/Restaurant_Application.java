package com.app.restaurant_app;

import com.app.restaurant_app.Yeahia.model_classes.Restaurant_manager;
import com.app.restaurant_app.Yeahia.model_classes.Waiter_staff;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Restaurant_Application extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Restaurant_Application.class.getResource("Log_in_scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Restaurant");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException{
        launch();
    }
}