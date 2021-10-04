package com_urbandecay_Page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com_urbandecay_Generic.BaseTest;

public class Intermediate_Login_Page extends BaseTest {

	@FindBy(name = "dwfrm_login_unregistered")
	private WebElement CheckoutAsGuest;

	@FindBy(xpath = "//form[@name='guest']/div/input")
	private WebElement guestEmailtxtbox;
	
	@FindBy(xpath = "//button[contains(text(),'Proceed to Checkout')]")
	private WebElement buttonProceedtoChkOut;

	@FindBy(xpath = "//input[@class=' textinput f_password c-text-field__input   required']")
	private WebElement Password;
	
	@FindBy(xpath = "//div[@class='l-signin ']/div/form/div/input[@type='email']")
	private WebElement txtBoxEmail;
	
	@FindBy(xpath = "//div[@class='l-signin ']/div/form/div/input[@type='password']")
	private WebElement txtBoxPassword;
	
	@FindBy(xpath = "//button[normalize-space()='Sign in']")
	private WebElement buttonSignIn;

	@FindBy(xpath = "//div[@class='f_field f_field_checkbox  formfield formfield_checkbox formfield_remember_me']//input[@class=' checkbox f_checkbox class.form.input.checkbox ']")
	private WebElement RememberMe_Checkbox;

	@FindBy(className = "forgot_password_link")
	private WebElement Forgot_Password_Link;

	@FindBy(xpath = "//div[@class='f_field f_field_email  formfield formfield_email formfield_email required f_state_error']/input[@class=' textinput f_email c-text-field__input   required']")
	private WebElement Enter_Email_ForgotPassword;

	@FindBy(className = "dwfrm_requestpassword_send")
	private WebElement submit_ForgotPassword;

	@FindBy(className = "button submit_button close_dialog_button display_close_button")
	private WebElement Close_ForgotPassword;
	@FindBy(xpath = "//span[contains(text(),'Continue To Addresses')]")
	private WebElement buttonContinueAddress;

	@FindBy(xpath = "//button[@type='submit'][contains(.,'Continue To Delivery')]")
	private WebElement buttonContinuedelivery;
	
	@FindBy(xpath = "//button[@class='c-button m-expand']")
	private WebElement CheckoutAsGuestButton;

	public Intermediate_Login_Page(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public void enterguestEmail() {
		guestEmailtxtbox.sendKeys("tester@mail.com");
	}
	
	public void clickoncheckoutbuttonasGuest() {
		CheckoutAsGuestButton.click();
		Reporter.log("Checkout as Guest button is displaying and user clicked on it", true);
		Reporter.log("User is navigating to Shipping page as a Guest user", true);
		Reporter.log("========================================", true);
	}

	public void clickonGuestCheckout() throws InterruptedException {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", buttonProceedtoChkOut);
		Thread.sleep(5000);
		Reporter.log("Checkout as Guest button is displaying and user clicked on it", true);
		Reporter.log("User is navigating to Shipping page as a Guest user", true);
		Reporter.log("========================================", true);

	}

	public void clickonContinueaddress() throws InterruptedException {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0,1000)");
		
		
		executor.executeScript("arguments[0].click();", buttonContinueAddress);
		Thread.sleep(5000);
		Reporter.log("buttonContinueAddress  is displaying and user clicked on it", true);

	}

	public void clickonContinueTodelivery() throws InterruptedException {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", buttonContinuedelivery);
		Thread.sleep(5000);
		Reporter.log("buttonContinueAddress  is displaying and user clicked on it", true);

	}

	public void enterIntermediate_Login_Details(String email_Intermediate, String password_Intermediate) {
		guestEmailtxtbox.sendKeys(email_Intermediate);
		Reporter.log("Entered Email is = " + guestEmailtxtbox.getText(), true);
		Password.sendKeys(password_Intermediate);
		Reporter.log("Entered Password is = " + Password.getText(), true);
		//Signin_Button.click();
		Reporter.log("User logged in successfully through Intermediate Login Page", true);
		Reporter.log("User is navigating to Checkout Pages as a Registered user", true);
		Reporter.log("========================================", true);
	}

	public void clickonRememberMe() {

		RememberMe_Checkbox.click();
		if (RememberMe_Checkbox.isSelected()) {
			Reporter.log("Remember me checkbox is selected in the Intermediate Login page", true);
		} else {
			Reporter.log("Remember me checkbox is not selected", true);
		}
		Reporter.log("========================================", true);
	}

	public void clickonForgotPassword(String Email_Data_ForgotPassword) throws InterruptedException {
		Forgot_Password_Link.click();
		Thread.sleep(2000);
		Enter_Email_ForgotPassword.sendKeys();
		Thread.sleep(2000);
		submit_ForgotPassword.click();
		Thread.sleep(2000);
		Close_ForgotPassword.click();
		Reporter.log("========================================", true);
	}

	
	public void loginFromInteremdiatePage() throws InterruptedException
	{
		txtBoxEmail.sendKeys("skf@gmail.com");
		txtBoxPassword.sendKeys("King@1836");
		buttonSignIn.click();
		Thread.sleep(5000);
		String title=driver.getTitle();
		Assert.assertEquals(title, "OneStepCheckout Title","Navigated to Checkout Page");
		
	}
}
