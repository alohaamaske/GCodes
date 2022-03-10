package com.GCodes.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.GCodes.pageObjects.Cart;
import com.GCodes.pageObjects.IssuanceImporter;
import com.GCodes.pageObjects.Login;
import com.GCodes.utilities.XLUtils;

public class TC_Issuance_Importer_005 extends BaseClass{
	@Test
	public void TC_Import_InvalidFile() throws InterruptedException, IOException
	{
		SoftAssert softassert=new SoftAssert();		
		XLUtils reader= new XLUtils(System.getProperty("user.dir")+"/src/test/java/com/GCodes/TestData/TestData_GCodes.xlsx");
		Login com=new Login(getDriver());
		IssuanceImporter importer=new IssuanceImporter(getDriver());
		getDriver().get(baseURL);
		System.out.println("TC_Import_InvalidFile Thread is " + Thread.currentThread().getId());
		getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);		
		com.username(username);
		com.password(password);
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
		importer.Click_browse("D:\\Automation\\bulk_issurance_rabbie_test_ci.csv");
	}
}
