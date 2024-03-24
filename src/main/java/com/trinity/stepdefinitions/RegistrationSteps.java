package com.trinity.stepdefinitions;

import org.testng.Assert;

import com.trinity.Config;
import com.trinity.Keyword;
import com.trinity.pages.HomePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationSteps {
	Keyword keyword = new Keyword();

	

	@When("user fills the entire form with invalid mobile number")
	public void fillRegistrationFormWithInvalidMobileNumber() {
		HomePage home = new HomePage();
		home.clickOnRegisterLink();
		home.enterFirstName("Avinash");
		home.enterLastName("Pingale");
		home.enterAddress("234234sfsdf");
		home.enterCity("California");
		home.enterState("California");
		home.enterZipcode("23422");
		home.enterPhone("dfsdfsd");
		home.enterSSN("23423");
		home.enterUserName("test");
		home.enterPassword("test@123");
		home.enterConfirmPassword("test@123");
	}

	@And("click on register button")
	public void clickOnRegisterBtn() {
		HomePage home = new HomePage();
		home.clickOnRegisterBtn();
	}

	@Then("User should get error message")
	public void verifyErroMessage() {
		String expectedErrorMsg = "Last name is required.";
		HomePage home = new HomePage();
		String erroMSg = home.getLastNameErrorMsg();

		Assert.assertEquals(erroMSg, expectedErrorMsg);
	}

}
