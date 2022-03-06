package com.freecrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.pages.RegistrationPage;

public class RegistrationPageTest extends TestBase {
	
	String expected_title = "Free CRM - CRM Pro for customer relationship management, sales, and support";
	RegistrationPage registrationpage;
	LoginPage loginpage;
	
	public RegistrationPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		registrationpage = new RegistrationPage();
		loginpage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void verifyRegistrationPageTitleTest() {
		String actual_title = registrationpage.verifyRegistrationPageTitle();
		Assert.assertEquals(actual_title, expected_title);
	}
	
	@Test(priority = 2)
	public void verifyCRMLogoTest() {
		String CRM_text = registrationpage.verifyCRMLogo();
		Assert.assertEquals(CRM_text, "CRMPRO");
	}
	
	@Test(priority = 3)
	public void verifyRegistrationProcessTest() {
		boolean flag = registrationpage.verifyRegristrationProcess(prop.getProperty("edition"), prop.getProperty("firstname"), prop.getProperty("lastname"), prop.getProperty("email"),
				prop.getProperty("email"), prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("password"), prop.getProperty("company"),
				prop.getProperty("phone"), prop.getProperty("fax"), prop.getProperty("website"), prop.getProperty("company_email"), prop.getProperty("desc"),
				prop.getProperty("address"), prop.getProperty("city"), prop.getProperty("state"), prop.getProperty("postalcode"), prop.getProperty("country"));
		Assert.assertEquals(flag, true);
		
	}
	
	@Test(priority = 4)
	public void gotoLoginPageTest() {
		loginpage = registrationpage.gotoLoginPageTest();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	} 
	

}
