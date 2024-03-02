package com.trinity;

import org.testng.annotations.Test;

import com.trinity.base.TestBase;
import com.trinity.pages.HomePage;
import com.trinity.utilities.PropUtil;

import org.testng.Assert;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class TestCases extends TestBase{

	@Test
	public void verifyIfLastNameFieldIsRequiredOrNot() {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(keyword.driver);
		wait.withTimeout(Duration.ofSeconds(15));
		wait.pollingEvery(Duration.ofMillis(500));
		wait.withMessage("Element was not operational during 60 seconds");
		wait.ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Register')]")));

		keyword.driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
		String expectedErrorMsg = "Last name is required.";
		keyword.driver.findElement(By.xpath("//input[@id=\"customer.firstName\"]")).sendKeys("Avinash");
		keyword.driver.findElement(By.xpath("//input[@id=\"customer.address.street\"]")).sendKeys("A1305, East Street");
		keyword.driver.findElement(By.xpath("//input[@id=\"customer.address.city\"]")).sendKeys("California");
		keyword.driver.findElement(By.xpath("//input[@id=\"customer.address.state\"]")).sendKeys("California");
		keyword.driver.findElement(By.xpath("//input[@id=\"customer.address.zipCode\"]")).sendKeys("411024");
		keyword.driver.findElement(By.xpath("//input[@id=\"customer.phoneNumber\"]")).sendKeys("7676767676");
		keyword.driver.findElement(By.xpath("//input[@id=\"customer.ssn\"]")).sendKeys("123324234sdfsd");
		keyword.driver.findElement(By.xpath("//input[@id=\"customer.username\"]")).sendKeys("TestUSer");
		keyword.driver.findElement(By.xpath("//input[@id=\"customer.password\"]")).sendKeys("Test@123");
		keyword.driver.findElement(By.xpath("//input[@id=\"repeatedPassword\"]")).sendKeys("Test@123");
		keyword.driver.findElement(By.xpath("//input[@value=\"Register\"]")).click();
		String errorMsg = keyword.driver.findElement(By.xpath("//span[@id=\"customer.lastName.errors\"]")).getText();
		Assert.assertEquals(errorMsg, expectedErrorMsg);
	}

	@Test
	public void verifyIfLastNameFieldIsRequired() throws IOException {
		String expectedErrorMsg = "Last name is required.";
		String dir = System.getProperty("user.dir");
		String filePath = dir+"/src/test/resources/Locators.properties";
		PropUtil prop = new PropUtil(filePath);
		
		String reglink = prop.getValue("REGISTERLINK");
		keyword.click(reglink);
		
		keyword.click(prop.getValue("REGISTERLINK"));
		
		keyword.enterText(Locator.FIRSTNAME, "Aviansh");
		keyword.enterText(Locator.ADDRESS, "A1305, East Street");
		keyword.enterText(Locator.CITY, "California");
		keyword.enterText(Locator.STATE, "California");
		keyword.enterText(Locator.ZIPCODE, "411056");
		keyword.enterText(Locator.PHONENO, "787878787878");
		keyword.enterText(Locator.SSN, "798asdf7d");
		keyword.enterText(Locator.USERNAME, "TestUser");
		keyword.enterText(Locator.PASSWORD, "Test@123");
		keyword.enterText(Locator.CONFIRMPASS, "Test@123");
		keyword.click(Locator.REGISTERBTN);
		String errorMSg = keyword.getText(Locator.LASTNAMEERROR);
		Assert.assertEquals(errorMSg, expectedErrorMsg);
				
	}
	
	@Test
	public void verifyIfLastNameFieldIsRequiredUsingPOM() {
		String expectedErrorMsg = "Last name is required.";
		HomePage home = new HomePage();
		home.clickOnRegisterLink();
		home.enterFirstName("Avinash");
		home.enterAddress("A1305, East Street");
		home.enterCity("California");
		home.enterState("California");
		home.enterZipcode("34323");
		
		home.enterPhone("3445453445");
		home.enterSSN("345345");
		home.enterUserName("test");
		home.enterPassword("test@123");
		home.enterConfirmPassword("test@123");
		home.clickOnRegisterBtn();
		String erroMSg = home.getLastNameErrorMsg();
		
		Assert.assertEquals(erroMSg, expectedErrorMsg);
	}
	
	@Test
	public void verifyErrorMsgWhenUserEntersInvalidMobileNumber() {
		String expectedErrMsg = "";
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
		
		home.clickOnRegisterBtn();
		
		
	}
	

}
