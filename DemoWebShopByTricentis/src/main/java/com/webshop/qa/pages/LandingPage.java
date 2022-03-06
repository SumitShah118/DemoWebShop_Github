package com.webshop.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webshop.qa.base.TestBase;

public class LandingPage extends TestBase {

	@FindBy(xpath="//a[@href=\"/login\"]")
	WebElement loginLink;
	
	@FindBy(xpath="//img[@src=\"/Themes/DefaultClean/Content/images/logo.png\"]")
	WebElement webShopImage;
	
	public LandingPage() {
		PageFactory.initElements(driver,this);
	}
	
	public String verifyLandingPageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyLoginLinkDisplayed() {
		boolean linkDisp = loginLink.isDisplayed();
		return linkDisp;
	}
	
	public boolean verifyWebShopImagePresent() {
		boolean imgPresent = webShopImage.isDisplayed();
		return imgPresent;
	}
 
	public LoginPage clickOnLoginLink() {
		loginLink.click();
		return new LoginPage();
	}
}
