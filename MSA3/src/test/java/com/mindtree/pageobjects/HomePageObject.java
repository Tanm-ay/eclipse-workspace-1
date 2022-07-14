package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.NeedsLocalLogs;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.mindtree.uistore.HomePageLocators;
import com.mindtree.utilities.BaseClass;
import com.mindtree.utilities.ExtentReporting;
import com.mindtree.utilities.Logging;

public class HomePageObject
{
	
	public void clickOnTravel(WebDriver driver)
	{
		Logging l = new Logging();
		ExtentReporting objReport = new ExtentReporting();
		if (BaseClass.executionFlag)
		{
			driver.quit();
			Assert.fail();
		}
		try
		{
			HomePageLocators homeObjectLoc = new HomePageLocators(driver);
			homeObjectLoc.travel.click();
			l.info("Clicked Travel link");
			BaseClass.ts.pass("Clicked on Travel link");
		}
		catch (Exception e)
		{
			BaseClass.executionFlag = true;
			e.getMessage();
			l.error("Could not click Travel link");
			BaseClass.ts.fail("Could not click Travel link", MediaEntityBuilder.createScreenCaptureFromPath(objReport.addScreenShot(driver)).build());
		}
	}
	public void clickSearchBox(WebDriver driver)
	{
		Logging l = new Logging();
		ExtentReporting objReport = new ExtentReporting();
		if (BaseClass.executionFlag)
		{
			driver.quit();
			Assert.fail();
		}
		try
		{
			HomePageLocators objHomeLoc = new HomePageLocators(driver);
			objHomeLoc.searchBox.click();
			l.info("Clicked search box");
			BaseClass.ts.pass("Clicked search box");
		}
		catch (Exception e)
		{
			BaseClass.executionFlag = true;
			System.out.println(e.getMessage());
			l.error("Search box not found");
			BaseClass.ts.fail("Search box not found", MediaEntityBuilder.createScreenCaptureFromPath(objReport.addScreenShot(driver)).build());
		}
	}


	public void clickFooterPrivacyLink(WebDriver driver)
	{
		Logging l = new Logging();
		ExtentReporting objReport = new ExtentReporting();
		if (BaseClass.executionFlag)
		{
			driver.quit();
			Assert.fail();
		}
		try
		{
			HomePageLocators objHomeLoc = new HomePageLocators(driver);
			objHomeLoc.privay.click();
			l.info("Clicked Privacy Policy link in footer");
			BaseClass.ts.pass("Clicked Privacy Policy link");
		}
		catch (Exception e)
		{
			BaseClass.executionFlag = true;
			System.out.println(e.getMessage());
			l.error("Failed to click Privacy Policy link. Link not found");
			BaseClass.ts.fail("Failed to click Privacy Policy link. Link not found", MediaEntityBuilder.createScreenCaptureFromPath(objReport.addScreenShot(driver)).build());
		}
	}

}
