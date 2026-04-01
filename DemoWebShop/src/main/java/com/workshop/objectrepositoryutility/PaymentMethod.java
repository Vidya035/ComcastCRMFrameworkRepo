package com.workshop.objectrepositoryutility;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentMethod
{
	WebDriver driver;
	public PaymentMethod(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//input[@class=\"button-1 payment-method-next-step-button\"]")
	private WebElement paymentMetContBtn;
	
	@FindBy(xpath="//input[@value=\"Payments.CheckMoneyOrder\"]")
	private WebElement PayementRadioBtn;
	
	public WebElement getPayementRadioBtn() {
		return PayementRadioBtn;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getPaymentMetContBtn() {
		return paymentMetContBtn;
	}
	
	public void ClickPayementRadioBtn()
	{
		new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.elementToBeClickable(PayementRadioBtn)).click();
	}
	public void clickPaymentMethodContinueBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(paymentMetContBtn));
        try {
            paymentMetContBtn.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", paymentMetContBtn);
        }
    }
}
