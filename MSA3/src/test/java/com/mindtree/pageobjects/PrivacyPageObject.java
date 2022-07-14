package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.mindtree.uistore.PrivacyPageLocators;
import com.mindtree.uistore.TravelPageLocators;
import com.mindtree.utilities.BaseClass;
import com.mindtree.utilities.ExtentReporting;
import com.mindtree.utilities.Logging;

public class PrivacyPageObject {


	
	public void verifyPromiseText(WebDriver driver,String verify)
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
			PrivacyPageLocators objPrivacyLoc = new PrivacyPageLocators(driver);
			tmp = objPrivacyLoc.privacyPromise.getText();
			Assert.assertEquals(tmp, verify);
			l.info("*ignore*");
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
