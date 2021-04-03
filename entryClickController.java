import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class entryClickController implements Initializable {


    @FXML
    private Label nameLabel;

    private AirbnbListing airbnbListingToDisplay;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     *
     * @param airbnbListingToDisplay
     */
    public void setAirbnbListingToDisplay(AirbnbListing airbnbListingToDisplay) {
        nameLabel.setText(airbnbListingToDisplay.getName());
    }
}
