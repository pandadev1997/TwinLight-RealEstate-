package com.RealState.twinlight.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListOfApartmentDetailsPage {

	@FindBy(xpath="//a[.='Edit']")
	private WebElement editBtn;
	
	@FindBy(xpath="//a[.='Complaint']")
	WebElement complainBtn;
	
	@FindBy(xpath="//p") private List<WebElement> editFields;
	
	@FindBy(xpath="//div[@class='card card-inverse card-info mb-3']/descendant::p[2]") private List<WebElement> mobilefields;
	
	
	
	@FindBy(xpath="//table[@class='table table-bordered']/thead/following-sibling::tbody/tr") private List<WebElement> complaintsfield;
	
	//intialization
	public ListOfApartmentDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public List<WebElement> getEditFields() {
		return editFields;
	}

	public List<WebElement> getMobilefields() {
		return mobilefields;
	}

	public List<WebElement> getComplaintsfield() {
		return complaintsfield;
	}
	public WebElement getEditBtn() {
		return editBtn;
	}
	public WebElement getComplainBtn() {
		return complainBtn;
	}
	
	
}
