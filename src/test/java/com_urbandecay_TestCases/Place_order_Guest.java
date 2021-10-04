package com_urbandecay_TestCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com_urbandecay_Generic.BaseTest;
import com_urbandecay_Generic.ExcelData;
import com_urbandecay_Page.Intermediate_Login_Page;
import com_urbandecay_Page.MyCart_Page;
import com_urbandecay_Page.OrderConfirmationPage;
import com_urbandecay_Page.PLP_Foundation_Page;
import com_urbandecay_Page.Payment_Page;
import com_urbandecay_Page.ProjectUtils;
import com_urbandecay_Page.Review_Page;
import com_urbandecay_Page.Shipping_Page;

//Verify the functionality by placing an order as a Guest user
public class Place_order_Guest extends BaseTest {

	@Test
	public void GstUsrPalcesingleOrderusingCC() throws Exception {

		// ============= Calling Page classes with objects ==============//
		PLP_Foundation_Page plp = new PLP_Foundation_Page(driver);
		OrderConfirmationPage  OCP= new OrderConfirmationPage(driver);
		MyCart_Page mcp = new MyCart_Page(driver);
		Intermediate_Login_Page ilp = new Intermediate_Login_Page(driver);
		Shipping_Page sp = new Shipping_Page(driver);
		Payment_Page pp = new Payment_Page(driver);
		Review_Page rp = new Review_Page(driver);
		ProjectUtils Pu = new ProjectUtils(driver);

		// ============= SHIPPING DETAILS ==============//
		String fn = ExcelData.getData(filepath_Shipping, "Shipping", 1, 0);
		String ln = ExcelData.getData(filepath_Shipping, "Shipping", 1, 1);
		String street = ExcelData.getData(filepath_Shipping, "Shipping", 1, 2);
		String city = ExcelData.getData(filepath_Shipping, "Shipping", 1, 3);
		String state = ExcelData.getData(filepath_Shipping, "Shipping", 1, 4);
		String zipcode = ExcelData.getData(filepath_Shipping, "Shipping", 1, 5);
		String phone = ExcelData.getData(filepath_Shipping, "Shipping", 1, 6);
		String email = ExcelData.getData(filepath_Shipping, "Shipping", 1, 7);

		// ============= PAYMENT DETAILS ==============//
		String cn = ExcelData.getData(filepath_PaymentDetails, "paymentdetails", 1, 0);
		String cno = ExcelData.getData(filepath_PaymentDetails, "paymentdetails", 1, 1);
		String Month_Text = ExcelData.getData(filepath_PaymentDetails, "paymentdetails", 1, 2);
		String Year_Text = ExcelData.getData(filepath_PaymentDetails, "paymentdetails", 1, 3);
		String sc = ExcelData.getData(filepath_PaymentDetails, "paymentdetails", 1, 4);

		// ============= VALIDATIONS ==============//
		plp.clickonL2Category();
		plp.clickonATC();
		mcp.getProductNames();
		mcp.getTotal();
		mcp.clickonSecureCheckout();
		/*
		 * ilp.clickonGuestCheckout(); sp.enterShippingAddress_Guest("test name one",
		 * "test lastnm", "1 microsoft way", "redmond", "98502", "3332223232",
		 * "testbrandemail@gmail.com", "Washington"); sp.clickOnKeepadrsbutton();
		 * pp.selectPaymentmethod(); pp.enterCardDetails(cn, cno, Month_Text, Year_Text,
		 * sc); rp.clickonReviewButton();
		 */
		ilp.clickoncheckoutbuttonasGuest();
		//ilp.enterguestEmail();
		//ilp.clickonGuestCheckout();
		
		ilp.clickonContinueaddress();
		
		sp.enterShippingAddress_Guest("test name one", "test lastnm", "1 microsoft way", "redmond", "98502",
				"3332223232", "testbrandemail@gmail.com", "Washington");
		pp.selectPaymentmethod();
		pp.enterCardDetails(cn, cno, Month_Text, Year_Text, sc);
		rp.clickonReviewButton();
		rp.clickonplaceorder();
		boolean b=OCP.verifyOrderConfirmationPage_CC();
		Assert.assertEquals(b, true);

	}

	//@Test
	public void GstUsrPalcesingleOrderusingCCunderPromotion() throws Exception {

		// ============= Calling Page classes with objects ==============//
		PLP_Foundation_Page plp = new PLP_Foundation_Page(driver);
		MyCart_Page mcp = new MyCart_Page(driver);
		Intermediate_Login_Page ilp = new Intermediate_Login_Page(driver);
		Shipping_Page sp = new Shipping_Page(driver);
		Payment_Page pp = new Payment_Page(driver);
		Review_Page rp = new Review_Page(driver);
		ProjectUtils Pu = new ProjectUtils(driver);
		OrderConfirmationPage OCP = new OrderConfirmationPage(driver);
		// ============= SHIPPING DETAILS ==============//
		String fn = ExcelData.getData(filepath_Shipping, "Shipping", 1, 0);
		String ln = ExcelData.getData(filepath_Shipping, "Shipping", 1, 1);
		String street = ExcelData.getData(filepath_Shipping, "Shipping", 1, 2);
		String city = ExcelData.getData(filepath_Shipping, "Shipping", 1, 3);
		String state = ExcelData.getData(filepath_Shipping, "Shipping", 1, 4);
		String zipcode = ExcelData.getData(filepath_Shipping, "Shipping", 1, 5);
		String phone = ExcelData.getData(filepath_Shipping, "Shipping", 1, 6);
		String email = ExcelData.getData(filepath_Shipping, "Shipping", 1, 7);

		// ============= PAYMENT DETAILS ==============//
		String cn = ExcelData.getData(filepath_PaymentDetails, "paymentdetails", 1, 0);
		String cno = ExcelData.getData(filepath_PaymentDetails, "paymentdetails", 1, 1);
		String Month_Text = ExcelData.getData(filepath_PaymentDetails, "paymentdetails", 1, 2);
		String Year_Text = ExcelData.getData(filepath_PaymentDetails, "paymentdetails", 1, 3);
		String sc = ExcelData.getData(filepath_PaymentDetails, "paymentdetails", 1, 4);

		// ============= VALIDATIONS ==============//
		plp.clickonL2Category();
		plp.clickonATC();
		Pu.handleAddedProductsPopUp();
		//mcp.getProductNames();
		//mcp.getTotal();
		mcp.clickonSecureCheckoutUnderPromotion();
		ilp.enterguestEmail();
		ilp.clickonGuestCheckout();
		
		ilp.clickonContinueaddress();
		
		sp.enterShippingAddress_Guest("test name one", "test lastnm", "1 microsoft way", "redmond", "98502",
				"3332223232", "testbrandemail@gmail.com", "Washington");
		//ilp.clickonContinueTodelivery();
		//sp.clickOnKeepadrsbutton();
		pp.selectPaymentmethod();
		pp.enterCardDetails(cn, cno, Month_Text, Year_Text, sc);
		rp.clickonReviewButton();
		rp.clickonplaceorder();
		boolean b=OCP.verifyOrderConfirmationPage_CC();
		Assert.assertEquals(b, true);

	}
}
