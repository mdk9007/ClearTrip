package com.clearTrip.utils;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Dilep Kumar Mangalapudi
 *
 */


public class CommonMethods {
    WebDriver driver;

    @SuppressWarnings("deprecation")
    public WebElement presenceOfTheElement(final WebElement element) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverManger.getDriver())
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        return wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return element;
            }
        });
    }

    @SuppressWarnings({"unchecked", "rawtypes", "deprecation"})
    public WebElement getElementByVisibilty(final By byValue) {
        WebElement elem = null;
        FluentWait wait = new FluentWait(DriverManger.getDriver());
        wait.pollingEvery(1, TimeUnit.SECONDS);
        wait.withTimeout(90, TimeUnit.SECONDS);
        wait.ignoring(NoSuchElementException.class);
        Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver wd) {
                List<WebElement> elementList = wd.findElements(byValue);
                int listSize = elementList.size();
                if (listSize > 0) {
                    return elementList.get(listSize - 1);
                } else if (listSize == 1) {
                    return elementList.get(0);
                } else {
                    return null;
                }
            }
        };
        elem = (WebElement) wait.until(function);
        return elem;
    }

    public static void waitFor(int milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (Exception e) {
        }
    }

    public void waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(DriverManger.getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(DriverManger.getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
