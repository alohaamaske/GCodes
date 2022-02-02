package com.GCodes.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.GCodes.pageObjects.Cart;
import com.GCodes.pageObjects.Login;
import com.GCodes.pageObjects.Wallets;
import com.GCodes.utilities.LibraryUtils;

public class TC_Cart_validation_004 extends BaseClass{

	@Test
	public void TC_CartAddRemove() throws InterruptedException
	{
		SoftAssert softassert=new SoftAssert();		
		Login com=new Login(getDriver());
		Cart cart=new Cart(getDriver());
		//username and password are retrieved from config.properties file
		getDriver().get(baseURL);
		System.out.println("TC_AddCart Thread is " + Thread.currentThread().getId());
		Thread.sleep(4000);		
		com.username(username);
		com.password(password);
		com.submit();
		LibraryUtils.waiForElementToBeVisible(getDriver(), cart.shop_link_wait(), 20);
		cart.lnk_shopsClick();
		Thread.sleep(10000);
		getDriver().switchTo().frame(0);
		LibraryUtils.waiForElementToBeVisible(getDriver(), cart.menu_button_wait(), 20);	
		cart.txt_keyword_enter("Applebee's");
		cart.click_search();
		LibraryUtils.waiForElementToBeVisible(getDriver(), cart.rewardBrand(), 20);
		if(cart.rewardBrand().isDisplayed())
		{
			System.out.println("Item Found");
			logger.info("Navigated to shopping screen");
			Integer rewardcost=Integer.valueOf(cart.rewardcost());
			Select objSelect =new Select(cart.selectOne());
			objSelect.selectByVisibleText("$5.00");
			Thread.sleep(3000);
			cart.enterQuantity("2");
			cart.addToCartClick();
			Thread.sleep(5000);
			System.out.println("Original get text value is "+ cart.Cart_totalvalue().replaceAll("[^0-9]", ""));
			Integer calcCatrvalue=Integer.valueOf(cart.Cart_totalvalue().replaceAll("[^0-9]", ""));
			System.out.println("Calculated final value is " + calcCatrvalue);
			cart.viewCartClick();
			LibraryUtils.waiForElementToBeVisible(getDriver(), cart.totalvalueOnCart2(), 20);
			Integer totalcartvalue=Integer.valueOf(cart.totalvalueOnCart().replaceAll("[^0-9]", ""));
			Integer expectedvalue=rewardcost*2;			
			softassert.assertEquals(totalcartvalue, expectedvalue);
			softassert.assertEquals(calcCatrvalue, expectedvalue);
			cart.cartRemove();
			Thread.sleep(400);
			cart.removeItems();
			LibraryUtils.waiForElementToBeVisible(getDriver(), cart.ItemIsRemoved(), 20);
			String expectedItemrem="Your Shopping Cart is empty.";
			System.out.println("Actual Item removed message is " + cart.removeItemsMessage());
			softassert.assertEquals(cart.removeItemsMessage(), expectedItemrem);			
			softassert.assertAll();
		}
		else
		{
			logger.error("Unable to find the brand");
			getDriver().close();
		}
	}
}
