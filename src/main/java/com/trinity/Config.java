package com.trinity;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.trinity.utilities.PropUtil;

public class Config {
	
	Logger LOG = Logger.getLogger(Config.class);

	public String getBrowserName() {
		return readProperty("browser_name");
	}

	public String getAppUrl() {
		return readProperty("app_url");
	}

	public String getUsername() {
		return readProperty("username");
	}

	private String readProperty(String property) {
		String baseDir = System.getProperty("user.dir");
		PropUtil prop = new PropUtil(baseDir + "/src/main/resources/Config.properties");
		String value = null;
		try {
			value = prop.getValue(property);
		} catch (IOException e) {
		}

		return value;
	}
	
	public boolean executeOnGrid() {
		String baseDir = System.getProperty("user.dir");
		PropUtil prop = new PropUtil(baseDir + "/src/main/resources/Config.properties");
		String value = null;
		try {
			value = prop.getValue("execute_on_grid");
		} catch (IOException e) {
		}

		return Boolean.valueOf(value);
	}
}