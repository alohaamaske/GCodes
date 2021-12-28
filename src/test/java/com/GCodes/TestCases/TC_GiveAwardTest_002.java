package com.GCodes.TestCases;
import static org.testng.Assert.assertEquals;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.GCodes.PageObject.GiveAward;
import com.GCodes.PageObject.Login;
import com.GCodes.utilities.LibraryUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class TC_GiveAwardTest_002 extends BaseClass
{
	@Test
	public void giveAward() throws InterruptedException
	{		
		Login login=new Login(driver);
		Thread.sleep(4000);
		login.username(username);
		login.password(password);
		login.submit();
		LibraryUtils.waiForElementToBeVisible(driver, login.home(), 10);	
		GiveAward give = new GiveAward(driver);
		Thread.sleep(4000);		
		String member="revathi";
		give.give();
		Thread.sleep(4000);
		give.peerbtnclick();
		Thread.sleep(4000);
		String  awardtext= give.awardtotalcount();
		Thread.sleep(3000);
		Integer awardcount=Integer.valueOf(awardtext);
		if (awardcount>0)
		{
			logger.info("Award count is greater than 0");
			give.sendaward();
			Thread.sleep(4000);	
			String memberselect= give.nomemberalert();
			String memberalert="No members selected";
			assertEquals(memberselect, memberalert);
			logger.info("Members selection validation successfully verified");
			Thread.sleep(2000);
			give.closepopup();
			give.memberfield(member);
			give.memberfilter();
			give.sendaward();
			Thread.sleep(2000);
			String entermessage=give.alertmsg();
			System.out.println("The alert message is "+ entermessage);
			if(entermessage.equals("Please enter the messages you would like to send to your awardees."))
			{
				Assert.assertTrue(true);
				logger.info("Empty awardees message validation successfully verified");
				give.closepopup();
			}
			else
			{
				Assert.assertTrue(false);
				logger.info("Empty awardees message could not be verified");
				give.closepopup();
			}
			String message="Congratulations to All awardees";
			give.awardmessage(message); 
			Thread.sleep(2000); 			
			give.sendaward();
			Thread.sleep(10000); 
			String awardsenttext=give.awardtextsent(); 
			String expectedmessage="Award sent successfully!";
			if(awardsenttext.equals(expectedmessage))
			{
				Assert.assertTrue(true);
				logger.info("Award sent successfully!");
			}
			else
			{
				Assert.assertTrue(false);
				logger.info("Issue with Award sent or award sent popup");
			}
			give.close(); 
			Thread.sleep(2000);
			give.give();
			give.peerbtnclick();
			Thread.sleep(3000); 
			String awardtext2=give.awardtotalcount();
			Integer awardcount2=Integer.valueOf(awardtext2);
			System.out.println("Previous Award Count was " + awardcount);
			System.out.println("Updated Award Count is " + awardcount2); 
			if(awardcount2==awardcount-1)
			{
				Assert.assertTrue(true);
				logger.info("Award count has been updated successfully");
				give.givepop();
				driver.quit();
			} 
			else 
			{
				Assert.assertTrue(false);
				logger.info("Award count update issue or updated award count could not be identified");
				give.givepop();
				driver.quit();
			}
		}		  
		else
		{
			logger.info("Award count is less than 1,unable to proceeed");
			driver.quit();			
		}
	}

}


