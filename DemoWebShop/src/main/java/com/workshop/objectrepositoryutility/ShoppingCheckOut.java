package com.workshop.objectrepositoryutility;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCheckOut
{
	WebDriver driver;
	public ShoppingCheckOut(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//input[@id=\"termsofservice\"]")
	private WebElement CheckBox;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	private WebElement CheckoutBtn;

	public WebElement getCheckBox() {
		return CheckBox;
	}

	public WebElement getCheckoutBtn() {
		return CheckoutBtn;
	}
	
	public void ClickCheckBox()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		try {
            wait.until(ExpectedConditions.elementToBeClickable(CheckBox));
            CheckBox.click();
        } catch (org.openqa.selenium.UnhandledAlertException e) {
            System.out.println("Alert detected: " + e.getMessage());
            // Handle the alert
            Alert alert = driver.switchTo().alert();
            alert.accept(); // dismiss or accept depending on your site
            // Retry clicking the checkbox
            wait.until(ExpectedConditions.elementToBeClickable(CheckBox));
            CheckBox.click();
        }
	}
	public void ClickCheckoutBtn()
	{
		CheckoutBtn.click();
	}
}
