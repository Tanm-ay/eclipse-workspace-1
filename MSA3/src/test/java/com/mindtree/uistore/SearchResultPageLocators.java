package com.mindtree.uistore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPageLocators {
	public WebElement secondResult;
	
	public SearchResultPageLocators(WebDriver driver)
	{
		this.secondResult = driver.findElement(By.xpath("(//div[contains(@class,'ssrcss-11rb3jo-Promo')])[2] //p[contains(@class,'Paragraph')]"));
	}
}
