package pages;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConfigReader;

public class BasePage {

	protected WebDriver driver;
	protected WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		Properties prop = ConfigReader.initializeProperties();
		int timeout = Integer.parseInt(prop.getProperty("timeout", "20"));
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	}

	protected void click(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
		
		/*int attempts = 0;
		while(attempts < 3)
			try {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
		break;
			} catch (org.openqa.selenium.StaleElementReferenceException | org.openqa.selenium.ElementClickInterceptedException e) {
				attempts++;
				if (attempts == 3) throw e;
			} */
	}

	protected void type(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

	public String getPageTitle() {
		return driver.getTitle();
	}

	protected WebElement waitForVisibility(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	protected String getText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }
	
	protected void waitForPageLoaded() {
		wait.until(webDriver -> ((org.openqa.selenium.JavascriptExecutor) webDriver)
				.executeScript("return document.readyState").equals("complete"));
		}
	
	protected void waitForNotificationToDisappear() {
		try {
			By notificationBar = By.id("bar-notification");
			wait.until(ExpectedConditions.invisibilityOfElementLocated(notificationBar));
		} catch (Exception e) {
			
		}
	}
}
