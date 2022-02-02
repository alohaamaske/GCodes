package com.GCodes.TestCases;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.GCodes.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig=new ReadConfig(); 
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static Logger Logger;
	Logger logger=Logger.getLogger("GCodes");
    
	private static ThreadLocal<WebDriver> driver=new ThreadLocal<>();

	@Parameters("browser")
	@BeforeMethod
	public void Setup(String br)
	{
		PropertyConfigurator.configure("log4j.properties");
		if(br.equals("chrome"))
		{	
			System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());
			driver.set(new ChromeDriver());
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getfirefoxpath());
			driver.set(new FirefoxDriver());		
		}

		else if(br.equals("msedge"))
		{
			System.setProperty("webdriver.edge.driver", readconfig.getmsedgepath());
			driver.set(new EdgeDriver());
		}
		getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;		

	}

	public WebDriver getDriver()//Chrome
	{
		return driver.get();
	}

	//@AfterMethod	
	public void teardown()
	{
		getDriver().quit();
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target= new File(System.getProperty("user.dir")+ "/Screenshots/" + tname +".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot Taken");
	}
	public static String randomString() {
		String generateString= RandomStringUtils.randomAlphabetic(5);
		return (generateString);
	}
	public static String randomNum()
	{
		String generateString2=RandomStringUtils.randomNumeric(4);
		return (generateString2);
	}
}


