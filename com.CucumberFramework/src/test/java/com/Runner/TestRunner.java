package com.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "src/test/resources/features",
		glue = "com.Step_Defenitions",
		dryRun = false,
		monochrome = true,
		plugin = {
				
				"rerun:target/Failed_Scenarios.txt",
				
				"html:target/cucumber-reports/report.html",
				
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				
				//"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"
				
				},
		
		
		publish = true
		
		)

 
public class TestRunner {

}
