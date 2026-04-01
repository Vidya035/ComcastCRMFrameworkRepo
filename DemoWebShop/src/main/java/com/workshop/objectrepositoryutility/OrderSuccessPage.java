package com.workshop.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSuccessPage {

	WebDriver driver;
	public OrderSuccessPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	// Locator for the order number text
    @FindBy(xpath = "//ul[@class='details']/li[1]")
    private WebElement orderNumberText;

    public String getOrderNumber() {
        // This will capture "Order number: 2253571"
        String rawText = orderNumberText.getText();
        // Extract only the digits
        return rawText.replaceAll("[^0-9]", "");
    }
}
