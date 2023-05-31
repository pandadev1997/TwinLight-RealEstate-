package com.RealState.twinlight.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	@FindBy(id="fullname")
	private WebElement fullnameText;
	@FindBy(id="username")
	private WebElement usernameTxt;
	@FindBy(id="mobile")
	private WebElement mobileTxt;
	@FindBy(id="email")
	private WebElement  emailTxt;
	@FindBy(id="password")
	private WebElement passwordTxt;
	@FindBy(id="c_password")
	private WebElement confirmpasswordTxt;
	@FindBy(xpath="//button[.='Submit']")
	private WebElement submitBtn;
	
	//intialization
	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

		//utilization
	public WebElement getFullnameText() {
		return fullnameText;
	}

	public WebElement getUsernameTxt() {
		return usernameTxt;
	}

	public WebElement getMobileTxt() {
		return mobileTxt;
	}

	public WebElement getEmailTxt() {
		return emailTxt;
	}

	public WebElement getPasswordTxt() {
		return passwordTxt;
	}

	public WebElement getConfirmpasswordTxt() {
		return confirmpasswordTxt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	//Create Generic methods
	public void registerUserToTheApp(String FN,String UN,String mobile,String email,String pw,String cnfpw) {
		fullnameText.sendKeys(FN);
		usernameTxt.sendKeys(UN);
		mobileTxt.sendKeys(mobile);
		emailTxt.sendKeys(email);
		passwordTxt.sendKeys(pw);
		confirmpasswordTxt.sendKeys(cnfpw);
		submitBtn.click();
}
}

