package com.GCodes.TestCases;

import java.util.concurrent.TimeUnit;

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
		Login com=new Login(driver);
		Wallets wallet=new Wallets(driver);
		//username and password are retrieved from config.properties file
		com.username(username);
		com.password(password);
		com.submit();
		Thread.sleep(5000);
		
		((JavascriptExecutor)driver).executeScript("scroll(0,5000)");
		wallet.walletLinkClick();
		String reddemcode=randomString();
		wallet.txtCode(reddemcode);
		wallet.redeemClick();
		String expectedmas="Invalid code format";
		softassert.assertEquals(wallet.messagecode(), expectedmas);
		wallet.redeemPopupClick();
		softassert.assertAll();	
	}
}
