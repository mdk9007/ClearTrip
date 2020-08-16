package steps;

import com.clearTrip.utils.DriverManger;

import cucumber.api.java.Before;

/**
 * @author Dilep Kumar Mangalapudi
 *
 */


public class BeforeActions {

    @Before
    public static void setUp() {
        System.out.println("In Setup method");
        DriverManger.setUpDriver();
    }
}
