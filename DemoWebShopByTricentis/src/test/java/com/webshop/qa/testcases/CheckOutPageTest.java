package com.webshop.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webshop.qa.base.TestBase;
import com.webshop.qa.pages.CheckOutPage;
import com.webshop.qa.pages.HomePage;
import com.webshop.qa.pages.LandingPage;
import com.webshop.qa.pages.LoginPage;
import com.webshop.qa.pages.OrderNumber_LogOutPage;
import com.webshop.qa.pages.ShoppingCartPage;
import com.webshop.qa.util.TestUtil;

public class CheckOutPageTest extends TestBase {

	LandingPage landingpage;
	LoginPage loginpage;
	HomePage homepage;
	ShoppingCartPage shoppingcartpage;
	CheckOutPage checkoutpage;
	OrderNumber_LogOutPage ordernumberpage;
	
	public CheckOutPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		landingpage = new LandingPage();
		loginpage = new LoginPage();
		homepage = new HomePage();
		shoppingcartpage = new ShoppingCartPage();
		checkoutpage = new CheckOutPage();
		ordernumberpage = new OrderNumber_LogOutPage();
		landingpage.clickOnLoginLink();
		loginpage.clickOnLoginBtn();
		homepage.validationToCallUpdateCartMethod();
		shoppingcartpage.addJeansAndClickOnCheckOutBtn();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void validateBrokenLinksOnLandingPage() {
		TestUtil.validateBrokenLink();
	}
	
	@Test(priority = 0)
	public void verifyCheckOutPageTitleTest() {
		String checkOutPageTitle = checkoutpage.verifyCheckOutPageTitle();
		Assert.assertEquals(checkOutPageTitle,"Demo Web Shop. Checkout","Checkout Page Title verification failed");
	}
	
	@Test(priority = 1)
	public void verifyTotalJeansPriceTest() {
		double jeansPrice = checkoutpage.verifyTotalJeansPrice();
		Assert.assertEquals(jeansPrice, 25.00 ,"Price is not matching");
	}
	
	@Test(priority = 2)
	public void verifyTotalCartValueTest() {
		double cartTotalValue = checkoutpage.verifyTotalCartValue();
		Assert.assertEquals(cartTotalValue, 42.00, "Final Price is not matching");
	}
	
	@Test(priority = 3)
	public void doConfirmOrderTest() {
		ordernumberpage = checkoutpage.doConfirmOrder();
	}
}
