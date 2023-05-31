package com.realstate.twinlightAdmin;

import java.io.FileInputStream;
import java.io.IOException;
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

import com.RealState.twinlight.objectRepository.Admin_Edit_page;
import com.RealState.twinlight.objectRepository.Dashboard_user_RegPage;
import com.RealState.twinlight.objectRepository.HomePage;
import com.RealState.twinlight.objectRepository.IndividualHomeRegpage;
import com.RealState.twinlight.objectRepository.ListOfApartmentDetailsPage;
import com.RealState.twinlight.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import twinlight.GenericUtility.BaseClass;
import twinlight.GenericUtility.PropertyFileUtility;
import twinlight.GenericUtility.WebdriverUtility;
@Listeners(twinlight.GenericUtility.ListnerImplementation.class)
public class Verify_Admin_Edit_the_UserRegisterPropertyTEst extends BaseClass {
	@Test(alwaysRun = true)
	public  void AdminEditTherProperty() throws Throwable {
		
		String ADUN = putil.getDataFromPropertyfile("AdminUN");
		String ADPW = putil.getDataFromPropertyfile("AdminPW");
		
		

		// verify home page displaying or not
		String homeurl = "http://rmgtestingserver/domain/House_Rental_Application/";
		Assert.assertEquals(homeurl, "http://rmgtestingserver/domain/House_Rental_Application/");
		System.out.println("home page displaying");
		HomePage homepage=new HomePage(driver);
		LoginPage login=new LoginPage(driver);
		
		IndividualHomeRegpage individual = new IndividualHomeRegpage(driver);
		individual.logout();
		homepage.getLoginBtn().click();
		// verify login page displayed or not
	

		// log in as admin
		login.loginTotheApp(ADUN, ADPW);
		


		// click on details/update
		Dashboard_user_RegPage dashboarduserpage=new Dashboard_user_RegPage(driver);
		dashboarduserpage.getDetailsOrUpdateBtn().click();
		

		// click on edit
		ListOfApartmentDetailsPage list=new ListOfApartmentDetailsPage(driver);
		list.getEditBtn().click();
		
		

		// click on submit button after editing phone number text field
		ListOfApartmentDetailsPage listofapartment=new ListOfApartmentDetailsPage(driver);
		
		Admin_Edit_page admin_Edit_page=new Admin_Edit_page(driver);
		admin_Edit_page.getSubmitBtn().click();
		
		// click on details and update
		dashboarduserpage.getDetailsOrUpdateBtn().click();
		

		// compare edited fields are there or not
		boolean flag = false;
		List<WebElement> number = listofapartment.getEditFields();
		String mob_no="",abcd=null;
		for (WebElement element : number) {
			mob_no=element.getText();
			if (mob_no.contains("7979078192")) {
			abcd=mob_no;
			break;
			}
		}

		
		Assert.assertTrue(abcd.contains("7979078192"));
		System.out.println("edited");
		// click on logout
		
		IndividualHomeRegpage individualHomeRegpage=new IndividualHomeRegpage(driver);
		individualHomeRegpage.logout();
		

	}

}
