package com.Aspen.testcases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Aspen.base.TestBase;
import com.Aspen.utilities.TestUtil;

public class Feedback extends TestBase {
	
	@Test(dataProviderClass=TestUtil.class, dataProvider="dp")
	public void feedback(Hashtable<String,String> data) throws InterruptedException {
		
		if(!TestUtil.isTestRunnable("feedback", excel)){
			
			throw new SkipException("Skipping the test "+ "feedback".toUpperCase() + " as the Run mode is NO ");
		}
		
		clickTest("feedback_XPATH");
		Thread.sleep(4000);
		selectTest("feedbackType_XPATH", data.get("feedbacktype"));
		typeTest("message_XPATH",data.get("message"));
		Thread.sleep(4000);
		clickTest("submit_XPATH");
		
		
	/*	Alert alert= wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();*/
	
	}
}
