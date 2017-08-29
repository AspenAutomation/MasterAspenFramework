package com.Aspen.testcases;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Aspen.base.TestBase;
import com.Aspen.utilities.TestUtil;

public class LoginTest extends TestBase {
	
	@Test(dataProviderClass=TestUtil.class, dataProvider="dp")
	public void loginTest(Hashtable<String,String> data) throws InterruptedException {
		/*
		driver.findElement(By.id(OR.getProperty("email"))).sendKeys(email);
		driver.findElement(By.id(OR.getProperty("password"))).sendKeys(password);
		driver.findElement(By.xpath(OR.getProperty("Login"))).click();
		Assert.fail("Test fails");
		
		*/
		/*if(!TestUtil.isTestRunnable("loginTest", excel)){
			
			throw new SkipException("Skipping the test "+ "loginTest".toUpperCase() + " as the Run mode is NO ");
		}*/
		
		if(!data.get("runmode").equals("Y")){
			
			throw new SkipException("Test data is skipping, Runmode is set it as NO ");
		}
		
		
	
		typeTest("email_ID", data.get("email"));
		typeTest("password_ID", data.get("password"));
		clickTest("Login_XPATH");
		Thread.sleep(6000);
		
		clickTest("settings_XPATH");
		Thread.sleep(4000);
		clickTest("logout_XPATH");
	
	}
	
	
	
}
