package com.freecrm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath="//*[@text=\"Login\"]")
	WebElement Sign_in;
	
	@FindBy(xpath="//input[@data-testid=\"user-mobileno-input-box\"]")
	WebElement mobileNumber;
	
	@FindBy(xpath="//input[@data-testid=\"password-input-box-cta\"]")
	WebElement password;
	
	@FindBy(xpath="//*[@data-testid=\"login-cta\"]")
	WebElement login;
	
	public LoginPage(WebDriver ldriver) {
		PageFactory.initElements(ldriver,this);
	}
	
	public String verifyLoginPageTitle() {
		return driver.getTitle();
	}
 
	
}
