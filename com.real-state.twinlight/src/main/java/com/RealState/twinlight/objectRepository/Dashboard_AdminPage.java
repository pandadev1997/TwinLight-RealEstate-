package com.RealState.twinlight.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard_AdminPage {
	
	@FindBy(xpath="//a[.='Complaint List']")
	private WebElement complaintListBtn;
	
	public Dashboard_AdminPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getComplaintListBtn() {
		return complaintListBtn;
	}
	

}
