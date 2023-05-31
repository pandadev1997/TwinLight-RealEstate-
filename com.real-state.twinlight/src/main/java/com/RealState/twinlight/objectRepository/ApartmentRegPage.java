package com.RealState.twinlight.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import twinlight.GenericUtility.WebdriverUtility;

public class ApartmentRegPage {
	
	@FindBy(xpath="//a[.='Apartment Registration']")
	private WebElement apartmentRegBtn;
	
	@FindBy(id="apartment_name")
	private WebElement apartmentnameApartmentTxt;
	
	@FindBy(xpath="//h2[.='Apartment Room']/parent::div[@class='alert alert-info']/descendant::input[@id='mobile']")
	private WebElement mobileApartmentTxt;
	
	@FindBy(xpath="//h2[.='Apartment Room']/parent::div[@class='alert alert-info']/descendant::input[@id='alternat_mobile']")
	private WebElement alternateApartmentTxt;
	
	@FindBy(xpath="//h2[.='Apartment Room']/parent::div[@class='alert alert-info']/descendant::input[@id='email']")
	private WebElement emailApartmentTxt;
	
	@FindBy(xpath="//h2[.='Apartment Room']/parent::div[@class='alert alert-info']/descendant::input[@id='plot_number']")
	private WebElement plotnumberinApartmentTxt;

	@FindBy(xpath="//h2[.='Apartment Room']/parent::div[@class='alert alert-info']/descendant::input[@id='country']")
	private WebElement countryApartmentTxt;
	
	@FindBy(xpath="//h2[.='Apartment Room']/parent::div[@class='alert alert-info']/descendant::input[@id='state']")
	private WebElement stateApartmentTxt;
	
	@FindBy(xpath="//h2[.='Apartment Room']/parent::div[@class='alert alert-info']/descendant::input[@id='city']")
	private WebElement cityApartmentTxt;
	
	@FindBy(xpath="//h2[.='Apartment Room']/parent::div[@class='alert alert-info']/descendant::input[@id='landmark']")
	private WebElement landmarkApartmentTxt;
	
	@FindBy(xpath="//h2[.='Apartment Room']/parent::div[@class='alert alert-info']/descendant::input[@id='address']")
	private WebElement addressApartmentTxt;
	
	@FindBy(xpath="//h2[.='Apartment Room']/parent::div[@class='alert alert-info']/descendant::input[@type='file']")
	private WebElement fileuploadApartmentTxt;
	
	@FindBy(xpath="//a[.='Add More(Plat Number/Description)']")
	private WebElement addApartmentBtn;
	
	@FindBy(xpath="//h2[.='Apartment Room']/parent::div[@class='alert alert-info']/descendant::input[@id='fullname']")
	private WebElement fullnameApartmentTxt;
	
	@FindBy(xpath="//h2[.='Apartment Room']/parent::div[@class='alert alert-info']/descendant::input[@id='ap_number_of_plats']")
	private WebElement flatNumberApartmentTxt;
	
	@FindBy(xpath="//h2[.='Apartment Room']/parent::div[@class='alert alert-info']/descendant::input[@id='rooms']")
	private WebElement roomsApartmentTxt;
	
	@FindBy(xpath="//h2[.='Apartment Room']/parent::div[@class='alert alert-info']/descendant::input[@id='area']")
	private WebElement areaApartmentTxt;
	
	@FindBy(xpath="//h2[.='Apartment Room']/parent::div[@class='alert alert-info']/descendant::input[@id='rent']")
	private WebElement rentApartmentTxt;
	
	@FindBy(xpath="//h2[.='Apartment Room']/parent::div[@class='alert alert-info']/descendant::input[@id='accommodation']")
	private WebElement facilityApartmentTxt;
	
	@FindBy(xpath="//h2[.='Apartment Room']/parent::div[@class='alert alert-info']/descendant::input[@id='description']")
	private WebElement descriptionApartmentTxt;
	
	@FindBy(xpath="//h2[.='Apartment Room']/parent::div[@class='alert alert-info']/descendant::button[.='Submit']")
	private WebElement clicksubmitApartmentBtn;
	
	@FindBy(xpath="//select[@id='purpose']")
	private WebElement purposeDropDown;
	
	@FindBy(xpath="//select[@id='floor']")
	private WebElement floorDropdown;
	
	@FindBy(xpath="//select[@id='ownership']")
	private WebElement rentedDropdown;
	
	//intialization
	
		public ApartmentRegPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}

	public WebElement getPurposeDropDown() {
		return purposeDropDown;
	}

	public WebElement getFloorDropdown() {
		return floorDropdown;
	}

	public WebElement getRentedDropdown() {
		return rentedDropdown;
	}

	public WebElement getApartmentRegBtn() {
		return apartmentRegBtn;
	}

	public WebElement getApartmentnameApartmentTxt() {
		return apartmentnameApartmentTxt;
	}

	public WebElement getMobileApartmentTxt() {
		return mobileApartmentTxt;
	}

	public WebElement getAlternateApartmentTxt() {
		return alternateApartmentTxt;
	}

	public WebElement getEmailApartmentTxt() {
		return emailApartmentTxt;
	}

	public WebElement getPlotnumberinApartmentTxt() {
		return plotnumberinApartmentTxt;
	}

	public WebElement getCountryApartmentTxt() {
		return countryApartmentTxt;
	}

	public WebElement getStateApartmentTxt() {
		return stateApartmentTxt;
	}

	public WebElement getCityApartmentTxt() {
		return cityApartmentTxt;
	}

	public WebElement getLandmarkApartmentTxt() {
		return landmarkApartmentTxt;
	}

	public WebElement getAddressApartmentTxt() {
		return addressApartmentTxt;
	}

	public WebElement getFileuploadApartmentTxt() {
		return fileuploadApartmentTxt;
	}

	public WebElement getAddApartmentBtn() {
		return addApartmentBtn;
	}

	public WebElement getFullnameApartmentTxt() {
		return fullnameApartmentTxt;
	}

	public WebElement getFlatNumberApartmentTxt() {
		return flatNumberApartmentTxt;
	}

	public WebElement getRoomsApartmentTxt() {
		return roomsApartmentTxt;
	}

	public WebElement getAreaApartmentTxt() {
		return areaApartmentTxt;
	}

	public WebElement getRentApartmentTxt() {
		return rentApartmentTxt;
	}

	public WebElement getFacilityApartmentTxt() {
		return facilityApartmentTxt;
	}

	public WebElement getDescriptionApartmentTxt() {
		return descriptionApartmentTxt;
	}

	public WebElement getClickApartmentBtn() {
		return clicksubmitApartmentBtn;
	}
	
	public void file(WebdriverUtility wutil,String path1) {
		wutil.fileUpload(fileuploadApartmentTxt, path1);
	}

	public void purposeDropDown(WebdriverUtility wutil,String option) {
		purposeDropDown.click();
		wutil.selectDropDownValueUsingVisibleText(purposeDropDown, option);
	}

	public void floorDropDown(WebdriverUtility wutil,String text) {
		floorDropdown.click();
		wutil.selectDropDownValueUsingVisibleText(floorDropdown, text);
	}
	
	public void rentedDropDown(WebdriverUtility wutil,String value) {
		rentedDropdown.click();
		wutil.selectDropDownValueUsingVisibleText(rentedDropdown, value);
	}











}
