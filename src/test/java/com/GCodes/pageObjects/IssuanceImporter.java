package com.GCodes.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IssuanceImporter {

	WebDriver driver;
	@FindBy(xpath ="//*[@id=\"app\"]/div/div[1]/div[2]/a[4]/div/p")
	WebElement lnk_admin;
	
	@FindBy(xpath ="//*[@id=\"app\"]/div/main/div/div/div[2]/div/div/div/div[2]/b/a")
	WebElement lnk_importer;
	
	@FindBy(linkText ="Issuance Importer")
	WebElement lnk_IssueImporter;
	
	@FindBy(xpath="//*[@id=\"import_file\"]")
	WebElement btm_browse;
	
	public IssuanceImporter(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Click_AdminTab()
	{
		lnk_admin.click();
	}
	
	public void Click_importer()
	{
		lnk_IssueImporter.click();
	}
	public void Click_browse(String path)
	{
		btm_browse.sendKeys(path);;
	}
}
