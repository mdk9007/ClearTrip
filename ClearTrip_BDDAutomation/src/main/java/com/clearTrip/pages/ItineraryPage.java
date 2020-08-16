package com.clearTrip.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.clearTrip.pages.locators.ItineraryPageLocators;
import com.clearTrip.utils.DriverManger;

/**
 * @author Dilep Kumar Mangalapudi
 *
 */


public class ItineraryPage {
    public static List<String> sourceFlightDetails = new ArrayList<String>();
    public static List<String> destinationFlightDetails = new ArrayList<String>();
    ItineraryPageLocators itineraryPageLocators = null;

    public ItineraryPage() {
        itineraryPageLocators = new ItineraryPageLocators();
        PageFactory.initElements(DriverManger.getDriver(), itineraryPageLocators);
    }

    public List<String> getOnwardJourneyFlightDetails() {
        List<WebElement> details = itineraryPageLocators.itinerary_onWardJourney.findElements(By.tagName("li"));
        System.err.println("count:" + details.size());
        sourceFlightDetails.add(details.get(0).findElement(By.cssSelector("span.name")).getText());
        sourceFlightDetails.add(details.get(1).findElement(By.cssSelector("span.placeTime")).getText());
        sourceFlightDetails.add(details.get(2).getText());
        sourceFlightDetails.add(details.get(3).findElement(By.cssSelector("span.placeTime")).getText());
        System.out.println("Flight Details: " + sourceFlightDetails.toString());
        return sourceFlightDetails;
    }

    public List<String> getReturnJourneyFlightDetails() {
        List<WebElement> details = itineraryPageLocators.itinerary_returnJourney.findElements(By.tagName("li"));
        System.err.println("count:" + details.size());
        destinationFlightDetails.add(details.get(0).findElement(By.cssSelector("span.name")).getText());
        destinationFlightDetails.add(details.get(1).findElement(By.cssSelector("span.placeTime")).getText());
        destinationFlightDetails.add(details.get(2).getText());
        destinationFlightDetails.add(details.get(3).findElement(By.cssSelector("span.placeTime")).getText());
        System.out.println("Flight Details: " + destinationFlightDetails.toString());
        return destinationFlightDetails;
    }
}
