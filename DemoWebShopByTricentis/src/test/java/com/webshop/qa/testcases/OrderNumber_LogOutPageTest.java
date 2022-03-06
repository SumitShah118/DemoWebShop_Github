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

public class OrderNumber_LogOutPageTest extends TestBase{

	LandingPage landingpage;
	LoginPage loginpage;
	HomePage homepage;
	ShoppingCartPage shoppingcartpage;
	CheckOutPage checkoutpage;
	OrderNumber_LogOutPage ordernumberpage;
	
	public OrderNumber_LogOutPageTest() {
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
		checkoutpage.doConfirmOrder();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = 0)
	public void verifyOrderPlacementMessageTest() {
		String message = ordernumberpage.verifyOrderPlacementMessage();
		Assert.assertEquals(message,"Thank you","Order Placement Message not verified");
	}
	
	@Test(priority = 1)
	public void captureTheOrderNumberTest() {
		String orderNumber = ordernumberpage.captureTheOrderNumber();
		System.out.println(orderNumber);
	}
	
	@Test(priority = 2)
	public void clickOnContinueBtnAndLogoutTest() {
		loginpage = ordernumberpage.clickOnContinueBtnAndLogOut();
	}
}
