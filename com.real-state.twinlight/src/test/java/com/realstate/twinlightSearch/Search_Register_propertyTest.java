package com.realstate.twinlightSearch;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.RealState.twinlight.objectRepository.Dashboard_user_RegPage;
import com.RealState.twinlight.objectRepository.HomePage;
import com.RealState.twinlight.objectRepository.LoginPage;
import com.RealState.twinlight.objectRepository.RegisterPage;
import com.RealState.twinlight.objectRepository.SearchPage;
import com.RealState.twinlight.objectRepository.IndividualHomeRegpage;
import com.RealState.twinlight.objectRepository.ListOfSearchDetails;

import io.github.bonigarcia.wdm.WebDriverManager;
import twinlight.GenericUtility.BaseClass;
import twinlight.GenericUtility.ExcelFileUtility;
import twinlight.GenericUtility.JavaUtility;
import twinlight.GenericUtility.PropertyFileUtility;
import twinlight.GenericUtility.WebdriverUtility;

public class Search_Register_propertyTest extends BaseClass {

	@Test(retryAnalyzer = twinlight.GenericUtility.IRetryanalyserImplementation.class,alwaysRun = true)
	public void searchTheRegisterProperty() throws Throwable {

		// generate random number
		int randomNO = jutil.getRandomNumber();

		String firstname = eutil.fetch_data_from_excel("UserPropertyRegpage", 1, 1) + randomNO;
		String mobile = eutil.fetch_data_from_excel("UserPropertyRegpage", 2, 1) + randomNO;
		String alternate_mobile = eutil.fetch_data_from_excel("UserPropertyRegpage", 3, 1) + randomNO;
		String email = randomNO+eutil.fetch_data_from_excel("UserPropertyRegpage", 4, 1);
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
		String URL = driver.getCurrentUrl();
		Assert.assertTrue(URL.contains("House"),"home is displaying");
		// click on register link and register a propertty
		Reporter.log("user registered sucessfully",true);
		HomePage homepage = new HomePage(driver);
		String homeurl = driver.getCurrentUrl();
		Assert.assertTrue(homeurl.contains("House"));
		System.out.println("home page is displaying");
		String path1 = ".\\src\\test\\resources\\File.txt";
		IndividualHomeRegpage individualhomepage = new IndividualHomeRegpage(driver);
		Dashboard_user_RegPage dashboarduserregpage = new Dashboard_user_RegPage(driver);
		dashboarduserregpage.getRegisterBt().click();
		individualhomepage.registerThePropertyInRegister(firstname, mobile, alternate_mobile, email, plot_Number,
				Available_room, country, state, city, rent, deposit, landmark, Address, dropdownValue, path1, wutil);

		IndividualHomeRegpage individualhomepage1 = new IndividualHomeRegpage(driver);
		individualhomepage1.logout();
		Reporter.log("property got registered",true);
		// click on search module
		homepage.getSearchBtn().click();
		SearchPage searchpage = new SearchPage(driver);
		searchpage.searchRegProperty(Available_room, city);

		// String ss = wutil.takesScreenshot(driver, "searchpage12");
		
		String mob_no="",abcd=null;
		
		ListOfSearchDetails searchlist=new ListOfSearchDetails(driver);
		List<WebElement> id = searchlist.getSearchlist();
		
		for (int i = 0; i < id.size(); i++) {
			mob_no = id.get(i).getText();
			if(mob_no.contains(mobile)) {
				abcd=mob_no;
				break;
			}

		 
		}
		
		Assert.assertTrue(abcd.contains(mobile));
		System.out.println("property register");
		
		
		
		Reporter.log("test script pass",true);
	}

}
