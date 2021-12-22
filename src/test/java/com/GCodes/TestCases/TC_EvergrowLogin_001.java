package com.GCodes.TestCases;
import static org.testng.Assert.assertEquals;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.swing.text.html.HTMLDocument.Iterator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.GCodes.PageObject.GiveAward;
import com.GCodes.PageObject.Login;
import com.GCodes.utilities.LibraryUtils;
import com.GCodes.utilities.XLUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TC_EvergrowLogin_001 extends BaseClass 
{
		@Test
	public void TC_EvergrowLogin_001() throws InterruptedException, IOException 
	{
		XLUtils reader= new XLUtils(System.getProperty("user.dir")+"/src/test/java/com/GCodes/TestData/TestData_Evergrow.xlsx");
		System.out.println(reader);
		Login com=new Login(driver);
		String username= reader.getCellData("Sheet1", "Username", 2);
		String password= reader.getCellData("Sheet1", "Password", 2);
		Thread.sleep(3000);
		com.username(username);
		com.password(password);
		com.submit();				
		LibraryUtils.waiForElementToBeVisible(driver, com.home(), 10);		
      	System.out.println("Page title is " +driver.getTitle());
		
		if(driver.getTitle().equals("Evergrow Application"))
		{			
			Assert.assertTrue(true);
		} 
		
		else {
			captureScreen(driver,"LoginTest");
			Assert.assertTrue(false); 
		}
	}

}



