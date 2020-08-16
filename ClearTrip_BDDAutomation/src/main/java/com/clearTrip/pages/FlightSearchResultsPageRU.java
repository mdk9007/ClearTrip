package com.clearTrip.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.clearTrip.pages.locators.FlightSearchResultsPageLocators;
import com.clearTrip.utils.CommonMethods;
import com.clearTrip.utils.DriverManger;
import com.cucumber.listener.Reporter;

/**
 * @author Dilep Kumar Mangalapudi
 *
 */

public class FlightSearchResultsPageRU {

    FlightSearchResultsPageLocators flightSearchResultsPageLoc = null;

    public FlightSearchResultsPageRU() {
        flightSearchResultsPageLoc = new FlightSearchResultsPageLocators();
        PageFactory.initElements(DriverManger.getDriver(), flightSearchResultsPageLoc);
    }

    public WebElement getDepartureFlightsList() {
        return flightSearchResultsPageLoc.SearchResults_FromFlightsListView;
    }

    public WebElement getReturnFlightsList() {
        return flightSearchResultsPageLoc.SearchResults_ReturnFlightsListView;
    }

    public void clickBookTikcetsButton() {
        flightSearchResultsPageLoc.SearchResults_BookTicket.click();
    }

    public void clickToChooseDeparture_ReturnFlights(WebElement departList, WebElement returnList, int depart, int retu) {
        Reporter.addStepLog("Selecting " + depart + "st Flight");
        WebElement departelement = departList.findElement(By.xpath("li[" + depart + "]"));
        List<WebElement> colData = departelement.findElements(By.tagName("th"));
        colData.get(depart).click();
        CommonMethods.waitFor(3000);
        Reporter.addStepLog("Selecting " + retu + "st Flight");
        WebElement Returnelement = returnList.findElement(By.xpath("li[" + retu + "]"));
        List<WebElement> retcolData = Returnelement.findElements(By.tagName("th"));
        retcolData.get(retu).click();
        CommonMethods.waitFor(3000);
    }

    public List<String> getSelectedRowData(WebElement listview, int row) throws Exception {
        WebElement element = listview.findElement(By.xpath("li[" + row + "]"));
        java.util.List<String> flightData = new ArrayList<String>();
        List<WebElement> colData = element.findElements(By.tagName("th"));
        Reporter.addStepLog("Flight Details");
        flightData.add(colData.get(1).findElement(By.cssSelector("img")).getAttribute("title"));
        Reporter.addStepLog(colData.get(1).getAttribute("class") + ":" + colData.get(1).findElement(By.cssSelector("img")).getAttribute("title"));
        for (int i = 2; i < colData.size(); i++) {
            String text = colData.get(i).getText();
            Reporter.addStepLog(colData.get(i).getAttribute("class") + ":" + text.trim());
            System.out.println(colData.get(i).getAttribute("class") + "= " + text.trim());
            flightData.add(text);
        }
        return flightData;
    }
}
