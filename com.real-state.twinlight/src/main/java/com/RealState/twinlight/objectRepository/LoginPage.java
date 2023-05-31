package com.RealState.twinlight.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(id="exampleInputEmail1")
	private WebElement userTextEdt;
	@FindBy(id="exampleInputPassword1")
	private WebElement passwordTextEdt;
	@FindBy(xpath="//button[.='Submit']")
	private WebElement loginBtn;
	
	//intialization
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//utilization
	public WebElement getUserTextEdt() {
		return userTextEdt;
	}

	public WebElement getPasswordTextEdt() {
		return passwordTextEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Create generic method
	
	public void loginTotheApp(String username,String password ) {
		userTextEdt.sendKeys(username);
		passwordTextEdt.sendKeys(password);
		loginBtn.click();
	}

}
