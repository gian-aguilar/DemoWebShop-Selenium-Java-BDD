package stepdefinitions;

import java.util.Properties;

import org.junit.Assert;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginSteps {

	HomePage homePage;
	LoginPage loginPage;
	Properties prop;
	
	public LoginSteps(){
		homePage = new HomePage(Hooks.driver);
		loginPage = new LoginPage(Hooks.driver);
		prop = ConfigReader.initializeProperties();
	}

	@Given("I am on the demo web shop login page")
	public void I_am_on_the_demo_web_shop_login_page() {
		//Hooks.driver.get("https://demowebshop.tricentis.com/");
		String baseUrl = prop.getProperty("url");
		Hooks.driver.get(baseUrl);
		homePage.clickLogin();
	}

	@When("I enter {string} and {string}")
	public void I_enter_username_and_password(String username, String password) {
		loginPage.enterCredentials(username, password);

	}

	@And("I click the login button")
	public void I_click_the_login_button() {
		loginPage.clickLogin();
	}

	@Then("the logout link should display")
	public void the_logout_link_should_display() {
		Assert.assertTrue("LOGIN FAILED: Logout link not found!", loginPage.isLogoutLinkDisplayed());
	}
	
	@Then("the unsuccessful message {string} should display")
	public void the_unsuccessful_message_should_display(String expectedMessage) {
	    String actualMessage = loginPage.getErrorMessage();
	    Assert.assertEquals("Error message mismatch!", expectedMessage, actualMessage);
	}

}
