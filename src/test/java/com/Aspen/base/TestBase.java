package com.Aspen.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.Aspen.utilities.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase {

	/*
	 * WebDriver Properties Logs ExtentReports DB Excel Mail ReportNG,
	 * ExtentReports Jenkins
	 */

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger Log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir")
					+ "\\src\\test\\resources\\excel\\testdata.xlsx");

	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static String browser;

	@BeforeSuite
	public void setUp() {

		if (driver == null) {

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir")
								+ "\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				Log.debug("Config file loaded !!");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				fis = new FileInputStream(System.getProperty("user.dir")
						+ "\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				Log.debug("OR file loaded !!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		if(System.getenv("browser")!=null && !System.getenv("browser").isEmpty()){
			
			browser = System.getenv("browser");
			
		}else{
			
			browser=config.getProperty("browser");
			
		}
		
		config.setProperty("browser", browser);
		
		
		

		if (config.getProperty("browser").equals("firefox")) {
			System.setProperty(
					"webdriver.gecko.driver",
					"C:\\Users\\Jithin\\Downloads\\Aspen Automation\\GeocoDriver\\geckodriver-v0.17.0-win64\\geckodriver.exe");

			driver = new FirefoxDriver();

			// System.setProperty("webdriver.gecko.driver","C:\\Users\\Jithin\\AspenUniversity\\DataDrivenFramework\\src\\test\\resources\\executables\\geckodriver.exe");

			// driver = new FirefoxDriver();

		} else if (config.getProperty("browser").equals("chrome")) {

			System.setProperty(
					"webdriver.chrome.driver",
					"C:\\Users\\Jithin\\AspenUniversity\\DataDrivenFramework\\src\\test\\resources\\executables\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (config.getProperty("browser").equals("ie")) {

			System.setProperty(
					"webdriver.ie.driver",
					"C:\\Users\\Jithin\\AspenUniversity\\DataDrivenFramework\\src\\test\\resources\\executables\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}

		driver.get(config.getProperty("testsiteurl"));
		Log.debug("TestSiteUrl Loading !!" + config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("Implicit Wait")),
		// TimeUnit.SECONDS);

	}

	public boolean isElementPresent(By by) {

		try {

			driver.findElement(by);

			return true;

		} catch (NoSuchElementException e) {

			return false;

		}

	}

	public void clickTest(String locator1) {

		if (locator1.endsWith("_ID")) {

			driver.findElement(By.id(OR.getProperty(locator1))).click();

		} else if (locator1.endsWith("_NAME")) {

			driver.findElement(By.name(OR.getProperty(locator1))).click();

		} else if (locator1.endsWith("_CSS")) {

			driver.findElement(By.cssSelector(OR.getProperty(locator1))).click();

		} else {

			driver.findElement(By.xpath(OR.getProperty(locator1))).click();

		}
		test.log(LogStatus.INFO, "Clicking on : " + locator1);

	}

	static WebElement dropdown;

	public void selectTest(String locator1, String value) {

		if (locator1.endsWith("_ID")) {

			dropdown = driver.findElement(By.id(OR.getProperty(locator1)));

		} else if (locator1.endsWith("_NAME")) {

			driver.findElement(By.name(OR.getProperty(locator1))).click();

		} else if (locator1.endsWith("_CSS")) {

			driver.findElement(By.cssSelector(OR.getProperty(locator1))).click();

		} else {

			driver.findElement(By.xpath(OR.getProperty(locator1))).click();

		}

		Select select = new Select(dropdown);
		select.selectByVisibleText(value);

		test.log(LogStatus.INFO, "Selecting from dropdown : " + locator1
				+ "value as : " + value);

	}

	public void typeTest(String locator1, String value1) {

		if (locator1.endsWith("_ID")) {

			driver.findElement(By.id(OR.getProperty(locator1)))
					.sendKeys(value1);

		} else {

			driver.findElement(By.xpath(OR.getProperty(locator1))).sendKeys(
					value1);

		}

		test.log(LogStatus.INFO, "Typing on: " + locator1
				+ " and entered value as  :" + value1);

	}

	public void clearTest(String locator1) {

		if (locator1.endsWith("_ID")) {

			driver.findElement(By.id(OR.getProperty(locator1))).clear();

		} else {

			driver.findElement(By.id(OR.getProperty(locator1))).clear();

		}

		test.log(LogStatus.INFO, "Clearing on : " + locator1);

	}

	public static void verifyEquals(String Expected, String Actual)
			throws IOException {

		try {

			Assert.assertEquals(Actual, Expected);

		} catch (Throwable t) {

			TestUtil.captureScreenshot();
			// ReportNG
			Reporter.log("<br>" + "Verification Failure : " + t.getMessage()
					+ "<br>");
			Reporter.log("<br>");
			Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName
					+ "><img src=" + TestUtil.screenshotName
					+ " height=200 width=200></img></a>");
			Reporter.log("<br>");
			Reporter.log("<br>");

			// Extent Reports
			test.log(LogStatus.FAIL,
					"Verification FAILED with exception:" + t.getMessage());
			test.log(LogStatus.FAIL,
					test.addScreenCapture(TestUtil.screenshotName));

		}

	}

	/*
	 * @AfterSuite public void tearDown() {
	 * 
	 * if (driver != null) {
	 * 
	 * driver.quit();
	 * 
	 * Log.debug("Application Quit  !!");
	 * 
	 * }
	 * 
	 * }
	 */
}
