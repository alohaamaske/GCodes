package com.GCodes.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	WebDriver driver;
	@FindBy(xpath="//*[@id='username']")
	WebElement txtusername;

	@FindBy(xpath="//*[@id='password']")
	WebElement txtpassword;

	@FindBy(xpath="//*[@class='btn btn-color mt-20']")
	WebElement btnsubmitt;

	@FindBy(xpath="//*[@id=\"app\"]/div/div[1]/div[2]/a[3]/div/p")
	WebElement accountlink;
	
	@FindBy(xpath="//*[@id=\"nav-account\"]/a[4]/p")
	WebElement logoutlink;
	
	@FindBy(xpath="//*[@id=\"flashbag-messages\"]/div")
	WebElement alertmsg;

	//@FindBy(xpath="//*[@id=\"loggedIn\"]/div[1]/div[2]/div[1]/button[1]")
	//WebElement btngive1;

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
	public void accountLinkclick()
	{
		accountlink.click();
	}
	public void logoutclick()
	{
		logoutlink.click();
	}
	
	public String loginalert()
	{
	return alertmsg.getText();
	}
}
