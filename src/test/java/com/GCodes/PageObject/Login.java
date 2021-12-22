package com.GCodes.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	WebDriver driver;
	@FindBy(xpath="//*[@id='login-username']")
	WebElement txtusername;

	@FindBy(xpath="//*[@id='login-password']")
	WebElement txtpassword;

	@FindBy(xpath="//*[@class='green-fill login-button']")
	WebElement btnsubmitt;


	@FindBy(xpath="//*[@id=\"loggedIn\"]/div[1]/div[2]/div[1]/button[1]")
	WebElement btngive1;

	public Login(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	

	public void username(String username)
	{
		txtusername.clear();
		txtusername.sendKeys(username);

	}

	public void password(String password)
	{
		txtpassword.clear();
		txtpassword.sendKeys(password);
	}

	public void submit()
	{
		btnsubmitt.click();
	}

	public String givebtn()
	{
		return btngive1.getText();
	}
	public WebElement home()
	{
	return btngive1;
	}
}
