package com.realsttate.twinlightUser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
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
import com.RealState.twinlight.objectRepository.IndividualHomeRegpage;
import com.RealState.twinlight.objectRepository.ListOfApartmentDetailsPage;
import com.RealState.twinlight.objectRepository.LoginPage;
import com.RealState.twinlight.objectRepository.RegisterPage;
import com.RealState.twinlight.objectRepository.UserComplaintsPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import twinlight.GenericUtility.BaseClass;
import twinlight.GenericUtility.ExcelFileUtility;
import twinlight.GenericUtility.JavaUtility;
import twinlight.GenericUtility.PropertyFileUtility;
import twinlight.GenericUtility.WebdriverUtility;

public class Edit_File_complaintTest extends BaseClass {
	@Test(groups = "smoke",alwaysRun = true)
	public void EditThenFileComplaintTest() throws Throwable {

		// create a random number
		int randomNO = jutil.getRandomNumber();

		String firstname = eutil.fetch_data_from_excel("UserPropertyRegpage", 1, 1) + randomNO;
		String mobile = eutil.fetch_data_from_excel("UserPropertyRegpage", 2, 1) + randomNO;
		String alternate_mobile = eutil.fetch_data_from_excel("UserPropertyRegpage", 3, 1) + randomNO;
		String email = eutil.fetch_data_from_excel("UserPropertyRegpage", 4, 1);
		String plot_Number = eutil.fetch_data_from_excel("UserPropertyRegpage", 5, 1) + randomNO;
		String Available_room = eutil.fetch_data_from_excel("UserPropertyRegpage", 6, 1);
		String country = eutil.fetch_data_from_excel("UserPropertyRegpage", 7, 1);
		String state = eutil.fetch_data_from_excel("UserPropertyRegpage", 8, 1);
		String city = eutil.fetch_data_from_excel("UserPropertyRegpage", 9, 1);
		String rent = eutil.fetch_data_from_excel("UserPropertyRegpage", 10, 1) + randomNO;
		String deposit = eutil.fetch_data_from_excel("UserPropertyRegpage", 11, 1) + randomNO;
		String facility = eutil.fetch_data_from_excel("UserPropertyRegpage", 12, 1);
		String description = eutil.fetch_data_from_excel("UserPropertyRegpage", 13, 1);
		String landmark = eutil.fetch_data_from_excel("UserPropertyRegpage", 14, 1) + randomNO;
		String Address = eutil.fetch_data_from_excel("UserPropertyRegpage", 15, 1) + randomNO;
		String dropdownValue = eutil.fetch_data_from_excel("UserPropertyRegpage", 1, 6);
		System.out.println(dropdownValue);

		// verify home page displaying or not
		String homeurl = driver.getCurrentUrl();
		Assert.assertTrue(homeurl.contains("House"));
		System.out.println("home page displaying");
		
		// click on register link
		Dashboard_user_RegPage dashboarduser = new Dashboard_user_RegPage(driver);
		dashboarduser.getRegisterBt().click();

		String path2 = ".\\src\\test\\resources\\File.txt";
		IndividualHomeRegpage individualhomereg = new IndividualHomeRegpage(driver);
		individualhomereg.registerThePropertyInRegister(firstname, mobile, alternate_mobile, email, plot_Number,
				Available_room, country, state, city, rent, deposit, landmark, Address, dropdownValue, path2, wutil);
		Reporter.log("property registred into the app",true);
		// click on home link from left hand nevigation
		dashboarduser.getHomeBtn().click();

		// click on register room link
		dashboarduser.getRegisterRoomBtn().click();

		// click on Edit button
		ListOfApartmentDetailsPage listofapartmentdetails = new ListOfApartmentDetailsPage(driver);
		listofapartmentdetails.getEditBtn().click();

		// Edit on acommodation text field
//		driver.findElement(By.id("accommodation")).sendKeys("yes");

		// Edit description
//		driver.findElement(By.id("description")).sendKeys(description);

		// click on submit
		ApartmentRegPage apt=new ApartmentRegPage(driver);
//		apt.getClickApartmentBtn().click();
		Reporter.log("Apartment registered into the app",true);
		// click on details/update link in left hand navigation
		dashboarduser.getDetailsOrUpdateBtn().click();
		

		// cliick on compalint button
		listofapartmentdetails.getComplainBtn().click();

		// Enter apartment number in the text field
		UserComplaintsPage usercomplaints = new UserComplaintsPage(driver);
		usercomplaints.getApartmentnumbettext().sendKeys(plot_Number);

		// Enter issue in the text field
		usercomplaints.getComplaintText().sendKeys("hotwater issue");

		// click on submit
		usercomplaints.getSubmitBtn().click();
		Reporter.log("filed a complaint sucessfully",true);
		// click on logout
		individualhomereg.logout();
		Reporter.log("Test Script pass",true);

	}

}
