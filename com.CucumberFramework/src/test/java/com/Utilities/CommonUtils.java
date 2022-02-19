package com.Utilities;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.PageObjects.DirectoryPage;
import com.PageObjects.HomePage;
import com.PageObjects.LoginPage;
import com.PageObjects.TimePage;
import com.constants.Constants;
import com.webdriver_manager.DriverManager;

public class CommonUtils {
	
	private static final Logger LOGGER=LogManager.getLogger("com.CucumberFramework");


	private static CommonUtils  CommonUtilsInstance=null;


	private CommonUtils() {

	}


	public static CommonUtils getInstance() {

		if(CommonUtilsInstance==null) {

			CommonUtilsInstance=new CommonUtils();
		}
		return CommonUtilsInstance;



	}



	public void loadProperties() {

		Properties properties =new Properties();

		try {

			properties.load(getClass().getResourceAsStream("/config.properties"));

		} catch (Exception e) {
			e.printStackTrace();
		}





		Constants.APP_URL=	properties.getProperty("APP_URL");
		Constants.BROWSER=	properties.getProperty("BROWSER");
		Constants.USERNAME=	properties.getProperty("UserName");
		Constants.PASSWORD=	properties.getProperty("Password");
		Constants.CHROME_DRIVER_LOCATION=	properties.getProperty("CHROME_DRIVER_LOCATION");
		Constants.FIREFOX_DRIVER_LOCATION=	properties.getProperty("FIREFOX_DRIVER_LOCATION");
		Constants.EDGE_DRIVER_LOCATION=	properties.getProperty("EDGE_DRIVER_LOCATION");



	}



	public void initWebElements() {

		PageFactory.initElements(DriverManager.getDriver(), LoginPage.getLoginInstance());
		PageFactory.initElements(DriverManager.getDriver(), HomePage.getHomeInstance());
		PageFactory.initElements(DriverManager.getDriver(), DirectoryPage.getdirectoryInstance());
		PageFactory.initElements(DriverManager.getDriver(), TimePage.getTimePageInstance());

	}




//	public void takeScreenshot() {
//
//
//		File screenshot=((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
//
//
//		try {
//			FileUtils.copyFile(screenshot, new File(Common_Step_Def.getScenarioName()+".png"));
//		} catch (IOException e) {
//			System.out.println(e.getMessage());
//		}
//
//	}

	public void highlightWebElements(WebElement element) {


		JavascriptExecutor executor= (JavascriptExecutor) DriverManager.getDriver();

		executor.executeScript("arguments[0].setAttribute('style','border: 3px solid red');", element);

	}


	public void selectFromDropdown(WebElement dropdown,String howTo, String value) {

		Select select=new Select(dropdown);

		switch (howTo) {
		case "index":

			select.selectByIndex(Integer.parseInt(value));

			break;

		case "text":

			select.selectByVisibleText(value);

			break;

		case "value":

			select.selectByValue(value);

			break;

		default:
			
			LOGGER.info("please select a valid option");
			
			break;
		}

	}

}
