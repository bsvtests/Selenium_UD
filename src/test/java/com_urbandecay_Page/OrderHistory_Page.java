package com_urbandecay_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_urbandecay_Generic.BaseTest;

public class OrderHistory_Page extends BaseTest {

	@FindBy(xpath = "//button[@class='c-user__link m-my-account'][contains(.,'Welcome ')]")
	private WebElement textWelcome;

	@FindBy(xpath = "(//a[@class='c-user-menu__content-link'][contains(.,'Order history')])[2]")
	private WebElement linkOrderhistory;

	@FindBy(xpath = "//img[@alt='UrbanDecay']")
	private WebElement logo;

	@FindBy(xpath = "//h1[normalize-space()='Order details']")
	private WebElement textOrder;

	public OrderHistory_Page(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public void navigateOrderHistoryPage() throws Exception {
		try {
			if (textWelcome.isDisplayed()) {
				System.out.println("Welcome element not displayed");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logo.click();
			System.out.println("Navigating to homepage");
			Thread.sleep(5000);
		}

		Actions act = new Actions(driver);
		act.moveToElement(textWelcome).perform();
		act.moveToElement(linkOrderhistory).perform();
		linkOrderhistory.click();

	}

	public void clickOnOrder(String orderNumber) throws Exception {

		WebElement ele = driver.findElement(By.xpath("//td[contains(text(),'" + orderNumber + "')]"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		ele.click();
		Thread.sleep(3000);

	}

	public boolean verifyOrderDetailPage(String orderNumber) throws Exception {
		boolean b = false;
		WebElement ele = driver.findElement(By.xpath("//div[@class='c-order-info']//li[2]/span[2]"));
		if (textOrder.isDisplayed() && orderNumber.equals(ele.getText())) {
			b = true;
		}
		Thread.sleep(3000);
		return b;
	}
}
