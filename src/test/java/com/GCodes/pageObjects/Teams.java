package com.GCodes.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class Teams {
	//updates
	WebDriver driver;
	@FindBy(xpath="//*[@id=\"loggedIn\"]/div[3]/div[2]/a[4]/img")
	WebElement btnteams;

	@FindBy(xpath="//*[@id=\"loggedIn\"]/main/div/div/div[1]/h1")
	WebElement titleteams;

	@FindBy(xpath="//*[@id=\"loggedIn\"]/main/div/div/div[1]/div")
	WebElement createteambtn;

	@FindBy(xpath="//*[@id=\"loggedIn\"]/main/div/div/div[3]/div[2]/button")
	WebElement teamnext;

	@FindBy(xpath="//*[@id=\"loggedIn\"]/main/div/div/div[3]/div[3]/div/h1")
	WebElement teamnameval;
	
	@FindBy(xpath="//div[@class=\"toast-close\"]")
	WebElement toastclose;
	
	@FindBy(xpath="//*[@id=\"loggedIn\"]/main/div/div/div[3]/div[2]/div[1]/input")
	WebElement teamname;

	@FindBy(xpath="//*[@id=\"loggedIn\"]/main/div/div/div[3]/div[3]/button")
	WebElement addtobtn;
	
	@FindBy(xpath="//*[@id=\"loggedIn\"]/main/div/div/div[3]/div[4]/div/h1")
	WebElement addteamalert;
	
	@FindBy(xpath="//*[@id=\"loggedIn\"]/main/div/div/div[3]/div[4]/div/div")
	WebElement addmemberalert;
	
	@FindBy(xpath="//input[@placeholder='Find members']")
	WebElement findmembertxt;
	
	@FindBy(xpath="//div[@class=\"filteredMemberList\"]")
	WebElement selectmember;
	
	@FindBy(xpath=" //*[@id=\"loggedIn\"]/main/div/div/div[3]/div[3]/div[2]/div[1]/div")
	WebElement selectedmember2;
	
	@FindBy(xpath="//div[h2='Evergrow QA Team 01']")
	WebElement teamnameadded;
	
	@FindBy(xpath="//*[@id=\"loggedIn\"]/main/div/div/div[2]/div[3]/div[2]/div[2]/div[1]/div[1]")
	WebElement verigyteamtext;
	
	@FindBy(xpath="/html/body/div/div/main/div/div/div[2]/div[3]/div[2]/div[2]/div[3]/div[2]/div[1]/div[3]")
	WebElement deleteiconm;
	

	@FindBy(xpath="//*[@id=\"loggedIn\"]/main/div/div/div[2]/div[3]/div[2]/div[3]/div/button")
	WebElement deleteconfirmmem;
	
	
	@FindBy(xpath="//*[@id=\"loggedIn\"]/main/div/div/div[2]/div[3]/div[2]/div[3]/div/h1")
	WebElement memberdeletedmalert;
	
	@FindBy(xpath="//*[@id=\"loggedIn\"]/main/div/div/div[2]/div[3]/div[2]/div[3]/div/h1")
	WebElement actualdeleteconf;
	
	@FindBy(xpath="//*[@id=\"loggedIn\"]/main/div/div/div[2]/div[3]/div[2]/div[2]/div[1]/div[2]/img")
	WebElement deleteteamicon;
	
	
	@FindBy(xpath="//*[@id=\"loggedIn\"]/main/div/div/div[2]/div[3]/div[2]/div[2]/div[1]/div[2]/img")
	WebElement deleteicon;

	
	@FindBy(xpath="//*[@id=\"loggedIn\"]/main/div/div/div[2]/div[3]/div[2]/div[3]/div/button")
	WebElement btndeleteconfirm;
	
	@FindBy(xpath="//*[@id=\"loggedIn\"]/main/div/div/div[2]/div[3]/div[2]/div[2]/div[1]/div[2]/div/p[2]")
	WebElement deleteteambtb;
	
	
	
	public Teams(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	

	public void teamspage()
	{
		btnteams.click();
	}
	public String teamstitle()
	{
		return titleteams.getText();
	}

	public void createteam()
	{
		createteambtn.click();
	}

	public void teamnextbtn()
	{
		teamnext.click();
	}

	public String teamvalidation()
	{
		return teamnameval.getText();
	}

	public String teamstext()
	{
		String teamstextval;
		return teamstextval="Teams";			
	}	
	public String expectedteamval()
	{
		String teamvalidation;
		return teamvalidation="You forgot to type team name!";				
	}

	public void teamtoast()
	{
		toastclose.click();
	}
	
	public void teamanametxt(String teamanametxt)
	{
		teamname.sendKeys(teamanametxt);
	}
	
	public void addToteam()
	{
		addtobtn.click();
	}

	public String teamalert()
	{
		return addteamalert.getText();
	}
	
	public String teamexpectedalrt()
	{
		String tealalrtexp;
		return tealalrtexp="Please add at least one member to your team.";				
	}
	
	public void addmemberalert()
	{
		addmemberalert.click();
	}

	
	public void findmembertext(String findmembertext)
	{
		findmembertxt.sendKeys(findmembertext);
	}
	
	public void selectedmember()
	{
		selectmember.click();
	}
	
	public void selectedmember2()
	{
		selectedmember2.click();
	}
	
	public void teamnameaction()
	{
		teamnameadded.click();
	}
	
	public String teamverify()
	{
		return verigyteamtext.getText();
	}
	
	public String teamverifyexpected()
	{
		String teamnameexpected;
		return teamnameexpected="Evergrow QA Team 01";				
	}
	
	public void deletemembericon()
	{
		deleteiconm.click();
	}
	
	public void deleteconfirm()
	{
		deleteconfirmmem.click();
	}
	
	public String expecteddeletmem()
	{
		String expectedconfirmdel;
		return expectedconfirmdel="Member deleted.";				
	}
	
	public String actualmemberconf()
	{
		return actualdeleteconf.getText();
	}
	
	public void deleteTicon()
	{
		deleteteamicon.click();
	}
	
	
	public void deleteteam()
	{
		deleteteambtb.click();
	}
	
	public void deleteteamconf()
	{
		btndeleteconfirm.click();
	}
	
	
	
}

