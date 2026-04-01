package com.workshop.objectrepositoryutility;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShippingAddress {

	WebDriver driver;
	public ShippingAddress(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//input[@onclick=\"Shipping.save()\"]")
	private WebElement continBtn;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getContinBtn() {
		return continBtn;
	}
	
		public void ClickShipAddressContinueBtn() {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		    wait.until(ExpectedConditions.elementToBeClickable(continBtn)); // wait until clickable
		    wait.until(ExpectedConditions.visibilityOf(continBtn)); // wait until visible
		 // Scroll into view
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continBtn);

	        // Slight pause to allow dynamic scripts to complete
	        try { Thread.sleep(500); } catch (Exception e) {}
		    continBtn.click();
	
	
}
}
