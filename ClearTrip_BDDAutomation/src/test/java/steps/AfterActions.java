package steps;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.clearTrip.utils.DriverManger;

import cucumber.api.Scenario;
import cucumber.api.java.After;

/**
 * @author Dilep Kumar Mangalapudi
 *
 */


public class AfterActions {

    @After
    public static void tearDown(Scenario scenario) {
        WebDriver driver = DriverManger.getDriver();
        if (scenario.isFailed()) {
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshotBytes, "image/png");
        }
        DriverManger.tearDown();
    }
}
