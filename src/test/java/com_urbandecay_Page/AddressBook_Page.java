package com_urbandecay_Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com_urbandecay_Generic.BasePage;

public class AddressBook_Page{

	@FindBy(xpath = "//a[@class='c-stacked-links__link ' and text()=' Address book ']")
	private WebElement AddressBook_Link;

	@FindBy(xpath = "//div[@class='c-account__empty-page-actions']//a[text()=' Add Address ']")
	private WebElement Add_Address_Button;

	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement FirstName;

	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement LastName;

	@FindBy(xpath = "//input[@name='address1']")
	private WebElement Street_Adress;

	@FindBy(xpath = "//input[@name='city']")
	private WebElement City;

	@FindBy(xpath = "//select[@name='statecode']")
	private WebElement State_dropdown;

	@FindBy(xpath = "//input[@name='postalcode']")
	private WebElement ZipCode;

	@FindBy(xpath = "//input[@name='phone']")
	private WebElement PhoneNumber;

	@FindBy(xpath = "//select[@name='countrycode']")
	private WebElement Country_dropdown;

	@FindBy(xpath = "//button[@name='submit' and text()='Add new address']")
	private WebElement Add_New_Address_Button;

	@FindBy(xpath = "c-account-card m-address l-account__section m-active")
	private WebElement New_Address_Verification;

	@FindBy(xpath = "//a[@title='Edit address']")
	private WebElement Edit_Link;

	@FindBy(xpath = "//button[@class='c-form__submit c-button']")
	private WebElement Edit_Address_Button;

	@FindBy(xpath = "//a[@title='Remove']")
	private WebElement Remove_Link;

	public AddressBook_Page(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public void AddNewAddress(String fn, String ln, String street, String city, String zipcode, String state, String phone, String country) throws InterruptedException {
		AddressBook_Link.click();
		Thread.sleep(2000);
		Add_Address_Button.click();
		Thread.sleep(3000);
		FirstName.sendKeys(fn);
		Reporter.log("First Name is = "+fn, true);
		LastName.sendKeys(ln);
		Reporter.log("Last Name is = "+ln, true);
		Street_Adress.sendKeys(street);
		Reporter.log("street is = "+street, true);
		City.sendKeys(city);
		Reporter.log("city is = "+city, true);
		
		Select state_option = new Select(State_dropdown);
		state_option.selectByVisibleText(state);
		Reporter.log("state selected from dropdown is = "+state, true);
		
		Select country_option = new Select(Country_dropdown);
		country_option.selectByVisibleText(country);
		Reporter.log("Country selected from dropdown is = "+country, true);
		
		ZipCode.sendKeys(zipcode);
		Reporter.log("zipcode is = "+zipcode, true);
		PhoneNumber.sendKeys(phone);
		Reporter.log("phone is = "+phone, true);
		Add_New_Address_Button.click();
		Thread.sleep(3000);
		Reporter.log("===================================", true);
	}

	public void verifyNewAddress() {
		BasePage.verifyElement(New_Address_Verification);
		Reporter.log("===================================", true);
	}

	public void clickOnRemoveAddres() throws InterruptedException {
		
		AddressBook_Link.click();
		Thread.sleep(2000);
		Remove_Link.click();
		Reporter.log("Address has been removed from account", true);
		Reporter.log("===================================", true);
	}

	public void clickonEditLink() throws InterruptedException {
		AddressBook_Link.click();
		Thread.sleep(2000);
		Edit_Link.click();
		Thread.sleep(2000);
		Edit_Address_Button.click();
		Thread.sleep(2000);
		Reporter.log("User edited the Address successfully", true);
		Reporter.log("===================================", true);
	}




}
