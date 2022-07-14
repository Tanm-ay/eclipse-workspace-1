package com.mindtree.uistore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageLocators {
	public WebElement travel;
	public WebElement searchBox;
	public WebElement privay;
	public HomePageLocators(WebDriver driver)
	{
		this.travel = driver.findElement(By.xpath("//a[@href='https://www.bbc.com/travel']"));
		this.searchBox = driver.findElement(By.xpath("//a[@title='Search BBC']"));
		this.privay = driver.findElement(By.xpath("//a[text()='Privacy Policy']"));
	}
}
