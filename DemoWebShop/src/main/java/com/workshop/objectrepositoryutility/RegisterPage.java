package com.workshop.objectrepositoryutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

	WebDriver driver;
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[@class=\"ico-register\"]")
	private WebElement RegLink;
	
	@FindBy(id="gender-female")
	private WebElement FemaleRadioBtn;
	
	@FindBy(id="gender-male")
	private WebElement MaleRadioBtn;

	@FindBy(name="FirstName")
	private WebElement editFN;
	
	@FindBy(name="LastName")
	private WebElement editLN;
	
	@FindBy(name="Email")
	private WebElement editEmail;
	
	@FindBy(name="Password")
	private WebElement editPassword;
	
	@FindBy(name="ConfirmPassword")
	private WebElement editConfPassword;
	
	@FindBy(id="register-button")
	private WebElement regBtn;
	
	@FindBy(xpath="//div[@class=\"result\"]")
	private WebElement registrationMsg;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getRegLink() {
		return RegLink;
		
	}
	
	
	public WebElement getRegistrationMsg() {
		return registrationMsg;
	}

	public WebElement getFemaleRadioBtn() {
		return FemaleRadioBtn;
	}
	
	public WebElement getMaleRadioBtn() {
		return MaleRadioBtn;
	}

	public WebElement getEditFN() {
		return editFN;
	}

	public WebElement getEditLN() {
		return editLN;
	}

	public WebElement getEditEmail() {
		return editEmail;
	}

	public WebElement getEditPassword() {
		return editPassword;
	}

	public WebElement getEditConfPassword() {
		return editConfPassword;
	}

	public WebElement getRegBtn() {
		return regBtn;
	}
	
	public void clickRegisterLink() {
	    RegLink.click();
	}
	public void selectGender() {
	    FemaleRadioBtn.click();
	}
	
	public String getRegistrationMessage()
	{
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(registrationMsg));
	    return registrationMsg.getText();
	}
	
	public void UserRegDetails(String FirstName, String LastName, 
			String Email, String Password, String ConfirmPassword) throws InterruptedException
	{
		
        editFN.sendKeys(FirstName);
		editLN.sendKeys(LastName);
		editEmail.sendKeys(Email);
		editPassword.sendKeys(Password);
		editConfPassword.sendKeys(ConfirmPassword);
	}
	public void clickRegisterButton() {
	    regBtn.click();
	}

	

}
