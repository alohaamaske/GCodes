package com.GCodes.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GiveAward {

	//updates
	WebDriver driver;
	@FindBy(xpath="//*[@id=\"loggedIn\"]/div[1]/div[2]/div[1]/button[1]")
	WebElement btngive;
	
	@FindBy(xpath="//*[@id=\"loggedIn\"]/div[1]/div[3]/div[2]/div/div[2]")
	WebElement btnpeer;

	@FindBy(xpath="/html/body/div/div/div[1]/div[3]/div[2]/div[1]")
	WebElement txtaward;

	@FindBy(xpath="//input[@placeholder='Find members']")
	WebElement txtmemberfield;

	@FindBy(xpath="//*[@class='filteredMemberList']")
	WebElement filteredmember;

	@FindBy(xpath="//*[@id=\"loggedIn\"]/div[1]/div[3]/div[4]/div[3]/button")
	WebElement btnsendaward;

	@FindBy(xpath="//*[@id=\"loggedIn\"]/div[1]/div[3]/div[4]/div[3]/textarea")
	
	WebElement txtmessage;

	@FindBy(xpath="//*[@id=\"loggedIn\"]/div[1]/div[3]/div[4]/p[1]")
	WebElement awardsenttext;


	@FindBy(xpath="//*[@id=\"loggedIn\"]/div[1]/div[3]/div[4]/p[3]")
	WebElement btnclose;

	@FindBy(xpath="//*[@id=\"loggedIn\"]/div[1]/div[3]/div[3]/div[1]")
	WebElement txtawardcount;

	@FindBy(xpath="//*[@id=\"loggedIn\"]/div[1]/div[3]/div[5]/div/h1")
	WebElement nomemberalert;

	@FindBy(xpath="//*[@id=\"loggedIn\"]/div[1]/div[3]/div[5]/div/div")
	
	WebElement closepopup;

	@FindBy(xpath="//*[@id=\"loggedIn\"]/div[1]/div[3]/div[5]/div/h1")
	WebElement alertmsg;


	@FindBy(xpath="//*[@id=\"loggedIn\"]/div[1]/div[3]/div[1]")
	WebElement closegivepop;
	
	public GiveAward(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
	public void give()
	{
		btngive.click();
	}
	
	public String awardtext()
	{
		return txtaward.getText();
	}
	public void memberfield(String memberfield)
	{
		txtmemberfield.sendKeys(memberfield);
	}
	public void memberfilter()
	{
		filteredmember.click();
	}
	public void sendaward()
	{
		btnsendaward.click();
	}
	public void awardmessage(String awardmessage)
	{
		txtmessage.sendKeys(awardmessage);
	}
	public String awardtextsent()
	{
		return awardsenttext.getText();
	}
	public void close()
	{
		btnclose.click();
	}

	public String awardtotalcount()
	{
		return txtawardcount.getText();
	}

	public String nomemberalert()
	{
		return nomemberalert.getText();
	}
	public void closepopup()
	{
		closepopup.click();
	}
	public String alertmsg()
	{
		return alertmsg.getText();
	}
	public void givepop()
	{
		closegivepop.click();
	}
	public void peerbtnclick()
	{
		btnpeer.click();
	}
	
}
