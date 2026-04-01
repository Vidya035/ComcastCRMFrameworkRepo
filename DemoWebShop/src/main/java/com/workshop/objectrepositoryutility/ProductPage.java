package com.workshop.objectrepositoryutility;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Build your own computer')]")
    private WebElement computerLink;

    public void clickProduct(String productName) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        if(productName.equalsIgnoreCase("Computer")) {
            wait.until(ExpectedConditions.elementToBeClickable(computerLink)).click();
        } 
        else {
            WebElement product = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//h2[@class='product-title']/a[contains(text(),'"+productName+"')]")
            ));
            product.click();
        }
    }
}