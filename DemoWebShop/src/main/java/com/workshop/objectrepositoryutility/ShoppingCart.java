package com.workshop.objectrepositoryutility;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCart {
	WebDriver driver;
	public ShoppingCart(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//input[@id=\"small-searchterms\"]")
	private WebElement EditSearch;
	
	@FindBy(xpath="//input[@class=\"button-1 search-box-button\"]")
	private WebElement SearchBtn;
	
	@FindBy(xpath="//input[@value=\"Add to cart\"]")
	private WebElement AddtoCartBtn;
	
	@FindBy(xpath="//span[text()='Shopping cart']")
	private WebElement ShoppingCartLink;
		public WebElement getShoppingCartBtn() {
		return ShoppingCartLink;
	}
		public WebElement getAddtoCartBtn() {
		return AddtoCartBtn;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getEditSearch() {
		return EditSearch;
	}
	public WebElement getSearchBtn() {
		return SearchBtn;
	}
	public void ClickAddtoCartBtn()
	{
		AddtoCartBtn.click();
	}
	public void ClickShoppingCartLink()
	{
		ShoppingCartLink.click();
	}
	public void ClickShoppingCart()
	{
		Actions action=new Actions(driver);
		action.moveToElement(ShoppingCartLink).click().perform();
	}
	public void searchAndSelectAutoSuggestion(String product, String suggestion)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchBox = wait.until( ExpectedConditions.visibilityOfElementLocated(By.id("small-searchterms")));
        searchBox.clear();
        searchBox.sendKeys(product);
        List<WebElement> list = wait.until(
            ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//ul[@id='ui-id-1']/li")));
   for(WebElement ele : list)
        {
	   if(ele.getText().equalsIgnoreCase(suggestion))
            {
                ele.click();
                break;
            }}}
    public void clickAddToCart()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(AddtoCartBtn)).click();
    }
    public void clickShoppingCart()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(ShoppingCartLink)).click();
    }
}
