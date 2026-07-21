package base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.ConfigReader;

public class DriverFactory {
    public static WebDriver driver;

    public static WebDriver getDriver() {
        Properties prop = ConfigReader.initializeProperties();
        String browserName = System.getProperty("browser") != null 
                ? System.getProperty("browser") 
                : prop.getProperty("browser");
        
        if (browserName == null) {
            browserName = "chrome";
        }

        if (driver == null) {
            if (browserName.equalsIgnoreCase("chrome")) {
            	ChromeOptions options = new ChromeOptions();
            	options.addArguments("--headless=new"); // Runs Chrome without a UI
            	options.addArguments("--no-sandbox"); // Required for Linux environments
            	options.addArguments("--disable-dev-shm-usage"); // Overcomes resource limits in containers
            	options.addArguments("--window-size=1920,1080"); // Sets a virtual resolution
            	
            	driver = new ChromeDriver(options);
            } else if (browserName.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}