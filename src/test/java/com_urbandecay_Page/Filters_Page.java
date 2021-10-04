package com_urbandecay_Page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com_urbandecay_Generic.ScrollToElement_JavaScriptExecutor;

public class Filters_Page {

	@FindBy(id = "refinement-color")
	private WebElement Refinements_section;

	@FindBy(xpath = "//div[@class='c-refinement-swatches']")
	private List<WebElement> Color_Options;

	@FindBy(xpath = "//div[@class='c-refinement m-expanded']")
	private WebElement Refinements_Section_Expanded;

	@FindBy(xpath = "//span[@class='c-refinement-swatches__name h-show-for-sr' and text()='RED']")
	private WebElement Color_RED;
	
	@FindBy(xpath = "//a[@class='c-refinement__clear']")
	private WebElement Clear_Filter;

	public Filters_Page(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public void clickonRefinementsSection() throws InterruptedException {
		Refinements_section.click();
		Thread.sleep(2000);
		if(Refinements_Section_Expanded.isDisplayed()) {
			Reporter.log("Color filter is expanded and displaying", true);
		}
		else {
			Reporter.log("Color filter is NOT expanded and NOT displaying", true);
		}
		Reporter.log("Total no of color filters displaying are = "+Color_Options.size(), true);
		Reporter.log("Available Colors are = ", true);
		List<WebElement> colors = Color_Options;
		for(int i=0; i<colors.size(); i++) {
			Reporter.log(colors.get(i).getText()+" color ", true);
			Thread.sleep(1000);
		}
		Reporter.log("========================================", true);
		}

	public void clickonColorOption() throws InterruptedException {
	
		ScrollToElement_JavaScriptExecutor.ScrollDownToElement(Clear_Filter);
		if(Clear_Filter.isDisplayed()) {
			
			Clear_Filter.click();
			Thread.sleep(2000);
			Reporter.log("Cleared the pre-selected color filter", true);
		}
		else {
			Reporter.log("No color filters are selected", true);
		}
		Color_RED.click();
		Thread.sleep(3000);
		Reporter.log("========================================", true);
	}



}
