package com.workshop.objectrepositoryutility;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShippingMethod {

	WebDriver driver;
	public ShippingMethod(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@onclick=\"ShippingMethod.save()\"]")
	private WebElement ShippingMetContinueBtn;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getShippingMetContinueBtn() {
		return ShippingMetContinueBtn;
	}
	
	public void ClickShipMethodContinueBtn() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    wait.until(ExpectedConditions.elementToBeClickable(ShippingMetContinueBtn)); // wait until clickable
	    wait.until(ExpectedConditions.visibilityOf(ShippingMetContinueBtn)); // wait until visible
	 // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ShippingMetContinueBtn);

        // Slight pause to allow dynamic scripts to complete
        try { Thread.sleep(500); } catch (Exception e) {}
        ShippingMetContinueBtn.click();
}}
