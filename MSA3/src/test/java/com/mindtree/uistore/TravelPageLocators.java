package com.mindtree.uistore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TravelPageLocators {
	public WebElement travelText;
	
	public TravelPageLocators(WebDriver driver)
	{
		this.travelText = driver.findElement(By.xpath("//p[contains(text(),'Editor')]"));
	}
}
