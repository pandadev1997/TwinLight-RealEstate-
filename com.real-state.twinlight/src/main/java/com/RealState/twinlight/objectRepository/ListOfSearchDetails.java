package com.RealState.twinlight.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListOfSearchDetails {
	@FindBy(xpath="//div[@class='card card-inverse card-info mb-3']/descendant::p[2]")
	private List<WebElement> searchlist;
	
	public ListOfSearchDetails(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public List<WebElement> getSearchlist() {
		return searchlist;
	}
	
}
