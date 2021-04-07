import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;
public class StatisticsController implements Initializable {
    private AirbnbDataLoader dataLoader;
    private ArrayList<AirbnbListing> propertyList;
    @FXML private Label statistic1;
    @FXML private Label statistic2;
    @FXML private Label statistic3;
    @FXML private Label statistic4;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dataLoader = new AirbnbDataLoader();
        propertyList = new ArrayList<>();
        propertyList = dataLoader.load();
        setStatAverageReviews();
        setStatAvailableProperties();
        setStatNumberOfHouses();
        setStatMostExpensive();
    }


/**
 * Most expensive borough
 */
private String expensiveBorough(ArrayList<AirbnbListing> listings) {
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
    String returnString = "";
    Iterator<String> it = distinctNeighbourhoods.iterator() ;
    for (int i =0;i < distinctNeighbourhoodsMap.size();i++) {
        String temp = "";
        temp = it.next();

        if (max < distinctNeighbourhoodsMap.get(temp) ) {
            max = distinctNeighbourhoodsMap.get(temp);
            returnString = temp;
        }
    }
    return returnString;
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


    private void setStatAverageReviews(){
        statistic1.setText("This is a stats label");
    }
    private void setStatAvailableProperties(){
        statistic2.setText("This is a stats label");
    }
    private void setStatNumberOfHouses(){
        statistic3.setText("The of Homes and Apartments is: " + homesAndApartments(propertyList));
    }
    private void setStatMostExpensive(){
        statistic4.setText("The most expensive borough is: "+expensiveBorough(propertyList));
    }
}