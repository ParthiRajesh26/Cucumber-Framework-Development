package com.Step_Defenitions;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.PageObjects.LoginPage;
import com.Utilities.CommonUtils;
import com.constants.Constants;
import com.webdriver_manager.DriverManager;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Common_Step_Def {
	
	
	private static String ScenarioName;
	
	
	
	public static String getScenarioName() {
		return ScenarioName;
	}


	private static final  org.apache.logging.log4j.Logger LOGGER=LogManager.getLogger("com.CucumberFramework");


	@Before
	public void beforeScenario(Scenario scenario) {
		
		
		ScenarioName=scenario.getName();


		LOGGER.info("Execution Started");


		try {  
			

			LOGGER.info("Instantiation the CommonUtils");

			LOGGER.info("Loading the Properties file");

			CommonUtils.getInstance().loadProperties();

			LOGGER.info("Checking the driver is Null or Not");

			if(DriverManager.getDriver()==null) {

				LOGGER.info("Driver is Null, Instantiating it");

				DriverManager.launchBrowser();

				CommonUtils.getInstance().initWebElements();
				
				login();

			}

		} catch (Exception e) {

			e.printStackTrace();

		}


	}


	private void login() {
		
		DriverManager.getDriver().get(Constants.APP_URL);
		LoginPage.getLoginInstance().enterUserName(Constants.USERNAME);
		LoginPage.getLoginInstance().enterPassword(Constants.PASSWORD);
		LoginPage.getLoginInstance().clickLoginButton();

		
	}
	
	
	@AfterStep
	public void attachScreenshot(Scenario scenario) {
		
		
		if(scenario.isFailed()) {
			
			
		byte[] screenshotTaken=	((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
			
			scenario.attach(screenshotTaken, "image/png", "Error screen");
		}
		
	}



}
