package com.RealState.twinlight.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_Edit_page {
	
	//declartion
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submitBtn;
	
	//intialization
	public Admin_Edit_page(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	

}
