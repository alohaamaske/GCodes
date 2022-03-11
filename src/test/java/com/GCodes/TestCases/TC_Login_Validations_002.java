package com.GCodes.TestCases;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.GCodes.pageObjects.Login;
import com.GCodes.utilities.XLUtils;
import org.testng.annotations.Test;

public class TC_Login_Validations_002 extends BaseClass{
	@Test
	public void TC_GCodes_LoginValidations_002() throws InterruptedException
	{
		SoftAssert softassert=new SoftAssert();
		XLUtils reader= new XLUtils(System.getProperty("user.dir")+"/src/test/java/com/GCodes/TestData/TestData_GCodes.xlsx");
		Login com=new Login(getDriver());
		getDriver().get(baseURL);
		logger.info("Invalid password test started");
		String user= reader.getCellData("Login_Data", "Username", 3);
		String pswd= reader.getCellData("Login_Data", "Password", 3);
		Thread.sleep(3000);
		com.username(user);
		com.password(pswd);
		com.submit();
		String result = com.loginalert().replaceAll("[-+.^:,Ã*Ã—×]","").trim();
		//System.out.println("Actual alert is " + result);		
		String expectedalert="Invalid username and password combination";
		//System.out.println("Expected alert is " + expectedalert);
		softassert.assertEquals(result, expectedalert);			
		getDriver().navigate().refresh();
		Thread.sleep(3000);
		logger.info("Invalid Email test started");
		String user2= reader.getCellData("Login_Data", "Username", 4);
		String pswd2= reader.getCellData("Login_Data", "Password", 4);
		com.username(user2);
		com.password(pswd2);
		com.submit();
		softassert.assertEquals(result, expectedalert);
		Thread.sleep(3000);
		logger.info("Invalid Email and password test started");
		String user3= reader.getCellData("Login_Data", "Username", 5);
		String pswd3= reader.getCellData("Login_Data", "Password", 5);
		com.username(user3);
		com.password(pswd3);
		com.submit();
		softassert.assertEquals(result, expectedalert);
		softassert.assertAll();
		//Thread.sleep(3000);
	}
}
