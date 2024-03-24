package com.trinity.stepdefinitions;

import java.net.MalformedURLException;

import com.trinity.Config;
import com.trinity.Keyword;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	Keyword keyword = new Keyword();

	@Before(order = 0)
	public void launchBrowserAndAppUrl() throws MalformedURLException {
		Config conf = new Config();
		keyword.openBrowser(conf.getBrowserName());
		keyword.launchUrl(conf.getAppUrl());
	}
	
	@After
	public void tearDown() throws Exception {
		keyword.quiteBrowser();
	}

}
