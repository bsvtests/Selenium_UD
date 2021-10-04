package com_urbandecay_Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com_urbandecay_Generic.BaseTest;

public class SearchTextbox_Page extends BaseTest{

	@FindBy(xpath = "//div[@class='c-hamburger l-header__hamburger']//div[@class='l-header__search-cta']")
	private WebElement Search_button;

	@FindBy(className = "c-simple-search__field")
	private WebElement Enter_Text;

	@FindBy(xpath = "//button[@class='c-simple-search__button']")
	private WebElement Search_Icon;

	@FindBy(xpath = "//span[@class='c-suggestions-products__title' and text()='Best matches']")
	private WebElement Best_matches;

	public SearchTextbox_Page(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public void clickonSearchTextbox() throws InterruptedException {
		Search_button.click();
		Thread.sleep(1000);
		Reporter.log("========================================", true);
	}

	public void enterSearchText(String et) throws InterruptedException {
		Enter_Text.clear();
		Enter_Text.sendKeys(et);
		Reporter.log("Entered Text is = "+et, true);
		Thread.sleep(1000);
		Reporter.log("========================================", true);
	}

	public void clickonSearchIcon() throws InterruptedException {
		Search_Icon.click();
		Thread.sleep(5000);
		Reporter.log("Search icon is displaying and is clickable", true);
		Reporter.log("========================================", true);
	}

	public void verifyBestMatches() {

		if(Best_matches.isDisplayed()) {
			Reporter.log("Search suggestions are displaying", true);
		}
		else {
			Reporter.log("No search suggestions are displaying", true);
		}

		Reporter.log("========================================", true);

	}




}