package com_urbandecay_Page;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com_urbandecay_Generic.BaseTest;

public class MyCart_Page extends BaseTest {

	@FindBy(xpath = "(//td[contains(@class,'c-cart-summary-table__cell m-value')])[5]")
	private WebElement Total_Price;

	@FindBy(xpath = "(//td[contains(@class,'c-cart-summary-table__cell m-value')])[1]")
	private WebElement Sub_Total_Cart;

	@FindBy(xpath = "//input[@type='number']")
	private WebElement Quantity;

	@FindBy(xpath = "//div[@class='c-cart-box__actions']//button[@name='checkout'][normalize-space()='Secure Checkout']")
	private WebElement Secure_Checkout;

	@FindBy(xpath = "//div[@class='l-cart__footer-actions']//button[@name='checkout'][normalize-space()='Secure Checkout']")
	private WebElement Secure_Checkout_promotion;

	@FindBy(xpath = "//tbody[@class='c-product-table__body']//h3[@class='c-product-table-details__title']//button[@class='c-product-table-details__action m-edit']")
	private WebElement Product_Names;

	@FindBy(xpath = "//button[@class='c-product-table-details__action m-remove' and @name='item_remove']")
	private WebElement Remove_Link;

	@FindBy(xpath = "//button[@class='c-product-table-details__action m-edit' and contains(text(),'  Edit  ')]")
	private WebElement Edit_Link;

	@FindBy(xpath = "//div[@class='c-modal__wrapper']//button[@class='c-stepper-input__plus']")
	private WebElement Quantity_Edit_Increase_Modal;

	@FindBy(xpath = "//input[@class='c-stepper-input__field ']")
	private WebElement Quantity_Cart;

	@FindBy(xpath = "//div[@class='c-product-main__actions m-actions']//input[@class='c-stepper-input__field og-quantity']")
	private WebElement Quantity_Edit_Modal_Text;

	@FindBy(xpath = "//button[@class='c-product-add-bag']")
	private WebElement Update_EditModal;

	@FindBy(xpath = "//div[@class='l-cart__back']//span[@class='c-back-to-parent__text']")
	private WebElement BackToShop_Link;

	@FindBy(xpath = "//span[@class='c-product-table__wishlist-add' and text()='Add to wishlist']")
	private WebElement AddtoWishlist_Link;

	// Initialization
	public MyCart_Page(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	// declaration
	public void getTotal() {
		Reporter.log("Total price displaying is = " + Total_Price.getText(), true);
		Reporter.log("Sub-Total price displaying is = " + Sub_Total_Cart.getText(), true);
	}

	public void getQuantity() {
		Reporter.log("Quantity displaying is = " + Quantity.getText(), true);
	}

	public void clickonSecureCheckout() throws InterruptedException {

		if (Secure_Checkout.isEnabled()) {
			Reporter.log("Secure Checkout button is enabled", true);
			Secure_Checkout.click();
			Reporter.log("User is navigating to Checkout pages", true);
			Thread.sleep(4000);
		} else {
			Reporter.log("Secure Checkout button is not enabled in the My cart page", true);
		}
		Reporter.log("========================================", true);
	}

	public void clickonSecureCheckoutUnderPromotion() throws InterruptedException {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0,2000)");
		if (Secure_Checkout_promotion.isEnabled()) {
			Reporter.log("Secure_Checkout_promotion button is enabled", true);
			Secure_Checkout.click();
			Reporter.log("User is navigating to Checkout pages", true);
			Thread.sleep(5000);
		} else {
			Reporter.log("Secure_Checkout_promotion button is not enabled in the My cart page", true);
		}
		Reporter.log("========================================", true);
	}

	public void getProductNames() {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", Product_Names);
		// Product_Names.getText();
		Reporter.log("Product Name is = " + Product_Names.getText(), true);

		Reporter.log("========================================", true);
	}

	public void clickonRemove() throws InterruptedException {
		Remove_Link.click();
		Reporter.log("Product is removed from the cart", true);
		Thread.sleep(3000);
		Reporter.log("========================================", true);
	}

	public void clickonEditlink() throws InterruptedException {
		if (Edit_Link.isDisplayed()) {
			Reporter.log("Edit link is displaying for the product in cart page", true);
			Edit_Link.click();
			Thread.sleep(4000);

		} else {
			Reporter.log("Edit link is not displaying for the product in cart page", true);
		}

		Reporter.log("Current quantity is = " + Quantity_Edit_Modal_Text.getSize(), true);
		Quantity_Edit_Increase_Modal.click();
		Reporter.log("Updated quantity to = " + Quantity_Edit_Modal_Text.getText(), true);
		Thread.sleep(3000);
		Update_EditModal.click();
		Thread.sleep(3000);
		Reporter.log("========================================", true);
	}

	public void clickonBackToShopLink() throws InterruptedException {
		if (BackToShop_Link.isDisplayed()) {
			String BackToShop_Link_Text = BackToShop_Link.getText();
			Reporter.log("Back To Shop Link is displaying and Text is " + BackToShop_Link_Text, true);
			BackToShop_Link.click();
			Thread.sleep(3000);
		}
		Reporter.log("========================================", true);
	}

	public void clickonAddtoWishList() {
		if (AddtoWishlist_Link.isDisplayed())
			Reporter.log("Add to wishlist link is displaying and Text is " + AddtoWishlist_Link.getText(), true);
		AddtoWishlist_Link.click();
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
		Reporter.log("========================================", true);
	}

}
