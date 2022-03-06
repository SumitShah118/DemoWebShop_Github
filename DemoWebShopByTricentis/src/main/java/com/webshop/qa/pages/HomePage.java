package com.webshop.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webshop.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//div[@class=\"header-links\"]//a[@href=\"/customer/info\"]")
	WebElement loggedInUser;
	
	@FindBy(xpath="//div[@class=\"header-menu\"]/ul[@class=\"top-menu\"]//a[@href=\"/apparel-shoes\"]")
	WebElement apparel_shoes_link;
	
	@FindBy(xpath="//span[@class=\"cart-qty\"]")
	WebElement cartQuantityValue;
	
	@FindBy(xpath="//a[@href=\"/cart\"]//span[@class=\"cart-label\"]")
	WebElement shoppingCartLink;
	
	@FindBy(xpath="//input[contains(@name,\"itemquantity\")]")
	WebElement itemQuantity;
	
	@FindBy(name="updatecart")
	WebElement updateCartBtn;

	
	public HomePage() {
		PageFactory.initElements(driver,this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public String verifyLoggedInUser() {
		String user = loggedInUser.getText();
		return user;
	}	
	
	public void clickOnApparelAndShoesLink() {
		apparel_shoes_link.click();
	}
	
	public int cartQuantityValidation() {
		String actualValue="";
		String cartQuantity = cartQuantityValue.getText();
		int cartQtyLength = cartQuantity.length();
		if(cartQtyLength == 5) {
			actualValue = cartQuantity.substring(1,4);
		}else if(cartQtyLength == 4) {
			actualValue = cartQuantity.substring(1,3);
		}else if(cartQtyLength == 3) {
			actualValue = cartQuantity.substring(1,2);
		}
		return Integer.parseInt(actualValue);
	}
	
	public ShoppingCartPage validationToCallUpdateCartMethod() {
		if(cartQuantityValidation() != 0) {
			updateCartToZero();
		}
		else {
			clickOnApparelAndShoesLink();
		}
		return new ShoppingCartPage();
	}
	
	public void updateCartToZero() {
		shoppingCartLink.click();
		itemQuantity.clear();
		itemQuantity.sendKeys("0");
		updateCartBtn.click();
		clickOnApparelAndShoesLink();
	}
}
