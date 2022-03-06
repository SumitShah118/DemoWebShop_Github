package com.webshop.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.webshop.qa.base.TestBase;

public class AddressDetailsPage extends TestBase {
	
	@FindBy(id="billing-address-select")
	WebElement addressDropDown;
	
	@FindBy(id="BillingNewAddress_CountryId")
	WebElement countryDropDown;	
	
	@FindBy(id="BillingNewAddress_FirstName")
	WebElement firstName;
	
	@FindBy(id="BillingNewAddress_LastName")
	WebElement lastName;
	
	@FindBy(id="BillingNewAddress_Email")
	WebElement email;
	
	@FindBy(id="BillingNewAddress_City")
	WebElement city;
	
	@FindBy(id="BillingNewAddress_Address1")
	WebElement address1;

	@FindBy(id="BillingNewAddress_PhoneNumber")
	WebElement phoneNumber;
	
	@FindBy(id="BillingNewAddress_ZipPostalCode")
	WebElement postalCode;
	
	@FindBy(xpath="//div[@id=\"billing-buttons-container\"]//input[@type=\"button\"]")
	WebElement billingAddressContinue;
	
	@FindBy(xpath="//div[@id=\"shipping-buttons-container\"]//input[@type=\"button\"]")
	WebElement shippingAddressContinue;

	public AddressDetailsPage() {
		PageFactory.initElements(driver,this);
	}
	
	public void newAddress() {
		Select newAdd = new Select(addressDropDown);
		newAdd.selectByVisibleText("New Address");
	}
	
	public void selectContryMethod() {
		Select country = new Select(countryDropDown);
		country.selectByVisibleText("India");
	}

	public void fillAddressDetails() {
		try {
			Thread.sleep(2000);
		}catch(InterruptedException io) {
			io.printStackTrace();
		}
		newAddress();
		firstName.clear();
		firstName.sendKeys("Sumit");
		lastName.clear();
		lastName.sendKeys("Shah");
		email.clear();
		email.sendKeys("sumitshah118@hotmail.com");
		city.clear();
		city.sendKeys("Geneva");
		selectContryMethod();
		address1.clear();
		address1.sendKeys("Port Elizabeth");
		phoneNumber.clear();
		phoneNumber.sendKeys("123456778");
		postalCode.clear();
		postalCode.sendKeys("345634");
		billingAddressContinue.click();
		shippingAddressContinue.click();
	}	
}
