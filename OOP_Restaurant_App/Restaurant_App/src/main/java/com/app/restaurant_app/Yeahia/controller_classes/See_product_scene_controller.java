package com.app.restaurant_app.Yeahia.controller_classes;

import com.app.restaurant_app.Non_user_classes.Product;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.util.ArrayList;

import static com.app.restaurant_app.Utility.is_integer;
import static com.app.restaurant_app.Utility.write_object;

public class See_product_scene_controller {
    @javafx.fxml.FXML
    private TableView<Product> product_list_tableview;
    @javafx.fxml.FXML
    private TableColumn<Product,String> product_name_table_column;
    @javafx.fxml.FXML
    private TableColumn<Product, ArrayList<String>> product_ingredient_table_column;
    @javafx.fxml.FXML
    private TableColumn<Product,Integer> product_sales_table_column;
    @javafx.fxml.FXML
    private TableColumn<Product,Integer> product_price_table_column;
    @javafx.fxml.FXML
    private TextArea new_product_ingredients_textarea;
    @javafx.fxml.FXML
    private TextField new_product_price_textfield;
    @javafx.fxml.FXML
    private ChoiceBox<String> ingredient_choice_box;
    @javafx.fxml.FXML
    private TextField new_product_name_textfield;
    @javafx.fxml.FXML
    private TextField new_ingredient_name_textfield;

    ArrayList<String> product_ingredient_arraylist = new ArrayList<String>();

    public void initialize(){

    }

    @javafx.fxml.FXML
    public void add_product_ingredient_button_on_action(ActionEvent actionEvent) {
        product_ingredient_arraylist.add(ingredient_choice_box.getValue());

    }

    @javafx.fxml.FXML
    public void add_new_product_button_on_action(ActionEvent actionEvent) {
        if (is_integer(new_product_price_textfield.getText()) && !product_ingredient_arraylist.isEmpty()){
            Product product = Product.verify_new_product_and_return(new_product_name_textfield.getText(),product_ingredient_arraylist,Integer.parseInt(new_product_price_textfield.getText()));
            try{
                write_object("data_files/product_data.bin",product);
                product_list_tableview.getItems().add(product);
            }
            catch (Exception e){

            }

        }

    }

    @javafx.fxml.FXML
    public void remove_product_button_on_action(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void add_new_ingredient_button_on_action(ActionEvent actionEvent) {
    }
}
