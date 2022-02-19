package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DirectoryPage {


	private static DirectoryPage directoryInstance;

	private DirectoryPage() {


	}

	public static DirectoryPage getdirectoryInstance() {

		if(directoryInstance==null) {

			directoryInstance=new DirectoryPage();

		}

		return directoryInstance;


	}




	@FindBy(id="searchDirectory_job_title")
	private WebElement JOB_TITLE;


	@FindBy(id="searchBtn")
	private WebElement SEARCH_BUTTON;

	@FindBy(xpath="//ul/li/b")
	private WebElement CEO_NAME;



	public WebElement getJOB_TITLE() {
		return JOB_TITLE;
	}
	
	//
	//	public WebElement getSEARCH_BUTTON() {
	//		return SEARCH_BUTTON;
	//	}
	//
	//	public WebElement getCEO_NAME() {
	//		return CEO_NAME;
	//	}



	//	public void getJobTitle(String jobTitle) {
	//		
	//		Select select=new Select(JOB_TITLE);
	//		select.selectByVisibleText(jobTitle);
	//		
	//	}


	public void clickSearchButton() {

		SEARCH_BUTTON.click();

	}


	public String getPersonName() {

		return	CEO_NAME.getText();

	}




}
