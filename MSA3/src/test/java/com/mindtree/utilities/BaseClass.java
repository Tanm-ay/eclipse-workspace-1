package com.mindtree.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;


public class BaseClass
{
	public static WebDriver driver = null;
	public static boolean executionFlag = false;
	public static ExtentTest ts = null;
	public static ExtentReports ext = null;
	ExcelFileRead objExcel = new ExcelFileRead();
	PropertyFileRead objProp = new PropertyFileRead();
	ExtentReporting objRepo = new ExtentReporting();
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	Logging l = new Logging();

	public WebDriver initialize(int wait)
	{
		if (executionFlag)
		{
			Assert.fail();
		}
		try
		{
			System.setProperty(objProp.getFromProperty("Configuration", "driverType"), objProp.getFromProperty("Configuration", "driverPath"));
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(wait,TimeUnit.SECONDS);
			BaseClass.ts.pass("System property set. Driver initialized");
			l.info("System property set. Driver initialized");
		}
		catch (Exception e)
		{
			BaseClass.executionFlag = true;
			e.getMessage();
			l.fatal("System property was not set. Could not initialize the driver");
			BaseClass.ts.fail("System property not set. Could not initialize the driver");
		}
		return driver;
	}
	public WebDriver navigateUrl(WebDriver driver,String url)
	{
		if (executionFlag)
		{
			Assert.fail();
		}
		try
		{
			driver.manage().window().maximize();
			driver.get(url);
			BaseClass.ts.pass("Navigated to " + url);
			l.debug("Navigated to " + url);
		}
		catch (Exception e)
		{
			BaseClass.executionFlag = true;
			e.getMessage();
			l.fatal("Could not navigate to website. " + url + " might be incorrect");
			BaseClass.ts.fail("Could not navigate to website. " + url + " might be incorrect", MediaEntityBuilder.createScreenCaptureFromPath(objRepo.addScreenShot(driver)).build());
		}

		return driver;
	}
	public String getDateTime()
	{
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH.mm.ss");
		LocalDateTime current = LocalDateTime.now();
		String str = pattern.format(current);
		return str;
	}
}
