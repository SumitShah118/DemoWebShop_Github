package com.webshop.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webshop.qa.base.TestBase;
import com.webshop.qa.pages.HomePage;
import com.webshop.qa.pages.LandingPage;
import com.webshop.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LandingPage landingpage;
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		landingpage = new LandingPage();
		loginpage = new LoginPage();
		homepage = new HomePage();
		landingpage.clickOnLoginLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = 0)
	public void verifyLoginPageTitleTest() {
		String loginPageTitle = loginpage.verifyLoginPageTitle();
		Assert.assertEquals(loginPageTitle,"Demo Web Shop. Login","Login Page Title verification failed");
	}
	
	@Test(priority = 1)
	public void getNewCustomerTextTest() {
		String newCustText = loginpage.getNewCustomerText();
		Assert.assertEquals(newCustText, "By creating an account on our website you will be able to shop faster, be up to date on an orders status, and keep track of the orders you have previously made." ,"New Customer Text is not matching");
	}
	
	@Test(priority = 2)
	public void clickOnLoginBtnTest() {
		homepage = loginpage.clickOnLoginBtn();
	}
}
