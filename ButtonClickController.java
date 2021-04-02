import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ButtonClickController implements Initializable {

    @FXML private Label myLabel;

    private ArrayList<AirbnbListing> airbnbListings;

    @FXML
    private TableView<AirbnbListing> tableView;
    @FXML private TableColumn<AirbnbListing, String > hostNameCollumn;
    @FXML private TableColumn<AirbnbListing, Integer> priceCollumn;
    @FXML private TableColumn<AirbnbListing, Integer> numberOfReviewsCollumn;
    @FXML private TableColumn<AirbnbListing, Integer> minnumberOfNights;
    @FXML private TableColumn<AirbnbListing, String> neighbourhood;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hostNameCollumn.setCellValueFactory(new PropertyValueFactory<AirbnbListing, String>("host_name"));
        priceCollumn.setCellValueFactory(new PropertyValueFactory<AirbnbListing,Integer>("price"));
        numberOfReviewsCollumn.setCellValueFactory(new PropertyValueFactory<AirbnbListing, Integer>("numberOfReviews"));
        minnumberOfNights.setCellValueFactory(new PropertyValueFactory<AirbnbListing, Integer>("minimumNights"));
        neighbourhood.setCellValueFactory(new PropertyValueFactory<AirbnbListing,String>("neighbourhood"));

        System.out.println("hey");
    }

    public void display(String neighbourhood, ArrayList<AirbnbListing> listings) {
        tableView.setItems(getListing(listings));
    }

    public ObservableList<AirbnbListing> getListing(ArrayList<AirbnbListing> airbnbListings) {

        return FXCollections.observableArrayList(airbnbListings);
    }
}
