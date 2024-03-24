package com.trinity.base;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@Test
@CucumberOptions(features = "src/test/resources/Features", 
glue = "com.trinity.stepdefinitions", dryRun = false, plugin = {
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
})

public class TestRunner extends AbstractTestNGCucumberTests{

	
	
}
