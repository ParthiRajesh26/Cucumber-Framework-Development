package com.Step_Defenitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import com.PageObjects.DirectoryPage;
import com.PageObjects.HomePage;
import com.PageObjects.LoginPage;
import com.Utilities.CommonUtils;
import com.constants.Constants;
import com.webdriver_manager.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Verify_CEO_Step_Def {

	private static final Logger LOGGER=LogManager.getLogger("com.CucumberFramework");


	@Given("the user is logged in successfully and is on homepage")
	public void the_user_is_logged_in_successfully_and_is_on_homepage() {

		try {

			String url=DriverManager.getDriver().getCurrentUrl();

			if(url.contains("dashboard")) {

				LOGGER.info("the user is logged in successfully and is on homepage");
			}


		} catch (Exception e) {
			LOGGER.error(e);
			//CommonUtils.getInstance().takeScreenshot();
			Assert.fail(e.getMessage());
		}

	}



	@When("the user clicks on the directory option from the Menu bar")
	public void the_user_clicks_on_the_directory_option_from_the_menu_bar() {



		try {

			HomePage.getHomeInstance().getDirectory();
			LOGGER.info("the user clicks on the directory option from the Menu bar");

		} catch (Exception e) {
			LOGGER.error(e);
			//CommonUtils.getInstance().takeScreenshot();
			Assert.fail(e.getMessage());

		}
	}


	@When("the user selects the job title as {string} from the dropdown using {string}")
	public void the_user_selects_the_job_title_as_from_the_dropdown(String job_title, String howTo) {

		try {
			
			CommonUtils.getInstance().selectFromDropdown(DirectoryPage.getdirectoryInstance().getJOB_TITLE(), howTo, job_title);
		} catch (Exception e) {

			LOGGER.error(e);
	    //	 CommonUtils.getInstance().takeScreenshot();
			Assert.fail(e.getMessage());

		}



		//		try {
		//
		//			DirectoryPage.getdirectoryInstance().getJobTitle(job_title);
		//			LOGGER.info("the user selects the job title as {string} from the dropdown");
		//
		//		} catch (Exception e) {
		//			LOGGER.error(e);
		//			CommonUtils.getInstance().takeScreenshot();
		//		}

	}

	@When("clicks the search button")
	public void clicks_the_search_button() {



		try {
			DirectoryPage.getdirectoryInstance().clickSearchButton();

			LOGGER.info("clicks the search button");

		} catch (Exception e) {

			LOGGER.error(e);
			//CommonUtils.getInstance().takeScreenshot();
			Assert.fail(e.getMessage());
		}


	}

	@Then("the user should see the CEO name as  {string}")
	public void the_user_should_see_the_ceo_name_as(String expectedName) {


		try {

			String actualName = DirectoryPage.getdirectoryInstance().getPersonName();

			if(actualName.equals(expectedName)) {

				LOGGER.info("the user should see the CEO name as John Smith");

			}

		} catch (Exception e) {
			LOGGER.error(e);
			//CommonUtils.getInstance().takeScreenshot();
			Assert.fail(e.getMessage());
		}


	}


}
