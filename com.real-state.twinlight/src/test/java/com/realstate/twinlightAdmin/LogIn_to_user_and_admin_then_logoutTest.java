package com.realstate.twinlightAdmin;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.checkerframework.framework.qual.DefaultQualifier.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.RealState.twinlight.objectRepository.Dashboard_user_RegPage;
import com.RealState.twinlight.objectRepository.HomePage;
import com.RealState.twinlight.objectRepository.IndividualHomeRegpage;
import com.RealState.twinlight.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import twinlight.GenericUtility.BaseClass;
import twinlight.GenericUtility.PropertyFileUtility;
import twinlight.GenericUtility.WebdriverUtility;
@Listeners(twinlight.GenericUtility.ListnerImplementation.class)
public class LogIn_to_user_and_admin_then_logoutTest extends BaseClass {
	@Test(retryAnalyzer = twinlight.GenericUtility.IRetryanalyserImplementation.class,alwaysRun = true)
	public void login_user_admin() throws Throwable {

		String ADUN = putil.getDataFromPropertyfile("AdminUN");
		String ADPW = putil.getDataFromPropertyfile("AdminPW");

		// verify home page displaying or not
		String homeurl = "http://rmgtestingserver/domain/House_Rental_Application/";
		Assert.assertEquals(homeurl, "http://rmgtestingserver/domain/House_Rental_Application/");
		System.out.println("home page displaying");
		HomePage homepage = new HomePage(driver);
		LoginPage login = new LoginPage(driver);

		
		IndividualHomeRegpage individualhomeregpage = new IndividualHomeRegpage(driver);
		individualhomeregpage.logout();

		// click on login module
		homepage.getLoginBtn().click();

		// log in as admin
		login.loginTotheApp(ADUN, ADPW);

		// click on register link
		Dashboard_user_RegPage dashboarduserregpage = new Dashboard_user_RegPage(driver);
		dashboarduserregpage.getRegisterBt().click();

		// logout
		individualhomeregpage.logout();
		// driver.findElement(By.xpath("//a[.='Logout']")).click();

	}

}
