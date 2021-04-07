import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;


import java.lang.reflect.Array;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;

public class StatisticsController implements Initializable {
    private AirbnbDataLoader dataLoader;
    private ArrayList<AirbnbListing> propertyList;
    private ArrayList<String> stats = new ArrayList<>();

    @FXML private Label statistic1;
    @FXML private Label statistic2;
    @FXML private Label statistic3;
    @FXML private Label statistic4;

    @FXML private Button left1,left2,left3,left4;
    @FXML private Button right1,right2,right3,right4;

    int count = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dataLoader = new AirbnbDataLoader();
        propertyList = new ArrayList<>();
        propertyList = dataLoader.load();
        propertyList = filter(propertyList);

        statistic1.setText(averageReviewCount(propertyList));
        statistic2.setText( avalailableProperties(propertyList));
        statistic3.setText(homesAndApartments(propertyList));
        statistic4.setText(expensiveBorough(propertyList));

        stats.add(averageReviewCount(propertyList));
        stats.add(avalailableProperties(propertyList));
        stats.add(homesAndApartments(propertyList));
        stats.add(expensiveBorough(propertyList));
        stats.add(mostCommonRoomType(propertyList));

        count = 4;

    }

    /**
     * Filter the listings
     */
    private ArrayList<AirbnbListing> filter(ArrayList<AirbnbListing> listings) {
        ArrayList<AirbnbListing> filtered = new ArrayList<>();
        for (AirbnbListing listing : listings) {
            if (listing.getPrice() < Controller.max && listing.getPrice() > Controller.min) {
                filtered.add(listing);
            }
        }
        return filtered;
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

        //Make it into a hashmap so we can associate Name with number
        Object[] neighbourhoods = distinctNeighbourhoods.toArray();
        HashMap<String, Integer> distinctNeighbourhoodsMap = new HashMap<>();
        for (int i = 0; i < distinctNeighbourhoods.size();i++) {
            distinctNeighbourhoodsMap.put(((String) neighbourhoods[i]),0);
        }

        //Compute (price * minimum days) and add it to the entries
        int tempCount = 0;
        for (AirbnbListing listing : listings) {
            tempCount = distinctNeighbourhoodsMap.get(listing.getNeighbourhood());
            tempCount += listing.getPrice() * listing.getMinimumNights();
            distinctNeighbourhoodsMap.put(listing.getNeighbourhood(), tempCount);
        }

        //Filter for the most expensive Entry
        int max =0;
        String returnString = "";
        String temp = "";
        Iterator<String> it = distinctNeighbourhoods.iterator() ;
        for (int i =0;i < distinctNeighbourhoodsMap.size();i++) {
            temp = it.next();

            if (max < distinctNeighbourhoodsMap.get(temp) ) {
                max = distinctNeighbourhoodsMap.get(temp);
                returnString = temp;
            }
        }

        return ("The most expensive borough is: "+returnString);
    }  

    /**
     * The number of entire home and apartments (as opposed to private rooms)
     * @return number of homes and apartments (no private rooms)
     */
    private String homesAndApartments(ArrayList<AirbnbListing> listings) {

        //Find all those that are not a private room
        int count = 0;
        for (AirbnbListing listing : listings) {
            if (!(listing.getRoom_type().equals("Private room"))) {
                count++;
            }
        }
        return ("The number of houses or apartments is "+count);
    }

    /**
     * average number of reviews for each property
     */
    private String averageReviewCount(ArrayList<AirbnbListing> propertyList){
        int sum = 0;
        int numOfProperties = 0;
        for (AirbnbListing listing: propertyList){
            sum = sum+listing.getNumberOfReviews();
            numOfProperties++;
        }

        //Whenever we are dividing by zero
        try {
            return ("The average number of reviews per property is: "+(sum/numOfProperties));
        } catch (ArithmeticException e) {
            return "0";
        }
    }

    /**
     * number of available properties
     */
    private String avalailableProperties(ArrayList<AirbnbListing> listings){
        return ("The number of available properties is: "+listings.size());

    }

    /**
     *
     * @return
     */
    private String mostCommonRoomType(ArrayList<AirbnbListing> listings) {
        int countPrivateRoom = 0;
        int countHouse = 0;
        for (int i =0; i < listings.size(); i++) {
            if (listings.get(i).getRoom_type().equals("Private room")) {
                countPrivateRoom++;
            } else {countHouse++;}
        }
        if (countPrivateRoom > countHouse) {
            return "The most common room type is: Private room";
        } else return "The most common room type is: Entirehome/apt";
    }


    /**
     * For when the right buttons are pressed
     */
    @FXML
    private void goRight(ActionEvent event) {
        double x= ((Button)event.getSource()).getTranslateZ();
        int prevCount = 0;
        if (x == 1) {
            //righ1
            for (int i = 0;i < stats.size();i++) {
                if (stats.get(i).equals(statistic1.getText())) {
                    prevCount = i;
                }
            }
            statistic1.setText(stats.get(count));
            count = prevCount;
        } else if(x== 2){
            //right2
            for (int i = 0;i < stats.size();i++) {
                if (stats.get(i).equals(statistic2.getText())) {
                    prevCount = i;
                }
            }
            statistic2.setText(stats.get(count));
            count = prevCount;
        } else  if(x == 3) {
            ///right3
            for (int i = 0;i < stats.size();i++) {
                if (stats.get(i).equals(statistic3.getText())) {
                    prevCount = i;
                }
            }
            statistic3.setText(stats.get(count));
            count = prevCount;
        }else if (x == 4) {
            //rigt4
            for (int i = 0;i < stats.size();i++) {
                if (stats.get(i).equals(statistic4.getText())) {
                    prevCount = i;
                }
            }
            statistic4.setText(stats.get(count));
            count = prevCount;
        }
    }

    /**
     * For when the left buttons are pressed
     */
    @FXML
    private void goLeft(ActionEvent event) {
        double x= ((Button)event.getSource()).getTranslateZ();
        int prevCount = 0;
        if (x == 1) {
            //left1

            for (int i = 0;i < stats.size();i++) {
                if (stats.get(i).equals(statistic1.getText())) {
                    prevCount = i;
                }
            }
            statistic1.setText(stats.get(count));
            count = prevCount;

        } else if(x== 2){
            //left2

            for (int i = 0;i < stats.size();i++) {
                if (stats.get(i).equals(statistic2.getText())) {
                    prevCount = i;
                }
            }
            statistic2.setText(stats.get(count));
            count = prevCount;

        } else  if(x == 3) {
            //left3
            for (int i = 0;i < stats.size();i++) {
                if (stats.get(i).equals(statistic3.getText())) {
                    prevCount = i;
                }
            }
            statistic3.setText(stats.get(count));
            count = prevCount;
        }else if (x == 4) {
            //left4
            for (int i = 0;i < stats.size();i++) {
                if (stats.get(i).equals(statistic4.getText())) {
                    prevCount = i;
                }
            }
            statistic4.setText(stats.get(count));
            count = prevCount;
        }
    }


}
