package com.mindtree.uistore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PrivacyPageLocators {
	public WebElement privacyPromise;
	
	public PrivacyPageLocators(WebDriver driver)
	{
		this.privacyPromise = driver.findElement(By.xpath("//a[@title='Privacy Promise']"));
	}
}
