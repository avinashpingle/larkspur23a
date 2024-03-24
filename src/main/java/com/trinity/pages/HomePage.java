package com.trinity.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trinity.Keyword;
import com.trinity.base.TestBase;

public class HomePage {

	@FindBy(xpath = "//a[contains(text(),'Register')]")
	public WebElement registerLink;

	@FindBy(css = "input[id='customer.firstName']")
	public WebElement firstName;

	@FindBy(xpath = "// input[@id='customer.address.street']")
	public WebElement address;

	@FindBy(xpath = "// input[@id='customer.address.city']")
	public WebElement city;
	
	@FindBy(xpath = "//input[@id=\"customer.lastName\"]")
	public WebElement lastName;

	@FindBy(xpath = "// input[@id='customer.address.state']")
	public WebElement state;
	@FindBy(xpath = "// input[@id='customer.address.zipCode']")
	public WebElement zipcode;
	@FindBy(xpath = "// input[@id='customer.phoneNumber']")
	public WebElement phoneNo;
	@FindBy(xpath = "// input[@id='customer.ssn']")
	public WebElement ssn;
	@FindBy(xpath = "// input[@id='customer.username']")
	public WebElement username;
	@FindBy(xpath = "// input[@id=\"customer.password\"]")
	public WebElement password;
	@FindBy(xpath = "// input[@id=\"repeatedPassword\"]")
	public WebElement confirmPass;
	@FindBy(xpath = "// input[@value=\"Register\"]")
	public WebElement registerBtn;
	@FindBy(xpath = "// span[@id='customer.lastName.errors']")
	public WebElement lastNameError;

	public HomePage() {
		PageFactory.initElements(Keyword.driver, this);
	}

	public void clickOnRegisterLink() {
		registerLink.click();
	}
	
	public void enterFirstName(String text) {
		firstName.sendKeys(text);
	}
	
	public void enterAddress(String text) {
		address.sendKeys(text);
	}

	public void enterCity(String text) {
		city.sendKeys(text);
	}

	public void enterState(String text) {
		state.sendKeys(text);
	}

	public void enterZipcode(String text) {
		zipcode.sendKeys(text);
	}

	public void enterPhone(String text) {
		phoneNo.sendKeys(text);
	}

	public void enterSSN(String text) {
		ssn.sendKeys(text);
	}

	public void enterUserName(String text) {
		username.sendKeys(text);
	}

	public void enterPassword(String text) {
		password.sendKeys(text);
	}

	public void enterConfirmPassword(String text) {
		confirmPass.sendKeys(text);
	}

	public void clickOnRegisterBtn() {
		registerBtn.click();
	}

	public String getLastNameErrorMsg() {
		return lastNameError.getText();
	}

	public void enterLastName(String text) {
		lastName.sendKeys(text);
	}


}
