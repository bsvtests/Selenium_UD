package com_urbandecay_Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com_urbandecay_Generic.BasePage;

public class Login_Page extends BasePage {

	@FindBy(xpath = "//div[@class='c-account__login-section m-form m-expand']//input[@name='email']")
	private WebElement Email_Login;

	@FindBy(xpath = "//div[@class='c-account__login-section m-form m-expand']//input[@name='password']")
	private WebElement Password_Login;

	@FindBy(xpath = "//div[@class='c-field--no-margin c-field']//button[@type='submit']")
	private WebElement Submit_Login;

	@FindBy(xpath = "//a[text()=' Forgot your password? ']")
	private WebElement ForgotPassword_Link;

	@FindBy(xpath = "//label[@class=' c-check-field__label' and text()='Remember me']")
	private WebElement RememberMe_Checkbox;

	@FindBy(xpath = "//span[contains(text(),'My account')]")
	private WebElement Myacc_Link;
	
	@FindBy(className = "c-field__error-message")
	private WebElement invalidpwvalMsg;
	
	@FindBy(tagName = "a")
	private List<WebElement> linkElements;
	
	public List<WebElement> getLinkElements() {
		return linkElements;
	}

	public void setLinkElements(List<WebElement> linkElements) {
		this.linkElements = linkElements;
	}

	// Initialization
	public Login_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickonMyAcc_Header() {
		Myacc_Link.click();
	}

	public void enterlogincredentails(String email_login, String password_login) throws InterruptedException {
		Email_Login.sendKeys(email_login);
		Reporter.log("Email entered is = " + email_login, true);
		Thread.sleep(3000);
		Password_Login.sendKeys(password_login);
		Reporter.log("Password entered is = " + password_login, true);
		Thread.sleep(3000);
		Submit_Login.click();
		Thread.sleep(3000);
		Reporter.log("================ User Logged in successfully ======================", true);
	}
	
	public void enterInvalidLoginCredentails(String email_login, String password_login) throws InterruptedException {
		Email_Login.sendKeys("testbrandemail@gmail.com");
		Reporter.log("Email entered is = " + email_login, true);
		Thread.sleep(3000);
		Password_Login.sendKeys("India@111");
		Reporter.log("Password entered is = " + password_login, true);
		Thread.sleep(3000);
		Submit_Login.click();
		Thread.sleep(3000);
		Reporter.log("================Login is unsuccessfull======================", true);
	}

	public void clickonRememberMeCheckbox() {
		verifyCheckBox(RememberMe_Checkbox);
		if (RememberMe_Checkbox.isSelected()) {
			Reporter.log("Remember Me Checkbox is already selected", true);
		} else {
			Reporter.log("Remember Me Checkbox is selected", true);
			RememberMe_Checkbox.click();
		}
		Reporter.log("========================================", true);
	}

	public void verifyForgotPassword() {
		verifyElement(ForgotPassword_Link);
		Reporter.log("======== User clicked on Forgot password link ========", true);
	}

}
