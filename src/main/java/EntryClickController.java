import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class EntryClickController implements Initializable {

    //FXML Fields
    @FXML private Label nameLabel;

    @FXML private Label coordinateLabel;
    @FXML private Label availability365Label;
    @FXML private Label roomTypeLabel;
    @FXML private Label hostNameLabel;
    @FXML private Label reviewsPerMonthLabel;
    @FXML private Label hostListingscountLabel;

    private AirbnbListing airbnbListingToDisplay;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * Get the listing here
     */
    public void setAirbnbListingToDisplay(AirbnbListing airbnbListingToDisplay) {
        this.airbnbListingToDisplay = airbnbListingToDisplay;
        display();
    }

    /**
     * Display the text
     */
    private void display() {
        nameLabel.setText(airbnbListingToDisplay.getName());

        coordinateLabel.setText("Coordinates: " + airbnbListingToDisplay.getLatitude() + " " + airbnbListingToDisplay.getLongitude());
        availability365Label.setText("Availability: " +airbnbListingToDisplay.getAvailability365());
        roomTypeLabel.setText("Room Type: " + airbnbListingToDisplay.getRoom_type());
        hostNameLabel.setText("Host Name: " + airbnbListingToDisplay.getHost_name());
        reviewsPerMonthLabel.setText("Reviews per Month: " + airbnbListingToDisplay.getReviewsPerMonth());
        hostListingscountLabel.setText("Number of listings " + airbnbListingToDisplay.getHost_name() + " has: " + airbnbListingToDisplay.getCalculatedHostListingsCount() );

    }
}
