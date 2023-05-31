package twinlight.GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consist of all webdriver methods
 * @author debas
 *
 */
public class WebdriverUtility {
	/**
	 * This method help us to maximize the webpage
	 * @param driver
	 */
	public void maximizepage(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * This method help us to minimize the webpage
	 * @param driver
	 */
	public void minimizepage(WebDriver driver) {
		driver.manage().window().minimize();
	}
	/**
	 * This method wait the webpage for some time 
	 * @param driver
	 */
	public void waitThePage(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IpathConstant.implicitwaitDuration));
		
	}
	/**
	 * This method will wait the webpage for 10 sec until the webelement get visible
	 * @param driver
	 * @param element
	 */
	public void visibilityOfElement(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(IpathConstant.ExplicitwaitDuration));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will wait the webpage for maximum 10sec until the element get click
	 * @param driver
	 * @param element
	 */
	public void elementToBeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(IpathConstant.ExplicitwaitDuration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method will wait the webpage if alert is present
	 * @param driver
	 */
	public void alertPresent(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(IpathConstant.ExplicitwaitDuration));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	/**
	 * This method will wait for maximum 10second to display the title
	 * @param driver
	 * @param title
	 */
	public void waitForTitle(WebDriver driver,String title) {
		WebDriverWait wait=new  WebDriverWait(driver, Duration.ofSeconds(IpathConstant.ExplicitwaitDuration));
		wait.until(ExpectedConditions.titleContains(title));
	}
	/**
	 * This method will wait the webpage for maximum 10sec to display the webpage url
	 * @param driver
	 * @param url
	 */
	public void waitForURL(WebDriver driver,String url) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(IpathConstant.ExplicitwaitDuration));
		wait.until(ExpectedConditions.urlContains(url));
	}
	/** 
	 * This method will help us to wait the webpage for maximum 10sec to ignore NoSuchException
	 * @param driver
	 */
	public void ignoreNoSuchElementException(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(IpathConstant.ExplicitwaitDuration));
		wait.ignoring(NoSuchElementException.class);
	}
	/**
	 * This method select the dropdown option using index
	 * @param element
	 * @param index
	 */
	public void selectElementInDropDownUsingIndex(WebElement element,int index) {
		Select se=new Select(element);
		se.selectByIndex(index);
	}
	/**
	 * 
	 * This method will help us to select the dropdown option using value
	 * @param element
	 * @param value
	 */
	public void selectDropDownValueUsingValue(WebElement element,String value) {
		Select se=new Select(element);
		se.selectByValue(value);
	}
	/**
	 * This method will help us to select the dropdown option using visible text
	 * @param element
	 * @param text
	 */
	public void selectDropDownValueUsingVisibleText(WebElement element,String text) {
		Select se=new Select(element);
		se.selectByVisibleText(text);
	}
	/**
	 * This method help us to fetch all the options from the dropdown
	 * @param element
	 */
	public void getAllDropDownOptions(WebElement element) {
		Select se=new Select(element);
		List<WebElement> options = se.getOptions();
		for (WebElement opt : options) {
			String data = opt.getText();
			System.out.println(data);
			
		}
	}
	
	/**
	 * This method will help us to move our mouse cursur to porticular element
	 * @param driver
	 * @param element
	 */
		public void mouseHoverToElement(WebDriver driver,WebElement element) {
			Actions act=new Actions(driver);
			act.moveToElement(element).perform();
			
		
	}
		
		/**
		 * This method will perform right click operation on porticular element
		 * @param driver
		 * @param element
		 */
		public void rightclickOnElement(WebDriver driver,WebElement element) {
			Actions act=new Actions(driver);
			act.contextClick(element).perform();
		}
	/**
	 * This method will help us to perform double clciking operation on element
	 * @param driver
	 * @param elelmnt
	 */
		public void doubleClcikOnElement(WebDriver driver,WebElement elelmnt) {
			Actions act=new  Actions(driver);
			act.doubleClick(elelmnt).perform();
		}
		/**
		 * This method will help us to perform drag and drop operation 
		 * @param driver
		 * @param src
		 * @param dest
		 */
		public void dragAndDrop(WebDriver driver,WebElement src,WebElement dest) {
			Actions act=new Actions(driver);
			act.dragAndDrop(src, dest).perform();
		}
		/**
		 * This method will help us to switch into frame using index
		 * @param driver
		 * @param index
		 */
		public void switchFrameUsingIndex(WebDriver driver,int index) {
			driver.switchTo().frame(index);
		}
		/**
		 * This method will help us to switch into frame using id
		 * @param driver
		 * @param id
		 */
		public void switchFrameusingId(WebDriver driver,String id) {
			driver.switchTo().frame(id);
		}
		/**
		 * This method will help us to switch into frame using element
		 * @param driver
		 * @param element
		 */
		public void switchframeusingElement(WebDriver driver,WebElement element) {
			driver.switchTo().frame(element);
		}
		/**
		 * THis method will help us to return to main frmae
		 * @param driver
		 */
		public void switchToMainFrame(WebDriver driver) {
			driver.switchTo().defaultContent();
		}
		/**
		 * This method will help us to perform yes operation on alert popup
		 * @param driver
		 * @param text
		 */
		public void switchToAlertPopupA(WebDriver driver,String text) {
			Alert alt = driver.switchTo().alert();
			if(alt.getText().trim().equalsIgnoreCase(text.trim())) {
				System.out.println("alert is present");
			}
			else
				System.out.println("alert is not present");
			
			alt.accept();
		}
		/**
		 * This method will help us to perform no operation on alert popup
		 * @param driver
		 * @param text
		 */
		public void switchToAlertPopD(WebDriver driver,String text) {
			Alert alt = driver.switchTo().alert();
			if(alt.getText().trim().equalsIgnoreCase(text.trim())) {
				System.out.println("alert is present");
			}
			else
				System.out.println("alert is not present");
			
			alt.dismiss();
		}
		/**
		 * This method will help us for uploading a file
		 * @param element
		 * @param path
		 */
		public void fileUpload(WebElement element,String path) {
			File f = new File(".\\src\\test\\resources\\File.txt");
			String cpath = f.getAbsolutePath();
			element.sendKeys(cpath);
		}
		/**
		 * This method will help us to wait according to our own choice
		 * @param duration
		 * @param element
		 * @param pollingTime
		 */
		public void customWait(int duration,WebElement element,long pollingTime) {
			int count=0;
			while(count<duration) {
				try {
					element.click();
					break;
					
				} catch (Exception e) {
					try {
						Thread.sleep(pollingTime);
					} catch (InterruptedException e2) {
						e2.printStackTrace();
					}
					count++;
				}
			}
		}
		/**
		 * This method will help us to take the screenshot on the webpage
		 * @param driver
		 * @param screenshotName
		 * @return
		 * @throws Throwable 
		 * @throws Throwable
		 */
		public String takesScreenshot(WebDriver driver,String screenshotName) throws Throwable{
			TakesScreenshot ts=(TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			LocalDateTime localtime = LocalDateTime.now();
			File dest=new File("./ScreenShot/"+screenshotName+".png");
			Files.copy(src, dest);
			return screenshotName;
		}
		/**
		 * This method will help us to take the screenshot on porticular element
		 * @param element
		 * @param screenshotName
		 * @return
		 * @throws Throwable
		 */
		public String takesScreenshot(WebElement element,String screenshotName) throws Throwable {
			TakesScreenshot ts=(TakesScreenshot) element;
			File src = ts.getScreenshotAs(OutputType.FILE);
			LocalDateTime localtime = LocalDateTime.now();
			String dateTime=localtime.toString().replace(" ", "_").replace(":", "-");
			File dest=new File("./ScreenShot/"+screenshotName+" "+dateTime+".png");
			Files.copy(src, dest);
			return screenshotName;
		}
		/**
		 * This method will help us to switch the window using title
		 * @param driver
		 * @param partialTitle
		 */
		public void switchWindowUsingTitle(WebDriver driver,String partialTitle) {
			Set<String> childids = driver.getWindowHandles();
			for (String allids : childids) {
				String currentTitle = driver.switchTo().window(allids).getTitle();
				if(currentTitle.contains(partialTitle)) {
					break;
				}
			}
		}
	/**
	 * This method will help us to switch window by compairing the title	
	 * @param driver
	 * @param partialURl
	 */
		public void switchWindowUsingURl(WebDriver driver,String partialURl) {
			Set<String> childids = driver.getWindowHandles();
			Iterator<String> itr=childids.iterator();
			while(itr.hasNext()) {
				String winId = itr.next();
				String currentURl = driver.switchTo().window(winId).getCurrentUrl();
				if(currentURl.contains(partialURl)) {
					break;
				}
			}
		}

}
