import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.*;

public class StatisticsController implements Initializable {
    @FXML private Label statistic1;
    @FXML private Label statistic2;
    @FXML private Label statistic3;
    @FXML private Label statistic4;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        statistic1.setText("This is a stats label");
        AirbnbDataLoader airbnbDataLoader = new AirbnbDataLoader();
        ArrayList<AirbnbListing> listings = airbnbDataLoader.load();

        statistic1.setText("The most expensive borough is: " + expensiveBorough(listings));
        statistic2.setText("The amount of homes and apartments is: " + homesAndApartments(listings));
    }


    /**
     * Most expensive borough
     */
    private int expensiveBorough(ArrayList<AirbnbListing> listings) {
        //Filter for distinct boroughs
        HashSet<String> distinctNeighbourhoods = new HashSet<>();
        for (AirbnbListing listing : listings) {
            distinctNeighbourhoods.add(listing.getNeighbourhood());
        }

        Object[] neighbourhoods = distinctNeighbourhoods.toArray();
        for (Object neighbourhood : neighbourhoods) {
            System.out.println(neighbourhood);
        }

        HashMap<String, Integer> distinctNeighbourhoodsMap = new HashMap<>();
        for (int i = 0; i < distinctNeighbourhoods.size();i++) {
            distinctNeighbourhoodsMap.put(((String) neighbourhoods[i]),0);
        }

        int tempCount = 0;

        for (AirbnbListing listing : listings) {
            tempCount = distinctNeighbourhoodsMap.get(listing.getNeighbourhood());
            tempCount++;
            distinctNeighbourhoodsMap.put(listing.getNeighbourhood(), tempCount);
        }

        int max =0;

        Iterator<String> it = distinctNeighbourhoods.iterator() ;
        for (int i =0;i < distinctNeighbourhoodsMap.size();i++) {
            String temp = "";
            temp = it.next();
            String mostExpensiveBorough = "";
            if (max < distinctNeighbourhoodsMap.get(temp) ) {
                max = distinctNeighbourhoodsMap.get(temp);
            }
        }
        return max;
    }

    /**
     * The number of entire home and apartments (as opposed to private rooms)
     * @return number of homes and apartments (no private rooms)
     */
    private int homesAndApartments(ArrayList<AirbnbListing> listings) {
        int count = 0;

        for (AirbnbListing listing : listings) {
            if (!(listing.getRoom_type().equals("Private room"))) {
                count++;
            }
        }
        return count;
    }
}