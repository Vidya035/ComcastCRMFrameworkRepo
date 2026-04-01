package com.workshop.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BillingAddress
{

	WebDriver driver;
	public BillingAddress(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@id=\"BillingNewAddress_FirstName\"]")
	private WebElement EditFN;
	
	@FindBy(xpath="//input[@name=\"BillingNewAddress.LastName\"]")
	private WebElement EdintLN;
	
	@FindBy(xpath="//input[@id=\"BillingNewAddress_Email\"]")
	private WebElement EditEmail;
	
	@FindBy(xpath="//input[@id=\"BillingNewAddress_Company\"]")
	private WebElement EditCompany;
	
	@FindBy(xpath="//select[@name=\"BillingNewAddress.CountryId\"]")
	private WebElement EditDD;
	
	@FindBy(xpath="//input[@id=\"BillingNewAddress_City\"]")
	private WebElement EditCity;
	
	@FindBy(xpath="//input[@name=\"BillingNewAddress.Address1\"]")
	private WebElement EditAdd1;
	
	@FindBy(xpath="//input[@name=\"BillingNewAddress.Address2\"]")
	private WebElement EditAdd2;
	
	@FindBy(xpath="//input[@name=\"BillingNewAddress.ZipPostalCode\"]")
	private WebElement EditPostalCode;
	
	@FindBy(xpath="//input[@name=\"BillingNewAddress.PhoneNumber\"]")
	private WebElement EditPhone;
	
	@FindBy(xpath="//input[@name=\"BillingNewAddress.FaxNumber\"]")
	private WebElement EditFax;
	
	@FindBy(xpath="//input[@onclick=\"Billing.save()\"]")
	private WebElement ContinueBtn;
	
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getEditFN() {
		return EditFN;
	}

	public WebElement getEdintLN() {
		return EdintLN;
	}

	public WebElement getEditEmail() {
		return EditEmail;
	}

	public WebElement getEditCompany() {
		return EditCompany;
	}

	public WebElement getEditDD() {
		return EditDD;
	}

	public WebElement getEditCity() {
		return EditCity;
	}

	public WebElement getEditAdd1() {
		return EditAdd1;
	}

	public WebElement getEditAdd2() {
		return EditAdd2;
	}

	public WebElement getEditPostalCode() {
		return EditPostalCode;
	}

	public WebElement getEditPhone() {
		return EditPhone;
	}

	public WebElement getEditFax() {
		return EditFax;
	}

	public WebElement getContinueBtn() {
		return ContinueBtn;
	}
	
	public void selectCountry(String countryName) 
	{
        Select sel = new Select(EditDD);
        sel.selectByVisibleText(countryName);
	}
	
	public void CheckDetails(String FN,String LN,String Email,String Company,String City,
			String Add1,String Add2,String PostCode,String Phone,String Fax)
	{
		EditFN.sendKeys(FN);
		EdintLN.sendKeys(LN);
		
		EditEmail.clear();
		EditEmail.sendKeys(Email);
		
		EditCompany.sendKeys(Company);
		EditCity.sendKeys(City);
		EditAdd1.sendKeys(Add1);
		EditAdd2.sendKeys(Add2);
		EditPostalCode.sendKeys(PostCode);
		EditPhone.sendKeys(Phone);
		EditFax.sendKeys(Fax);
		
	}
	public void ClickContinueBtn()
	{
		ContinueBtn.click();
	}
}

