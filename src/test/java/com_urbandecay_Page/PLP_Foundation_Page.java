package com_urbandecay_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import java.util.List;

import com_urbandecay_Generic.BasePage;
import com_urbandecay_Generic.BaseTest;
import com_urbandecay_Generic.ScrollToElement_JavaScriptExecutor;

public class PLP_Foundation_Page extends BaseTest {

	// Declaration
	@FindBy(xpath = "//a[text()='  Face  ']")
	private WebElement menuHoverLink;

	@FindBy(xpath = "//div[@class='c-navigation__flyout-element']//li//a[@data-title='Foundation' and text()='Foundation']")
	private WebElement subLink;

	// Declaring for Bread-crumbs
	@FindBy(xpath = "//ol[@class='c-breadcrumbs__list']/li")
	private List<WebElement> bc_class;

	@FindBy(xpath = "//span[contains(@class, 'c-breadcrumbs__text') and normalize-space(text()) = 'Home']")
	private WebElement Home;

	@FindBy(xpath = "//span[contains(@class, 'c-breadcrumbs__text') and normalize-space(text()) = 'Face']")
	private WebElement Level1;

	@FindBy(xpath = "//span[@class='c-breadcrumbs__text c-breadcrumbs__item-text']")
	private WebElement current;

	// Declaring for sort by drop-down.
	// Here we are using Bootstrap drop down in our UD site. So Select class will
	// not work to find the element.
	// Click on the given drop down
	// • Get all the tags while are available under "li" tag
	// • Get the text of each "li//a" OR "div//a"
	// • Match the text and click on it
	@FindBy(xpath = "//div[@class='c-select__panel']//ul//li")
	private List<WebElement> sortby_dropdown;

	@FindBy(xpath = "//div[@class='l-plp__sorting']//div[@class='c-sorting m-customized']//div[@class='c-select m-large c-field m-active']//button[@class='c-select__placeholder']")
	private WebElement Find_sortby_dropdown;

	@FindBy(xpath = "//ul[@class='c-refinement-category']/li[contains(@class,'c-refinement-category__item')]")
	private List<WebElement> categories_PLP;

	@FindBy(xpath = "//aside[@class='l-plp__sidebar']//nav[@class='l-plp__refinements']//section[@id='refinements']/ul/li//a[@class='c-refinement-category__link ' and text()='Powder']")
	private WebElement AnotherCategory_PLP;

	@FindBy(xpath = "//button[contains(@class,'c-button m-expand-for-medium-down ') and @data-pid='3605972250681']//span[text()='Add to Cart']")
	private WebElement AddtoCart;

	@FindBy(xpath = "//body/div[8]/main[1]/div[2]/div[1]/section[1]/div[2]/div[1]/div[1]/figure[1]/figcaption[1]/div[2]/form[1]/button[1]/span[1]")
	private WebElement Add2Cart;

	// body/div[8]/main[1]/div[2]/div[1]/section[1]/div[2]/div[1]/div[1]/figure[1]/figcaption[1]/div[2]/form[1]/button[1]/span[1]
	// This will close the modal after adding the product to the cart.
	@FindBy(className = "c-modal__close")
	private WebElement Close_Modal_PLP;

	@FindBy(xpath = "//a[normalize-space()='Go to my cart']")
	private WebElement GoToCartbutton;

	@FindBy(xpath = "//div[@class='l-plp__results-count']//div[@class='c-results-count  ']")
	private WebElement Product_Count_PLP;

	@FindBy(xpath = "//a[text()=' Stay Naked Weightless Liquid Foundation ']//parent::h2[@class='c-product-tile__name']//preceding-sibling::div[@class='c-product-tile__wishlist']")
	private WebElement Wishlist_PLP;

	// Initialization
	public PLP_Foundation_Page(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	// Level 2 Mouse hover in root category
	// utilization

	public void clickonL2Category() throws Exception {
		// WebDriver driver = null;
		Actions act = new Actions(driver);
		act.moveToElement(menuHoverLink).perform();

		act.moveToElement(menuHoverLink).perform();
		Reporter.log("Face menu category is displaying now", true);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(subLink));

		act.moveToElement(subLink).click().build().perform();
		Reporter.log("Foundation category is clicked and displaying and now user is in foundation landing page", true);

		Thread.sleep(6000);
		Reporter.log("========================================", true);
	}

	// Breadcrumbs
	public void Breadcrumblist() throws InterruptedException {

		System.out.println("Current page breadcrumb is = " + current.getText());
		System.out.print("List of Breadcrumbs are = ");

		for (WebElement links_Text : bc_class) {
			System.out.print(links_Text.getText() + " > ");

		}
		Reporter.log("========================================", true);
	}

