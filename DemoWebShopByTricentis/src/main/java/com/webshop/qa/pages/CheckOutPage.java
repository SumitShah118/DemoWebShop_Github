package com.webshop.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webshop.qa.base.TestBase;

public class CheckOutPage extends TestBase {

	@FindBy(id="shippingoption_0")
	WebElement shippingMethod;
	
	@FindBy(xpath="//div[@id=\"shipping-method-buttons-container\"]//input[@type=\"button\"]")
	WebElement shippingMethodContinue;
	
	@FindBy(id="paymentmethod_0")
	WebElement cashOnDelivery;
	
	@FindBy(xpath="//div[@id=\"payment-method-buttons-container\"]//input[@type=\"button\"]")
	WebElement paymentMethodContinue;
	
	@FindBy(xpath="//div[@id=\"payment-info-buttons-container\"]//input[@type=\"button\"]")
	WebElement paymentInfoContinue;
	
	@FindBy(xpath="//table[@class=\"cart-total\"]//tr[1]//span[@class=\"product-price\"]")
	WebElement subTotal;
	
	@FindBy(xpath="//table[@class=\"cart-total\"]//tr[2]//span[@class=\"product-price\"]")
	WebElement shippingCost;
	
	@FindBy(xpath="//table[@class=\"cart-total\"]//tr[3]//span[@class=\"product-price\"]")
	WebElement paymentMethodCost;
	
	@FindBy(xpath="//table[@class=\"cart-total\"]//tr[5]/td[2]//span[contains(@class,\"product-price\")]")
	WebElement verifyTotalCartAmount;
	
	@FindBy(xpath="//div[@id=\"confirm-order-buttons-container\"]//input[@value=\"Confirm\"]")
	WebElement confirmBtn;
	
	public CheckOutPage() {
		PageFactory.initElements(driver,this);
	}

	public String verifyCheckOutPageTitle() {
		return driver.getTitle();
	}
	
	public double verifyTotalJeansPrice() {
		proceedWithOrder();
		return Double.parseDouble(subTotal.getText());
	}
	
	public double verifyTotalCartValue() {
		proceedWithOrder();
		double totalPrice = Double.parseDouble(subTotal.getText()) + Double.parseDouble(shippingCost.getText()) + Double.parseDouble(paymentMethodCost.getText());
		return totalPrice;
	}
	
	public void proceedWithOrder() {
		new AddressDetailsPage().fillAddressDetails();
		shippingMethod.click();
		shippingMethodContinue.click();
		cashOnDelivery.click();
		paymentMethodContinue.click();
		paymentInfoContinue.click();
	}
	
	public OrderNumber_LogOutPage doConfirmOrder() {
		proceedWithOrder();
		confirmBtn.click();
		try {
			Thread.sleep(5000);
		}catch(InterruptedException io) {
			io.printStackTrace();
		}
		return new OrderNumber_LogOutPage();
	}
}
