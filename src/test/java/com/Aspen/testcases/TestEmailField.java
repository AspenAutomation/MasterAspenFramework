package com.Aspen.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.Aspen.base.TestBase;
import com.Aspen.utilities.TestUtil;

public class TestEmailField extends TestBase {
	
	@Test
	public void testEmailfield() throws InterruptedException, IOException{
		
		/*
		if(!TestUtil.isTestRunnable("testEmailfield", excel)){
			
			throw new SkipException("Skipping the test "+ "testEmailfield".toUpperCase() + " as the Run mode is NO ");
		}
		*/
		//verifyEquals("abc", "xyz");
		Thread.sleep(3000);
		//System.setProperty("org.uncommons.reportng.escape-output", "false");
		Log.debug("LoginTest->section is opening !!");
		Thread.sleep(1000);
		
		clickTest("emailAddress_ID");
		
		//driver.findElement(By.id(OR.getProperty("emailAddress"))).click();
		
		//driver.findElement(By.id("CTASpecialApplyNow")).click();
		
		Thread.sleep(1000);
		
		//Assert.assertTrue(isElementPresent(By.id(OR.getProperty("emailAddress"))), "Button not clicked");
		
		Thread.sleep(3000);
		
		Log.debug("Tapped email textfield!!");
		//Assert.fail("Test fails");
	
		/*Reporter.log("Tapped email textfield!!");
		
		Reporter.log("<a target=\"_blank\" href=\"C:\\Users\\Jithin\\AspenUniversity\\DataDrivenFramework\\src\\test\\resources\\excel\\Penguins.jpeg\">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href=\"C:\\Users\\Jithin\\AspenUniversity\\DataDrivenFramework\\src\\test\\resources\\excel\\Penguins.jpeg\"><img src=\"C:\\Users\\Jithin\\AspenUniversity\\DataDrivenFramework\\src\\test\\resources\\excel\\Penguins.jpeg\" height=200 width=200></img></a>");
	*/
	
	}

}
