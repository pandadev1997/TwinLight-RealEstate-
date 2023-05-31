package com.RealState.twinlight.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import twinlight.GenericUtility.WebdriverUtility;

public class IndividualHomeRegpage  {

	@FindBy(id = "fullname")
	private WebElement fullnameTxt;

	@FindBy(id = "mobile")
	private WebElement mobileTxt;

	@FindBy(id = "alternat_mobile")
	private WebElement alternatemobileTxt;

	@FindBy(id = "email")
	private WebElement emailTxt;

	@FindBy(id = "plot_number")
	private WebElement plotnumberTxt;

	@FindBy(id = "rooms")
	private WebElement roomstxt;

	@FindBy(id = "country")
	private WebElement countryTxt;

	@FindBy(id = "state")
	private WebElement stateTxt;

	@FindBy(id = "city")
	private WebElement cityTxt;

	@FindBy(id = "rent")
	private WebElement rentTxt;

	@FindBy(id = "deposit")
	private WebElement depositTxt;

	@FindBy(id = "landmark")
	private WebElement landmarktxt;

	@FindBy(id = "address")
	private WebElement addressTxt;

	@FindBy(xpath = "//select[@id='vacant']")
	private WebElement vacantDropDown;

	@FindBy(xpath = "//h2[.='Register Room']/ancestor::div[@class='col-md-11 col-xs-12 col-sm-12']/descendant::input[@id='image']")
	private WebElement choosefileBtn;

	@FindBy(xpath = "//h2[.='Register Room']/ancestor::div[@class='col-md-11 col-xs-12 col-sm-12']/descendant::button[.='Submit']")
	private WebElement submitBtn;
	
	@FindBy(xpath="//a[.='Logout']")
	private WebElement logoutBtn;
	
	// intialization

	public IndividualHomeRegpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// utilization
	
	public void logout() {
		logoutBtn.click();
	}
	
	public void registerThePropertyInRegister(String fn, String mob, String altmob, String email, String plotno,
			String room, String country, String state, String city, String rent, String deposit, String landmark,
			String add, String text, String path,WebdriverUtility wutil) {
		
		
		fullnameTxt.sendKeys(fn);
		
		mobileTxt.sendKeys(mob);
		
		alternatemobileTxt.sendKeys(altmob);
		
		emailTxt.sendKeys(email);
		
		plotnumberTxt.sendKeys(plotno);
		
		roomstxt.sendKeys(room);
		
		countryTxt.sendKeys(country);
		
		stateTxt.sendKeys(state);
		
		cityTxt.sendKeys(city);
		
		rentTxt.sendKeys(rent);
		
		depositTxt.sendKeys(deposit);
		
		landmarktxt.sendKeys(landmark);
		
		addressTxt.sendKeys(landmark);
		 
		vacantDropDown.click();
		wutil.selectDropDownValueUsingVisibleText(vacantDropDown, text);
		
		wutil.fileUpload(choosefileBtn, path);
		
		submitBtn.click();
		
		//logoutBtn.click();

	}

}
