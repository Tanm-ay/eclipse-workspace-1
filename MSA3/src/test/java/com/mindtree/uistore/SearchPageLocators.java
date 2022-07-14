package com.mindtree.uistore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPageLocators {

	public WebElement searchBox1 = null;
	
	public SearchPageLocators(WebDriver driver)
	{
		this.searchBox1 = driver.findElement(By.xpath("//input[@placeholder='Search the BBC']"));
	}
}
