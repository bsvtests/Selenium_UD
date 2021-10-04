package com_urbandecay_Page;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com_urbandecay_Generic.BaseTest;

public class BrokenLinks_Page extends BaseTest{

	@FindBy(xpath = "//div[@class='l-footer__middle']//ul//li//a")
	private List<WebElement> Footer_Links_Static;

	@FindBy(xpath = "//div[@class='l-header__inner']//ul//li//a")
	private List<WebElement> Header_Links_Categories;
	
	public BrokenLinks_Page(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public void verifyHeaderCategories() throws IOException, InterruptedException{
		Reporter.log("Verifying the header category links", true);
		Reporter.log("Total Number of header links are = "+Header_Links_Categories.size(), true);

		for(int i=0; i <Header_Links_Categories.size(); i++) {
			WebElement element = Header_Links_Categories.get(i);
			String url = element.getAttribute("href");
			
			URL link = new URL(url);
			
			HttpURLConnection httpconn = (HttpURLConnection) link.openConnection();
			Thread.sleep(3000);
			
			httpconn.connect();
			int responsecode = httpconn.getResponseCode();
			
			if(responsecode >=400) {
				Reporter.log(url+ " = "+" is a Broken Link", true);
			}
			else {
				Reporter.log(url+ " = "+" is a Valid Link", true);
			}
			
			Thread.sleep(4000);
			}
		Reporter.log("===================================", true);
	}
	
	public void verifyFooterLinks() throws IOException, InterruptedException{
		Reporter.log("Verifying the Footer links", true);
		Reporter.log("Total Number of Footer links are = "+Footer_Links_Static.size(), true);

		for(int i=0; i <Footer_Links_Static.size(); i++) {
			WebElement element = Footer_Links_Static.get(i);
			String url = element.getAttribute("href");
			
			URL link = new URL(url);
			
			HttpURLConnection httpconn = (HttpURLConnection) link.openConnection();
			Thread.sleep(3000);
			
			httpconn.connect();
			int responsecode = httpconn.getResponseCode();
			
			if(responsecode >=400) {
				Reporter.log(url+ " = "+" is a Broken Link", true);
			}
			else {
				Reporter.log(url+ " = "+" is a Valid Link", true);
			}
			
		}
		Reporter.log("===================================", true);
	}
	
}