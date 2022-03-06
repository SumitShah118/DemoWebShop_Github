package com.webshop.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webshop.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(id="Email")
	WebElement email;
	
	@FindBy(id="Password")
	WebElement password;
	
	@FindBy(id="RememberMe")
	WebElement checkBox;
	
	@FindBy(xpath="//input[@type=\"submit\" and @value=\"Log in\"]")
	WebElement loginBtn;
	
	@FindBy(xpath="//div[@class=\"customer-blocks\"]//div[@class=\"text\"]")
	WebElement newCustText;
	
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	
	public String verifyLoginPageTitle() {
		return driver.getTitle();
	}
	
	public String getNewCustomerText() {
		String text = newCustText.getText();
		return text;
	}
	
	public HomePage clickOnLoginBtn() {
		email.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		loginBtn.click();
		return new HomePage();
	}	
}
