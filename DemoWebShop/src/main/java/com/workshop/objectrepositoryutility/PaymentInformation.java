package com.workshop.objectrepositoryutility;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentInformation {

	WebDriver driver;
	public PaymentInformation(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@onclick=\"PaymentInfo.save()\"]")
	private WebElement PaymentInfoBtn;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getPaymentInfoBtn() {
		return PaymentInfoBtn;
	}
	public void ClickPaymentInfoContinueBtn() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    wait.until(ExpectedConditions.elementToBeClickable(PaymentInfoBtn));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", PaymentInfoBtn);
	    try { Thread.sleep(1000); } catch (Exception e) {} // slight pause
	    PaymentInfoBtn.click();
	}
	
}
