package com_urbandecay_TestCases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com_urbandecay_Generic.BaseTest;
import com_urbandecay_Page.Login_Page;

public class HomePageLinkTest extends BaseTest {
	
	@Test
	public void verifyHomePageLink() throws Exception {
		verifylinks();
	}

	public void verifylinks() {

		String url = "";
		String mainDomain = "https://staging-eu03-lorealsa.demandware.net";
		Login_Page lp = new Login_Page(driver);
		lp.getLinkElements();
		// String[] linkTexts = new String[linkElements.size()];
		ArrayList<String> urls = new ArrayList<String>();
		int i = 0;
		// extract the link texts of each link element
		Iterator<WebElement> it = lp.getLinkElements().iterator();
		while (it.hasNext()) {
			url = it.next().getAttribute("href");
			if (url == null || url.isEmpty() || !url.startsWith(mainDomain)) {
				System.out.println("URL is either not configured for anchor tag or it is empty");
			} else {
				System.out.println(url);
				urls.add(url);
				if (driver.getTitle().contains("U")) {
				}
			}
		}

		for (int j = 0; j < urls.size(); j++) {
			SoftAssert sa = new SoftAssert();
			driver.get(urls.get(j));
			try {
				if (driver.findElement(By.xpath("//h1[contains(text(),'404 error page')]")).getText().contains("404")) {
					
					sa.assertEquals(true, false);
					System.out.println(urls.get(j));
					System.out.println("fail");
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				sa.assertEquals(true, true);
				System.out.println("Exception handled");
			}

		}

	}
}