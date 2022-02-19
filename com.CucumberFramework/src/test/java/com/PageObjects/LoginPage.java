package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Utilities.CommonUtils;

public class LoginPage {


	private static LoginPage loginInstance;

	private LoginPage() {


	}

	public static LoginPage getLoginInstance() {

		if(loginInstance==null) {

			loginInstance=new LoginPage();

		}

		return loginInstance;


	}


	@FindBy(id="txtUsername") 
	private WebElement USERNAME;

	@FindBy(id="txtPassword") 
	private WebElement PASSWORD;

	@FindBy(id="btnLogin") 
	private WebElement LOGIN_BUTTON;





	/*
	 * public WebElement getUSERNAME() { return USERNAME; }
	 * 
	 * public WebElement getPASSWORD() { return PASSWORD; }
	 * 
	 * public WebElement getLOGIN_BUTTON() { return LOGIN_BUTTON; }
	 */



	public void enterUserName(String userName) {
		
		CommonUtils.getInstance().highlightWebElements(USERNAME);

		USERNAME.sendKeys(userName);

	}

	public void enterPassword(String password) {
		
		CommonUtils.getInstance().highlightWebElements(PASSWORD);

		PASSWORD.sendKeys(password);

	}



	public void clickLoginButton() {
		
		CommonUtils.getInstance().highlightWebElements(LOGIN_BUTTON);

		LOGIN_BUTTON.click();

	}





}
