package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

	public CartPage(WebDriver driver) {
		super(driver);
	}

	private By tosCheckBox = By.id("termsofservice");
	private By checkOutButton = By.id("checkout");
	private By billingContinueButton = By.cssSelector("input[onclick='Billing.save()']");
	private By shippingContinueButton = By.cssSelector("input[onclick='Shipping.save()']");
	private By shippingMethodContinueButton = By.cssSelector("input[onclick='ShippingMethod.save()']");
	private By paymentMethodContinueButton = By.cssSelector("input[onclick='PaymentMethod.save()']");
	private By paymentInfoContinueButton = By.cssSelector("input[onclick='PaymentInfo.save()']");
	private By confirmOrderButton = By.cssSelector("input[onclick='ConfirmOrder.save()']");
	private By successOrderMessage = By.xpath("//strong[text()='Your order has been successfully processed!']");
	private By orderCompletedContinueBtn = By.cssSelector("input[onclick=\"setLocation('/')\"]");

	public void clickTosCheckBox() {
		click(tosCheckBox);
	}

	public void clickCheckOut() {
		click(checkOutButton);
	}

	public void clickBillingContinue() {
		click(billingContinueButton);
	}

	public void clickShippingContinue() {
		click(shippingContinueButton);
	}

	public void clickShippingMethodContinue() {
		click(shippingMethodContinueButton);
	}

	public void clickPaymentMethodContinue() {
		click(paymentMethodContinueButton);
	}

	public void clickPaymentInfoContinue() {
		click(paymentInfoContinueButton);
	}

	public void clickConfirmOrder() {
		click(confirmOrderButton);
	}

	public boolean isSuccessMessageDisplayed() {		
		try {
            return waitForVisibility(successOrderMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }		
	}

	public void clickOrderCompleteBtn() {
		click(orderCompletedContinueBtn);
	}

}
