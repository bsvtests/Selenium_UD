package com_urbandecay_TestCases;

import org.testng.annotations.Test;

import com_urbandecay_Generic.BaseTest;
import com_urbandecay_Generic.ExcelData;
import com_urbandecay_Page.Login_Page;
import com_urbandecay_Page.MyCart_Page;
import com_urbandecay_Page.PLP_Foundation_Page;
import com_urbandecay_Page.Payment_Page;
import com_urbandecay_Page.Review_Page;
import com_urbandecay_Page.SearchResults_Page;
import com_urbandecay_Page.SearchTextbox_Page;
import com_urbandecay_Page.Shipping_Page;

public class Place_order_Registered extends BaseTest{

	@Test
	public void PlacingOrder_Registered() throws Exception {
		
		//=============Calling Page classes with objects==============//
		PLP_Foundation_Page plp = new PLP_Foundation_Page(driver);
		SearchTextbox_Page stp = new SearchTextbox_Page(driver);
		SearchResults_Page srp = new SearchResults_Page(driver);
		MyCart_Page mcp = new MyCart_Page(driver);
		Login_Page lp = new Login_Page(driver);
		Shipping_Page sp = new Shipping_Page(driver);
		Payment_Page pp = new Payment_Page(driver);
		Review_Page rp = new Review_Page(driver);

		//=============SEARCH TEXT DETAILS==============//
		String et = ExcelData.getData(filepath_SearchText, "searchtext", 1, 0);

		//=============LOGIN DETAILS==============//
		String email_login = ExcelData.getData(filepath_LoginDetails, "login", 1, 0);
		String password_login = ExcelData.getData(filepath_LoginDetails, "login", 1, 1);
		String pagetitle = ExcelData.getData(filepath_LoginDetails, "login", 1, 2);

		//=============SHIPPING DETAILS==============//
		String fn = ExcelData.getData(filepath_Shipping, "Shipping", 1, 0);
		String ln = ExcelData.getData(filepath_Shipping, "Shipping", 1, 1);
		String street = ExcelData.getData(filepath_Shipping, "Shipping", 1, 2);
		String city = ExcelData.getData(filepath_Shipping, "Shipping", 1, 3);
		String state = ExcelData.getData(filepath_Shipping, "Shipping", 1, 4);
		String zipcode = ExcelData.getData(filepath_Shipping, "Shipping", 1, 5);
		String phone = ExcelData.getData(filepath_Shipping, "Shipping", 1, 6);
		String email = ExcelData.getData(filepath_Shipping, "Shipping", 1, 7);

		//=============PAYMENT DETAILS==============//
		String cn = ExcelData.getData(filepath_PaymentDetails, "paymentdetails", 1, 0);
		String cno = ExcelData.getData(filepath_PaymentDetails, "paymentdetails", 1, 1);
		String Month_Text = ExcelData.getData(filepath_PaymentDetails, "paymentdetails", 1, 2);
		String Year_Text = ExcelData.getData(filepath_PaymentDetails, "paymentdetails", 1, 3);
		String sc = ExcelData.getData(filepath_PaymentDetails, "paymentdetails", 1, 4);


		plp.clickonL2Category();
		plp.clickonATC();
		
		mcp.getProductNames();
		mcp.getTotal();
		mcp.clickonSecureCheckout();
		lp.enterlogincredentails(email_login, password_login);
		sp.enterShippingAddress_Registered(fn, ln, street, city, zipcode, phone, state);
		pp.enterCardDetails(cn, cno, Month_Text, Year_Text, sc);
		rp.clickonReviewButton();

	}
}