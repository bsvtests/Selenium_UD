package com_urbandecay_Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com_urbandecay_Generic.*;

public class CreateAccount_Page extends BasePage{

	//Declaration

	@FindBy(xpath = "//span[contains(text(),'My account')]")
	private WebElement Myacc_Link;

	@FindBy(xpath = "//h2[contains(text(),'Create Account')]")
	private WebElement Sectionheading_Text;

	@FindBy(xpath = "//label[text()='Mr']")
	private WebElement radiobutton;

	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement Firstname;

	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement Lastname;

	@FindBy(xpath = "(//input[@name='email'])[2]")
	private WebElement emailTB;

	@FindBy(xpath = "//input[@name='confirmemail']")
	private WebElement confirmEmailTB;

	@FindBy(xpath = "(//input[@name='password'])[2]")
	private WebElement pwdTB;

	@FindBy(xpath = "(//input[@name='confirmpassword'])")
	private WebElement confirmpwdTB;

	@FindBy(xpath = "//button[text()='Create My Account']")
	private WebElement button;

	@FindBy(xpath = "//input[@name='phonemobile']")
	private WebElement phoneTB;
	
	//Initialization
	public CreateAccount_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	//utilization

	public void verifyCreateAccount(String fn, String ln, String email, String confirmemail, String password, String confirmpassword, String phone) throws InterruptedException {
		Myacc_Link.click();
		Thread.sleep(2000);
		Reporter.log("Section heading displaying is = "+Sectionheading_Text.getText(), true);
		//currently in live site we do not have a radio button.
		//verifyRadiobutton(radiobutton);
		//radiobutton.click();
		Firstname.sendKeys(fn);
		Lastname.sendKeys(ln);
		emailTB.sendKeys(email);
		Reporter.log("Email entered is = "+email, true);
		confirmEmailTB.sendKeys(confirmemail);
		Reporter.log("Confirm email entered is = "+confirmemail, true);
		pwdTB.sendKeys(password);
		Reporter.log("password entered is = "+password, true);
		confirmpwdTB.sendKeys(confirmpassword);
		Reporter.log("Confirm Password entered is = "+confirmpassword, true);
		phoneTB.sendKeys(phone);
		Reporter.log("Phone number entered is = "+phone, true);
		Thread.sleep(2000);
		
		if(button.isDisplayed()) {
			Reporter.log("Create Account button is displaying", true);
			button.click();
		}
		else {
			Reporter.log("Create Account button is not displaying", true);
		}
		
		Thread.sleep(3000);
		Reporter.log("========== Account is created ==========", true);
		Reporter.log("Username = "+email, true);
		Reporter.log("Password = "+password, true);
		Reporter.log("========================================", true);
	}
	
}

