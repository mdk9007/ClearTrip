package runners;

import java.io.File;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


/**
 * @author Dilep Kumar Mangalapudi
 *
 */

@CucumberOptions(
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:output/report.html"},
        features = "src/test/resources/FeatureFiles",
        glue = "steps",
        tags = {"@Book_Flight_Tikect"})
public class Runner extends AbstractTestNGCucumberTests {

    @Parameters({"browser"})
    @BeforeClass
    public static void setup(String browser) {
        System.setProperty("browser", browser);
        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        extentProperties.setReportPath("output/report.html");
    }

    @AfterClass
    public static void teardown() {
        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        Reporter.setSystemInfo("User ", System.getProperty("user.name"));
        Reporter.setSystemInfo("OS ", "Mac OSX");
        Reporter.setTestRunnerOutput("Sample test runner output message");
    }
}
