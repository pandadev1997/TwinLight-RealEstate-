package twinlight.GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.RealState.twinlight.objectRepository.HomePage;
import com.RealState.twinlight.objectRepository.IndividualHomeRegpage;
import com.RealState.twinlight.objectRepository.LoginPage;
import com.RealState.twinlight.objectRepository.RegisterPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public Databsase_Utility dutil = new Databsase_Utility();
	public ExcelFileUtility eutil = new ExcelFileUtility();
	public PropertyFileUtility putil = new PropertyFileUtility();
	public WebdriverUtility wutil = new WebdriverUtility();
	public JavaUtility jutil = new JavaUtility();
	public static WebDriver sdriver;
	public  WebDriver driver;

	/**
	 * This methhod help us to make DB connection
	 * 
	 * @throws Throwable
	 */
	@BeforeSuite(groups = {"smoke","regression"},alwaysRun = true)
	public void dbConn() throws Throwable {
		dutil.dbConnection();

		System.out.println("--Data base connection");
	}

	/**
	 * This method help us to launch the browser
	 * 
	 * @throws Throwable
	 */
	//@Parameters("browser")
	@BeforeClass(groups = {"smoke","regression"})
	//@BeforeTest(alwaysRun = true)
	public void launchBrowser() throws Throwable {
		String BROWSER = putil.getDataFromPropertyfile("browser");
		String URL = putil.getDataFromPropertyfile("url");
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}  if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
//		} else {
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
//		}
		sdriver=driver;//for listner
		wutil.maximizepage(driver);
		wutil.waitThePage(driver);
		driver.get(URL);
	}

	/**
	 * this method help us to login to the app as admin
	 * 
	 * @throws Throwable
	 */
	@BeforeMethod(groups = {"smoke","regression"},alwaysRun = true)
	public void logintoAppAsAdmin() throws Throwable {
		// fetch the userdata from excel sheet
		String name = eutil.fetch_data_from_excel("UserPropertyRegpage", 2, 10);
		String username = eutil.fetch_data_from_excel("UserPropertyRegpage", 3, 10) + jutil.getRandomNumber();
		String mobileno = eutil.fetch_data_from_excel("UserPropertyRegpage", 4, 10) + jutil.getRandomNumber();
		String email_id = jutil.getRandomNumber()+eutil.fetch_data_from_excel("UserPropertyRegpage", 5, 10);
		String password = eutil.fetch_data_from_excel("UserPropertyRegpage", 6, 10);
		String confrmpassword = eutil.fetch_data_from_excel("UserPropertyRegpage", 7, 10);
		String UN = putil.getDataFromPropertyfile("username");
		String PW = putil.getDataFromPropertyfile("password");
		HomePage homepage = new HomePage(driver);
		homepage.getRegisterBtn().click();

		RegisterPage registerpage = new RegisterPage(driver);
		registerpage.registerUserToTheApp(name, username, mobileno, email_id, password, confrmpassword);

		// Click on login module and log in as user
		homepage.getLoginBtn().click();

		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginTotheApp(UN, PW);

		System.out.println("login to the app  ");

	}

	/**
	 * This method help us to logout from the app
	 */
	@AfterMethod(groups = {"smoke","regression"},alwaysRun = true)
	public void logOutApp() {
		IndividualHomeRegpage individualhomeregpage = new IndividualHomeRegpage(driver);
		// individualhomeregpage.logout();
		System.out.println("logout from the sucessfully");
	}

	/**
	 * This method help us to close the browser
	 */
	@AfterClass(groups = {"smoke","regression"})
	//@AfterTest(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}

	/**
	 * This method will help us to close the db connection
	 * 
	 * @throws Throwable
	 */
	@AfterSuite(groups = {"smoke","regression"},alwaysRun = true)
	public void closeDB() throws Throwable {
		dutil.closeDB();
		System.out.println("database connection close");

	}

}
