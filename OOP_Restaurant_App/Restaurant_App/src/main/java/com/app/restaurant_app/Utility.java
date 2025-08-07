package com.app.restaurant_app;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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

    public static void write_object(String file_path, Object object) throws IOException{
        ObjectOutputStream object_output_stream;
        File file = new File(file_path);

        if (file.exists()){
            FileOutputStream file_output_stream = new FileOutputStream(file, true);
            object_output_stream = new AppendableObjectOutputStream(file_output_stream);
        }else {
            FileOutputStream file_output_stream = new FileOutputStream(file);
            object_output_stream = new ObjectOutputStream(file_output_stream);
        }

        object_output_stream.writeObject(object);
    }

/*
    public read_object(){

    }
*/
}

