package com_urbandecay_Generic;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class GenericUtils extends BaseTest{
	
//By using this getscreenshot() we can use this method by calling the class name into other classes
	//getscreenshot() helps us in taking screenshots
	
	public static void getscreenshot(WebDriver driver, String name) {

		try {
			//File src = scrnshot.getScreenshotAs(OutputType.FILE);
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File("C:\\Users\\iamsp\\Selenium Framework Class\\Urban Decay Project\\Screenshot" +driver.getTitle()+".png"));
		}
		catch(IOException e) {
		}}

	
}