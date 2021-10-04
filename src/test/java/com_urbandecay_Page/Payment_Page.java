package com_urbandecay_Page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com_urbandecay_Generic.BasePage;
import com_urbandecay_Generic.BaseTest;

public class Payment_Page extends BaseTest {

	@FindBy(xpath = "//div[@id='PaymentMethod_CREDIT_CARD_custom']/label")
	private WebElement Select_CreditCard;

	@FindBy(xpath = "//label[@for='is-CREDIT_CARD']")
	private WebElement radiobtnCC;

	@FindBy(xpath = "//input[@id='dwfrm_billing_paymentMethods_creditCard_owner']")
	private WebElement Card_Name;

	@FindBy(xpath = "//input[@id='dwfrm_billing_paymentMethods_creditCard_number']")
	private WebElement Card_Number;

	@FindBy(xpath = "//select[@id='dwfrm_billing_paymentMethods_creditCard_month']")
	private WebElement Month;

	@FindBy(xpath = "//select[@id='dwfrm_billing_paymentMethods_creditCard_year']")
	private WebElement Year;

	@FindBy(xpath = "//input[@id='dwfrm_billing_paymentMethods_creditCard_cvn']")
	private WebElement Security_Code;

	@FindBy(xpath = "button section_submit_button c-checkout__submit-button js-presubmit")
	private WebElement Review_Order_Button;

	public Payment_Page(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public void selectPaymentmethod() throws InterruptedException {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0,1000)");
		executor.executeScript("arguments[0].click();", radiobtnCC);
		// Select_CreditCard.click();
		Thread.sleep(5000);
		/*
		 * if(Select_CreditCard.isSelected()) {
		 * Reporter.log("Credit Card payment option is selected", true); } else {
		 * Reporter.log("Credit Card payment option is NOT selected", true); }
		 */

		executor.executeScript("window.scrollBy(0,1000)");
		Reporter.log("===============Credit Card payment option is selected=========================", true);
	}

	public void enterCardDetails(String cn, String cno, String Month_Text, String Year_Text, String sc)
			throws InterruptedException {
		Card_Name.clear();
		Card_Name.sendKeys("test");
		Thread.sleep(2000);
		Reporter.log("Card Name entered is = " + cn, true);
		Card_Number.clear();
		Card_Number.sendKeys("4111111111111111");
		Reporter.log("Card Number entered is = " + cno, true);
		Thread.sleep(2000);

		Select month_option = new Select(Month);
		month_option.selectByIndex(6);
		Reporter.log("Month selected is = " + Month, true);

		Select year_option = new Select(Year);
		year_option.selectByIndex(6);
		Reporter.log("Year selected is = " + Year, true);

		Security_Code.clear();
		Security_Code.sendKeys("123");
		Reporter.log("Security Code entered is = " + Security_Code, true);
		Thread.sleep(5000);
		Reporter.log("========================================", true);
	}

	public void clickonReviewButton() {
		BasePage.verifyElement(Review_Order_Button);
		if (Review_Order_Button.isEnabled()) {
			Review_Order_Button.click();
			Reporter.log("Review order button is enabled and user clicked on the button", true);
		} else {
			Reporter.log("Review order button is not enabled", true);
		}

		Reporter.log("========================================", true);

	}
}
