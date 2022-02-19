package com.Step_Defenitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import com.PageObjects.TimePage;
import com.Utilities.CommonUtils;
import com.webdriver_manager.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TimeSheets_Step_Def {

	private static Logger LOGGER=LogManager.getLogger("com.CucumberFramework");

	@Given("the user is on the Directory page")
	public void the_user_is_on_the_homepage() {

		try {	
			
			String url=	DriverManager.getDriver().getCurrentUrl();

			if(url.contains("viewDirectory")) {

				LOGGER.info("the user is on the Directory page");
			}
			
		} catch (Exception e) {
			LOGGER.error(e);
			//CommonUtils.getInstance().takeScreenshot();
			Assert.fail(e.getMessage());

		}	

	}


	@Given("the user clicks on time option from the menu")
	public void the_user_clicks_on_time_option_from_the_menu() {

		try {

			TimePage.getTimePageInstance().clickTime();
			LOGGER.info("the user clicks on time option from the menu");

		} catch (Exception e) {
			LOGGER.error(e);
			//CommonUtils.getInstance().takeScreenshot();
			Assert.fail(e.getMessage());



		}


	}


	@Given("the user enters the name as {string}")
	public void the_user_enters_the_name_as(String name) {

		try {
			
			TimePage.getTimePageInstance().getEmployee(name);

			LOGGER.info("the user enters the name as {string}");

		} catch (Exception e) {

			LOGGER.error(e);
			//CommonUtils.getInstance().takeScreenshot();
			Assert.fail(e.getMessage());
		}


	}


	@Given("clicks on view button")
	public void clicks_on_view_button() {


		try {

			TimePage.getTimePageInstance().viewButton();
			LOGGER.info("clicks on view button");

		} catch (Exception e) {

			LOGGER.error(e);
			//CommonUtils.getInstance().takeScreenshot();
			Assert.fail(e.getMessage());

		}


	}


	@Then("the user should see the message as {string}")
	public void the_user_should_see_the_message_as(String expectedMessage) {


		try {

			String actualMessage=TimePage.getTimePageInstance().getmessage();

			if(actualMessage==expectedMessage) {

				LOGGER.info("Expected Message is Seen");
			}

		} catch (Exception e) {
			LOGGER.error(e);
			//CommonUtils.getInstance().takeScreenshot();
			Assert.fail(e.getMessage());
			

		}
		
	}



}
