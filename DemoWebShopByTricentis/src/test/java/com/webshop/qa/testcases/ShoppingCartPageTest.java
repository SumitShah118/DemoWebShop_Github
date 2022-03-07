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
import com.webshop.qa.pages.ShoppingCartPage;
import com.webshop.qa.util.TestUtil;

public class ShoppingCartPageTest extends TestBase{
	
	LandingPage landingpage;
	LoginPage loginpage;
	HomePage homepage;
	ShoppingCartPage shoppingcartpage;
	CheckOutPage checkoutpage;
	
	public ShoppingCartPageTest() {
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
		landingpage.clickOnLoginLink();
		loginpage.clickOnLoginBtn();
		homepage.validationToCallUpdateCartMethod();
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
	public void verifyShoppingPageTitleTest() {
		String shoppingCartPageTitle = shoppingcartpage.verifyShoppingPageTitle();
		Assert.assertEquals(shoppingCartPageTitle,"Demo Web Shop. Apparel & Shoes","Shopping Cart Page Title verification failed");
	}
	
	@Test(priority = 1)
	public void verifyBlueJeansLinkPresentTest() {
		boolean linkPresent = shoppingcartpage.verifyBlueJeansLinkPresent();
		Assert.assertEquals(linkPresent,true ,"Blue Jeans Link Present");
	}
	
	@Test(priority = 2)
	public void verifyBlueJeansTitleTest() {
		String blueJeanTitle =  shoppingcartpage.verifyBlueJeansTitle();
		Assert.assertEquals(blueJeanTitle, "Demo Web Shop. Blue Jeans","Blue Jeans Title verification not done");
	}
	
	@Test(priority = 3)
	public void verifyPriceOfBlueJeansTest() {
		double priceBlueJeans = shoppingcartpage.verifyPriceOfBlueJeans();
		Assert.assertEquals(priceBlueJeans, 1.00, "Price not matching");
	}
	
	@Test(priority = 4)
	public void addJeansAndClickOnCheckOutBtnTest() {
		checkoutpage = shoppingcartpage.addJeansAndClickOnCheckOutBtn();
	}

}
