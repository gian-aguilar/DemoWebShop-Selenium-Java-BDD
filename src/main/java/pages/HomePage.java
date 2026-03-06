package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	private By loginLink = By.linkText("Log in");
	private By logoutLink = By.linkText("Log out");

	// Search
	private By searchBox = By.id("small-searchterms");
	private By searchButton = By.cssSelector(".search-box-button");

	// Shopping Cart
	private By shoppingCartlink = By.xpath("//span[contains(text(),'Shopping cart')]");

	// method
	public void clickLogin() {
		click(loginLink);
	}

	public void inputSearch(String productname) {
		type(searchBox, productname);
	}

	public void clickSearchButton() {
		click(searchButton);
	}

	public void clickShoppingCartlink() {
		click(shoppingCartlink);
	}
	
	public void clickLogout() {
		click(logoutLink);
	}
	
	public boolean isLoginLinkDisplayed() {
		try {
            return waitForVisibility(loginLink).isDisplayed();
        } catch (Exception e) {
            return false;
        }
	}
}
