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
    //FXML fields
    @FXML
    private ChoiceBox<Integer> minPrice;
    @FXML
    private ChoiceBox<Integer> maxPrice;
    @FXML
    private Label titleLabel;
    // min and max price
    public static int min;
    public static int max;
    //values for price range (possibly add/remove some)
    private final Integer[] priceRange = {0,20, 40,60,80,100,200,300,400,500,600,1000,1500,2000,2500,3000,5000,10000};

    /**
     * For when the right button is pressed
     * @param event
     */
    @FXML
    private void goRight(ActionEvent event) {
        if (min < max) {
            display();
        }
    }

    /**
     * For when the left button is pressed
     * @param event
     */
    @FXML
    private void goLeft(ActionEvent event) {
        if (min < max) {
            display();
        }
    }

    /**
     * Populate the pricerange choice boxes and their actions
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        minPrice.getItems().addAll(priceRange);
        maxPrice.getItems().addAll(priceRange);
        minPrice.setOnAction(this::minChoice);
        maxPrice.setOnAction(this::maxChoice);
        titleLabel.setText("Welcome! Make a selection on the right hand side.");
    }

    /**
     * updates min with the choice and if min < max then display the "map"
     * @param event
     */
    private void minChoice(ActionEvent event) {
        min = minPrice.getSelectionModel().getSelectedItem();
    }

    /**
     * update max with the choice and if min < max then display the "map"
     * @param event
     */
    private void maxChoice(ActionEvent event) {
        max = maxPrice.getSelectionModel().getSelectedItem();
    }

    /**
     * display the "map" BoroughController.java is the controller class
     */
    private void display() {
        titleLabel.setText("Now click a borough");
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
