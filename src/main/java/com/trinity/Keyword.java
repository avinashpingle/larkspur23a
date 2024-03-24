package com.trinity;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.trinity.exceptions.InvalidBrowserNameError;

public class Keyword {

	public static RemoteWebDriver driver;
	public FluentWait<WebDriver> wait;

	private static final Logger LOG = Logger.getLogger(Keyword.class);

	public void openBrowser(String browserName) throws MalformedURLException {

		Config conf = new Config();
		if (conf.executeOnGrid()) {
			// Execute on Grid
			LOG.info("Executing on Grid........!");
			ChromeOptions option = new ChromeOptions();
			driver = new RemoteWebDriver(new URL("http://192.168.0.101:4444"),option);
		} else {

			if (browserName.equalsIgnoreCase("Chrome")) {
				driver = new ChromeDriver();
				LOG.info("Launching Chrome browser");
			} else if (browserName.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
				LOG.info("Launching Firefox browser");
			} else if (browserName.equalsIgnoreCase("Safari")) {
				driver = new SafariDriver();
				LOG.info("Launching Safari browser");
			} else {
				LOG.info("Invalid browser name");
				throw new InvalidBrowserNameError(browserName);
			}
		}

		wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(60));
		wait.pollingEvery(Duration.ofMillis(500));
		wait.withMessage("");
		wait.ignoring(NoSuchElementException.class);
	}

	public void launchUrl(String url) {
		driver.get(url);
	}

	public void waitForElementToBeVisible(By element) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}

	public void waitForElementToBeClickable(By element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void click(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public void enterText(String xpath, String text) {
		driver.findElement(By.xpath(xpath)).sendKeys(text);
	}

	public String getText(String xpath) {
		return driver.findElement(By.xpath(xpath)).getText();
	}

	public void closeBrowser() {
		driver.close();
	}

	public void quiteBrowser() {
		driver.quit();
	}

}
