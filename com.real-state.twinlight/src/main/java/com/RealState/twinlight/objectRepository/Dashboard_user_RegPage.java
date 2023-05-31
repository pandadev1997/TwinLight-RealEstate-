package com.RealState.twinlight.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard_user_RegPage {
	
	@FindBy(xpath = "//a[.='Register']")
	private WebElement registerLink;
	
	@FindBy(xpath="//a[@href='../auth/dashboard.php']")
	private WebElement homeLink;
	
	@FindBy(xpath="//a[.='Details/Update']")
	private WebElement detailsOrUpdateLink;
	
	@FindBy(xpath="//h1[.='Dash board']/parent::div[@class='col-md-12']/descendant::b")
	private WebElement registerRoomBtn;
	
	//intialization
	public Dashboard_user_RegPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getRegisterBt() {
		return registerLink;
	}

	public WebElement getHomeBtn() {
		return homeLink;
	}

	public WebElement getDetailsOrUpdateBtn() {
		return detailsOrUpdateLink;
	}
	public WebElement getRegisterRoomBtn() {
		return registerRoomBtn;
	}
	
	
	
	
}
