package com.GCodes.pageObjects;
import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendCode {
	WebDriver driver;

	@FindBy(xpath = "//*[@id=\"nav-admin\"]/a[2]/p")
	WebElement lnk_sendcode;

	@FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/div[2]/a[4]/div/p")
	WebElement tab_admin;

	@FindBy(xpath = "//*[@name='gcode_currency']")
	WebElement dropdwonCurrency;

	@FindBy(xpath = "//*[@ID='send_gcode_value']")
	WebElement currencyVal;

	@FindBy(xpath = "//*[@ID='send_gcode_theme_key']")
	WebElement dropdpwn_Theme;

	@FindBy(xpath = "//*[@ID='send_gcode_email']")
	WebElement txt_email;

	@FindBy(xpath = "//*[@ID='send_gcode_first_name']")
	WebElement txt_firstname;

	@FindBy(xpath = "//*[@ID='send_gcode_last_name']")
	WebElement txt_lastname;

	@FindBy(xpath = "//*[@name='gcode_country_code']")
	WebElement txt_countrycode;

	@FindBy(xpath = "//*[@name='gcode_area_code']")
	WebElement txt_areacode;

	@FindBy(xpath = "//*[@name='gcode_phone_number']")
	WebElement txt_telephone;

	@FindBy(xpath = "//*[@id='send_gcode_address_address1']")
	WebElement txt_address;

	@FindBy(xpath = "//*[@name='gcode_address_city']")
	WebElement txt_city;

	@FindBy(xpath = "//*[@name='gcode_country']")
	WebElement dropdpwn_country;

	@FindBy(xpath = "//*[@name='gcode_state']")
	WebElement dropdown_state;

	@FindBy(xpath = "//*[@name='gcode_address_zip']")
	WebElement txt_zip;

	@FindBy(xpath = "//*[@id='app_issue_gcode_send_email']")
	WebElement check_sendemail;

	@FindBy(xpath = "//*[@id='send_type_form_send']")
	WebElement btn_sendcode;


	@FindBy(xpath="//*[@id=\"flashbag-messages\"]/div")
	WebElement msg_thanks;
	
	@FindBy(xpath = "//*[@class='btn btn-lg btn-color btn-block']")
	WebElement btn_confirm;
	
	@FindBy(xpath = "//*[@id='agreeTerms']")
	WebElement checkbox_terms;

	//Thank you for your order!

	public SendCode(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
	public String ThanksMEssage()
	{
		return msg_thanks.getText();
	}
	public void Click_Admin()
	{
		tab_admin.click();
	}
	public void Click_SendCodeTab()
	{
		lnk_sendcode.click();
	}
	public WebElement SelectCurrency()
	{
		return dropdwonCurrency;
	}
	public WebElement CurrencyVal()
	{
		return currencyVal;
	}
	public WebElement Theame()
	{
		return dropdpwn_Theme;
	}
	public void SendEmail(String email)
	{
		txt_email.sendKeys(email);
	}
	public void EnterFirstName(String fname)
	{
		txt_firstname.sendKeys(fname);
	}
	public void EnterLasteName(String lname)
	{
		txt_lastname.sendKeys(lname);
	}
	public void EnterContryCode(String countrycode)
	{
		txt_countrycode.sendKeys(countrycode);
	}
	public void EnterAreaCode(String area)
	{
		txt_areacode.sendKeys(area);
	}
	public void Entertelephone(String telephone)
	{
		txt_telephone.sendKeys(telephone);
	}
	public void EnterAddress1(String address1)
	{
		txt_address.sendKeys(address1);
	}
	public void EnterCity(String city)
	{
		txt_city.sendKeys(city);
	}
	public WebElement SelectCountry()
	{
		return dropdpwn_country;
	}
	public WebElement SelectState()
	{
		return dropdown_state;
	}
	public void EnterZip(String zip)
	{txt_zip.sendKeys(zip);}

	public void SelectSendEmail()
	{
		check_sendemail.click();
	}
	public void ClickSendCode()
	{
		btn_sendcode.click();
	}
	public void ClickConfirm()
	{
		btn_confirm.click();
	}
     public void ClickTerms()
     {
    	 checkbox_terms.click();
     }
}



