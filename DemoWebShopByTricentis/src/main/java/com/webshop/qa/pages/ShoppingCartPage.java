package com.webshop.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webshop.qa.base.TestBase;

public class ShoppingCartPage extends TestBase{
	
	@FindBy(xpath="//h2[@class=\"product-title\"]/a[@href=\"/blue-jeans\"]")
	WebElement blueJeansLink;
	
	@FindBy(xpath="//span[@itemprop=\"price\"]")
	WebElement priceText;
	
	@FindBy(id="addtocart_36_EnteredQuantity")
	WebElement quantityBox;
	
	@FindBy(id="add-to-cart-button-36")
	WebElement addToCartBtn;
	
	@FindBy(id="termsofservice")
	WebElement termsOfServiceCheckBox;
	
	@FindBy(id="checkout")
	WebElement checkOutBtn;
	
	public ShoppingCartPage() {
		PageFactory.initElements(driver,this);
	}
	
	public String verifyShoppingPageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyBlueJeansLinkPresent() {
		return blueJeansLink.isDisplayed();
	}
	
	public String verifyBlueJeansTitle() {
		blueJeansLink.click();
		try {
			Thread.sleep(2000);
		}catch(InterruptedException io) {
			io.printStackTrace();
		}
		return driver.getTitle();
	}
	
	public double verifyPriceOfBlueJeans() {
		verifyBlueJeansTitle();
		return Double.parseDouble(priceText.getText());
	}
	
	public CheckOutPage addJeansAndClickOnCheckOutBtn() {
		verifyBlueJeansTitle();
		quantityBox.clear();
		quantityBox.sendKeys("25");
		addToCartBtn.click();
		new HomePage().shoppingCartLink.click();
		termsOfServiceCheckBox.click();
		checkOutBtn.click();
		return new CheckOutPage();
	}

}
