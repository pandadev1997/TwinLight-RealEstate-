package com.RealState.twinlight.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(xpath="//a[.='Search']")
	private WebElement searchBtn;
	@FindBy(xpath="//a[.='Register']")
	private WebElement registerBtn;
	@FindBy(xpath="//a[.='Login']")
	private WebElement loginBtn;
	
	//intialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getRegisterBtn() {
		return registerBtn;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//utilization
	
	

}
