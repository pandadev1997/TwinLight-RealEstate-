package com.realsttate.twinlightUser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.RealState.twinlight.objectRepository.ApartmentRegPage;
import com.RealState.twinlight.objectRepository.Dashboard_user_RegPage;
import com.RealState.twinlight.objectRepository.HomePage;
import com.RealState.twinlight.objectRepository.ListOfApartmentDetailsPage;
import com.RealState.twinlight.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import twinlight.GenericUtility.BaseClass;
import twinlight.GenericUtility.ExcelFileUtility;
import twinlight.GenericUtility.JavaUtility;
import twinlight.GenericUtility.PropertyFileUtility;
import twinlight.GenericUtility.WebdriverUtility;

public class RegisterASUser_Creat_Apartment_Check_InDetailsTest extends BaseClass {
	@Test(groups = "regression",alwaysRun = true)
	public void CheckInDetail() throws Throwable {

		// create a random number
		int randomNO = jutil.getRandomNumber();

		String Apartment_Name = eutil.fetch_data_from_excel("User_Apartment_RegPage", 2, 1);
		String mobile = eutil.fetch_data_from_excel("User_Apartment_RegPage", 3, 1) + randomNO;
		String alternate_mobile = eutil.fetch_data_from_excel("User_Apartment_RegPage", 4, 1) + randomNO;
		String email = randomNO + eutil.fetch_data_from_excel("User_Apartment_RegPage", 5, 1);
		String plot_Number = eutil.fetch_data_from_excel("User_Apartment_RegPage", 6, 1);
		String country = eutil.fetch_data_from_excel("User_Apartment_RegPage", 7, 1);
		String state = eutil.fetch_data_from_excel("User_Apartment_RegPage", 8, 1);
		String city = eutil.fetch_data_from_excel("User_Apartment_RegPage", 9, 1);
		String landmark = eutil.fetch_data_from_excel("User_Apartment_RegPage", 10, 1);
		String Address = eutil.fetch_data_from_excel("User_Apartment_RegPage", 11, 1);
		String Fullname = eutil.fetch_data_from_excel("User_Apartment_RegPage", 12, 1);
		String Flat_Number = eutil.fetch_data_from_excel("User_Apartment_RegPage", 13, 1);
		String Rooms = eutil.fetch_data_from_excel("User_Apartment_RegPage", 14, 1);
		String Area = eutil.fetch_data_from_excel("User_Apartment_RegPage", 15, 1);
		String purpose = eutil.fetch_data_from_excel("User_Apartment_RegPage", 16, 1);
		String rent = eutil.fetch_data_from_excel("User_Apartment_RegPage", 17, 1);
		String deposit = eutil.fetch_data_from_excel("User_Apartment_RegPage", 18, 1);
		String facility = eutil.fetch_data_from_excel("User_Apartment_RegPage", 19, 1);
		String description = eutil.fetch_data_from_excel("User_Apartment_RegPage", 20, 1);

		// verify home page displaying or not
		String homeurl = driver.getCurrentUrl();
		Assert.assertTrue(homeurl.contains("House"));
		System.out.println("home page displaying");

		// click on login module
		HomePage homepage = new HomePage(driver);
		// homepage.getLoginBtn().click();

		// verify login page displayed or not
		// String loginurl = driver.getCurrentUrl();

		// Assert.assertTrue(loginurl.contains("login"));
		Reporter.log("Logged to the app", true);
		// click on register link

		Dashboard_user_RegPage dashboardu = new Dashboard_user_RegPage(driver);
		dashboardu.getRegisterBt().click();

		ApartmentRegPage apartmentRegPage = new ApartmentRegPage(driver);
		// click on apartment registration
		apartmentRegPage.getApartmentRegBtn().click();

		// Enter apartment name in text field
		apartmentRegPage.getApartmentnameApartmentTxt().sendKeys(Apartment_Name);

		// Enter mobile number
		apartmentRegPage.getMobileApartmentTxt().sendKeys(mobile);

		// Enter alternate mobile no in the text field
		apartmentRegPage.getAlternateApartmentTxt().sendKeys(alternate_mobile);

		// Enter email id in the text field
		apartmentRegPage.getEmailApartmentTxt().sendKeys(email);

		// Enter plot no in the text field
		apartmentRegPage.getPlotnumberinApartmentTxt().sendKeys(plot_Number);

		// enter counttry name in the text field
		apartmentRegPage.getCountryApartmentTxt().sendKeys(country);

		// Entter state name in the text field
		apartmentRegPage.getStateApartmentTxt().sendKeys(state);

		// Enter the city name
		apartmentRegPage.getCityApartmentTxt().sendKeys(city);

		// Enter landmark
		apartmentRegPage.getLandmarkApartmentTxt().sendKeys(landmark);

		// Enter address in the text field
		apartmentRegPage.getAddressApartmentTxt().sendKeys(Address);

		String path = ".\\src\\test\\resources\\File.txt";
		apartmentRegPage.file(wutil, path);

		// click on add
		apartmentRegPage.getAddApartmentBtn().click();

		// click on full name
		apartmentRegPage.getFullnameApartmentTxt().sendKeys(Fullname);

		// click on flat number
		apartmentRegPage.getFlatNumberApartmentTxt().sendKeys(Flat_Number);

		// Enter rooms
		apartmentRegPage.getRoomsApartmentTxt().sendKeys(Rooms);

		// Enter area
		apartmentRegPage.getAreaApartmentTxt().sendKeys(Area);

		// Enter rentt
		apartmentRegPage.getRentApartmentTxt().sendKeys(rent);

		// Entter facility
		apartmentRegPage.getFacilityApartmentTxt().sendKeys(facility);

		// Enter description
		apartmentRegPage.getDescriptionApartmentTxt().sendKeys(description);

		// click on submit
		apartmentRegPage.getClickApartmentBtn().click();
		Reporter.log("Apartment registered into the app", true);
		String msg = driver.findElement(By.xpath("(//div[.='Registration successfull. Thank you'])[1]")).getText();
		Assert.assertTrue(msg.contains("success"));
		System.out.println("pass");
		// click on details/update
		dashboardu.getDetailsOrUpdateBtn().click();

		// verify register apartment there or not

		ListOfApartmentDetailsPage listofaptmnt = new ListOfApartmentDetailsPage(driver);
		List<WebElement> Allroomnumber = listofaptmnt.getMobilefields();
		String mobile_no = "", abcd = null;
		for (WebElement Element : Allroomnumber) {
			mobile_no = Element.getText();

			if (mobile_no.contains(mobile)) {
				abcd = mobile_no;
				break;
			}
		}

		Assert.assertTrue(abcd.contains(mobile));
		System.out.println("apartment present");
		// mobile_no=Element.getText();

		Reporter.log("test script pass", true);
	}

}
