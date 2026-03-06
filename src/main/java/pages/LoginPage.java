package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ConfigReader;

public class LoginPage extends BasePage {

	HomePage homePage;
	Properties prop;

	public LoginPage(WebDriver driver) {
		super(driver);
		homePage = new HomePage(driver);
		prop = ConfigReader.initializeProperties();
	}

	// locators
	private By emailField = By.id("Email");
	private By passwordField = By.id("Password");
	private By loginButton = By.cssSelector(".login-button");
	private By logoutLink = By.linkText("Log out");
	private By invalidLoginMessage = By.xpath("//span[text()='Login was unsuccessful. Please correct the errors and try again.']");

	// method
	public void enterCredentials(String username, String password) {
		type(emailField, username);
		type(passwordField, password);
	}

	public void clickLogin() {
		click(loginButton);
	}

	public boolean isLogoutLinkDisplayed() {
		try {
            return waitForVisibility(logoutLink).isDisplayed();
        } catch (Exception e) {
            return false;
        }
	}

	public void navigateToLogin() {
		//driver.get("https://demowebshop.tricentis.com/");
		String baseUrl = prop.getProperty("url");
		driver.get(baseUrl);
		homePage.clickLogin();
	}
	
//	public boolean isinvalidLoginMessageDisplayed() {
//		try {
//			return wait.until(ExpectedConditions.visibilityOfElementLocated(invalidLoginMessage)).isDisplayed();
//		} catch (Exception e) {
//			return false;
//		}
//	}
	
	public String getErrorMessage() {
	    return waitForVisibility(invalidLoginMessage).getText();
	}

}


