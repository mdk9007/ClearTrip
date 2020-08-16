package com.clearTrip.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.clearTrip.pages.locators.FlightsSearchPageLocators;
import com.clearTrip.utils.CommonMethods;
import com.clearTrip.utils.DriverManger;

/**
 * @author Dilep Kumar Mangalapudi
 *
 */


public class FlightsSearchPage {

    FlightsSearchPageLocators flightSearchPageLoc = null;
    CommonMethods common = new CommonMethods();
    WebDriver driver;

    public FlightsSearchPage() {
        flightSearchPageLoc = new FlightsSearchPageLocators();
        driver = DriverManger.getDriver();
        PageFactory.initElements(driver, flightSearchPageLoc);

    }

    public void chooseToHaveRoundTripJourney() {
        flightSearchPageLoc.we_RoundTripRadioBtn.click();
    }

    public void enterSourceAs(String sourceLocation) {
        flightSearchPageLoc.we_FromTag.clear();
        flightSearchPageLoc.we_FromTag.sendKeys(sourceLocation);
    }


    public void enterDestinationAs(String destinationLoc) {
        flightSearchPageLoc.we_ToTag.clear();
        flightSearchPageLoc.we_ToTag.sendKeys(destinationLoc);
    }

    public void selectDay(String date) {
        String day = date.split("/")[0];
        DriverManger.getDriver().findElement(By.xpath("//*[@class='monthBlock first']//a[text()='" + day + "']")).click();
    }

    public void enterDepartureDateAs(String date) {
        flightSearchPageLoc.we_DepartDate.click();
        selectDay(date);
    }

    public void enterReturnDateAs(String date) {
        flightSearchPageLoc.we_ReturnDate.click();
        selectDay(date);
    }

    public void selectNumberOfAdults(String adults) {
        Actions actions = new Actions(driver);
        actions.moveToElement(flightSearchPageLoc.we_Infants).click().build().perform();
        Select select = new Select(flightSearchPageLoc.we_Adults);
        select.selectByValue(adults);
        CommonMethods.waitFor(2000);
    }

    public void selectNumberOfChilds(String childs) {
        Select select = new Select(flightSearchPageLoc.we_Children);
        select.selectByValue(childs);
        CommonMethods.waitFor(2000);
    }

    public void selectTheFirstAvailableAutoCompleteOptionFromSource() {
        By locator = By.cssSelector("#ui-id-1");
        common.waitForElement(locator);
        List<WebElement> originOptions = DriverManger.getDriver().findElement(locator).findElements(By.tagName("li"));
        originOptions.get(0).click();
        CommonMethods.waitFor(2000);
    }

    public void selectTheFirstAvailableAutoCompleteOptionFromDestination() {
        By locator = By.cssSelector("#ui-id-2");
        common.waitForElement(locator);
        List<WebElement> originOptions = DriverManger.getDriver().findElement(locator).findElements(By.tagName("li"));
        originOptions.get(0).click();
        CommonMethods.waitFor(3000);
    }

    public void clickSearchButton() {
        flightSearchPageLoc.we_SearchBtn.click();
        CommonMethods.waitFor(20000);
    }

    public void sortFlightByDuration() {
        By locator = By.xpath("//*[text()='Duration']");
        common.getElementByVisibilty(locator);
        List<WebElement> elements = DriverManger.getDriver().findElements(locator);
        elements.get(0).click();
        CommonMethods.waitFor(3000);
        elements.get(1).click();
        CommonMethods.waitFor(3000);
    }

}
