package com.webshop.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webshop.qa.base.TestBase;
import com.webshop.qa.pages.LandingPage;
import com.webshop.qa.pages.LoginPage;

public class LandingPageTest extends TestBase {

	LandingPage landingpage;
	LoginPage loginpage;
	
	public LandingPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		landingpage = new LandingPage();
		loginpage = new LoginPage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = 0)
	public void verifyLandingPageTitleTest() {
		String landingPageTitle = landingpage.verifyLandingPageTitle();
		Assert.assertEquals(landingPageTitle,"Demo Web Shop","Landing Page Title verification failed");
	}
	
	@Test(priority = 1)
	public void verifyLoginLinkDisplayTest() {
		boolean linkFlag = landingpage.verifyLoginLinkDisplayed();
		Assert.assertEquals(linkFlag, true ,"Login Link is not displayed on Landing Page");
	}
	
	@Test(priority = 2)
	public void verifyWebShopImagePresentTest() {
		boolean imageFlag = landingpage.verifyWebShopImagePresent();
		Assert.assertEquals(imageFlag, true,"Image is not present on Landing Page");
	}
	
	@Test(priority = 3)
	public void clickOnLoginLinkTest() {
		loginpage = landingpage.clickOnLoginLink();
	}
}
