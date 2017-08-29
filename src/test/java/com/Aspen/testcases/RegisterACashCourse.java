package com.Aspen.testcases;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Aspen.base.TestBase;
import com.Aspen.utilities.TestUtil;

public class RegisterACashCourse extends TestBase {
	
	@Test(dataProviderClass=TestUtil.class, dataProvider="dp")
	public void registerACashCourse(Hashtable<String,String> data) throws InterruptedException {
		/*
		driver.findElement(By.id(OR.getProperty("email"))).sendKeys(email);
		driver.findElement(By.id(OR.getProperty("password"))).sendKeys(password);
		driver.findElement(By.xpath(OR.getProperty("Login"))).click();
		Assert.fail("Test fails");
	*/
		/*if(!TestUtil.isTestRunnable("feedback", excel)){
			
			throw new SkipException("Skipping the test "+ "feedback".toUpperCase() + " as the Run mode is NO ");
		}*/

		if(!TestUtil.isTestRunnable("RegisterACashCourse", excel)){
			
			throw new SkipException("Skipping the test "+ "RegisterACashCourse".toUpperCase() + " as the Run mode is NO ");
		}
		
		
		typeTest("email_ID",data.get("email"));
		typeTest("password_ID",data.get("password"));
		clickTest("Login_XPATH");
		Thread.sleep(7000);
		
		System.out.println("Checking for Register Section");
		clickTest("register_XPATH");
		Thread.sleep(5000);
		//clickTest("N508_XPATH");
		
		clickTest("N502_XPATH");
		//selectTest("startDate_XPATH", data.get("startDate"));
		String startDate_XPATH=".//*[@id='243630']/div[2]/div/select";
		Select objSelect= new Select(driver.findElement(By.xpath(startDate_XPATH)));
		
		objSelect.selectByIndex(3);//Select the dropdown value
		
		clickTest("continue_XPATH");
		
		Thread.sleep(2000);
		
		JavascriptExecutor jse11 = (JavascriptExecutor) driver;
	    jse11.executeScript("window.scrollBy(0,600)", "");
	    
	    JavascriptExecutor jse12 = (JavascriptExecutor) driver;
	    jse12.executeScript("window.scrollBy(0,600)", "");
	    
	    JavascriptExecutor jse13 = (JavascriptExecutor) driver;
	    jse13.executeScript("window.scrollBy(0,600)", "");
	    
	    JavascriptExecutor jse14 = (JavascriptExecutor) driver;
	    jse14.executeScript("window.scrollBy(0,600)", "");
	    
	    JavascriptExecutor jse15 = (JavascriptExecutor) driver;
	    jse15.executeScript("window.scrollBy(0,600)", "");
	    
	    clickTest("signature_ID");
	    typeTest("signature_ID",data.get("signature"));
	    clickTest("submit_XPATH");
	    
	    System.out.println("Tapped Submit button after enter signature");
	    
	    System.out.println("System Presents the enrollment page");
	    
	    Thread.sleep(5000);
	    clickTest("reminder_XPATH");
	   
	    System.out.println("Dismiss the orientation page");
	    
	    JavascriptExecutor jse16 = (JavascriptExecutor) driver;
	    jse16.executeScript("window.scrollBy(0,400)", "");
	    Thread.sleep(6000);
	    
	    clickTest("chekoutbutton_XPATH");
	    
	    Thread.sleep(9000);
	    System.out.println("Tapping Settings button");
	    
	    clickTest("settings_XPATH");
	    Thread.sleep(6000);
	    System.out.println("Tapping on Logout button");
	    clickTest("logout_XPATH");
	    
	   // WebDriverWait waitHome = new WebDriverWait(driver, 60);// 1 minute 
	  //  waitHome.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("home_XPATH")));
	    
	    //clickTest("Page_XPATH");
	    
	    //driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div/div/h2")).click();
		
	   // clickTest("home_XPATH");
	    
	    //clickTest("home_XPATH");
	    
	  }
	
	
	
}
