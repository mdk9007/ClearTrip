package steps;

import com.clearTrip.pages.FlightsSearchPage;
import com.clearTrip.utils.CommonMethods;
import com.clearTrip.utils.DriverManger;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * @author Dilep Kumar Mangalapudi
 *
 */


public class SearchFlightSteps {

    FlightsSearchPage flightSearchPage = new FlightsSearchPage();

    @Given("^I am on the Home Page \"([^\"]*)\" of cleartrip Website$")
    public void i_am_on_the_Home_Page_of_cleartrip_Website(String url) throws Exception {
        DriverManger.openPage(url);
    }

    @Then("^I select RoundTrip radioButton$")
    public void i_select_RoundTrip_dropdown() throws Exception {
        flightSearchPage.chooseToHaveRoundTripJourney();
        System.out.println("Selected RoundTrip");
    }

    @Then("^I enter \"([^\"]*)\" and \"([^\"]*)\" values$")
    public void i_enter_and_values(String from, String to) throws Exception {
        flightSearchPage.enterSourceAs(from);
        flightSearchPage.selectTheFirstAvailableAutoCompleteOptionFromSource();
        flightSearchPage.enterDestinationAs(to);
        flightSearchPage.selectTheFirstAvailableAutoCompleteOptionFromDestination();
        System.out.println("Selected source as " + from + " and destination is " + to);
    }

    @Then("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void i_enter_and(String departDate, String returnDate) throws Exception {
        flightSearchPage.enterDepartureDateAs(departDate);
        CommonMethods.waitFor(2000);
        System.out.println("Entered Departure Date is " + departDate);
        flightSearchPage.enterReturnDateAs(returnDate);
        CommonMethods.waitFor(2000);
        System.out.println("Entered Return Date is " + returnDate);
    }

    @Then("^I select \"([^\"]*)\" and \"([^\"]*)\"$")
    public void i_select_and(String adult, String child) throws Exception {
        flightSearchPage.selectNumberOfAdults(adult);
        CommonMethods.waitFor(2000);
        System.out.println("Selected number of Adults are " + adult);
        flightSearchPage.selectNumberOfChilds(child);
        CommonMethods.waitFor(2000);
        System.out.println("Selected number of childs are " + child);
    }

    @Then("^I click on Search Flights$")
    public void i_click_on_Search_Flights() throws Exception {
        flightSearchPage.clickSearchButton();
        flightSearchPage.sortFlightByDuration();
    }
}
