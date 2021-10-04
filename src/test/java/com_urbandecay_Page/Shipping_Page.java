package com_urbandecay_Page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com_urbandecay_Generic.BaseTest;

public class Shipping_Page extends BaseTest {

	@FindBy(xpath = "//span[contains(text(),'No, keep this address')]")
	private WebElement keepadrsbuton;

	@FindBy(xpath = "//span[contains(text(),'    Shipping & Billing')]")
	private WebElement Shipping_Heading_Text;

	@FindBy(xpath = "//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_firstName']")
	private WebElement FirstName;

	@FindBy(xpath = "//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_lastName']")
	private WebElement LastName;

	@FindBy(xpath = "//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_address1']")
	private WebElement Street_Adress;

	@FindBy(xpath = "//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_city']")
	private WebElement City;

	@FindBy(xpath = "//select[@id='dwfrm_singleshipping_shippingAddress_addressFields_states_state']")
	private WebElement State_dropdown;

	@FindBy(xpath = "//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_zip']")
	private WebElement ZipCode;

	@FindBy(xpath = "//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_phone']")
	private WebElement PhoneNumber;

	@FindBy(xpath = "//input[@type='email']")
	private WebElement Email_Shipping;

	@FindBy(xpath = "//div[@class='customer_email']//span[@class='value']")
	private WebElement Email_Reg;

	@FindBy(xpath = "//button[@name='dwfrm_checkout_sectionNext' and @value='addresses']")
	private WebElement ContinueToPayment_Button;

	@FindBy(xpath = "//select[@id='dwfrm_singleshipping_shippingAddress_addressFields_country']")
	private WebElement dropdownbillingCountry;

	@FindBy(xpath = "//span[normalize-space()='Logged In:']")
	private WebElement textLoggedIn;

	
	@FindBy(xpath = "//div[@class='c-ngcheckout-step__content']//h3[contains(text(),' Delivery  at home ')]")
	private WebElement Shippingpage_option1;
	
	public Shipping_Page(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public void enterShippingAddress_Guest(String fn, String ln, String street, String city, String zipcode,
			String phone, String email, String state) throws InterruptedException {
		// Reporter.log("Heading displaying is = " + Shipping_Heading_Text.getText(),
		// true);

		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 15);
		 * wait.until(ExpectedConditions.elementToBeClickable(FirstName));
		 */
		FirstName.clear();
		FirstName.sendKeys(fn.toUpperCase());
		Reporter.log("First Name is = " + fn, true);
		LastName.clear();
		LastName.sendKeys(ln);
		Reporter.log("Last Name is = " + ln, true);
		Street_Adress.clear();
		Street_Adress.sendKeys(street.toUpperCase());
		Reporter.log("street is = " + street, true);
		City.clear();
		City.sendKeys(city.toUpperCase());
		Reporter.log("city is = " + city, true);
		ZipCode.clear();
		ZipCode.sendKeys(zipcode);
		Reporter.log("zipcode is = " + zipcode, true);
		PhoneNumber.clear();
		PhoneNumber.sendKeys(phone);
		Reporter.log("phone is = " + phone, true);
		try {
			boolean status = textLoggedIn.isDisplayed();
			if (status) {
				//Reporter.log("email is = " + email, true);
			}
		} catch (Exception e) {
			// TODO: handle exception
			Email_Shipping.clear();
			Email_Shipping.sendKeys(email);
			Reporter.log("email is = " + email, true);
		}
		Select state_option = new Select(State_dropdown);
		state_option.selectByVisibleText(state);
		Reporter.log("state from dropdown is = " + state, true);

		Select s = new Select(dropdownbillingCountry);
		s.selectByVisibleText("United States");
		Reporter.log("state from dropdown is = " + state, true);

		if (ContinueToPayment_Button.isEnabled()) {
			Reporter.log("Continue to Payment button is displaying and enabled", true);
			ContinueToPayment_Button.click();
			Thread.sleep(7000);
		} else {
			Reporter.log("Continue to Payment button is not enabled", true);
		}
		Reporter.log("========================================", true);
	}

	public void enterShippingAddress_Registered(String fn, String ln, String street, String city, String zipcode,
			String phone, String state) throws InterruptedException {
		Reporter.log("Heading displaying is = " + Shipping_Heading_Text.getText(), true);
		FirstName.clear();
		FirstName.sendKeys(fn);
		Reporter.log("First Name is = " + fn, true);

		LastName.clear();
		LastName.sendKeys(ln);
		Reporter.log("Last Name is = " + ln, true);

		Street_Adress.clear();
		Street_Adress.sendKeys(street);
		Reporter.log("street is = " + street, true);

		City.clear();
		City.sendKeys(city);
		Reporter.log("city is = " + city, true);

		ZipCode.clear();
		ZipCode.sendKeys(zipcode);
		Reporter.log("zipcode is = " + zipcode, true);

		PhoneNumber.clear();
		PhoneNumber.sendKeys(phone);
		Reporter.log("phone is = " + phone, true);

		Select state_option = new Select(State_dropdown);
		state_option.selectByVisibleText(state);
		Reporter.log("state from dropdown is = " + state, true);

		if (Email_Reg.isDisplayed()) {
			Reporter.log("Email using for placing order is = " + Email_Reg.getText(), true);
		} else {
			Reporter.log("Email is not displaying for placing order", true);
		}

		if (ContinueToPayment_Button.isEnabled()) {
			Reporter.log("Continue to Payment button is displaying and enabled", true);
			ContinueToPayment_Button.click();
			Thread.sleep(3000);
		} else {
			Reporter.log("Continue to Payment button is not enabled", true);
		}

		Reporter.log("========================================", true);
	}

	public void clickOnKeepadrsbutton() throws InterruptedException {
		keepadrsbuton.click();
		Thread.sleep(3000);
	}

	public void clickOnDeliveryhome() {
		Shippingpage_option1.click();
		Reporter.log("=== User clicked on the Delivery at home option in shipping page===", true);
	}
}
