package com.workshop.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.workshop.generic.webdriverutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility{

	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(linkText="Log in")
	private WebElement LoginLink;
	
	@FindBy(id="Email")
	private WebElement EditEmail;
	
	@FindBy(id="Password")
	private WebElement EditPwd;
	
	@FindBy(xpath="//input[@value=\"Log in\"]")
	private WebElement LoginBtn;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getLoginLink() {
		return LoginLink;
	}

	public WebElement getEditEmail() {
		return EditEmail;
	}

	public WebElement getEditPwd() {
		return EditPwd;
	}

	public WebElement getLoginBtn() {
		return LoginBtn;
	}
	public void clickLoginlink()
	{
		LoginLink.click();
	}
	public void clickLoginBtn()
	{
		LoginBtn.click();
	}
	
	public void Login(String Email, String Password)
	{
		waitForPageToLoad(driver);	
		EditEmail.sendKeys(Email);
		EditPwd.sendKeys(Password);		
	}
	
}
