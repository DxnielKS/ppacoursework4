import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Controller implements Initializable{

    @FXML
    private ChoiceBox<Integer> minPrice;

    @FXML
    private ChoiceBox<Integer> maxPrice;

    public static int min;
    public static int max;

    private final Integer[] priceRange = {0,20, 40,60,80,100,200,300,400,500,600,1000,1500,2000,2500,3000,5000,10000};
    @FXML
    private void goRight(ActionEvent event) {
        System.out.println("right");

    }

    @FXML
    private void goLeft(ActionEvent event) {
        System.out.println("left");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        minPrice.getItems().addAll(priceRange);
        maxPrice.getItems().addAll(priceRange);

        minPrice.setOnAction(this::minChoice);
        maxPrice.setOnAction(this::maxChoice);
    }

    private void minChoice(ActionEvent event) {
        min = minPrice.getSelectionModel().getSelectedItem();
        if (min < max) {
            display();
        }
    }

    private void maxChoice(ActionEvent event) {
        max = maxPrice.getSelectionModel().getSelectedItem();
        if (min < max) {
            display();
        }
    }

    private void display() {
        URL viewLocation = getClass().getResource("borough.fxml");
        FXMLLoader boroughLoader = new FXMLLoader(viewLocation);
        try {
            StackPane boroughPane = boroughLoader.load();
            Stage stage = (Stage) minPrice.getScene().getWindow();
            ((BorderPane) stage.getScene().getRoot()).setCenter(boroughPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
