package com.clearTrip.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Dilep Kumar Mangalapudi
 *
 */

public class FlightsSearchPageLocators {

    @FindBy(xpath = "//ul[@class='navGroup productNav withArrows']/a[@href='/flights']")
    public WebElement we_FlightsBtn;

    @FindBy(id = "RoundTrip")
    public WebElement we_RoundTripRadioBtn;

    @FindBy(id = "FromTag")
    public WebElement we_FromTag;

    @FindBy(id = "ToTag")
    public WebElement we_ToTag;

    @FindBy(id = "DepartDate")
    public WebElement we_DepartDate;

    @FindBy(id = "ReturnDate")
    public WebElement we_ReturnDate;

    @FindBy(css = "#Adults")
    public WebElement we_Adults;

    @FindBy(css = "#Childrens")
    public WebElement we_Children;

    @FindBy(css = "#SearchBtn")
    public WebElement we_SearchBtn;

    @FindBy(xpath = "//label[contains(text(),'Infants')]")
    public WebElement we_Infants;
}
