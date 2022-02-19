package com.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "@target/Failed_Scenarios.txt",
		glue = "com.Step_Defenitions",
		dryRun = false,
		monochrome = true
		
		)

public class Rerunner {

}
