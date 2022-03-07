package com.webshop.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webshop.qa.base.TestBase;
import com.webshop.qa.pages.HomePage;
import com.webshop.qa.pages.LandingPage;
import com.webshop.qa.pages.LoginPage;
import com.webshop.qa.pages.ShoppingCartPage;
import com.webshop.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	LandingPage landingpage;
	LoginPage loginpage;
	HomePage homepage;
	ShoppingCartPage shoppingcartpage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		landingpage = new LandingPage();
		loginpage = new LoginPage();
		homepage = new HomePage();
		shoppingcartpage = new ShoppingCartPage();
		landingpage.clickOnLoginLink();
		loginpage.clickOnLoginBtn();
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
	public void verifyHomePageTitleTest() {
		String homePageTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle,"Demo Web Shop","Home Page Title verification failed");
	}
	
	@Test(priority = 1)
	public void verifyLoggedInUserTest() {
		String loggedInUser = homepage.verifyLoggedInUser();
		Assert.assertEquals(loggedInUser, prop.getProperty("username") ,"Logged User is different");
	}
	
	@Test(priority = 2)
	public void verifyShoppingCartQuantityValue() {
		shoppingcartpage =  homepage.validationToCallUpdateCartMethod();
	}	
}
