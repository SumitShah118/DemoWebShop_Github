package com.freecrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.freecrm.qa.base.TestBase;

public class RegistrationPage extends TestBase {

	@FindBy(xpath="//a[text()=\"Sign Up\"]")
	WebElement signUp;
	
	@FindBy(id="payment_plan_id")
	WebElement selectEdition;
	
	@FindBy(name="firstname")
	WebElement firstName;
	
	@FindBy(name="surname")
	WebElement lastName;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="email_confirm")
	WebElement email_confirm;
	
	@FindBy(name="username")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="passwordconfirm")
	WebElement password_confirm;
	
	@FindBy(name="agreeTerms")
	WebElement terms;
	
	@FindBy(name="submitButton")
	WebElement submit;
	
	@FindBy(xpath="//img[@class=\"img-responsive\"]")
	WebElement crm_logo;
	
	@FindBy(name ="company_name")
	WebElement company_name;
	
	@FindBy(name="phone")
	WebElement phone;
	
	@FindBy(name="fax")
	WebElement fax;
	
	@FindBy(name="website")
	WebElement website;
	
	@FindBy(name="company_email")
	WebElement company_email;
	
	@FindBy(name="service")
	WebElement desc;
	
	@FindBy(name="address")
	WebElement address;
	
	@FindBy(name="city")
	WebElement city;
	
	@FindBy(name="state")
	WebElement state;
	
	@FindBy(name="postcode")
	WebElement postalCode;
	
	@FindBy(name="copy_address")
	WebElement copy_address;
	
	@FindBy(name="country")
	WebElement country;
	
	@FindBy(name="btnSubmit")
	WebElement continues;
	
	public RegistrationPage() {
		PageFactory.initElements(driver,this);
	}
	
	
	public String verifyRegistrationPageTitle() {
		return driver.getTitle();
	}
	
	public String verifyCRMLogo() {
		return crm_logo.getText();
	}
		
	public boolean verifyRegristrationProcess(String edition, String firstname, String lastname, String email, String conf_email, String username, String password, String conf_password, String company, String phone, String fax, String website, String company_email, String desc, String address, String city, String state, String postalcode, String countryValue) {
		
		try {
		Thread.sleep(5000);
		}
		catch(Exception ie) {
			ie.printStackTrace();
		}
		this.signUp.click();
		
		Select edition_drpDown = new Select(selectEdition);
		edition_drpDown.selectByVisibleText(edition);
		
		this.firstName.sendKeys(firstname);
		this.lastName.sendKeys(lastname);
		this.email.sendKeys(email);
		this.email_confirm.sendKeys(conf_email);
		this.userName.sendKeys(username);
		this.password.sendKeys(password);
		password_confirm.sendKeys(conf_password);
		terms.click();
		submit.click();
		
		this.company_name.sendKeys(company);
		this.phone.sendKeys(phone);
		this.fax.sendKeys(fax);
		this.company_email.sendKeys(company_email);
		this.website.sendKeys(website);
		this.desc.sendKeys(desc);
		this.address.sendKeys(address);
		this.city.sendKeys(city);
		this.state.sendKeys(state);
		this.postalCode.sendKeys(postalcode);
		
		Select cntry = new Select(country);
		cntry.selectByValue(countryValue);
		
		if(continues.isEnabled()) {
			continues.click();
			return true;
		}else {
			return false;
		}
	}
	
	public LoginPage gotoLoginPageTest() {
		crm_logo.click();
		return new LoginPage();
	}
	
	
}
