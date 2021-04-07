import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;

public class BoroughController implements Initializable {

    //FXML fields
    @FXML
    private Button Enfield, Waltham, Westminster, Hillingdon, Havering, Wandsworth,Lewisham, Tower, Hounslow, Redbridge, Southwark, Camden, Bromley, Lambeth, Kensington, Islington, Barnet, Richmond, Kingston, Harrow, Sutton, Haringey, Brent, Bexley, Hackney, Greenwich, Hammersmith, Merton, Croydon, Newham, Ealing,City, Barking;
    @FXML
    private Label EnfieldLabel, WalthamLabel, WestminsterLabel, HillingdonLabel, HaveringLabel, WandsworthLabel,LewishamLabel, TowerLabel, HounslowLabel, RedbridgeLabel, SouthwarkLabel, CamdenLabel, BromleyLabel, LambethLabel, KensingtonLabel, IslingtonLabel, BarnetLabel, RichmondLabel, KingstonLabel, HarrowLabel, SuttonLabel, HaringeyLabel, BrentLabel, BexleyLabel, HackneyLabel, GreenwichLabel, HammersmithLabel, MertonLabel, CroydonLabel, NewhamLabel, EalingLabel,CityLabel, BarkingLabel;
    //Fields
    private ArrayList<AirbnbListing> listings = new ArrayList<>();
    private ArrayList<String> distinctneighbourhoods;
    private ArrayList<Label> labels;

    /**
     * Initialize the controller
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AirbnbDataLoader airbnbDataLoader = new AirbnbDataLoader();
        listings = airbnbDataLoader.load();
        distinctneighbourhoods = new ArrayList<String>(getdistinctBorough(listings));
        labels = new ArrayList<Label>();
        addLabels();
        showLabel();
    }

    /**
     * Populate the labels list
     * (FIND A BETTER WAY TO DO THIS0)
     */
    private void addLabels() {
        labels.add(EnfieldLabel);
        labels.add(WalthamLabel);
        labels.add(WestminsterLabel);
        labels.add(HillingdonLabel);
        labels.add(HaveringLabel);
        labels.add(WandsworthLabel);
        labels.add(LewishamLabel);
        labels.add(TowerLabel);
        labels.add(HounslowLabel);
        labels.add(RedbridgeLabel);
        labels.add(SouthwarkLabel);
        labels.add(CamdenLabel);
        labels.add(BromleyLabel);
        labels.add(LambethLabel);
        labels.add(KensingtonLabel);
        labels.add(IslingtonLabel);
        labels.add(BarnetLabel);
        labels.add(RichmondLabel);
        labels.add(KingstonLabel);
        labels.add(HarrowLabel);
        labels.add(SuttonLabel);
        labels.add(HaringeyLabel);
        labels.add(BrentLabel);
        labels.add(BexleyLabel);
        labels.add(HackneyLabel);
        labels.add(GreenwichLabel);
        labels.add(HammersmithLabel);
        labels.add(MertonLabel);
        labels.add(CroydonLabel);
        labels.add(NewhamLabel);
        labels.add(EalingLabel);
        labels.add(CityLabel);
        labels.add(BarkingLabel);
    }

    /**
     * Will update the labels with the number of properties available
     * everytime the price range is updated
     */
    private void showLabel() {
        int count = 0;
        for (int y = 0;y<distinctneighbourhoods.size();y++) {
            for (int i = 0;i<listings.size();i++) {
                if (distinctneighbourhoods.get(y).equals(listings.get(i).getNeighbourhood())) {
                    if (listings.get(i).getPrice() <= Controller.max && listings.get(i).getPrice() >= Controller.min)
                        count++;
                    }
                }
            for (int x = 0; x < distinctneighbourhoods.size();x++) {

                if (labels.get(x).getText().equals(distinctneighbourhoods.get(y))) {
                    labels.get(x).setText("" + count);
                }
            }
            count = 0;
        }
    }

    /**
     * Filters the list for all properties within the borough and within  the price range
     * @param name
     * @param listings
     * @return filtered
     */
    private ArrayList<AirbnbListing> filterListings(String name, ArrayList<AirbnbListing> listings) {
        ArrayList<AirbnbListing> filtered = new ArrayList<>();
        for (int i =0;i<listings.size();i++) {
            if (name.equals(listings.get(i).getNeighbourhood()) && listings.get(i).getPrice() <= Controller.max && listings.get(i).getPrice() >= Controller.min) {
                filtered.add(listings.get(i));
            }
        }
        return filtered;
    }

    /**
     * Handles event when a button is pressed.
     * Creates a new a table view of all the properties in that borough within that price range
     * ButtonClickController is the controller class
     * @param event
     */
    @FXML
    private void boroughClicked(ActionEvent event) {
        String neighbourhood = ((Button)event.getSource()).getText();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("buttonClick.fxml"));
            ScrollPane root = fxmlLoader.load();
            ((ButtonClickController)fxmlLoader.getController()).display(filterListings(neighbourhood,listings));
            Stage stage = new Stage();
            stage.setTitle(neighbourhood);
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Uses a hashset to get all the distinct boroughs in the data
     * @param listings
     * @return
     */
    private HashSet<String> getdistinctBorough(ArrayList<AirbnbListing> listings) {
        HashSet<String> distinctNeighbourhoods = new HashSet<>();
        for (AirbnbListing listing : listings) {
            distinctNeighbourhoods.add(listing.getNeighbourhood());
        }
        return distinctNeighbourhoods;
    }
}
