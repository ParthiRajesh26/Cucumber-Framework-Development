package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {


	private static HomePage homeInstance;

	private HomePage() {


	}

	public static HomePage getHomeInstance() {

		if(homeInstance==null) {

			homeInstance=new HomePage();

		}

		return homeInstance;


	}


	@FindBy(linkText ="Directory" )
	private WebElement Directory;


//	public WebElement getDirectory() {
//		return Directory;
//	}
	
	
	public void getDirectory() {
		
		Directory.click();
		
	}
	
	

}
