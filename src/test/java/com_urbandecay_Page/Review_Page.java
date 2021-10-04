package com_urbandecay_Page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com_urbandecay_Generic.BasePage;
import com_urbandecay_Generic.BaseTest;

public class Review_Page extends BaseTest {

	@FindBy(xpath = "//span[contains(.,'Review Order')]")
	private WebElement Review_order_button;

	@FindBy(xpath = "//button[@type='submit'][contains(.,'Review Order')]")
	private WebElement buttonrevieworderunderpaymnt;

	@FindBy(xpath = "//button[@type='submit'][contains(.,'Place Order')]")
	private WebElement buttonPlaceOrder;

	@FindBy(xpath = "//label[@class='f_label class.form.label '][contains(.,'I accept the general')]")
	private WebElement chkboxAcceppterms;

	public Review_Page(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public void clickonReviewButton() throws InterruptedException {
		// BasePage.verifyElement(Review_order_button);
		// Review_order_button.isEnabled();

		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].click();", Review_order_button);
		Thread.sleep(5000);
		// Reporter.log("Button text is = " + Review_order_button.getText(), true);
		// Reporter.log("User is in Review Order Page", true);
		Reporter.log("========================================", true);
	}

	public void clickonReviewButtonPayemnet() throws InterruptedException {
		// BasePage.verifyElement(Review_order_button);
		 buttonrevieworderunderpaymnt.isEnabled();

		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].click();", buttonrevieworderunderpaymnt);
		Thread.sleep(5000);
		// Reporter.log("Button text is = " + Review_order_button.getText(), true);
		// Reporter.log("User is in Review Order Page", true);
		Reporter.log("============buttonrevieworderunderpaymnt============================", true);
	}

	public void clickonplaceorder() throws InterruptedException {
		// BasePage.verifyElement(Review_order_button);
		buttonPlaceOrder.isEnabled();

		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].click();", chkboxAcceppterms);
		executor.executeScript("arguments[0].click();", buttonPlaceOrder);
		Thread.sleep(5000);
		
		
	}
}
