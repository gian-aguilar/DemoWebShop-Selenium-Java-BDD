package stepdefinitions;

import org.junit.Assert;

import hooks.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;

public class LogoutSteps {
	
	HomePage homePage;
	LoginPage loginPage;
	
	public LogoutSteps() {
		homePage = new HomePage(Hooks.driver);
	}
	
	@When("I Log out to demo web shop")
	public void I_Log_out_to_demo_web_shop() {		
		homePage.clickLogout();		
	}
	
	@Then("verify if the Login is visible")
	public void verify_if_the_Login_is_visible() {
		Assert.assertTrue("LOG OUT FAILED", homePage.isLoginLinkDisplayed());
		System.out.println("=== SUCCESS: THE LOG OUT LINK IS VISIBLE ===");
	}
	

}
