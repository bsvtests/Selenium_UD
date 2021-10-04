package com_urbandecay_Page;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com_urbandecay_Generic.BasePage;

public class AccountSettings_Page extends BasePage{
	
	@FindBy(xpath = "//a[@class='c-stacked-links__link ' and text()=' Account settings ']")
	private WebElement Account_Settings_Link_Nav;
	
	@FindBy(className = "c-account__title")
	private WebElement Heading_Text;
	
	@FindBy(className = "c-button m-expand")
	private WebElement Edit_Info_Button;
	
	@FindBy(xpath = "//h2[@class='c-account__subtitle' and text()='Edit information']")
	private WebElement Subheading_Text;
	
	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement FirstName_Textbox;
	
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement LastName_Textbox;
	
	@FindBy(xpath = "//div[@class='c-form__aside']//button[@name='submit']")
	private WebElement Save_Info_Button;
	
	@FindBy(xpath = "//div[text()='Your profile was updated']")
	private WebElement Success_Message;
	
	@FindBy(xpath = "//a[@title='Delete account']")
	private WebElement Delete_Button;
	
	@FindBy(className = "c-form__submit m-alert c-button")
	private WebElement Delete_Button_Modal;
	
	@FindBy(className = "c-modal__title")
	private WebElement Delete_Modal_Text;
	
	@FindBy(className = "c-modal__text")
	private WebElement Delete_Confirmation_Text;
	
	@FindBy(xpath = "//div[@class='c-modal__body']//button[@class='c-button c-form__submit']")
	private WebElement Back_To_Shop_Buton;
	
	@FindBy(xpath = "//a[@title='Change password']")
	private WebElement Change_Password_Button;
	
	@FindBy(xpath = "//h2[text()='Change password']")
	private WebElement Change_Password_Text;
	
	@FindBy(xpath = "//input[@name='currentpassword']")
	private WebElement Current_Password;
	
	@FindBy(xpath = "//input[@name='newpassword']")
	private WebElement New_Password;
	
	@FindBy(xpath = "//input[@name='confirmnewpassword']")
	private WebElement Confirm_New_Password;
	
	@FindBy(xpath = "//button[@type='submit' and text()='Change']")
	private WebElement Change_Button;
	
	@FindBy(className = "c-modal__text")
	private WebElement Password_Change_Confirmation_message;
	
	@FindBy(className = "c-button m-expand-for-medium-down")
	private WebElement Password_Close_Button;
	
	@FindBy(xpath = "//nav[@class='c-sidebar-navigation']//ul[@class='c-stacked-links c-sidebar-navigation__links']")
	private List<WebElement> MyAcc_Nav_Links;
	
	public AccountSettings_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
public void verifyEditInformation(String firstname, String lastname) throws InterruptedException {
	Account_Settings_Link_Nav.click();
	Thread.sleep(3000);
	Reporter.log("Heading Text displaying is ="+Heading_Text.getText(), true);
	Edit_Info_Button.click();
	Reporter.log("Sub-heading Text displaying is ="+Subheading_Text.getText(), true);
	Thread.sleep(2000);
	FirstName_Textbox.clear();
	FirstName_Textbox.sendKeys(firstname);
	LastName_Textbox.clear();
	LastName_Textbox.sendKeys(lastname);
	Save_Info_Button.click();
	Thread.sleep(3000);
	if(Success_Message.isDisplayed()) {
		Reporter.log("User updated the information successfully and message is = "+Success_Message.getText(), true);
		Reporter.log("Updated first name is = "+firstname, true);
		Reporter.log("Updated last name is = "+lastname, true);
	}
	else {
		Reporter.log("User information failed to save", true);
	}
	Reporter.log("===================================", true);
}
	
public void verifyDeleteAccount() throws InterruptedException {
	Account_Settings_Link_Nav.click();
	Thread.sleep(3000);
	Reporter.log("Heading is ="+Heading_Text.getText(), true);
	Edit_Info_Button.click();
	Reporter.log("Sub-heading is ="+Subheading_Text.getText(), true);
	Thread.sleep(2000);
	Delete_Button.click();
	Thread.sleep(2000);
	Reporter.log("Text displaying for Delete Modal is ="+Delete_Modal_Text.getText(), true);
	Delete_Button_Modal.click();
	Reporter.log("Confirmation message for account deletion is ="+Delete_Confirmation_Text.getText(), true);
	Back_To_Shop_Buton.click();
	Reporter.log("===================================", true);
	
}

public void verifyChangePassword(String current_password, String new_password, String confirm_new_password) throws InterruptedException {
	
	Account_Settings_Link_Nav.click();
	Thread.sleep(3000);
	Reporter.log("Heading is ="+Heading_Text.getText(), true);
	Change_Password_Button.click();
	Thread.sleep(3000);
	Reporter.log("Password text displaying is = "+Change_Password_Text.getText(), true);
	Current_Password.sendKeys(current_password);
	New_Password.sendKeys(new_password);
	Confirm_New_Password.sendKeys(confirm_new_password);
	Change_Button.click();
	Thread.sleep(2000);
	Reporter.log("Password is changed and success confirmation is  = "+Password_Change_Confirmation_message.getText(), true);
	Reporter.log("New password is = "+new_password, true);
	Password_Close_Button.click();
	Reporter.log("===================================", true);
	
}

public void verifyMyAcc_Left_Nav_Links() throws InterruptedException, IOException {
	Reporter.log("Verifying the My Account left navigation links", true);
	Reporter.log("Total Number of My Account links are = "+MyAcc_Nav_Links.size(), true);
	
	for(int i=0; i <MyAcc_Nav_Links.size(); i++) {
		WebElement element = MyAcc_Nav_Links.get(i);
		String url = element.getAttribute("href");
		
		URL link = new URL(url);
		
		HttpURLConnection httpconn = (HttpURLConnection) link.openConnection();
		Thread.sleep(3000);
		
		httpconn.connect();
		int responsecode = httpconn.getResponseCode();
		
		if(responsecode >=400) {
			Reporter.log(url+ " = "+" is a Broken Link", true);
		}
		else {
			Reporter.log(url+ " = "+" is a Valid Link", true);
		}
		
		Thread.sleep(4000);
		}
	Reporter.log("===================================", true);
}


}
