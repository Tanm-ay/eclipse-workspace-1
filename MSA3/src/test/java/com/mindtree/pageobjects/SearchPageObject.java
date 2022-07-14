package com.mindtree.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.mindtree.uistore.HomePageLocators;
import com.mindtree.uistore.SearchPageLocators;
import com.mindtree.utilities.BaseClass;
import com.mindtree.utilities.ExtentReporting;
import com.mindtree.utilities.Logging;

public class SearchPageObject {
	ExtentReporting objReport = new ExtentReporting();
	Logging l = new Logging();
	public void enterIntoSearchBox(WebDriver driver,String input)
	{
		if (BaseClass.executionFlag)
		{
			driver.quit();
			Assert.fail();
		}
		try
		{
			
			SearchPageLocators objSearchLoc = new SearchPageLocators(driver);
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.elementToBeClickable(objSearchLoc.searchBox1));
			objSearchLoc.searchBox1.sendKeys(input,Keys.ENTER);
			l.info("Entered text into search box");
			BaseClass.ts.pass("Entered text into search box");
		}
		catch (Exception e)
		{
			BaseClass.executionFlag = true;
			e.getMessage();
			l.error("Search Page Search box not found");
			BaseClass.ts.fail("Search Page Search box not found", MediaEntityBuilder.createScreenCaptureFromPath(objReport.addScreenShot(driver)).build());
		}
	}
}
