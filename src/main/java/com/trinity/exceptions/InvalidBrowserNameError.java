package com.trinity.exceptions;

import com.trinity.utilities.PropUtil;

public class InvalidBrowserNameError extends Error {
	private String msg;

	public InvalidBrowserNameError(String browserName) {
		msg = "Invalid browser name: "+browserName;
	}
	
	@Override
	public String toString() {
		return msg;
	}
}
