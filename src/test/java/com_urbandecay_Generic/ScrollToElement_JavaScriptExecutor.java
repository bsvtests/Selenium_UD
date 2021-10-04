package com_urbandecay_Generic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollToElement_JavaScriptExecutor {
	static WebDriver driver = null;
	
	public static void ScrollDownToElement(WebElement element) throws InterruptedException {
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);",element);
		Thread.sleep(3000);
	}


	public static void MouseScrollDown(WebElement element) throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	
	}

}