	public void clickonLevel1breadcrumb() throws InterruptedException {

		Reporter.log("Current page breadcrumb is = " + current.getText(), true);
		if (current != Level1) {
			Level1.click();
			Reporter.log("Navigating to previous page = " + Level1.getText(), true);
			Thread.sleep(3000);
		} else {
			Reporter.log("Breadcrumb mismatch in " + Level1.getText() + " page.", true);
		}
		Thread.sleep(3000);
		Reporter.log("========================================", true);
	}

	public void clickonHomebreadcrumb() throws InterruptedException {

		if (current != Home) {
			Home.click();
			System.out.println("User is in Homepage");
			Thread.sleep(3000);
		} else {
			System.out.println("Breadcrumb mismatch in " + Home.getText() + " page.");
		}
		Thread.sleep(3000);
		Reporter.log("========================================", true);
	}

	// Sort By
	public void AllDropDownOptions() throws InterruptedException {
		Find_sortby_dropdown.click();
		Thread.sleep(2000);

		List<WebElement> dropdown = sortby_dropdown;
		System.out.println("Total sort by dropdown options are " + dropdown.size());
		System.out.println("dropdown options are ");
		for (int i = 0; i < dropdown.size(); i++) {

			String drop_down_values = dropdown.get(i).getText();
			System.out.println(drop_down_values);

		}
		Reporter.log("========================================", true);
	}

	public void selectOptionfromDropdown() throws InterruptedException {
		Find_sortby_dropdown.click();
		Thread.sleep(2000);

		List<WebElement> dropdown = sortby_dropdown;

		for (int i = 0; i < dropdown.size(); i++) {

			if (dropdown.get(i).getText().contains("Price (High To Low)")) {
				dropdown.get(i).click();
				Reporter.log(dropdown.get(i).getText() + " Option is selected in drodpdown", true);
				Thread.sleep(3000);
				break;
			}
		}
		Reporter.log("========================================", true);
	}

	// Categories in left Nav of PLP
	public void getAllPLPCategories() {

		List<WebElement> categories = categories_PLP;
		Reporter.log("sub categories are : ", true);
		for (int i = 0; i < categories.size(); i++) {

			String category_text = categories.get(i).getText();
			Reporter.log(category_text, true);

		}
		Reporter.log("========================================", true);

	}

	public void clickPLPCategory() throws InterruptedException {

		List<WebElement> categories = categories_PLP;

		for (int i = 0; i < categories.size(); i++) {

			WebDriverWait wait = new WebDriverWait(driver, 10);
			if (categories.get(i).getText().contains("Primer")) {
				Boolean invisible = wait
						.until(ExpectedConditions.invisibilityOfElementLocated(By.id("onetrust-policy-text")));

				if (invisible) {
					AnotherCategory_PLP.click();
					Thread.sleep(3000);

				}
			}
		}
		Reporter.log("========================================", true);
	}

	// Only adds the product in PLP
	public void clickonAddToBag_PLP() throws InterruptedException {

		AddtoCart.click();
		Reporter.log("Product has been added to cart from PLP", true);
		Thread.sleep(4000);
		Close_Modal_PLP.click();
		Thread.sleep(2000);
		Reporter.log("========================================", true);
	}

	// Adds product and Navigates to Cart page
	public void clickonATC() throws InterruptedException {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0,1000)");

		WebElement element = driver.findElement(By.xpath(
				"(//span[contains(.,'Add to Cart')])[1]"));

		executor.executeScript("arguments[0].click();", element);

		// Add2Cart.click();
		Reporter.log("Product has been added to cart from PLP", true);
		Thread.sleep(10000);
		//WebElement ele = driver.findElement(By.xpath("//a[normalize-space()='Go to my cart']"));
		//executor.executeScript("arguments[0].click();", ele);
		Reporter.log("User is navigating to Cart page", true);
		Thread.sleep(5000);
		Reporter.log("========================================", true);

	}

	public void productcount() {
		Reporter.log(Product_Count_PLP.getText() + " in the PLP", true);
		Reporter.log("========================================", true);
	}

	public void clickOnWishlist_PLP() throws InterruptedException {
		if (Wishlist_PLP.isDisplayed()) {
			Reporter.log("Wishlist icon is displaying in the PLP", true);
			Wishlist_PLP.click();
			Reporter.log("User clicked on the Wishlist icon", true);
			Reporter.log("Login credentials pop-up is displaying", true);
			Thread.sleep(3000);
		} else {
			Reporter.log("Wishlist icon is NOT displaying in the PLP", true);
		}

		Thread.sleep(3000);
		Reporter.log("========================================", true);
	}

}
