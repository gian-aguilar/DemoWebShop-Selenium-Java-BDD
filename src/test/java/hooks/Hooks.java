package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import base.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class Hooks {
    public static WebDriver driver;
    Properties prop = ConfigReader.initializeProperties();

    @Before
    public void setup() {
        System.out.println("=== STARTING THE BROWSER ===");
        // Get driver from factory and assign it to the local driver variable
        driver = DriverFactory.getDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
    	if (scenario.isFailed()) {
            System.out.println("=== SCENARIO FAILED: TAKING SCREENSHOT ===");
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failed_Scenario_Screenshot");
    	}
    	
        System.out.println("=== CLOSING THE BROWSER ===");
        DriverFactory.quitDriver();
    }
}