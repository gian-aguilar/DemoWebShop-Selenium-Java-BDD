package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

	public ProductPage(WebDriver driver) {
		super(driver);
	}

	private By addToCartButton = By.id("add-to-cart-button-36");
	private By toastAddToCart = By.cssSelector("p.content");
	private By quantityInput = By.cssSelector(".qty-input");

	public void clickAddToCart() {
		click(addToCartButton);
	}

	public boolean isToastMessageDisplayed() {		
		try {
            return waitForVisibility(toastAddToCart).isDisplayed();
        } catch (Exception e) {
            return false;
        }
		
	}

	public String getProductQuantity() {
		return driver.findElement(quantityInput).getAttribute("value");
	}

}
