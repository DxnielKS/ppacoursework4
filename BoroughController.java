import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.apache.commons.lang3.ArrayUtils;


import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ResourceBundle;

public class BoroughController implements Initializable {


    @FXML
    private Button Enfield, Waltham, Westminster, Hillingdon, Havering, Wandsworth,Lewisham, Tower, Hounslow, Redbridge, Southwark, Camden, Bromley, Lambeth, Kensington, Islington, Barnet, Richmond, Kingston, Harrow, Sutton, Haringey, Brent, Bexley, Hackney, Greenwich, Hammersmith, Merton, Croydon, Newham, Ealing,City, Barking;

    @FXML
    private Label EnfieldLabel, WalthamLabel, WestminsterLabel, HillingdonLabel, HaveringLabel, WandsworthLabel,LewishamLabel, TowerLabel, HounslowLabel, RedbridgeLabel, SouthwarkLabel, CamdenLabel, BromleyLabel, LambethLabel, KensingtonLabel, IslingtonLabel, BarnetLabel, RichmondLabel, KingstonLabel, HarrowLabel, SuttonLabel, HaringeyLabel, BrentLabel, BexleyLabel, HackneyLabel, GreenwichLabel, HammersmithLabel, MertonLabel, CroydonLabel, NewhamLabel, EalingLabel,CityLabel, BarkingLabel;


    private ArrayList<AirbnbListing> listings = new ArrayList<>();
    private HashSet<String> distinctNeighbourhoods;
    private ArrayList<String> neighbourhoods;
    private ArrayList<Label> labels;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AirbnbDataLoader airbnbDataLoader = new AirbnbDataLoader();
        listings = airbnbDataLoader.load();
        distinctNeighbourhoods = new HashSet<String>();
        distinctNeighbourhoods = getdistinctBorough(listings);
        neighbourhoods = new ArrayList<String>(distinctNeighbourhoods);
        labels = new ArrayList<Label>();
        addLabels();
        showLabel();
    }

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

    private void showLabel() {
        int count = 0;
        for (int y = 0;y<neighbourhoods.size();y++) {
            for (int i = 0;i<listings.size();i++) {
                if (neighbourhoods.get(y).equals(listings.get(i).getNeighbourhood())) {
                    if (listings.get(i).getPrice() <= Controller.max && listings.get(i).getPrice() >= Controller.min)
                        count++;
                    }
                }
            for (int x = 0; x < neighbourhoods.size();x++) {

                if (labels.get(x).getText().equals(neighbourhoods.get(y))) {
                    labels.get(x).setText("" + count);
                }
            }
            count = 0;
        }
    }

    private ArrayList<AirbnbListing> filterListings(String name, ArrayList<AirbnbListing> listings) {
        ArrayList<AirbnbListing> filtered = new ArrayList<>();
        for (int i =0;i<listings.size();i++) {
            if (name.equals(listings.get(i).getNeighbourhood()) && listings.get(i).getPrice() <= Controller.max && listings.get(i).getPrice() >= Controller.min) {
                filtered.add(listings.get(i));
            }
        }
        return filtered;
    }


    @FXML
    private void hello(ActionEvent event) {
        String neighbourhood = ((Button)event.getSource()).getText();
        System.out.println(neighbourhood);
        // create a new window here
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("buttonClick.fxml"));
            ScrollPane root = fxmlLoader.load();
            ((ButtonClickController)fxmlLoader.getController()).display(neighbourhood,filterListings(neighbourhood,listings));
            Stage stage = new Stage();
            stage.setTitle("Second window");
            stage.setScene(new Scene(root));

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private HashSet<String> getdistinctBorough(ArrayList<AirbnbListing> listings) {
        HashSet<String> distinctNeighbourhoods = new HashSet<>();
        for (AirbnbListing listing : listings) {
            distinctNeighbourhoods.add(listing.getNeighbourhood());
        }
        return distinctNeighbourhoods;
    }
}
