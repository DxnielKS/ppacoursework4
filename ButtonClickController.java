import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.event.ActionEvent;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ButtonClickController implements Initializable {

    // FXML fields
    @FXML private TableView<AirbnbListing> tableView;
    @FXML private TableColumn<AirbnbListing, String > hostNameCollumn;
    @FXML private TableColumn<AirbnbListing, Integer> priceCollumn;
    @FXML private TableColumn<AirbnbListing, Integer> numberOfReviewsCollumn;
    @FXML private TableColumn<AirbnbListing, Integer> minnumberOfNights;

    private ArrayList<AirbnbListing> airbnbListings;

    /**
     * Add tables to the table and a listener when an entry is clicked
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hostNameCollumn.setCellValueFactory(new PropertyValueFactory<AirbnbListing, String>("host_name"));
        priceCollumn.setCellValueFactory(new PropertyValueFactory<AirbnbListing,Integer>("price"));
        numberOfReviewsCollumn.setCellValueFactory(new PropertyValueFactory<AirbnbListing, Integer>("numberOfReviews"));
        minnumberOfNights.setCellValueFactory(new PropertyValueFactory<AirbnbListing, Integer>("minimumNights"));

        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<AirbnbListing>() {
            @Override
            public void changed(ObservableValue<? extends AirbnbListing> observableValue, AirbnbListing airbnbListing, AirbnbListing t1) {
                entryClick();
            }
        });
    }

    /**
     * Populate the table
     * @param neighbourhood
     * @param listings
     */
    public void display(String neighbourhood, ArrayList<AirbnbListing> listings) {
        tableView.setItems(FXCollections.observableArrayList(listings));
    }


    /**
     * When an entry in the table is clicked, display extra information.
     */
    public void entryClick() {
        System.out.println(tableView.getSelectionModel().selectedItemProperty().get().getName());
        // make a new window to display this information

    }

    //SORT THE TABLE
}
