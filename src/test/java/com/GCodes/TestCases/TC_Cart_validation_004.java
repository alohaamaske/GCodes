package com.GCodes.TestCases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.GCodes.pageObjects.Cart;
import com.GCodes.pageObjects.Login;
import com.GCodes.pageObjects.Wallets;
import com.GCodes.utilities.LibraryUtils;
import com.GCodes.utilities.XLUtils;

public class TC_Cart_validation_004 extends BaseClass{

	@Test
	public void TC_CartAddRemove() throws InterruptedException
	{
		SoftAssert softassert=new SoftAssert();		
		XLUtils reader= new XLUtils(System.getProperty("user.dir")+"/src/test/java/com/GCodes/TestData/TestData_GCodes.xlsx");
		Login com=new Login(getDriver());
		Cart cart=new Cart(getDriver());
		//username and password are retrieved from config.properties file
		getDriver().get(baseURL);
		System.out.println("TC_AddCart Thread is " + Thread.currentThread().getId());
		getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);		
		com.username(username);
		com.password(password);
		com.submit();
		//LibraryUtils.waiForElementToBeVisible(getDriver(), cart.shop_link_wait(), 20);
		getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		cart.lnk_shopsClick();
		//Thread.sleep(5000);
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		cart.Clickviewcart_link();
		Thread.sleep(5000);
		getDriver().switchTo().frame(0);
		Boolean bool1 = getDriver().findElements(By.xpath("//*[@class='btn btn-block btn-lg btn-secondary']")).size()>0;
		System.out.println("first bool1 value is " + bool1);
		if(bool1==true)
		{
			WebDriverWait wait= new WebDriverWait(getDriver(), 10);
			WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"row_points_0\"]/td[3]/form/div/p/a")));
			cart.cartRemove();
			Thread.sleep(3000);
			cart.removeItems();
			LibraryUtils.waiForElementToBeVisible(getDriver(), cart.ItemIsRemoved(), 30);
			getDriver().navigate().to("https://app-ci.g.codes/shop");
		}
		else
		{
			getDriver().navigate().to("https://app-ci.g.codes/shop");
		}
		Thread.sleep(10000);
		getDriver().switchTo().frame(0);
		LibraryUtils.waiForElementToBeVisible(getDriver(), cart.menu_button_wait(), 20);	
		String brandname= reader.getCellData("Cart_Data", "BrandName", 2);
		cart.txt_keyword_enter(brandname);			
		cart.click_search();
		System.out.println("Clicked on Search brand");
		LibraryUtils.waiForElementToBeVisible(getDriver(), cart.virtulGIftCart(), 30);		
		Boolean bool2 =getDriver().findElements(By.xpath("//*[@id='reward-brand']")).size()>0;
		System.out.println("Boolean value is "+bool2);
		if(bool2==true)
		{
			System.out.println("Item Found");
			logger.info("Navigated to shopping screen");
			Integer rewardcost=Integer.valueOf(cart.rewardcost());
			Select objSelect2 =new Select(cart.selectOne());
			objSelect2.selectByVisibleText("$5.00");
			Thread.sleep(3000);
			cart.enterQuantity("2");
			cart.addToCartClick();
			LibraryUtils.waiForElementToBeVisible(getDriver(), cart.cart_TotalvalueVisible(), 20);			
			System.out.println("Original get text value is "+ cart.Cart_totalvalue().replaceAll("[^0-9]", ""));
			Integer calcCatrvalue=Integer.valueOf(cart.Cart_totalvalue().replaceAll("[^0-9]", ""));
			System.out.println("Calculated final value is " + calcCatrvalue);
			cart.viewCartClick();
			LibraryUtils.waiForElementToBeVisible(getDriver(), cart.totalvalueOnCart2(), 30);			
			Integer totalcartvalue=Integer.valueOf(cart.totalvalueOnCart().replaceAll("[^0-9]", ""));
			Integer expectedvalue=rewardcost*2;			
			softassert.assertEquals(totalcartvalue, expectedvalue);
			softassert.assertEquals(calcCatrvalue, expectedvalue);			
			WebElement ele = getDriver().findElement(By.xpath("//*[@id=\"row_points_0\"]/td[3]/form/div/p/a"));
			JavascriptExecutor jse = (JavascriptExecutor)getDriver();
			jse.executeScript("arguments[0].click()", ele);
			Thread.sleep(2000);
			cart.removeItems();
			LibraryUtils.waiForElementToBeVisible(getDriver(), cart.ItemIsRemoved(), 30);
			String expectedItemrem="Your Shopping Cart is empty.";
			System.out.println("Actual Item removed message is " + cart.removeItemsMessage());
			softassert.assertEquals(cart.removeItemsMessage(), expectedItemrem);			
			softassert.assertAll();			
		}
		else
		{
			logger.error("Unable to find the brand");
			throw new SkipException("Brand Not found with locator, Skipping this exception");
		}
	}
}
