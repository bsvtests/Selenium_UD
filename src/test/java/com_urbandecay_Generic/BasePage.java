package com_urbandecay_Generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
public class BasePage {

	static WebDriver driver;
	public BasePage(WebDriver driver)
	{
		BasePage.driver=driver;
	}

	//We are using this method to know & verify the title of the web page
	public static void verifyTitle(String title)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try
		{
			wait.until(ExpectedConditions.titleIs(title));
			Reporter.log("Page title is = "+title,true);
		}
		catch (Exception e) 
		{
			Reporter.log("Title is not matching....",true);
			Reporter.log("Page title displaying is = "+driver.getTitle(),true);
			Assert.fail();
		}
	}

	//We are using this method to verify the element in the web page
	public static void verifyElement(WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log("----WebElement "+element.getText()+" is displaying in the page----",true);
		}
		catch (Exception e) 
		{
			Reporter.log("----WebElement "+element.getText()+" is NOT displaying in the page----",true);
			Assert.fail();
		}
	}

	//This radio button method will click on any radio button in the webpage
	public void verifyRadiobutton(WebElement radiobutton)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(radiobutton));
			Reporter.log("Radio button is present and clickable",true);
		}
		catch (Exception e) 
		{
			Reporter.log("Radio button is already clicked",true);
			Assert.fail();
		}
	}
	
	public void verifyCheckBox(WebElement checkbox)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(checkbox));
			Reporter.log("Check Box is present and clickable",true);
		}
		catch (Exception e) 
		{
			Reporter.log("Check Box is already clicked",true);
			Assert.fail();
		}
	}
	
}