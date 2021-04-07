

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class StatisticsControllerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StatisticsControllerTest
{
    /**
     * Default constructor for test class StatisticsControllerTest
     */
    public StatisticsControllerTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void checkAvgReviews()
    {
        AirbnbDataLoader airbnbDa1 = new AirbnbDataLoader();
        java.util.ArrayList<AirbnbListing> arrayLis1 = airbnbDa1.load();
        StatisticsController statisti1 = new StatisticsController();
        assertEquals("The average number of reviews per property is: 12", statisti1.averageReviewCount(arrayLis1));
    }

    @Test
    public void checkNumberOfProperties()
    {
        AirbnbDataLoader airbnbDa1 = new AirbnbDataLoader();
        java.util.ArrayList<AirbnbListing> arrayLis1 = airbnbDa1.load();
        StatisticsController statisti1 = new StatisticsController();
        assertEquals("The number of available properties is: 53904", statisti1.avalailableProperties(arrayLis1));
    }

    @Test
    public void mostExpensiveBorough()
    {
        AirbnbDataLoader airbnbDa1 = new AirbnbDataLoader();
        StatisticsController statisti1 = new StatisticsController();
        java.util.ArrayList<AirbnbListing> arrayLis1 = airbnbDa1.load();
        assertEquals("The most expensive borough is: Westminster", statisti1.expensiveBorough(arrayLis1));
    }

    @Test
    public void homesAndProperties()
    {
        StatisticsController statisti1 = new StatisticsController();
        AirbnbDataLoader airbnbDa1 = new AirbnbDataLoader();
        java.util.ArrayList<AirbnbListing> arrayLis1 = airbnbDa1.load();
        assertEquals("The number of houses or apartments is 27885", statisti1.homesAndApartments(arrayLis1));
    }

    @Test
    public void cheapestBorough()
    {
        AirbnbDataLoader airbnbDa1 = new AirbnbDataLoader();
        StatisticsController statisti2 = new StatisticsController();
        java.util.ArrayList<AirbnbListing> arrayLis1 = airbnbDa1.load();
        assertEquals("The cheapest borough is: Havering", statisti2.cheapestBorough(arrayLis1));
    }
}





