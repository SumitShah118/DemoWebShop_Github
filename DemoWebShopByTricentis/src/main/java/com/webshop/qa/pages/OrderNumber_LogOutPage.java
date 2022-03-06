package com.webshop.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webshop.qa.base.TestBase;

public class OrderNumber_LogOutPage extends TestBase{

	@FindBy(xpath="//div[@class=\"page-title\"]//h1")
	WebElement thankYouMessage;
	
	@FindBy(xpath="//ul[@class=\"details\"]/li[1]")
	WebElement orderNumber;
	
	@FindBy(xpath="//input[@value=\"Continue\"]")
	WebElement continueBtn;
	
	@FindBy(xpath="//a[@href=\"/logout\"]")
	WebElement logout;
	
	public OrderNumber_LogOutPage() {
		PageFactory.initElements(driver,this);
	}
	
	public String verifyOrderPlacementMessage() {
		return thankYouMessage.getText();
	}
	
	public String captureTheOrderNumber() {
		return orderNumber.getText();
	}
	
	public LoginPage clickOnContinueBtnAndLogOut() {
		continueBtn.click();
		logout.click();
		return new LoginPage();
	}
}
