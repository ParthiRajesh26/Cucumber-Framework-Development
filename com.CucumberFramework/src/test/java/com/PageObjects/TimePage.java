package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TimePage {
	
	
	private static TimePage  timepageInstance;
	
	
	private TimePage() {
		
	}
	
	
	public static  TimePage getTimePageInstance() {
		
		if(timepageInstance==null) {
			
			timepageInstance=new TimePage();
		}
		
		return timepageInstance;
		
		
	}
	
	
	
	@FindBy(linkText = "Time")
	private WebElement TIME;
	
	@FindBy(id="employee")
	private WebElement EMPLOYEE_NAME;
	
	
	@FindBy(id="btnView")
	private WebElement VIEW_BUTTON;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div/div[1]")
	private WebElement MESSAGE;   
	
	
	
	
	
	
	
	public void clickTime() {
		
		TIME.click();
		
	}
	
	
	public void getEmployee(String name) {
		
		EMPLOYEE_NAME.clear();
		
		EMPLOYEE_NAME.sendKeys(name);
		
	}
	
	
	public void viewButton() {
		
		VIEW_BUTTON.click();
		
	}
	
	
	public String getmessage() {
		
		return  MESSAGE.getText();
		
	}

}



