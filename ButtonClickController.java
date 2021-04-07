import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
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


    /**
     * Add tables to the table and a listener when an entry is clicked
     *
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hostNameCollumn.setCellValueFactory(new PropertyValueFactory<>("host_name"));
        priceCollumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        numberOfReviewsCollumn.setCellValueFactory(new PropertyValueFactory<>("numberOfReviews"));
        minnumberOfNights.setCellValueFactory(new PropertyValueFactory<>("minimumNights"));

        tableView.getSelectionModel().selectedItemProperty().addListener((observableValue, airbnbListing, t1) -> entryClick());
    }

    /**
     * Gives the table access to the (filtered) data
     */
    public void display(ArrayList<AirbnbListing> listings) {
        tableView.setItems(FXCollections.observableArrayList(listings));
    }

    /**
     * When an entry in the table is clicked, display extra information.
     */
    public void entryClick() {
        // make a new window to display this information
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("entryClick.fxml"));
        try {
            Stage stage = new Stage();
            stage.setTitle(tableView.getSelectionModel().selectedItemProperty().get().getNeighbourhood());
            stage.setScene(new Scene(fxmlLoader.load()));
            stage.setResizable(false);
            ((entryClickController) fxmlLoader.getController()).setAirbnbListingToDisplay(tableView.getSelectionModel().selectedItemProperty().get());
            stage.show();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
