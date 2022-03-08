package com.GCodes.TestCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.GCodes.pageObjects.Login;
import com.GCodes.pageObjects.Wallets;

public class TC_Wallet_003 extends BaseClass {

	@Test
	public void TC_Invalid_Wallet_003() throws InterruptedException
	{
		SoftAssert softassert=new SoftAssert();		
		Login com=new Login(getDriver());
		Wallets wallet=new Wallets(getDriver());
		//username and password are retrieved from config.properties file
		getDriver().get(baseURL);
		System.out.println("TC_Invalid_Walle Thread is " + Thread.currentThread().getId());
		Thread.sleep(4000);		
		com.username(username);
		com.password(password);
		com.submit();
		Thread.sleep(5000);		
		((JavascriptExecutor)getDriver()).executeScript("scroll(0,5000)");
		Thread.sleep(1000);
		wallet.walletLinkClick();
		String reddemcode=randomString();
		wallet.txtCode(reddemcode);
		wallet.redeemClick();
		String expectedmas="Invalid code format";
		softassert.assertEquals(wallet.messagecode(), expectedmas);
		wallet.redeemPopupClick();
		softassert.assertAll();	
		//getDriver().close();
	}	
	@Test
	public void TC_Invalid_Wallet_005() throws InterruptedException
	{
		getDriver().get("https://www.google.com/");
		System.out.println("TC_Invalid_Wallet 005 Thread is " + Thread.currentThread().getId());
		Thread.sleep(4000);		
	}
}
