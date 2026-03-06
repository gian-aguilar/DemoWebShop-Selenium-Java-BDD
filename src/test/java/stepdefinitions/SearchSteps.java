package stepdefinitions;

import java.util.Properties;

import org.junit.Assert;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchPage;
import utils.ConfigReader;

public class SearchSteps {

	HomePage homePage;
	SearchPage searchPage;
	Properties prop;
	
	public SearchSteps() {
		homePage = new HomePage(Hooks.driver);
		searchPage = new SearchPage(Hooks.driver);
		prop = ConfigReader.initializeProperties();		
	}

	@Given("I am on the demo shop home page")
	public void I_am_on_the_demo_shop_home_page() {
		String baseUrl = prop.getProperty("url");
		Hooks.driver.get(baseUrl);		
	}

	@When("I search for {string}")
	public void I_search_for_productname(String productname) {		
		homePage.inputSearch(productname);
		homePage.clickSearchButton();
	}

	@And("I click on the product {string}")
	public void I_click_on_the_product(String productname) {		
		searchPage.clickProduct();
	}

	@Then("the page title should contain {string}")
	public void the_page_title_should_contain(String productname) {
		String actualTitle = searchPage.getPageTitle();
		Assert.assertTrue("The page title did not contain the product name!", actualTitle.contains(productname));
	}

}
