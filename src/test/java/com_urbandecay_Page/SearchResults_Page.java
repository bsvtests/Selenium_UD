package com_urbandecay_Page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com_urbandecay_Generic.BaseTest;

public class SearchResults_Page extends BaseTest{

	@FindBy(xpath = "//div[@class='l-search__tools']//div[@class='c-results-count m-search ']")
	private WebElement Results_Count;

	@FindBy(xpath = "//figure[@class='c-product-tile ']//h2[@class='c-product-tile__name']")
	private List<WebElement> Product_Names;
	
	@FindBy(xpath = "//a[text()=' Stay Naked Correcting Concealer ']")
	private WebElement Prod_Name;
	
	@FindBy(xpath = "//div[@class='c-product-grid m-grid']//button[@class='c-add-to-wishlist']")
	private WebElement Wishlist_Icon;
	
	@FindBy(xpath = "//input[@type='password']")
	private WebElement Password;
	
	@FindBy(xpath = "//button[@class='m-expand c-button']")
	private WebElement Signin_button;

	public SearchResults_Page(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public void verifyProductCount() {
		Reporter.log("Total of "+Results_Count.getText()+" are displaying in search results", true);
		Reporter.log("========================================", true);
	}

	public void getProductNames() throws InterruptedException {
		
//		for(WebElement Name : Product_Names) {
//			String Names = Name.getText();
//			Reporter.log("Names", true);
//			if(Names.get(i).getText().contains("SET TO STAY NAKED")) {
//			if(Names.equalsIgnoreCase("SET TO STAY NAKED")) {
//				
//			}
		List<WebElement> Names = Product_Names;
		Reporter.log("Product count is "+Product_Names.size(), true);
		Reporter.log("Product Names are = ", true);
		for(int i=0; i<=Product_Names.size(); i++) {
			Reporter.log(Names.get(i).getText(), true);
			Thread.sleep(1000);
		}
		Reporter.log("========================================", true);
	}
	public void clickOnProduct() {
		
		Prod_Name.click();
//		List<WebElement> products = Product_Names;
//		Reporter.log("Clicking on the product", true);
//		
//			if(products.get(i).getText().contains("SET TO STAY NAKED")) {
//				Reporter.log("User is navigating to "+products.get(i).getText()+"PDP ", true);
//				products.get(i).click();
//				Thread.sleep(3000);
		Reporter.log("========================================", true);
		}
	
	public void clickonWishlist() throws InterruptedException {
		if(Wishlist_Icon.isDisplayed()) {
			Reporter.log("Wishlist icon is displaying for the product", true);
			Wishlist_Icon.click();
			Thread.sleep(4000);
		}
		else {
			Reporter.log("Wishlist icon is NOT displaying for the product", true);
		}}

	public void enterPassword(String password) throws InterruptedException {
		Password.sendKeys(password);
		Reporter.log("Password entered is = "+password, true);
		Thread.sleep(3000);
	}
	public void clickonSigninButton() throws InterruptedException {
		Signin_button.click();
		Reporter.log("Clicked on the sign in button", true);
		Thread.sleep(3000);
		Reporter.log("========================================", true);
	}
	
	}
