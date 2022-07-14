package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.mindtree.uistore.SearchPageLocators;
import com.mindtree.uistore.SearchResultPageLocators;
import com.mindtree.uistore.TravelPageLocators;
import com.mindtree.utilities.BaseClass;
import com.mindtree.utilities.ExtentReporting;
import com.mindtree.utilities.Logging;

public class SearchResultPageObject 
{
	
	ExtentReporting objReport = new ExtentReporting();
	Logging l = new Logging();
	
	public void searchTextVerify(WebDriver driver,String verify)
	{
		if (BaseClass.executionFlag)
		{
			driver.quit();
			Assert.fail();
		}
		boolean b = true;
		String tmp = "";
		try
		{
			SearchResultPageLocators objSearchLoc = new SearchResultPageLocators(driver);
			tmp = objSearchLoc.secondResult.getText();
			Assert.assertEquals(tmp, verify);
			BaseClass.ts.pass(verify+" is present in second result");
			l.info("TC1 Pass. "+verify+" is present in second result");
			b = false;
		}
		finally
		{
			if (b)
			{
				BaseClass.executionFlag = true;
				BaseClass.ts.fail(verify+" is NOT present in second result", MediaEntityBuilder.createScreenCaptureFromPath(objReport.addScreenShot(driver)).build());
				l.error("TC1 Fail. "+verify+" is NOT present in second result");
			}
			driver.quit();
		}
	}
}
