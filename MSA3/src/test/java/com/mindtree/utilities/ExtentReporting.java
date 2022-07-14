package com.mindtree.utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporting
{
	Logging l = new Logging();

	public String addExtentReport(String reportPath)
	{
		BaseClass objBase = new BaseClass();
		String tp = objBase.getDateTime();
		reportPath = "/Reports/Report_" + tp + ".html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(new File("." + reportPath));
		BaseClass.ext = new ExtentReports();
		BaseClass.ext.attachReporter(reporter);
		return reportPath;
	}

	public String addScreenShot(WebDriver wd)
	{
		BaseClass objBase = new BaseClass();
		String tpo = "";
		String tp = objBase.getDateTime();
		try
		{
			tpo = System.getProperty("user.dir") + "/ScreenShots/ScreenShot_" + tp + ".png";
			File capture = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(capture, new File(tpo));
		}
		catch (IOException i)
		{
			l.error("Failed to add screenshot to report");
		}
		return tpo;
	}
}
