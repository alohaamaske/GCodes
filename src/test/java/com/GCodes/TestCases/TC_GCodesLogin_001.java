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

import com.GCodes.pageObjects.GiveAward;
import com.GCodes.pageObjects.Login;
import com.GCodes.utilities.LibraryUtils;
import com.GCodes.utilities.XLUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.configuration.Theme;
public class TC_GCodesLogin_001 extends BaseClass{

	@Test
	public void TC_GCodes_Login_001() throws InterruptedException, IOException 
	{
		XLUtils reader= new XLUtils(System.getProperty("user.dir")+"/src/test/java/com/GCodes/TestData/TestData_GCodes.xlsx");
		//System.out.println(reader);
		Login com=new Login(getDriver());
		getDriver().get(baseURL);
		String username= reader.getCellData("Login_Data", "Username", 2);
		String password= reader.getCellData("Login_Data", "Password", 2);
		Thread.sleep(3000);
		com.username(username);
		com.password(password);
		com.submit();									
		System.out.println("Page title is " +getDriver().getTitle());

		if(getDriver().getTitle().equals("GCodes® - INSTANT REWARDS, EVERYWHERE.™"))
		{			
			Assert.assertTrue(true);
			logger.info("Login Test is Pass");
			com.accountLinkclick();
			Thread.sleep(2000);
			com.logoutclick();
		} 

		else {
			captureScreen(getDriver(),"LoginTest");
			Assert.assertTrue(false); 
			logger.info("Login Test is Fail");
		}
	}	

}
