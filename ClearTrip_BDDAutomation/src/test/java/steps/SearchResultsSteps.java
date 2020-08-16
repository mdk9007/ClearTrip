package steps;

import com.clearTrip.pages.FlightSearchResultsPageRU;
import com.clearTrip.utils.CaptureScreenShot;
import com.clearTrip.utils.CommonMethods;
import com.clearTrip.utils.DriverManger;
import com.cucumber.listener.Reporter;

import cucumber.api.java.en.Then;

/**
 * @author Dilep Kumar Mangalapudi
 *
 */


public class SearchResultsSteps {

    FlightSearchResultsPageRU searchActions = new FlightSearchResultsPageRU();

    @Then("^I select (\\d+) Flight and (\\d+) flight to book tickets$")
    public void i_select_Flight_and_flight_to_book_tickets(int depart, int retr) throws Exception {
        String beforeSelect = new CaptureScreenShot().capture(DriverManger.getDriver(), "Before_Select_Flight");
        Reporter.addScreenCaptureFromPath(beforeSelect, "Before selection of Flights");
        searchActions.clickToChooseDeparture_ReturnFlights(searchActions.getDepartureFlightsList(), searchActions.getReturnFlightsList(), depart,
                retr);
        Reporter.addStepLog("After Selecting From and To Flights");
        String AfterSelect = new CaptureScreenShot().capture(DriverManger.getDriver(), "After_Select_Flight");
        Reporter.addScreenCaptureFromPath(AfterSelect, "After selection of Flights");
    }

    @Then("^I read departure Flights (\\d+) rowData$")
    public void i_read_DepartureFlights_rowData(int row) throws Exception {
        System.out.println("Departure Flight details: ");
        searchActions.getSelectedRowData(searchActions.getDepartureFlightsList(), row);
        System.out.println("========================");
    }

    @Then("^I read Return Flights (\\d+) rowData$")
    public void i_read_ReturnFlights_rowData(int row) throws Exception {
        System.out.println("Return Flight details: ");
        searchActions.getSelectedRowData(searchActions.getReturnFlightsList(), row);
        System.out.println("========================");
    }

    @Then("^I Book the Tickets$")
    public void i_Book_Tickets() throws Exception {
        searchActions.clickBookTikcetsButton();
        CommonMethods.waitFor(10000);
        String reivewPage = new CaptureScreenShot().capture(DriverManger.getDriver(), "ReivewPage");
        Reporter.addScreenCaptureFromPath(reivewPage, "CheckoutPage");
    }
}
