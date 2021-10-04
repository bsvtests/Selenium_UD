package com_urbandecay_Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com_urbandecay_Generic.BasePage;

public class Logout_Page extends BasePage{

	@FindBy(className = "c-stacked-links__link m-logout")
	private WebElement Logout_Button_MyAccountPage;

	@FindBy(xpath = "//div[@class='c-user__authenticated-welcome']")
	private WebElement MyAccount_Mousehover;

	@FindBy(xpath = "//div[@class='c-tooltip m-active']//a[contains(text(),'Log out')]")
	private WebElement Logout_Mousehover_Click;

	public Logout_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickonLogoutButton(String pagetitle) throws InterruptedException {
		BasePage.verifyElement(Logout_Button_MyAccountPage);
		Reporter.log("Logout text displaying is = "+Logout_Button_MyAccountPage.getText(), true);
		Logout_Button_MyAccountPage.click();
		Reporter.log("User logged out successfully", true);
		Thread.sleep(3000);
		BasePage.verifyTitle(pagetitle);
		Reporter.log("User is navigated to "+pagetitle, true);
		Reporter.log("========================================", true);
	}

	public void clickonLogout_Header(String pagetitle, WebDriver driver) throws InterruptedException {

		Actions act = new Actions(driver);
		
		act.moveToElement(MyAccount_Mousehover);
		Thread.sleep(3000);
		
		act.moveToElement(Logout_Mousehover_Click);
		
		BasePage.verifyElement(Logout_Mousehover_Click);
		Reporter.log("Logout text displaying is = "+Logout_Mousehover_Click.getText(), true);
		
		act.click().build().perform();
		
		Reporter.log("User logged out successfully", true);
		Thread.sleep(2000);
		BasePage.verifyTitle(pagetitle);
		Reporter.log("User is navigated to "+pagetitle, true);
		Reporter.log("========================================", true);
	}







}
