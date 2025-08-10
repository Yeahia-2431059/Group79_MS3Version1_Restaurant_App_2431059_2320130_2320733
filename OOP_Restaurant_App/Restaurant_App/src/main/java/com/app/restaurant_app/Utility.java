package com.app.restaurant_app;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;



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


    public static ArrayList<Object> read_object(String file_path) throws IOException {
        File file = new File(file_path);
        ArrayList<Object> object_arraylist = new ArrayList<Object>();
        if (file.exists()) {

            FileInputStream file_input_stream = new FileInputStream(file);
            ObjectInputStream object_input_stream = new ObjectInputStream(file_input_stream);

            while (true) {
                try {
                    object_arraylist.add(object_input_stream.readObject());
                } catch (Exception e) {
                    break;
                }

            }
        }
        return object_arraylist;
    }
    public static boolean is_integer(String string) {
        if (string == null) {
            return false;
        }
        try {
            Integer.parseInt(string);
            return true; // Successfully parsed
        } catch (NumberFormatException e) {
            return false; // Not an integer
        }
    }
}
