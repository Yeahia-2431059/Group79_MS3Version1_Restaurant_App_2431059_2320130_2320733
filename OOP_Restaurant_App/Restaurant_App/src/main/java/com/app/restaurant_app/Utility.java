package com.app.restaurant_app;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Utility{
    public static void scene_changer(ActionEvent actionEvent, String Scene_path) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Utility.class.getResource(Scene_path));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
    public static void new_scene(String Scene_path) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Utility.class.getResource(Scene_path));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void write_object(){
        //
    }

/*
    public read_object(){

    }
*/
}
