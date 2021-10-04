package com_urbandecay_TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com_urbandecay_Generic.BasePage;
import com_urbandecay_Generic.BaseTest;
import com_urbandecay_Generic.ExcelData;
import com_urbandecay_Page.Login_Page;

public class LoginTests extends BaseTest {

	@Test
	public void verifyLoginValidcredentials() throws InterruptedException {
		Login_Page lp = new Login_Page(driver);

		String email_login = ExcelData.getData(filepath_LoginDetails, "login", 1, 0);
		String password_login = ExcelData.getData(filepath_LoginDetails, "login", 1, 1);
		String pagetitle = ExcelData.getData(filepath_LoginDetails, "login", 1, 2);

		lp.clickonMyAcc_Header();
		BasePage.verifyTitle("My Account | UrbanDecay");
		lp.enterlogincredentails(email_login, password_login);
		// lp.clickonRememberMeCheckbox();
		// lp.verifyForgotPassword();

	}

	 @Test
	public void verifyLogin_With_InValidcredentials() throws InterruptedException {
		Login_Page lp = new Login_Page(driver);

		String email_login = ExcelData.getData(filepath_LoginDetails, "login", 1, 0);
		String password_login = "test";
		String pagetitle = ExcelData.getData(filepath_LoginDetails, "login", 1, 2);

		lp.clickonMyAcc_Header();
		//BasePage.verifyTitle(pagetitle);
		lp.enterInvalidLoginCredentails(email_login, password_login);

		lp.clickonRememberMeCheckbox();
		lp.verifyForgotPassword();

	}

}
