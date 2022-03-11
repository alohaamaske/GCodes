package com.GCodes.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.GCodes.pageObjects.Cart;
import com.GCodes.pageObjects.IssuanceImporter;
import com.GCodes.pageObjects.Login;
import com.GCodes.utilities.XLUtils;

public class TC_Issuance_Importer_005 extends BaseClass{

	//@Test
	public void TC_EmptyFile_validation() throws InterruptedException, IOException
	{
		SoftAssert softassert=new SoftAssert();		
		XLUtils reader= new XLUtils(System.getProperty("user.dir")+"/src/test/java/com/GCodes/TestData/TestData_GCodes.xlsx");
		Login com=new Login(getDriver());
		IssuanceImporter importer=new IssuanceImporter(getDriver());
		getDriver().get(baseURL);
		System.out.println("TC_Import_InvalidFile Thread is " + Thread.currentThread().getId());
		getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String user= reader.getCellData("Login_Data", "Username", 2);
		String pswd= reader.getCellData("Login_Data", "Password", 2);
		com.username(user);
		com.password(pswd);
		com.submit();
		getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		importer.Click_AdminTab();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.info("Importer Link is available");
		Thread.sleep(2000);
		captureScreen(getDriver(),"Importer Screen");
		importer.Click_importer();		
		Thread.sleep(2000);
		importer.Click_btnValidate();
		softassert.assertEquals(importer.validateText(), "Please select a file");
		softassert.assertAll();		
	}
	//@Test
	public void TC_Invalid_Import_InvalidFile() throws InterruptedException, IOException
	{
		SoftAssert softassert=new SoftAssert();		
		XLUtils reader= new XLUtils(System.getProperty("user.dir")+"/src/test/java/com/GCodes/TestData/TestData_GCodes.xlsx");
		Login com=new Login(getDriver());
		IssuanceImporter importer=new IssuanceImporter(getDriver());
		getDriver().get(baseURL);
		System.out.println("TC_Import_InvalidFile Thread is " + Thread.currentThread().getId());
		getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String user= reader.getCellData("Login_Data", "Username", 2);
		String pswd= reader.getCellData("Login_Data", "Password", 2);
		com.username(user);
		com.password(pswd);
		com.submit();
		getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//captureScreen(getDriver(),"LoginTest");
		importer.Click_AdminTab();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.info("Importer Link is available");
		Thread.sleep(2000);
		captureScreen(getDriver(),"Importer Screen");
		importer.Click_importer();		
		Thread.sleep(2000);
		//Invalid data file
		importer.Click_browse("D:\\Automation\\FileImport\\bulk_issurance_rabbie_test_ci.csv");	
		importer.Click_btnValidate();
		Thread.sleep(5000);
		//getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println(importer.alertFileInvalid());
		softassert.assertEquals(importer.alertFileInvalid(), "File validation failed.");
		softassert.assertAll();
	}	
	@Test
	public void Valid_ImportTest() throws InterruptedException, IOException
	{
		getDriver().get(baseURL);
		SoftAssert softassert=new SoftAssert();	
		IssuanceImporter importer=new IssuanceImporter(getDriver());
		XLUtils reader= new XLUtils(System.getProperty("user.dir")+"/src/test/java/com/GCodes/TestData/TestData_GCodes.xlsx");
		Login com=new Login(getDriver());
		System.out.println("TC_Import_InvalidFile Thread is " + Thread.currentThread().getId());
		getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);		
		String user= reader.getCellData("Login_Data", "Username", 2);
		String pswd= reader.getCellData("Login_Data", "Password", 2);
		com.username(user);
		com.password(pswd);
		com.submit();
		getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		importer.Click_AdminTab();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.info("Importer Link is available");
		Thread.sleep(2000);
		captureScreen(getDriver(),"Importer Screen");
		importer.Click_importer();		
		Thread.sleep(2000);
		//valid file
		importer.Click_browse("D:\\Automation\\bulk_issurance_rabbie_test_ci.csv");	
		importer.Click_btnValidate();
		Thread.sleep(5000);
		Boolean bool = getDriver().findElements(By.xpath("//*[@class='alert alert-internal alert-danger']")).size()>0;
		System.out.println("Boolean Value is "+bool);
		if(bool==true)
		{
			logger.info("Insufficient Fund, unable to perform this test");
			throw new SkipException("Insufficient Fund, unable to perform this test");
		}
		else		
		{
			((JavascriptExecutor)getDriver()).executeScript("scroll(0,5000)");
			importer.Confirm();
			Thread.sleep(2000);
			System.out.println("Actual Message is "+ importer.Message_selectTerm());
			softassert.assertEquals(importer.Message_selectTerm(), "You must agree to the GCodes Purchase agreement before continuing.");
			importer.Select_Term();
			importer.Confirm();
			getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			Boolean boll2= getDriver().findElements(By.xpath("//*[@class='alert alert-internal alert-success']")).size()>0;
			System.out.println("FInal boolean value is "+ boll2);
			if(boll2==true)
			{
				logger.info("File scheduled successfully");
			}
			else
			{
				logger.error("Issue with import scheduler ");
			}
			softassert.assertAll();
		}
	}
}