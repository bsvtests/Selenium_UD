package com_urbandecay_Page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com_urbandecay_Generic.BaseTest;

public class MiniCart_Page extends BaseTest{
	
	@FindBy(xpath = "//button[@class='c-minicart-icon__link']")
	private WebElement Minicart_Mousehover;
	
	@FindBy(className = "c-minicart__text")
	private WebElement CartEmpty_Text;
	
	@FindBy(xpath = "//a[@class='c-minicart__checkout-link']")
	private WebElement Start_Shopping_Link;
	
	@FindBy(xpath = "//tr[@class='c-minicart__item']//td//h3[@class='c-minicart__product-title']")
	private List<WebElement> ProductNames_Minicart;
	
	@FindBy(xpath = "//span[contains(text(),'product in cart')]")
	private WebElement Quantity_Minicart;
	
	@FindBy(xpath = "//div[@class='c-minicart__subtotal-price']")
	private WebElement SubTotal_MiniCart;
	
	@FindBy(xpath = "//a[@class='c-minicart__actions-checkout c-button']")
	private WebElement Checkout_Button_MiniCart;
	
	@FindBy(xpath = "//button[@name='item_remove']")
	private WebElement Remove_Link_MiniCart;
	
	public MiniCart_Page(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public void verifyEmptyMiniCart() throws InterruptedException {
		Reporter.log("======= Verifying Empty mini cart =======", true);
		Actions act = new Actions(driver);
		
		act.moveToElement(Minicart_Mousehover).perform();
		Reporter.log("User mouse hovered on mini cart", true);
		Reporter.log("Mini Cart is displaying now", true);
		Reporter.log("Empty cart message is displaying as = "+CartEmpty_Text.getText(), true);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(Start_Shopping_Link));
		if(Start_Shopping_Link.isDisplayed()) {
			act.moveToElement(Start_Shopping_Link).click().build().perform();
			Reporter.log("User clicked on Start Shopping link in mini cart", true);
		}
		else {
			Reporter.log("start shopping link in mini cart is not displaying", true);
		}
		
		Thread.sleep(3000);
		Reporter.log("========================================", true);
	}

	public void verifyMiniCart() throws InterruptedException {
		Reporter.log("======= Verifying Mini cart =======", true);
		//Displaying the mini cart by mouse hover
		Actions MiniCart = new Actions(driver);
		MiniCart.moveToElement(Minicart_Mousehover).perform();
		Reporter.log("User mouse hovered on mini cart", true);
		Reporter.log("Mini Cart is displaying now", true);
		
		//Getting Number of product count and product names
		Reporter.log("Product Names in Mini cart are = ", true);
		for(WebElement Prod_Names : ProductNames_Minicart) {
			Reporter.log(Prod_Names.getText(), true);
		}
		Reporter.log("Total Mini Cart Quantity is = "+Quantity_Minicart.getText(), true);
		
		//Getting subtotal & clicking on the checkout button
		Reporter.log("Sub-Total of all the Mini Cart products are = "+SubTotal_MiniCart.getText(), true);
		Thread.sleep(2000);
		if(Checkout_Button_MiniCart.isDisplayed()) {
			Reporter.log("Checkout Button is displaying in the mini cart",true);
			Checkout_Button_MiniCart.click();
			Thread.sleep(3000);
			Reporter.log("User clicked on Checkout Button in mini cart",true);
			Reporter.log("User is navigating to Cart Page",true);
		}
		else {
			Reporter.log("Checkout Button is not displaying in the mini cart",true);
			
		}
		Thread.sleep(3000);
		Reporter.log("========================================", true);
		
	}
	
	public void clickRemove_Minicart() throws InterruptedException {
		Remove_Link_MiniCart.click();
		Thread.sleep(3000);
		Reporter.log("========================================", true);
	}
}
