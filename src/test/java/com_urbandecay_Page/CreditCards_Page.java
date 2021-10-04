package com_urbandecay_Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com_urbandecay_Generic.ScrollToElement_JavaScriptExecutor;

public class CreditCards_Page {

	ScrollToElement_JavaScriptExecutor ste = new ScrollToElement_JavaScriptExecutor();

	@FindBy(xpath = "//a[@class='c-stacked-links__link ' and text()=' Credit cards ']")
	private WebElement CreditCards_Link;

	@FindBy(xpath = "//a[@title='Add New Credit Card']")
	private WebElement Add_CC_Button;

	@FindBy(className = "c-account__title")
	private WebElement Heading_Text;

	@FindBy(xpath = "//input[@name='cardnumber']")
	private WebElement CardNumber_Textbox;

	@FindBy(xpath = "//input[@name='owner']")
	private WebElement NameOnCard_Textbox;

	@FindBy(xpath = "//select[@name='month']")
	private WebElement Month_Dropdown;

	@FindBy(xpath = "//select[@name='year']")
	private WebElement Year_Dropdown;

	@FindBy(xpath = "//input[@name='nickname']")
	private WebElement CardsName_Textbox;

	@FindBy(xpath = "//button[@input='submit']")
	private WebElement Add_New_CC_Button;

	@FindBy(xpath = "//section[@class='c-account-card m-credit l-account__section m-active']//a[@class='c-account-card__link ']")
	private WebElement Remove_Link;

	//Removing the default card even though we have multiple cards added to account
	@FindBy(xpath = "//label[text()='Default credit card']")
	private WebElement CardName_Verification;
	
	@FindBy(className = "c-form__submit c-button m-alert")
	private WebElement Delete_Card_Button;

	public CreditCards_Page(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public void AddCreditCard(String cardnumber, String nameoncard, String month, String year, String cardname) throws InterruptedException {
		ScrollToElement_JavaScriptExecutor.ScrollDownToElement(CreditCards_Link);
		Thread.sleep(2000);
		Add_CC_Button.click();
		Thread.sleep(2000);
		Heading_Text.click();
		Reporter.log("Heading Text displaying is "+Heading_Text.getText(), true);
		CardNumber_Textbox.sendKeys(cardnumber);
		Reporter.log("Card Number entered is "+cardnumber, true);
		NameOnCard_Textbox.sendKeys(nameoncard);
		Reporter.log("Name on card entered is "+nameoncard, true);

		Select month_option = new Select(Month_Dropdown);
		month_option.selectByVisibleText(month);
		Reporter.log("month selected from dropdown is = "+month, true);
		Thread.sleep(2000);

		Select year_option = new Select(Year_Dropdown);
		year_option.selectByVisibleText(year);
		Reporter.log("year selected from dropdown is = "+year, true);
		Thread.sleep(2000);

		CardsName_Textbox.sendKeys(cardname);
		Reporter.log("Card's Name entered is "+cardname, true);
		Add_New_CC_Button.click();
		Thread.sleep(3000);
		Reporter.log("========================================", true);
	}

	public void RemoveCreditCard(String cardnumber, String nameoncard, String month, String year, String cardname) throws InterruptedException {
		this.AddCreditCard(cardnumber, nameoncard, month, year, cardname);
		if(CardName_Verification.isSelected()) {
			Remove_Link.click();
			Reporter.log("Removing the default credit card", true);
			Delete_Card_Button.click();
		}
		else {
			Reporter.log("No default cards are displaying, Add a card to the account", true);
		}
		Reporter.log("========================================", true);
	}
}