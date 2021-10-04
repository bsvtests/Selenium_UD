package com_urbandecay_Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com_urbandecay_Generic.BaseTest;

public class ProjectUtils extends BaseTest{

	
	
	

	@FindBy(xpath = "//a[contains(text(),'Go to my cart')]")
	private WebElement buttongoToMyCart;
	
	
	public ProjectUtils(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public void handleAddedProductsPopUp()
	{
		try {
			buttongoToMyCart.isDisplayed();
			Thread.sleep(3000);
			buttongoToMyCart.click();
			Reporter.log("Go to my cart button is  displaying  and clicked succssfully", true);
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
			Reporter.log("Go to my cart button is not displaying", true);
		}
	}
}
