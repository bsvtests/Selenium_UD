package com_urbandecay_Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com_urbandecay_Generic.BaseTest;

public class PDP_Foundation_Page extends BaseTest{

	@FindBy(xpath = "//a[text()=' Hydromaniac Tinted Glow Hydrator ']")
	private WebElement Prod_PLP_Link;
	
	@FindBy(xpath = "//span[@class='c-swatches__toggle-more']")
	private WebElement More_Shades_Link;
	
	@FindBy(xpath = "//div[@class='c-carousel__inner m-initialized m-horizontal m-multirow']//a[@title='60 - Medium Dark Warm']")
	private WebElement Select_Color;
	
	@FindBy(xpath = "//button[@class='c-select__placeholder']//span[text()='60 - Medium Dark Warm']")
	private WebElement Color_Text;
	
	@FindBy(xpath = "//button[@class='c-stepper-input__plus']")
	private WebElement Increase_Quantity;
	
	@FindBy(xpath = "//span[@class='c-product-add-bag__text' and text()='Add to Cart']")
	private WebElement AddToCart_PDP;
	
	@FindBy(xpath = "//div[@class='c-product-price c-product-main__price h-text-justify-content-center c-product-sticky-bar__item']//span[@class='c-product-price__value']")
	private WebElement Price_PDP;
	
	@FindBy(xpath = "//span[@class='c-product-availability__label']")
	private WebElement Instock_PDP;
	
	@FindBy(xpath = "//a[@class='c-button  c-add-cart__goto-button']")
	private WebElement Go_To_My_Cart_Modal_PDP;
	
	@FindBy(xpath = "//button[@class='c-button m-secondary c-add-cart__continue-button']")
	private WebElement Continue_Shopping_Modal_PDP;
	
	public PDP_Foundation_Page(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public void verifyPDP() throws InterruptedException {
		Reporter.log("===== Verifying PDP =====", true);
		Prod_PLP_Link.click();
		Reporter.log("User clicked the product in PLP. Product Name is = "+Prod_PLP_Link.getText(), true);
		Thread.sleep(3000);
		Reporter.log("Price of the product is = "+Price_PDP.getText(), true);
		Reporter.log("Availability message of Product is = "+Instock_PDP.getText(), true);
		
		Reporter.log("Selecting different color from the More shades link", true);
		if(More_Shades_Link.isDisplayed()) {
			Reporter.log("More shades link is displaying", true);
			More_Shades_Link.click();
			Select_Color.click();
			Reporter.log("User selected "+Color_Text.getText()+" color", true);
			Thread.sleep(3000);
			}
		else {
			Reporter.log("More shades link is NOT displaying in PDP", true);
		}
		
		Increase_Quantity.click();
		Reporter.log("Quantity Increased from 1 to 2", true);
		if(AddToCart_PDP.isDisplayed()) {
			AddToCart_PDP.click();
			Reporter.log("Add to bag button is displayed & clicked", true);
			Reporter.log("Product has been added to cart", true);
			Thread.sleep(3000);
		}
		Reporter.log("========================================", true);
	}
	
	public void clickContinueShopping_Modal_PDP() {
		Continue_Shopping_Modal_PDP.click();
		Reporter.log("User clicked on Continue Shopping button in the add to cart modal", true);
	}
	
	public void clickGoToMyCart_Modal_PDP() {
		Go_To_My_Cart_Modal_PDP.click();
		Reporter.log("User clicked on Go To My Cart button in the add to cart modal", true);
	}
	
	
}
