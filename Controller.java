import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;


public class Controller implements Initializable{
    //FXML fields
    @FXML
    private ChoiceBox<Integer> minPrice;
    @FXML
    private ChoiceBox<Integer> maxPrice;
    @FXML
    private Label titleLabel;

    @FXML
    private Button rightButton;
    @FXML
    private Button leftButton;

    private boolean validPriceRange;
    //Flag to know if its been of the first page ever
    private boolean firstPageFlag;

    private int count ;
    // min and max price
    public static int min;
    public static int max;
    //values for price range
    private final Integer[] priceRange = {0,20, 40,60,80,100,200,300,400,500,600,1000,1500,2000,2500,3000,5000,10000};

    /**
     * For when the right button is pressed
     */
    @FXML
    private void goRight(ActionEvent event) {
        firstPageFlag = true;
        if (count ==0 ) {
            if (validPriceRange) {
                displayMap();
            }
        } else  displayStatistics();
        count++;
        count = count%2;
    }

    /**
     * For when the left button is pressed
     */
    @FXML
    private void goLeft(ActionEvent event) {
        firstPageFlag = true;
        System.out.println(count);
        if (count == 0) {
            if (validPriceRange) {
                displayMap();
            }
        } else displayStatistics();
        count--;
        count = Math.abs(count%2);
    }
    
    /**
     * Populate the pricerange choice boxes and their actions
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        count = 0;
        validPriceRange = false;
        rightButton.setDisable(true);
        leftButton.setDisable(true);
        minPrice.getItems().addAll(priceRange);
        maxPrice.getItems().addAll(priceRange);
        minPrice.setOnAction(this::minChoice);
        maxPrice.setOnAction(this::maxChoice);
        titleLabel.setText("Welcome! Make a selection on the right hand side.");
    }

    /**
     * updates min with the choice and if min < max then display the "map"
     */
    private void minChoice(ActionEvent event) {
        min = minPrice.getSelectionModel().getSelectedItem();
        validPriceRange = min < max;
        if (validPriceRange) {
            rightButton.setDisable(false);
            leftButton.setDisable(false);
            if (firstPageFlag) {
                if (count == 1) displayMap();
                else displayStatistics();
            }
        } else {
            rightButton.setDisable(true);
            leftButton.setDisable(true);
        }
    }

    /**
     * update max with the choice and if min < max then display the "map"
     */
    private void maxChoice(ActionEvent event) {
        max = maxPrice.getSelectionModel().getSelectedItem();
        validPriceRange = min < max;
        if (validPriceRange) {
            rightButton.setDisable(false);
            leftButton.setDisable(false);
            if (firstPageFlag) {
                if (count == 1) displayMap();
                else displayStatistics();
            }
        } else {
            rightButton.setDisable(true);
            leftButton.setDisable(true);
        }
    }

    /**
     * display the "map" BoroughController.java is the controller class
     */
    private void displayMap() {
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

    private void displayStatistics()
    {
        titleLabel.setText("Displaying statistics!");
        URL viewLocation = getClass().getResource("statisticspanel.fxml");
        FXMLLoader statsLoader = new FXMLLoader(viewLocation);

        try {
            GridPane statsPane = statsLoader.load();
            Stage stage = (Stage) minPrice.getScene().getWindow();
            ((BorderPane) stage.getScene().getRoot()).setCenter(statsPane);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
