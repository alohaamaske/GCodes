package com.GCodes.TestCases;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.GCodes.pageObjects.SendCode;
import com.GCodes.pageObjects.IssuanceImporter;
import com.GCodes.pageObjects.Login;
import com.GCodes.utilities.LibraryUtils;
import com.GCodes.utilities.XLUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.configuration.Theme;
public class TC_SendCode_006 extends BaseClass {

	@Test
	public void TC_SendCode() throws InterruptedException, IOException
	{
		SoftAssert softassert=new SoftAssert();		
		XLUtils reader= new XLUtils(System.getProperty("user.dir")+"/src/test/java/com/GCodes/TestData/TestData_GCodes.xlsx");
		Login com=new Login(getDriver());
		SendCode sc =new SendCode(getDriver());
		getDriver().get(baseURL);
		System.out.println("TC_Import_InvalidFile Thread is " + Thread.currentThread().getId());
		getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String user= reader.getCellData("Login_Data", "Username", 2);
		String pswd= reader.getCellData("Login_Data", "Password", 2);
		com.username(user);
		com.password(pswd);
		com.submit();
		getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		sc.Click_Admin();
		sc.Click_SendCodeTab();
		Select objSelect2 =new Select(sc.SelectCurrency());
		objSelect2.selectByVisibleText("GBP (GBP)");
		Select objSelect3 =new Select(sc.CurrencyVal());
		Thread.sleep(1000);
		objSelect3.selectByVisibleText("$5 USD");
		Select objSelect4 =new Select(sc.Theame());
		objSelect4.selectByVisibleText("GCodes Global");
		String email= reader.getCellData("SendCode_Data", "Email", 2);
		String firstname= reader.getCellData("SendCode_Data", "FirstName", 2);
		String lastname= reader.getCellData("SendCode_Data", "LastName", 2);
		String ContryCode= reader.getCellData("SendCode_Data", "CountryCode", 2);
		String AreaCode= reader.getCellData("SendCode_Data", "AreaCode", 2);
		String Telephone= reader.getCellData("SendCode_Data", "Telephone", 2);
		String Address1= reader.getCellData("SendCode_Data", "Address1", 2);
		String City= reader.getCellData("SendCode_Data", "City", 2);
		String Zip= reader.getCellData("SendCode_Data", "Zip", 2);		
		sc.SendEmail(email);
		sc.EnterFirstName(firstname);
		sc.EnterLasteName(lastname);
		sc.EnterContryCode(ContryCode);
		sc.EnterAreaCode(AreaCode);
		sc.Entertelephone(Telephone);
		sc.EnterAddress1(Address1);
		sc.EnterCity(City);
		Select objSelect5 =new Select(sc.SelectCountry());
		objSelect5.selectByVisibleText("Canada");
		Select objSelect6 =new Select(sc.SelectState());
		objSelect6.selectByVisibleText("Northwest Territories");
		sc.EnterZip(Zip);
		sc.ClickSendCode();
		getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		sc.ClickTerms();
        sc.ClickConfirm();
        getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Boolean bool =getDriver().findElements(By.xpath("//*[@id=\"flashbag-messages\"]/div")).size()>0;
		System.out.println("Boolean value is "+bool);
		if(bool==true)
		{
			logger.info("Send Code performed successfully");
			Assert.assertFalse(false); 
		}
		else
		{
			logger.info("Unable to Send Code or the thanks message not found");
			Assert.assertFalse(true); 
		}
	}

}
