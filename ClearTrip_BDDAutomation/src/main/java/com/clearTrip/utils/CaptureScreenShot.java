package com.clearTrip.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

/**
 * @author Dilep Kumar Mangalapudi
 *
 */


public class CaptureScreenShot {
    public static String timeStampString;

    public String capture(WebDriver driver, String screenShotName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir") + File.separator + "output" + File.separator + screenShotName + ".png";
        File destination = new File(dest);
        FileHandler.copy(source, destination);
        return dest;
    }
}
