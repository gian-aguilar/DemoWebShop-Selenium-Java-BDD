package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	private By bluJeansProduct = By.xpath("//h2[@class='product-title']//a[text()='Blue Jeans']");

	public void clickProduct() {
		click(bluJeansProduct);
	}

}
