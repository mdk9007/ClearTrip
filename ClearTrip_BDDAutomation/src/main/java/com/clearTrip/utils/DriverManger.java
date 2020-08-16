package com.clearTrip.utils;

import java.awt.Toolkit;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * @author Dilep Kumar Mangalapudi
 *
 */


public class DriverManger {
    private static DriverManger driverManager;
    private static WebDriver webDriver;
    public final static int TIMEOUT = 30;
    public final static int PAGE_LOAD_TIMEOUT = 50;

    public DriverManger(String browserType) {
        if (browserType.contains("chrome")) {
            File resourcesDirectory = new File("src/test/resources/Driver/chrome/chromedriver");
            String chromePath = resourcesDirectory.getAbsolutePath();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            System.err.println(System.getProperty("user.dir"));
            System.setProperty("webdriver.chrome.driver", chromePath);
            webDriver = new ChromeDriver(options);
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension screenResolution = new Dimension((int) toolkit.getScreenSize().getWidth(),
                    (int) toolkit.getScreenSize().getHeight());
            webDriver.manage().window().setSize(screenResolution);
        } else if (browserType.contains("safari")) {
            webDriver = new SafariDriver();
            webDriver.manage().window().maximize();
        } else {
            Assert.fail("unknown browser has selected, pls check browser type is Chrome/Safari");
        }
        new WebDriverWait(webDriver, TIMEOUT);
        webDriver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    }

    public static void openPage(String url) {
        System.out.println("Application URL is->  " + url);
        webDriver.get(url);
        System.out.println("=================================");
    }

    public static WebDriver getDriver() {
        return webDriver;
    }

    public static void setUpDriver() {
        if (driverManager == null) {
            String browserName = System.getProperty("browser");
            System.out.println("Scripts are executing on " + browserName + " Browser");
            driverManager = new DriverManger(browserName);
        }
    }

    public static void tearDown() {
        if (webDriver != null) {
            webDriver.close();
        }
        driverManager = null;
    }
}
