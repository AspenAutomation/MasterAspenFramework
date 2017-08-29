package com.Aspen.testcases;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Aspen.base.TestBase;
import com.Aspen.utilities.TestUtil;

public class TestClearFunctionality extends TestBase {
	
	@Test(dataProviderClass=TestUtil.class, dataProvider="dp")
	public void testClearFunctionality(Hashtable<String,String> data) throws InterruptedException {
		/*
		driver.findElement(By.id(OR.getProperty("email"))).sendKeys(email);
		driver.findElement(By.id(OR.getProperty("password"))).sendKeys(password);
		driver.findElement(By.xpath(OR.getProperty("Login"))).click();
		Assert.fail("Test fails");
	*/
		if(!TestUtil.isTestRunnable("feedback", excel)){
			
			throw new SkipException("Skipping the test "+ "feedback".toUpperCase() + " as the Run mode is NO ");
		}
		
		
		
		typeTest("email_ID",data.get("email"));
		typeTest("password_ID",data.get("password"));
		clearTest("email_ID");
		clearTest("password_ID");
		
		/*clickTest("Login_XPATH");
		Thread.sleep(6000);
		
		clickTest("settings_XPATH");
		Thread.sleep(4000);
		clickTest("logout_XPATH");
	*/
	}
	
	
	
}
