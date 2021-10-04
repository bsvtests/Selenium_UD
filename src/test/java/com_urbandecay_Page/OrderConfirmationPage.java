package com_urbandecay_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com_urbandecay_Generic.BaseTest;

public class OrderConfirmationPage extends BaseTest {

	@FindBy(xpath = "//h2[normalize-space()='Order summary']")
	private WebElement titleOrderSummary;

	@FindBy(xpath = "//button[normalize-space()='Print your invoice']")
	private WebElement linkprintyourInVoice;

	@FindBy(xpath = "//span[contains(text(),'Date ordered')]")
	private WebElement textDateOrdered;

	@FindBy(xpath = "//span[contains(text(),'Order number')]")
	private WebElement textOrderNumber;

	public OrderConfirmationPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public boolean verifyOrderConfirmationPage_CC() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0,1000)");
		boolean status = false;
		try {
			if (titleOrderSummary.isDisplayed() && textDateOrdered.isDisplayed()) {
				Reporter.log("===========Title and Ordered Date are displaying===============", true);
				status = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			Reporter.log("===========Title and Ordered Date are displaying===============", true);
			status = false;
		}
		return status;

	}

	public String getOrderNumber() {
		String orderNumber = null;
		WebElement ele = driver.findElement(By.xpath("(//li[contains(@class,'c-order-info__item')])[2]/span[2]"));
		System.out.println(ele.getText());
		return ele.getText();

	}
}