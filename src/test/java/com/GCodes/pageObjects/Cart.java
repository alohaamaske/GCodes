package com.GCodes.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Cart {
	WebDriver driver;
	@FindBy(linkText="Shop")
	WebElement lnk_shops;
	@FindBy(xpath="//*[@id=\"shop-hamburger\"]")
	WebElement btn_menu;
	@FindBy(id ="desk_mega_keyword")
	WebElement tbt_keywords;
	@FindBy(xpath ="/html/body/header/div[1]/div[2]/div/div[1]/div[3]/div/form/div/button")
	WebElement btn_search;
	@FindBy(xpath ="//*[@id='reward-brand']")
	WebElement lbl_reward_brand;
	
	@FindBy(xpath ="//*[@id='reward-cost']")
	WebElement number_rewardcost;
	
	@FindBy(xpath = "//*[@title='Select One']")
	WebElement drop_Denomination;
	
	@FindBy(xpath = "//*[@name='productQty']")
	WebElement txt_qty;
	
	@FindBy(xpath = "//*[@class='btn btn-secondary mb-sm add-to-cart rgloadable rgloader']")
	WebElement btn_addToCart;
	
	@FindBy(xpath = "//*[@class=\"mt-0 mb-md text-center\"]")
	WebElement cart_total;
	
	@FindBy(xpath = "//*[@class='btn btn-secondary mb-md']")
	WebElement btn_viewcart;
	
	@FindBy(xpath = "//*[@class='pull-right']")
	WebElement value_cart_page;
	
	@FindBy(xpath = "//*[@id=\"row_points_0\"]/td[3]/form/div/p/a")
	WebElement lnk_removecart;
	
	@FindBy(xpath = "//*[@class='btn btn-secondary mb-md remove-item']")
	WebElement btn_removeitems;
	
	@FindBy(xpath = "//*[@id=\"shopping-cart\"]/div[3]/div/h3")
	WebElement msg_itemsRemoved;
	
	@FindBy(xpath = "/html/body/main/div[1]/h2")
	WebElement shoppingCartpageClick;
	
	@FindBy(xpath = "//*[@id=\"desktop_breadcrumb\"]/li[3]")
    WebElement bread_vitualgiftcard;
 	
	@FindBy(xpath = "/html/body/header/div[1]/div[2]/div/div[1]/div[3]/div/form/div/div")
	WebElement seletItemstype;
	
	@FindBy(xpath ="//*[@id=\"shop-nav-bar\"]/div[2]/div[3]/div/p" )
	WebElement lnk_viewcart;
	
	@FindBy(xpath ="//*[@class='btn btn-block btn-lg btn-secondary']")
	WebElement btn_continue;
	
	
	public Cart(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void lnk_shopsClick()
	{
		lnk_shops.click();
	}
	
	public WebElement shop_link_wait()
	{
		return lnk_shops;
	}
	
	public WebElement menu_button_wait()
	{
		return btn_menu;
	}
	
	public void menu_button()
	{
		btn_menu.click();
	}
	
	public void txt_keyword_enter(String item)
	{
		tbt_keywords.sendKeys(item);
	}
	
	public void click_search()
	{
		btn_search.click();
	}
	
	public WebElement rewardBrand()
	{
		return lbl_reward_brand;
	}
	
	public String rewardcost()
	{
		return number_rewardcost.getText();
	}
	public WebElement selectOne()
	{
		return drop_Denomination;
	}
	public void enterQuantity(String qtyvalue)
	{
		txt_qty.clear();
		txt_qty.sendKeys(qtyvalue);
	}
	public void addToCartClick()
	{
		btn_addToCart.click();
	}
	public String Cart_totalvalue()
	{
		return cart_total.getText();
	}
	public WebElement cart_TotalvalueVisible()
	{
		return cart_total;
	}
	
	public void viewCartClick()
	{
		btn_viewcart.click();
	}
	
	public String totalvalueOnCart()
	{
		return value_cart_page.getText();
	}
	
	public WebElement totalvalueOnCart2()
	{
		return value_cart_page;
	}
	public void cartRemove()
	{
		lnk_removecart.click();
	}	
	public WebElement removebtnClick()
	{
		return lnk_removecart;
	}
	public void removeItems()
	{
		btn_removeitems.click();
	}
	
	public String removeItemsMessage()
	{
		return msg_itemsRemoved.getText();
	}
	public WebElement ItemIsRemoved()
	{
		return msg_itemsRemoved;
	}
	public WebElement virtulGIftCart()
	{
		return bread_vitualgiftcard;
	}
	
	public void shoppingPageClick()
	{
		shoppingCartpageClick.click();
	}
	
	public WebElement itemList()
	{
		return seletItemstype;
	}
	public void Clickviewcart_link()
	{
		lnk_viewcart.click();
	}
	
}