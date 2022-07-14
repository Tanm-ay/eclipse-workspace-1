package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.mindtree.uistore.TravelPageLocators;
import com.mindtree.utilities.BaseClass;
import com.mindtree.utilities.ExtentReporting;
import com.mindtree.utilities.Logging;

public class TravelPageObject 
{
	public void verifyTravelText(WebDriver driver,String verify)
	{
		Logging l = new Logging();
		ExtentReporting objReport = new ExtentReporting();
		if (BaseClass.executionFlag)
		{
			driver.quit();
			Assert.fail();
		}
		boolean b = true;
		String tmp = "";
		try
		{
			TravelPageLocators objTravelLoc = new TravelPageLocators(driver);
			tmp = objTravelLoc.travelText.getText().toUpperCase();
			Assert.assertEquals(tmp, verify);
			BaseClass.ts.pass("String matched.  Expected [ " + verify + " ] , Found [ " + tmp + " ]");
			l.info("TC1 Pass. String matched\n");
			b = false;
		}
		finally
		{
			if (b)
			{
				BaseClass.executionFlag = true;
				BaseClass.ts.fail("String NOT matched.   Expected [ " + verify + " ] , Found [ " + tmp + " ]", MediaEntityBuilder.createScreenCaptureFromPath(objReport.addScreenShot(driver)).build());
				l.error("TC1 Fail. String NOT matched.\n");
			}
			driver.quit();
		}
	}
}
