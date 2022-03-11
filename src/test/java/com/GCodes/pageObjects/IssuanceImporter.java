package com.GCodes.pageObjects;
import javax.xml.xpath.XPath;

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
	
	@FindBy(xpath="//*[@id=\"app\"]/div/main/div/div/div[2]/div/div/div/div[2]/b/a")
	WebElement btn_IssueImporter;
	
	@FindBy(xpath="//*[@id=\"import_file\"]")
	WebElement btn_browse;
	
	@FindBy(xpath ="//*[@id=\"app\"]/div/main/div/div/div[2]/div[2]/div/div/div/form/button[1]")
	WebElement btn_validate;
	
	@FindBy(xpath = "//*[@class='is-danger']")
	WebElement alert_validate;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div/div[2]/div[2]/div/div/div/p")
	WebElement msg_filevalidation;
	
	@FindBy(xpath ="//*[@id='agree_terms']")
	WebElement check_term;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div/div[2]/div[2]/div/div/div/form/span")
	WebElement msg_selectterms;
	
	@FindBy(xpath = "//*[@type='submit']")
	WebElement btn_confirm;
	
	@FindBy(xpath = "//*[@class='alert alert-internal alert-success']")
	WebElement msg_scheduled;
	
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
		btn_IssueImporter.click();
	}
	public void Click_browse(String path)
	{
		btn_browse.sendKeys(path);;
	}
	public void Click_btnBrowse()
	{
		btn_browse.click();
	}
	public void Click_btnValidate()
	{
		btn_validate.click();
	}
	
	public String validateText()
	{
	return alert_validate.getText();	
	}
	public String alertFileInvalid()
	{
		return msg_filevalidation.getText();
	}
	public void Select_Term() 
	{
		check_term.click();
	}
    public String Message_selectTerm()
    {
    	return msg_selectterms.getText();
    }
    public void Confirm()
    {
    	btn_confirm.click();
    }
}
