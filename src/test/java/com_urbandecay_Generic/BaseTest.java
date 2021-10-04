package com_urbandecay_Generic;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest implements AutoConstant {

	static {
		//System.setProperty(chrome_key, chrome_value);
		System.setProperty(firefox_key, firefox_value);
	}
	public static WebDriver driver;

	@BeforeMethod
	public void precondition() throws MalformedURLException, Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://storefront:loreal1@staging-eu03-lorealsa.demandware.net/s/NGUrbanDecay/en_GB/home/");
		Reporter.log("==== BROWSER OPENED ====", true);
		Reporter.log("---- Program Start ----", true);
		driver.findElement(By.className("c-modal__close")).click();
		Thread.sleep(3000);

	}

	@AfterMethod
	// ITestResult -This is a listener. used to indicate that the particular test
	// method has been failed
	// ITestResult interface along with its instance �result� which describes the
	// result of a test
	public void postcondition(ITestResult result) {
		/*
		 * int status = result.getStatus(); if(status == 2) { String Failed_Methodname =
		 * result.getName(); GenericUtils.getscreenshot(driver, Failed_Methodname); }
		 */ Reporter.log("---- Program End ----", true);
		driver.quit();
	}
}