package stepdefinitions;

import java.util.Properties;

import org.junit.Assert;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import utils.ConfigReader;

public class CartSteps {

	ProductPage productPage;
	HomePage homePage;
	CartPage cartPage;
	LoginPage loginPage;
	Properties prop;
	
	public CartSteps(){
		productPage = new ProductPage(Hooks.driver);
		homePage = new HomePage(Hooks.driver);
		loginPage = new LoginPage(Hooks.driver);
		cartPage = new CartPage(Hooks.driver);
		prop = ConfigReader.initializeProperties();
	}

	@Given("I am on the product viewing page")
	public void I_am_on_the_product_viewing_page() {
		//Hooks.driver.get("https://demowebshop.tricentis.com/blue-jeans");
		String itemBaseUrl = prop.getProperty("productUrl");
		Hooks.driver.get(itemBaseUrl);
	}

	@And("the shopping cart quantity should be {string} by default")
	public void the_shopping_cart_quantity_should_be_1_by_default(String expectedQuantity) {		
		String actualQuantity = productPage.getProductQuantity();
		Assert.assertEquals("The default quantity was NOT " + expectedQuantity, expectedQuantity, actualQuantity);

	}

	@When("I click the Add to cart button for {string}")
	public void I_click_the_Add_to_cart_button_for(String productname) {
		productPage.clickAddToCart();
	}

	@Then("a success message contains {string} should appear")
	public void a_success_message_contains_The_product_has_been_added_to_your_should_appear(String expectedMessage) {
		Assert.assertTrue("Add to cart failed: The toast message was not displayed!", productPage.isToastMessageDisplayed());
		System.out.println("=== SUCCESS: THE TOAST MESSAGE IS DISPLAYED ===");
	}

	@Given("I am logged in with valid credentials")
	public void i_am_logged_in_with_valid_credentials() {
		loginPage.navigateToLogin();
		loginPage.enterCredentials("testemail2026@testemail.com", "testpass2026");
		loginPage.clickLogin();
	}

	@And("I go to shopping cart")
	public void I_go_to_shopping_cart() {
		homePage.clickShoppingCartlink();
	}

	@When("I proceed to check process")
	public void I_proceed_to_check_process() {		
		cartPage.clickTosCheckBox();
		cartPage.clickCheckOut();
		cartPage.clickBillingContinue();
		cartPage.clickShippingContinue();
		cartPage.clickShippingMethodContinue();
		cartPage.clickPaymentMethodContinue();
		cartPage.clickPaymentInfoContinue();
		cartPage.clickConfirmOrder();
	}

	@Then("a confirmation message contains {string} should display")
	public void a_confirmation_message_should_display(String expectedSuccessOrderMessage) {
		Assert.assertTrue("ORDER FAILED", cartPage.isSuccessMessageDisplayed());
		System.out.println("=== SUCCESS: THE SUCCESSFUL ORDER MESSAGE IS DISPLAYED ===");
		cartPage.clickOrderCompleteBtn();
	}
}
