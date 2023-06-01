package com.realstate.twinlightAdmin;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
import twinlight.GenericUtility.PropertyFileUtility;
import twinlight.GenericUtility.WebdriverUtility;
@Listeners(twinlight.GenericUtility.ListnerImplementation.class)
public class Admin_register_complaintTest extends BaseClass {
	@Test(retryAnalyzer = twinlight.GenericUtility.IRetryanalyserImplementation.class,alwaysRun = true)
	public void AdminFileComplaint() throws Throwable {
		//we are test Engg
		String ADUN = putil.getDataFromPropertyfile("AdminUN");
		String ADPW = putil.getDataFromPropertyfile("AdminPW");

		// verify home page displaying or not
		String homeurl = "http://rmgtestingserver/domain/House_Rental_Application/";
		Assert.assertEquals(homeurl, "http://rmgtestingserver/domain/House_Rental_Application/");
		System.out.println("home page displaying");
		HomePage homepage = new HomePage(driver);
		LoginPage login = new LoginPage(driver);

		Dashboard_user_RegPage dashboard = new Dashboard_user_RegPage(driver);

		// click on details/update link in left hand navigation
		dashboard.getDetailsOrUpdateBtn().click();

		ListOfApartmentDetailsPage listOfApartmentDetailsPage = new ListOfApartmentDetailsPage(driver);
		// cliick on compalint button
		listOfApartmentDetailsPage.getComplainBtn().click();

		// Enter apartment number in the text field
		UserComplaintsPage userComplaintsPage = new UserComplaintsPage(driver);
		userComplaintsPage.getApartmentnumbettext().sendKeys("81");

		// Enter issue in the text field
		userComplaintsPage.getComplaintText().sendKeys("hot water issue");

		// click on submit
		userComplaintsPage.getSubmitBtn().click();
		//Assert.fail();

		// click on logout
		IndividualHomeRegpage individualHomeRegpage = new IndividualHomeRegpage(driver);
		individualHomeRegpage.logout();

		// click on login module
		homepage.getLoginBtn().click();
		
		// log in as admin
		login.loginTotheApp(ADUN, ADPW);

		// click on complaint list
		Dashboard_AdminPage dashboardAdminpage = new Dashboard_AdminPage(driver);
		dashboardAdminpage.getComplaintListBtn().click();

		// verify register complain there or not
		//String complaintroomno = driver.findElement(By.xpath("//table/tbody/tr[25]/td[1]")).getText();
		ListOfApartmentDetailsPage listofaptment= new ListOfApartmentDetailsPage(driver);
		List<WebElement> complaintroomno = listofaptment.getComplaintsfield();
		String plot="",cde=null;
		for(WebElement ele:complaintroomno) {
			plot=ele.getText();
			if(plot.contains("81")) {
				cde=plot;
				break;
			}
		}
		Assert.assertTrue(cde.contains("81"));
		System.out.println("complaint registeres");
		
		
		//PROJECT UPDATED SUCCESSFULLY
	}

}
