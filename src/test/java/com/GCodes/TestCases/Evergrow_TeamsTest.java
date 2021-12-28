package com.GCodes.TestCases;
import org.testng.Assert;
import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.GCodes.PageObject.*;
import com.google.common.base.Verify;
public class Evergrow_TeamsTest 
//extends GiveAwardTest
{
	//updates
	public WebDriver driver;
	Teams co;
	SoftAssert Softassert = new SoftAssert();
	@Test(priority=1)	
	public void teamsnaviation() throws InterruptedException 
	{
		co = new Teams(this.driver);
		co.teamspage();
		Thread.sleep(3000);
		Softassert.assertEquals(co.teamstitle(), co.teamstext());
		Softassert.assertAll();		  
	}
	@Test(priority=2)
	public void AddTeam() throws InterruptedException

	{
		co = new Teams(this.driver);
		WebDriverWait wait = new WebDriverWait(driver, 100);
		Thread.sleep(10000);
		co.createteam();
		co.teamnextbtn();
		Thread.sleep(3000);
		Softassert.assertEquals(co.teamvalidation(), co.expectedteamval());
		co.teamtoast();
		co.teamanametxt("Evergrow QA Team 01");
		co.teamnextbtn();
		Thread.sleep(500);
		co.addToteam();
		Thread.sleep(100);
		Softassert.assertEquals(co.teamalert(), co.teamexpectedalrt());
		co.addmemberalert();
		co.findmembertext("Revathi");
		co.selectedmember();
		co.findmembertext("Anil");
		co.selectedmember2();
		Thread.sleep(500);
		co.addToteam();
		Thread.sleep(3000);
		//co.teamnameaction();
		Softassert.assertAll();
		System.out.println("Hello, delete this");
	}
	@Test(priority=3)
	public void VerifyAndEditTeam() throws AWTException, InterruptedException
	{
		co = new Teams(this.driver);
		Thread.sleep(2000);	
	   ((JavascriptExecutor)driver).executeScript("scroll(0,5000)");
	    Thread.sleep(1000);
	    Robot rb = new Robot();
	    rb.keyPress(KeyEvent.VK_UP);
	    Thread.sleep(1000);
	    rb.keyPress(KeyEvent.VK_UP);
	    Thread.sleep(1000);
	    rb.keyPress(KeyEvent.VK_UP);
	    Thread.sleep(1000);
	    rb.keyPress(KeyEvent.VK_UP);
	    Thread.sleep(1000);
	    rb.keyPress(KeyEvent.VK_UP);
	    Actions actions = new Actions(driver);
	    WebElement elementLocator = driver.findElement(By.xpath("//div[h2='Evergrow QA Team 01']"));
	    actions.doubleClick(elementLocator).perform();
		Thread.sleep(3000);
		rb.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		rb.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(5000);
		rb.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(4000);
		Softassert.assertEquals(co.teamverify(), co.teamverifyexpected());
		co.deletemembericon();
		Thread.sleep(3000);
		co.deleteconfirm();
		Thread.sleep(4000);
		Softassert.assertEquals(co.actualmemberconf(), co.expecteddeletmem());		
		Softassert.assertAll();
	}	
	@Test(priority=4)
	public void DeleteTeam() throws InterruptedException
	{
		co = new Teams(this.driver);
		co.deleteTicon();
	    co.deleteteam();
		Thread.sleep(3000);
		co.deleteteamconf();
		Softassert.assertAll();
	}

}