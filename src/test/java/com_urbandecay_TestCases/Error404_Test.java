package com_urbandecay_TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com_urbandecay_Generic.BaseTest;

public class Error404_Test extends BaseTest {

	static {
		String chrome_key = "webdriver.chrome.driver";
		String chrome_value = "./Drivers/chromedriver.exe";
		System.setProperty(chrome_key, chrome_value);
	}
	static WebDriver driver;

	// public static void main(String[] Arguments) throws InterruptedException {
	@Test
	public void verify404Page() throws Exception {
		/*
		 * driver = new ChromeDriver(); driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 * driver.manage().deleteAllCookies();
		 * driver.get("https://www.urbandecay.com/404");
		 * Reporter.log("---- Program Start ----", true);
		 * driver.findElement(By.className("c-modal__close")).click();
		 */
		Thread.sleep(3000);
		String url = driver.getCurrentUrl();
		driver.get(url);
		WebElement Heading_Text = driver.findElement(By.xpath("//h1[contains(text(),'404 error page')]"));
		String ErrorMessage = Heading_Text.getText();
		Reporter.log("404 error page heading text is " + ErrorMessage, true);
		//WebElement ReturnToHomepage = driver.findElement(By.xpath("//a[@title='Return to the Homepage']"));
		//ReturnToHomepage.click();
		//Thread.sleep(3000);
		//String title = driver.getTitle();
		Reporter.log("404 error page heading text is displaying");
	}
}
