package com.GCodes.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Wallets {
	WebDriver driver;
	@FindBy(xpath="//*[@class='plus-button']")
	WebElement lnk_wallet;
	
	@FindBy(xpath="//*[@name='redeem_form_code_key']")
	WebElement txt_code;	
	
	@FindBy(xpath="//*[@class='redeem-btn']")
	WebElement btn_redeem;
	
	@FindBy(xpath="//*[@id=\"app\"]/div/main/div/div/div[5]/div/div[2]/button/img")
	WebElement btn_closeredeem;
	
	@FindBy(xpath="//*[@class='is-danger']")
	WebElement msginvalidcode;
	
	public Wallets(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void walletLinkClick()
	{
		 lnk_wallet.click();	
	}

	public void txtCode(String code)
	{
		txt_code.sendKeys(code);
	}
	public void redeemClick()
	{
		btn_redeem.click();	
	}
	public void redeemPopupClick()
	{
		btn_closeredeem.click();	
	}
	
	public String messagecode()
	{
		return msginvalidcode.getText();		
	}
	
}
