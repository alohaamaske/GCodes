package com.GCodes.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LibraryUtils {

	public static WebElement waiForElementToBeVisible(WebDriver driver, WebElement webelement, int Seconds)

	{
		WebDriverWait wait=new WebDriverWait(driver, Seconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOf(webelement));
		return element;
	}
	public static WebElement waiForElementToBeClickable(WebDriver driver, WebElement webelement, int Seconds)

	{
		WebDriverWait wait=new WebDriverWait(driver, Seconds);
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(webelement));
		return element;
	}
	
}
