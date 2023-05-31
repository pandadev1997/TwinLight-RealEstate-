package com.RealState.twinlight.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserComplaintsPage {
	
	@FindBy(name="name")
	private WebElement apartmentnumbettext;
	
	@FindBy(id="cmp")
	private WebElement complaintText;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submitBtn;
	
	//intialization
	
	public UserComplaintsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getApartmentnumbettext() {
		return apartmentnumbettext;
	}

	public WebElement getComplaintText() {
		return complaintText;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	
	
	

}
