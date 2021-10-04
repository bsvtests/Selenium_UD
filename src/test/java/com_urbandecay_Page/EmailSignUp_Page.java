package com_urbandecay_Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class EmailSignUp_Page {
	
	//Email signup for header
	@FindBy(xpath = "//button[@class='c-signup-link']")
	private WebElement Email_SignUp_Link_Header;
	
	@FindBy(className = "c-modal__title")
	private WebElement Email_SignUp_Text;
	
	@FindBy(xpath = "//div[@class='c-field c-text-field m-float']//input[@name='email']")
	private WebElement Email_TB_SignUp_Header;
	
	@FindBy(xpath = "(//button[@class='m-autosize c-button'])[3]")
	private WebElement Submit_Button_SignUp_Header;
	
	@FindBy(xpath = "//body/div[21]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[5]/label[1]")
	private WebElement Checkbox_SignUp_Header;
	
	//==========================================================//
	//Email signup for footer
	@FindBy(xpath = "//form[@name='newslettersignup']//input[@name='email']")
	private WebElement Email_TB_SignUp_Footer;
	
	@FindBy(xpath = "//label[text()=' and ']")
	private WebElement Checkbox_SignUp_Footer;
	
	@FindBy(xpath = "//div[@class='c-form__row m-group m-grouped']//button[@name='submit']")
	private WebElement Submit_Button_SignUp_Footer;

	public EmailSignUp_Page(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public void verifyEmailSignUpHeader(String email_Text_SignUp) throws InterruptedException {
		Reporter.log("===== Verifying Email Sign Up in Header =====", true);
		
		Email_SignUp_Link_Header.click();
		Thread.sleep(2000);
		Reporter.log("Clicked on Email Sign Up Link in header", true);
		
		Reporter.log("Email SignUp Heading displaying is = "+Email_SignUp_Text.getText(), true);
		
		Email_TB_SignUp_Header.sendKeys(email_Text_SignUp);
		Reporter.log("Text entered in Email Text Box is = "+Email_TB_SignUp_Header.getText(), true);
		
		if(Checkbox_SignUp_Header.isSelected()) {
			Reporter.log("Email Sign Up checkbox is pre-selected", true);
		}
		else {
			Checkbox_SignUp_Header.click();
			Reporter.log("Email Sign Up checkbox is Selected by user", true);
		}
		
		Submit_Button_SignUp_Header.click();
		Reporter.log("Email Sign Up checkbox is pre-selected", true);
		
	}

	public void verifyEmailSignUpFooter(String email_Text_SignUp_Footer) throws InterruptedException {
		Reporter.log("===== Verifying Email Sign Up in Footer =====", true);
		
		Email_TB_SignUp_Footer.sendKeys(email_Text_SignUp_Footer);
		Reporter.log("Text entered in Email Text Box is = "+Email_TB_SignUp_Footer.getText(), true);
		
		if(Checkbox_SignUp_Footer.isSelected()) {
			Reporter.log("Email Sign Up checkbox is pre-selected", true);
		}
		else {
			Checkbox_SignUp_Footer.click();
			Reporter.log("Email Sign Up checkbox is Selected by user", true);
		}
		
		Submit_Button_SignUp_Footer.click();
		Reporter.log("Email Sign Up checkbox is pre-selected", true);
		
	}
	



}
