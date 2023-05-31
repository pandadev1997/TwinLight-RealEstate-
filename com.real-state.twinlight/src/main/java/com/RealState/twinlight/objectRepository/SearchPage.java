package com.RealState.twinlight.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	@FindBy(id="keywords")
	private WebElement keywordText;
	@FindBy(id="location")
	private WebElement locationText;
	@FindBy(name="search")
	private WebElement submitBtn;
	
	//intialization
	
	public SearchPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//utilization
	public WebElement getKeywordText() {
		return keywordText;
	}

	public WebElement getLocationText() {
		return locationText;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	public void searchRegProperty(String keyword,String location) {
		keywordText.sendKeys(keyword);
		locationText.sendKeys(location);
		submitBtn.click();
	}
	
}
