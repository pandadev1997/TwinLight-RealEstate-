package com.realstate.twinlightAdmin;

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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.RealState.twinlight.objectRepository.ApartmentRegPage;
import com.RealState.twinlight.objectRepository.Dashboard_AdminPage;
import com.RealState.twinlight.objectRepository.Dashboard_user_RegPage;
import com.RealState.twinlight.objectRepository.HomePage;
import com.RealState.twinlight.objectRepository.IndividualHomeRegpage;
import com.RealState.twinlight.objectRepository.ListOfApartmentDetailsPage;
import com.RealState.twinlight.objectRepository.LoginPage;
import com.RealState.twinlight.objectRepository.UserComplaintsPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import twinlight.GenericUtility.BaseClass;
import twinlight.GenericUtility.ExcelFileUtility;
import twinlight.GenericUtility.JavaUtility;
import twinlight.GenericUtility.PropertyFileUtility;
import twinlight.GenericUtility.WebdriverUtility;
@Listeners(twinlight.GenericUtility.ListnerImplementation.class)
public class Register_apartment_then_register_complaintAndVerifyTest extends BaseClass {
	@Test(retryAnalyzer = twinlight.GenericUtility.IRetryanalyserImplementation.class,alwaysRun = true)
	public void RegAPtThenComplaint() throws Throwable {
		
		int randomNO = jutil.getRandomNumber();
		String ADUN = putil.getDataFromPropertyfile("AdminUN");
		String ADPW = putil.getDataFromPropertyfile("AdminPW");

		String Apartment_Name = eutil.fetch_data_from_excel("User_Apartment_RegPage", 2, 1) + randomNO;
		String mobile = eutil.fetch_data_from_excel("User_Apartment_RegPage", 3, 1) + randomNO;
		String alternate_mobile = eutil.fetch_data_from_excel("User_Apartment_RegPage", 4, 1) + randomNO;
		String email = randomNO+eutil.fetch_data_from_excel("User_Apartment_RegPage", 5, 1);
		String plot_Number = eutil.fetch_data_from_excel("User_Apartment_RegPage", 6, 1) + randomNO;
		String country = eutil.fetch_data_from_excel("User_Apartment_RegPage", 7, 1);
		String state = eutil.fetch_data_from_excel("User_Apartment_RegPage", 8, 1);
		String city = eutil.fetch_data_from_excel("User_Apartment_RegPage", 9, 1);
		String landmark = eutil.fetch_data_from_excel("User_Apartment_RegPage", 10, 1) + randomNO;
		String Address = eutil.fetch_data_from_excel("User_Apartment_RegPage", 11, 1) + randomNO;
		String Fullname = eutil.fetch_data_from_excel("User_Apartment_RegPage", 12, 1);
		String Flat_Number = eutil.fetch_data_from_excel("User_Apartment_RegPage", 13, 1) + randomNO;
		String Rooms = eutil.fetch_data_from_excel("User_Apartment_RegPage", 14, 1);
		String Area = eutil.fetch_data_from_excel("User_Apartment_RegPage", 15, 1) + randomNO;
		String purpose = eutil.fetch_data_from_excel("User_Apartment_RegPage", 16, 1);
		String rent = eutil.fetch_data_from_excel("User_Apartment_RegPage", 17, 1) + randomNO;
		String deposit = eutil.fetch_data_from_excel("User_Apartment_RegPage", 18, 1) + randomNO;
		String facility = eutil.fetch_data_from_excel("User_Apartment_RegPage", 19, 1);
		String description = eutil.fetch_data_from_excel("User_Apartment_RegPage", 20, 1);
		String purposeDrop = eutil.fetch_data_from_excel("User_Apartment_RegPage", 1, 8);
		String floorDrop = eutil.fetch_data_from_excel("User_Apartment_RegPage", 2, 11);
		String ownerorrentDrop = eutil.fetch_data_from_excel("User_Apartment_RegPage", 1, 13);

		

		// verify home page displaying or not
		String homeurl = "http://rmgtestingserver/domain/House_Rental_Application/";
		Assert.assertEquals(homeurl, "http://rmgtestingserver/domain/House_Rental_Application/");
		System.out.println("home page displaying");

		HomePage homepage = new HomePage(driver);
		LoginPage login = new LoginPage(driver);
		
		// verify login page displayed or not
		String loginpage = driver.getCurrentUrl();
		if (loginpage.contains("login.php")) {
			System.out.println("log in page displaying");
		} else
			System.out.println("log in page is not displaying");

		

		// click on register link
		Dashboard_user_RegPage dashboarduserpage = new Dashboard_user_RegPage(driver);
		dashboarduserpage.getRegisterBt().click();
		

		// click on apartment registration
		ApartmentRegPage apartmentRegPage = new ApartmentRegPage(driver);
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

		// click on purpose dropdown
		apartmentRegPage.purposeDropDown(wutil, purposeDrop);

		// click on floor droopdown
		apartmentRegPage.floorDropDown(wutil, floorDrop);

		// click on rented dropdown
		apartmentRegPage.rentedDropDown(wutil, ownerorrentDrop);

		// Enter rentt
		apartmentRegPage.getRentApartmentTxt().sendKeys(rent);

		// Entter facility
		apartmentRegPage.getFacilityApartmentTxt().sendKeys(facility);

		// Enter description
		apartmentRegPage.getDescriptionApartmentTxt().sendKeys(description);

		// click on submit
		apartmentRegPage.getClickApartmentBtn().click();

	

		Dashboard_user_RegPage dashboardu = new Dashboard_user_RegPage(driver);
		// click on details/update
		dashboardu.getDetailsOrUpdateBtn().click();

		
		// verify register apartment there or not
		String mobile_no="",abcd=null;
		List<WebElement> Allroomnumber = driver.findElements(By.xpath("//p"));
		for (WebElement Element : Allroomnumber) {
			mobile_no=Element.getText();
			
		if (mobile_no.contains(mobile)) {
			abcd=mobile_no;
					break;
		}
		}

			Assert.assertTrue(abcd.contains(mobile));
		

		// click on complaint
		ListOfApartmentDetailsPage list = new ListOfApartmentDetailsPage(driver);
		list.getComplainBtn().click();
		
		// Enter room no
		UserComplaintsPage usercomplaint = new UserComplaintsPage(driver);
		usercomplaint.getApartmentnumbettext().sendKeys(Flat_Number);

		// driver.findElement(By.id("name")).sendKeys(Flat_Number);

		// Enter the issue
		usercomplaint.getComplaintText().sendKeys("cleaning issue");

		// driver.findElement(By.id("cmp")).sendKeys("cleaning issue");

		// click on submit button
		usercomplaint.getSubmitBtn().click();
		

		// logout
		IndividualHomeRegpage individual = new IndividualHomeRegpage(driver);
		individual.logout();
		

		// click on login module
		homepage.getLoginBtn().click();

		

		// log in as admin
		login.loginTotheApp(ADUN, ADPW);



		// click on complaint list
		Dashboard_AdminPage dashboardadmin = new Dashboard_AdminPage(driver);
		dashboardadmin.getComplaintListBtn().click();
		
		// verify complaint present or not
		
		ListOfApartmentDetailsPage listofapartment=new ListOfApartmentDetailsPage(driver);
		 List<WebElement> elemnt = listofapartment.getComplaintsfield();
		String plot="",man=null;
		for(WebElement n:elemnt) {
			plot=n.getText();
			if(plot.contains(plot_Number)) {
				man=plot;
			}
		}
		 Assert.assertTrue(man.contains(plot_Number));
		 System.out.println("complaint register");
		 
		 

	}
	}

