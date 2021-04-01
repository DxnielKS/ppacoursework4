import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    private ChoiceBox<Integer> minPrice;

    @FXML
    private ChoiceBox<Integer> maxPrice;

    private final Integer[] priceRange = {0, 500,1000,1500,2000,2500,3000,3500};


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

    }

}
